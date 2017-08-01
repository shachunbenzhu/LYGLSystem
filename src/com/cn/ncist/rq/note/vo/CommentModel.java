package com.cn.ncist.rq.note.vo;

public class CommentModel {
	private Integer comment_id ;
	private String comment_date ;
	private String comment_content ;
	private Integer user_id ;
	private Integer note_id ;
	private String response_date ;
	private String response_content ;
	
	private String user_name ;
	private String user_touxiang ;
	
	public Integer getNote_id() {
		return note_id;
	}
	public void setNote_id(Integer noteId) {
		note_id = noteId;
	}
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer commentId) {
		comment_id = commentId;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String commentDate) {
		comment_date = commentDate;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String commentContent) {
		comment_content = commentContent;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer userId) {
		user_id = userId;
	}
	public String getResponse_date() {
		return response_date;
	}
	public void setResponse_date(String responseDate) {
		response_date = responseDate;
	}
	public String getResponse_content() {
		return response_content;
	}
	public void setResponse_content(String responseContent) {
		response_content = responseContent;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		user_name = userName;
	}
	public String getUser_touxiang() {
		return user_touxiang;
	}
	public void setUser_touxiang(String userTouxiang) {
		user_touxiang = userTouxiang;
	}
	
}
