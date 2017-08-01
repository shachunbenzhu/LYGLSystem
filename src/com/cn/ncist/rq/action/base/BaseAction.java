package com.cn.ncist.rq.action.base;

import com.cn.ncist.rq.destination.service.ManagerDestinationService;
import com.cn.ncist.rq.note.service.ManagerNoteService;
import com.cn.ncist.rq.page.service.PageService;
import com.cn.ncist.rq.province.service.ManagerProvinceService;
import com.cn.ncist.rq.question.service.ManagerQuestionService;
import com.cn.ncist.rq.user.service.ManagerUserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author ศฮูป
 * @version 1.0 <br>
 *          Copyright (C), 2005-2008, yeeku.H.Lee <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: <br>
 *          Date:
 */

public class BaseAction extends ActionSupport {
	/*protected LoginService loginService;
	protected RegisterService registerService;*/
	protected ManagerUserService managerUserService ;
	protected PageService pageService ;
	protected ManagerNoteService managerNoteService ;
	protected ManagerQuestionService managerQuestionService ;
	protected ManagerDestinationService managerDestinationService ;
	protected ManagerProvinceService managerProvinceService ;
	
	public ManagerUserService getManagerUserService() {
		return managerUserService;
	}

	public void setManagerUserService(ManagerUserService managerUserService) {
		this.managerUserService = managerUserService;
	}

	public PageService getPageService() {
		return pageService;
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}

	public ManagerNoteService getManagerNoteService() {
		return managerNoteService;
	}

	public void setManagerNoteService(ManagerNoteService managerNoteService) {
		this.managerNoteService = managerNoteService;
	}

	public ManagerQuestionService getManagerQuestionService() {
		return managerQuestionService;
	}

	public void setManagerQuestionService(
			ManagerQuestionService managerQuestionService) {
		this.managerQuestionService = managerQuestionService;
	}

	public ManagerDestinationService getManagerDestinationService() {
		return managerDestinationService;
	}

	public void setManagerDestinationService(
			ManagerDestinationService managerDestinationService) {
		this.managerDestinationService = managerDestinationService;
	}

	public ManagerProvinceService getManagerProvinceService() {
		return managerProvinceService;
	}

	public void setManagerProvinceService(
			ManagerProvinceService managerProvinceService) {
		this.managerProvinceService = managerProvinceService;
	}
	
}