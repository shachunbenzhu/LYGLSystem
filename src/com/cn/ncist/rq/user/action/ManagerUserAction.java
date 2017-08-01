package com.cn.ncist.rq.user.action;

import java.util.List;
import java.util.Map;
import com.cn.ncist.rq.Tools.ConvertCharacter;
import com.cn.ncist.rq.action.base.BaseAction;
import com.cn.ncist.rq.page.vo.PageBean;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author  任倩
 * @version  1.0 
 */
public class ManagerUserAction extends BaseAction {	
	private PageBean pageBean = null;
	private int page; // 用户提交的当前页数
	private String user_ids;
	private String user_infos;
	private String user_name_select;
	private String flag ;
	
	private String user_name_add;
	private String user_pwd_add;
	private String user_pocket_add;
	private String user_point_add;
	
	private String admin_pwd ;
	private String admin_new_pwd ;
	
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getUser_ids() {
		return user_ids;
	}

	public void setUser_ids(String userIds) {
		user_ids = userIds;
	}

	public String getUser_infos() {
		return user_infos;
	}

	public void setUser_infos(String userInfos) {
		user_infos = userInfos;
	}

	public String getUser_name_select() {
		return user_name_select;
	}

	public void setUser_name_select(String userNameSelect) {
		user_name_select = userNameSelect;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUser_name_add() {
		return user_name_add;
	}

	public void setUser_name_add(String userNameAdd) {
		user_name_add = userNameAdd;
	}

	public String getUser_pwd_add() {
		return user_pwd_add;
	}

	public void setUser_pwd_add(String userPwdAdd) {
		user_pwd_add = userPwdAdd;
	}

	public String getUser_pocket_add() {
		return user_pocket_add;
	}

	public void setUser_pocket_add(String userPocketAdd) {
		user_pocket_add = userPocketAdd;
	}

	public String getUser_point_add() {
		return user_point_add;
	}

	public void setUser_point_add(String userPointAdd) {
		user_point_add = userPointAdd;
	}
	
	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String adminPwd) {
		admin_pwd = adminPwd;
	}

	public String getAdmin_new_pwd() {
		return admin_new_pwd;
	}

	public void setAdmin_new_pwd(String adminNewPwd) {
		admin_new_pwd = adminNewPwd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		String hql = "select um from UserModel um order by um.user_id";
		commonMethod(hql);
		return "success";
	}	
	
	public void commonMethod(String hql) throws Exception {
		pageBean = pageService.queryPageQuestion(hql, 10, page, "UserModel");
	}
	
	public String queryUser() throws Exception {
		String hql = "select um from UserModel um where 1=1" ;//注意，这样就不需要判断是否加and
		if(user_name_select != null) {
			hql = hql + " and um.user_name like '%" ;
			hql = hql + user_name_select.trim();
			hql = hql + "%'" ;
		} 
		hql = hql + " order by um.user_id" ;
		commonMethod(hql);
		return "success";
	}

	public String deleteUser() throws Exception {
		if (user_ids != null && !"".equals(user_ids.trim())) {
			String[] nids = user_ids.split(";");
			if (nids.length > 0) {
				for (int i = 0; i < nids.length; i++) {
					flag = managerUserService.deleteUser(Integer
							.valueOf(nids[i]));
				}
			}
		}
		if (flag.equals("ok")) {
			String hql = "select um from UserModel um order by um.user_id";
			commonMethod(hql);
			return "success";
		} else {
			addActionError("删除失败");
			return "failure";
		}
	}

	public String updateUser() throws Exception {
		
		if(user_infos != null && !"".equals(user_infos.trim())) {
			String[] ninfos = user_infos.split(";");
			if (ninfos.length > 0) {
				flag = managerUserService.updateUser(
						Integer.valueOf(ninfos[0]), ConvertCharacter.Convert(ninfos[1]), 
						ConvertCharacter.Convert(ninfos[2]), ConvertCharacter.Convert(ninfos[3]),
						ConvertCharacter.Convert(ninfos[4]));
			}
		}
		if (flag.equals("ok")) {
			String hql = "select um from UserModel um order by um.user_id";
			commonMethod(hql);
			return "success";
		} else {
			addActionError("修改失败");
			return "failure";
		}
	}

	
	public String addUser() throws Exception { 
		user_name_add = ConvertCharacter.Convert(user_name_add) ;
		user_pwd_add = ConvertCharacter.Convert(user_pwd_add) ;
		user_pocket_add = ConvertCharacter.Convert(user_pocket_add) ;
		user_point_add = ConvertCharacter.Convert(user_point_add) ;
		
		flag = managerUserService.addUser(user_name_add, user_pwd_add, user_pocket_add, user_point_add) ;
		if (flag.equals("ok")) { 
			String hql = "select um from UserModel um order by um.user_id";
			commonMethod(hql);
			return "success" ; 
		} else { 
			addActionError("添加失败") ; 
			return "failure" ; 
		} 
	}
	
	@SuppressWarnings("unchecked")
	public String updatePwd() throws Exception {
		Map session = ActionContext.getContext().getSession() ;
		Integer admin_id = (Integer) session.get("user_id") ;
		
		String flag = managerUserService.queryAdminPwdById(admin_id , admin_pwd) ;
		if(flag == null || !flag.equals("ok")) {
			addActionError("原始密码不正确") ;
			return "failure" ;
		} else {
			String flag1 = managerUserService.updatePwd(admin_id , admin_new_pwd) ;
			if (flag1.equals("ok")) {
				return "success" ; 
			} else {
				addActionError("修改密码出现异常") ;
				return "failure" ;
			}
		}
		
	}
}
