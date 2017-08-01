package com.cn.ncist.rq.user.action;

import java.util.Map;

import com.cn.ncist.rq.Tools.ConvertCharacter;
import com.cn.ncist.rq.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;

public class LoginRegisterAction extends BaseAction {
	private String admin_name ;
	private String admin_pwd ;
	private Integer admin_id ;
	private String admin_question ;
	private String admin_answer ;
	
	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String adminName) {
		admin_name = adminName;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String adminPwd) {
		admin_pwd = adminPwd;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer adminId) {
		admin_id = adminId;
	}

	public String getAdmin_question() {
		return admin_question;
	}

	public void setAdmin_question(String adminQuestion) {
		admin_question = adminQuestion;
	}

	public String getAdmin_answer() {
		return admin_answer;
	}

	public void setAdmin_answer(String adminAnswer) {
		admin_answer = adminAnswer;
	}
	
	public String execute() throws Exception {
		if (admin_name == null || admin_pwd == null) {
			return "failure" ;
		}
		Map session = ActionContext.getContext().getSession() ;
		admin_id = managerUserService.validLogin(admin_name , admin_pwd) ;
		if (admin_id != null) {
			session.put("user_id" , admin_id) ;
			return "success" ;
		} else {
			addActionError("用户名/密码不匹配") ;
			return "failure" ;
		}
	}
	
	public String register() throws Exception {
		admin_id = managerUserService.testAdminName(admin_name) ;
		if (admin_id != null) {
			addActionError("此用户名已存在") ;
			return "failure" ;
		} else {
			admin_id = managerUserService.validRegister(admin_name , admin_pwd , ConvertCharacter.Convert(admin_question) , ConvertCharacter.Convert(admin_answer)) ;
			if (admin_id != null) {
				return "success" ;
			} else {
				addActionError("此用户已存在") ;
				return "failure" ;
			}
		}
	}
	
	/*public String testAdminName() throws Exception {
	admin_id = managerUserService.testAdminName(admin_name) ;
	System.out.println(admin_name) ;
	if (admin_id != null) {
		return "success" ;
	} else {
		addActionError("此用户已存在") ;
		return "failure" ;
	}
}*/
	
}
