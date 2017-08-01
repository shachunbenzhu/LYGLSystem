package com.cn.ncist.rq.action.base;

import com.cn.ncist.rq.destination.service.ManagerDestinationService;
import com.cn.ncist.rq.note.service.ManagerNoteService;
import com.cn.ncist.rq.page.service.PageService;
import com.cn.ncist.rq.province.service.ManagerProvinceService;
import com.cn.ncist.rq.question.service.ManagerQuestionService;
import com.cn.ncist.rq.user.service.ManagerUserService;
import com.opensymphony.xwork2.Action;

//import org.yeeku.service.AuctionManager;
/**
 * @author  ศฮูป
 * @version  1.0
 */

public class BaseActionInterface implements Action
{
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

	public String execute() throws Exception
	{
		return SUCCESS;
	}
}