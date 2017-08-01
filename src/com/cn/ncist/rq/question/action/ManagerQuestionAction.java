package com.cn.ncist.rq.question.action;

import java.util.List;
import com.cn.ncist.rq.Tools.ConvertCharacter;
import com.cn.ncist.rq.action.base.BaseAction;
import com.cn.ncist.rq.page.vo.PageBean;
import com.cn.ncist.rq.question.vo.QuestionModel;

public class ManagerQuestionAction extends BaseAction {

	private PageBean pageBean = null;
	private int page; // 用户提交的当前页数
	private String question_ids;
	private String question_infos;
	private String question_label_select;
	private List<QuestionModel> allQuestionLabel;
	private String flag ;
	
	private String question_label_add;
	private String question_content_add;
	private String question_answer_add;
	
	public String getQuestion_ids() {
		return question_ids;
	}

	public void setQuestion_ids(String questionIds) {
		question_ids = questionIds;
	}

	public String getQuestion_infos() {
		return question_infos;
	}

	public void setQuestion_infos(String questionInfos) {
		question_infos = questionInfos;
	}

	public String getQuestion_label_select() {
		return question_label_select;
	}

	public void setQuestion_label_select(String questionLabelSelect) {
		question_label_select = questionLabelSelect;
	}

	public List<QuestionModel> getAllQuestionLabel() {
		return allQuestionLabel;
	}

	public void setAllQuestionLabel(List<QuestionModel> allQuestionLabel) {
		this.allQuestionLabel = allQuestionLabel;
	}

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
	
	public String getQuestion_label_add() {
		return question_label_add;
	}

	public void setQuestion_label_add(String questionLabelAdd) {
		question_label_add = questionLabelAdd;
	}

	public String getQuestion_content_add() {
		return question_content_add;
	}

	public void setQuestion_content_add(String questionContentAdd) {
		question_content_add = questionContentAdd;
	}

	public String getQuestion_answer_add() {
		return question_answer_add;
	}

	public void setQuestion_answer_add(String questionAnswerAdd) {
		question_answer_add = questionAnswerAdd;
	}

	@Override
	public String execute() throws Exception { // 分页查询所有Note
		String hql = "select qm from QuestionModel qm order by qm.question_id";
		commonMethod(hql);
		return "success";
	}

	public void commonMethod(String hql) throws Exception {
		allQuestionLabel = managerQuestionService.queryQuestion();	
		pageBean = pageService.queryPageQuestion(hql, 10, page, "QuestionModel");
	}

	public String queryQuestion() throws Exception {
		//question_label_select = ConvertCharacter.Convert(question_label_select) ;
		
		String hql = "select qm from QuestionModel qm where 1=1" ;//注意，这样就不需要判断是否加and
		if(!question_label_select.equals(String.valueOf(-1))) {
			hql = hql + " and qm.question_label = '" ;
			hql = hql + question_label_select;
			hql = hql + "'" ;
		} 
		hql = hql + " order by qm.question_id" ;
		commonMethod(hql);
		return "success";
	}

	public String deleteQuestion() throws Exception {
		if (question_ids != null && !"".equals(question_ids.trim())) {
			String[] nids = question_ids.split(";");
			if (nids.length > 0) {
				for (int i = 0; i < nids.length; i++) {
					flag = managerQuestionService.deleteQuestion(Integer
							.valueOf(nids[i]));
				}
			}
		}
		if (flag.equals("ok")) {
			String hql = "select qm from QuestionModel qm order by qm.question_id";
			commonMethod(hql);
			return "success";
		} else {
			addActionError("删除失败");
			return "failure";
		}
	}

	public String updateQuestion() throws Exception {
		
		if (question_infos != null && !"".equals(question_infos.trim())) {
			String[] ninfos = question_infos.split(";");
			if (ninfos.length > 0) {
				flag = managerQuestionService.updateQuestion(
						Integer.valueOf(ninfos[0]), ConvertCharacter.Convert(ninfos[1]), 
						ConvertCharacter.Convert(ninfos[2]), ConvertCharacter.Convert(ninfos[3]));
			}
		}
		if (flag.equals("ok")) {
			String hql = "select qm from QuestionModel qm order by qm.question_id";
			commonMethod(hql);
			return "success";
		} else {
			addActionError("修改失败");
			return "failure";
		}
	}

	
	public String addQuestion() throws Exception { 
		question_content_add = ConvertCharacter.Convert(question_content_add) ;
		question_answer_add = ConvertCharacter.Convert(question_answer_add) ;
		question_label_add = ConvertCharacter.Convert(question_label_add) ;
		
		flag = managerQuestionService.addQuestion(question_content_add, question_answer_add, question_label_add) ;
		if (flag.equals("ok")) { 
			String hql = "select qm from QuestionModel qm order by qm.question_id";
			commonMethod(hql);
			return "success" ; 
		} else { 
			addActionError("添加失败") ; 
			return "failure" ; 
		} 
	}
	 
}
