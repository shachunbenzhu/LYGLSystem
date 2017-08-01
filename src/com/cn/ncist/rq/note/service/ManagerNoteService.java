package com.cn.ncist.rq.note.service;

import java.util.List;

import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.note.vo.CommentModel;
import com.cn.ncist.rq.note.vo.NoteModel;

public interface ManagerNoteService {
	/**
     * ��ҳ��ѯ
     * @param currentPage ��ǰҳ��
     * @param pageSize ÿҳ��С
     * @return PageBean
     */
	
    //PageBean queryForPage(String hql , int pageSize , int currentPage) throws ManagerException ;
	
	/**
	 * ��ѯ�����μ�
	 * @return PageBean
	 */
	//PageBean queryAllNote() throws ManagerException ;
	
	List<NoteModel> queryNote() throws ManagerException ;
	
	NoteModel queryNoteById(int note_id) throws ManagerException ;
	/**
	 * ��ѯ�����μǣ������û���Ϣ
	 * @return
	 * @throws ManagerException
	 */
	List<NoteModel> queryAllNote(String note_address) throws ManagerException ;
	
	/**
	 * �����û�id��ѯ��Ӧ�û����μ�
	 * @param user_id
	 * @return
	 * @throws ManagerException
	 */
	List<NoteModel> queryMyNote(int user_id) throws ManagerException ;
	/**
	 * ��ѯ����������μ�
	 * @return
	 * @throws ManagerException
	 */
	NoteModel queryTtNote() throws ManagerException ;
    /**
     * ��ѯ�����μ�����
     * @return List
     */
    //List<NoteModel> queryNoteDays() throws ManagerException ;
    
    /**
     * ����ID��ѯ�μ�
     * @return
     * @throws ManagerException
     */
    List<NoteModel> queryNoteDetile(Integer note_id) throws ManagerException ;
    
    /**
     * ɾ��ѡ�е��μ�
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
     * ��ѯ��������
     * @param note_id
     * @return
     * @throws ManagerException
     */
    List<CommentModel> queryAllComment(Integer note_id) throws ManagerException ;
    
    /**
     * ��������ID��ѯ�μ�ID
     * @param comment_id
     * @return
     * @throws ManagerException
     */
    Integer queryNoteIdByCommentId(Integer comment_id) throws ManagerException ;
    
    String addComment(CommentModel commentModel) throws ManagerException ;
    /**
     * ɾ������
     * @param note_id
     * @return
     * @throws ManagerException
     */
    String deleteComment(Integer comment_id) throws ManagerException ;
}
