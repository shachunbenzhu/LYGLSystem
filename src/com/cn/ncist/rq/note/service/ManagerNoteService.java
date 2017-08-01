package com.cn.ncist.rq.note.service;

import java.util.List;

import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.note.vo.CommentModel;
import com.cn.ncist.rq.note.vo.NoteModel;

public interface ManagerNoteService {
	/**
     * 分页查询
     * @param currentPage 当前页数
     * @param pageSize 每页大小
     * @return PageBean
     */
	
    //PageBean queryForPage(String hql , int pageSize , int currentPage) throws ManagerException ;
	
	/**
	 * 查询所有游记
	 * @return PageBean
	 */
	//PageBean queryAllNote() throws ManagerException ;
	
	List<NoteModel> queryNote() throws ManagerException ;
	
	NoteModel queryNoteById(int note_id) throws ManagerException ;
	/**
	 * 查询所有游记，包括用户信息
	 * @return
	 * @throws ManagerException
	 */
	List<NoteModel> queryAllNote(String note_address) throws ManagerException ;
	
	/**
	 * 根据用户id查询对应用户的游记
	 * @param user_id
	 * @return
	 * @throws ManagerException
	 */
	List<NoteModel> queryMyNote(int user_id) throws ManagerException ;
	/**
	 * 查询最新最精华的游记
	 * @return
	 * @throws ManagerException
	 */
	NoteModel queryTtNote() throws ManagerException ;
    /**
     * 查询所有游记天数
     * @return List
     */
    //List<NoteModel> queryNoteDays() throws ManagerException ;
    
    /**
     * 根据ID查询游记
     * @return
     * @throws ManagerException
     */
    List<NoteModel> queryNoteDetile(Integer note_id) throws ManagerException ;
    
    /**
     * 删除选中的游记
     * @param note_id
     * @return
     * @throws ManagerException
     */
    String deleteNote(Integer note_id) throws ManagerException ;
    /*String updateNote(Integer note_id , String note_title , String note_date , 
    		Integer note_days , Double note_expend , String note_partner , 
    		Integer note_zannumber , Integer note_seenumber , Integer note_commentnumber , 
    		String user_name , String note_bgimg , String note_img , String note_img_desc , 
    		String comment_content , String note_address , String note_content) throws ManagerException ;*/
    
    String saveNote(NoteModel noteModel) throws ManagerException ;
    
    Integer updateNoteZan(Integer note_id) throws ManagerException ;
    
    /**
     * 查询所有评论
     * @param note_id
     * @return
     * @throws ManagerException
     */
    List<CommentModel> queryAllComment(Integer note_id) throws ManagerException ;
    
    /**
     * 根据评论ID查询游记ID
     * @param comment_id
     * @return
     * @throws ManagerException
     */
    Integer queryNoteIdByCommentId(Integer comment_id) throws ManagerException ;
    
    String addComment(CommentModel commentModel) throws ManagerException ;
    /**
     * 删除评论
     * @param note_id
     * @return
     * @throws ManagerException
     */
    String deleteComment(Integer comment_id) throws ManagerException ;
}
