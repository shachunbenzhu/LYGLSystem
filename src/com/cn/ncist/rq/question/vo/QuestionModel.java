package com.cn.ncist.rq.question.vo;

public class QuestionModel {
	private Integer question_id ;
	private String question_content ;
	private String question_answer ;
	private String question_label ;
	
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer questionId) {
		question_id = questionId;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String questionContent) {
		question_content = questionContent;
	}
	public String getQuestion_answer() {
		return question_answer;
	}
	public void setQuestion_answer(String questionAnswer) {
		question_answer = questionAnswer;
	}
	public String getQuestion_label() {
		return question_label;
	}
	public void setQuestion_label(String questionLabel) {
		question_label = questionLabel;
	}
}