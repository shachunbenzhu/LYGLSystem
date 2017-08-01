package com.cn.ncist.rq.province.action;

import java.util.List;

import com.cn.ncist.rq.Tools.ConvertCharacter;
import com.cn.ncist.rq.action.base.BaseAction;
import com.cn.ncist.rq.page.vo.PageBean;
import com.cn.ncist.rq.province.vo.NationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;

public class ManagerProvinceAction extends BaseAction {

	private PageBean pageBean = null;
	private int page; // 用户提交的当前页数
	private String province_ids;
	private String province_name_select;
	private String flag ;
	
	private String province_name_add;
	private String nation_name_add;
	private List<NationModel> allNationName ;

	private String nation_name ;
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

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
	
	public String getProvince_ids() {
		return province_ids;
	}

	public void setProvince_ids(String provinceIds) {
		province_ids = provinceIds;
	}

	public String getProvince_name_select() {
		return province_name_select;
	}

	public void setProvince_name_select(String provinceNameSelect) {
		province_name_select = provinceNameSelect;
	}

	public String getProvince_name_add() {
		return province_name_add;
	}

	public void setProvince_name_add(String provinceNameAdd) {
		province_name_add = provinceNameAdd;
	}

	public String getNation_name_add() {
		return nation_name_add;
	}

	public void setNation_name_add(String nationNameAdd) {
		nation_name_add = nationNameAdd;
	}
	
	public List<NationModel> getAllNationName() {
		return allNationName;
	}

	public void setAllNationName(List<NationModel> allNationName) {
		this.allNationName = allNationName;
	}
	
	public String getNation_name() {
		return nation_name;
	}

	public void setNation_name(String nationName) {
		nation_name = nationName;
	}

	@Override
	public String execute() throws Exception { // 分页查询所有Note
		String hql = "select pm.province_id, pm.province_name, nm.nation_name from ProvinceModel pm,NationModel nm" +
					" where pm.nation_id = nm.nation_id order by pm.province_id";
		commonMethod(hql , 1);
		return "success";
	}

	public void commonMethod(String hql , int flag) throws Exception {
		allNationName = managerProvinceService.queryNation();	
		pageBean = pageService.queryPageProvince(hql, 10, page, "ProvinceModel", flag);
	}

	public String queryProvince() throws Exception {
		String hql = "select pm.province_id, pm.province_name, nm.nation_name from ProvinceModel pm,NationModel nm" +
					" where pm.nation_id = nm.nation_id" ;
		if(province_name_select != null ||  (!province_name_select.equals(""))) {
			hql = hql + " and pm.province_name like '" ;
			hql = hql + province_name_select.trim();
			hql = hql + "%'" ;
		} 
		hql = hql + " order by pm.province_id" ;
		commonMethod(hql , 1);
		return "success";
	}

	public String deleteProvince() throws Exception {
		if (province_ids != null && !"".equals(province_ids.trim())) {
			String[] nids = province_ids.split(";");
			if (nids.length > 0) {
				for (int i = 0; i < nids.length; i++) {
					flag = managerProvinceService.deleteProvince(Integer
							.valueOf(nids[i]));
				}
			}
		}
		if (flag.equals("ok")) {
			String hql = "select pm.province_id, pm.province_name, nm.nation_name from ProvinceModel pm,NationModel nm" +
					" where pm.nation_id = nm.nation_id order by pm.province_id";
			commonMethod(hql , 1);
			return "success";
		} else {
			addActionError("删除失败");
			return "failure";
		}
	}
	
	public String addProvince() throws Exception { 
		province_name_add = ConvertCharacter.Convert(province_name_add) ;
		nation_name_add = ConvertCharacter.Convert(nation_name_add) ;
		
		flag = managerProvinceService.addProvince(province_name_add, nation_name_add) ;
		if (flag.equals("ok")) { 
			String hql = "select pm.province_id, pm.province_name, nm.nation_name from ProvinceModel pm,NationModel nm" +
					" where pm.nation_id = nm.nation_id order by pm.province_id";
			commonMethod(hql , 1);
			return "success" ; 
		} else { 
			addActionError("添加失败") ; 
			return "failure" ; 
		} 
	}
	
	public String addNation() throws Exception { 
		nation_name = ConvertCharacter.Convert(nation_name) ;
		
		flag = managerProvinceService.addNation(nation_name) ;
		if (flag.equals("ok")) { 
			String hql = "select pm.province_id, pm.province_name, nm.nation_name from ProvinceModel pm,NationModel nm" +
					" where pm.nation_id = nm.nation_id order by pm.province_id";
			commonMethod(hql , 1);
			return "success" ; 
		} else { 
			addActionError("添加失败") ; 
			return "failure" ; 
		} 
	}
	 
}
