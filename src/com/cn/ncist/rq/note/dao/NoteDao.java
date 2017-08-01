package com.cn.ncist.rq.note.dao;

import java.util.List;

import com.cn.ncist.rq.note.vo.CommentModel;
import com.cn.ncist.rq.note.vo.NoteModel;

/**
 * @author  ��ٻ
 * @version  1.0
 */
public interface NoteDao {
	//public boolean IsUserIsOk(String user, String password,String verifycode);
	/**
     * ��������NOte
     * @return 
     */ 
	List<NoteModel> queryAllNote() ;
	
	/**
	 * ��ѯ�����μǰ����û�
	 * @return
	 */
	List<NoteModel> queryAllNoteAndUser(int flag , String note_address) ;
	
	List<NoteModel> queryAllMyNote(int user_id) ;
	
	NoteModel queryNoteAndUser(int note_id) ;
	/**
	 * ��ѯ���������һ���μ�
	 * @return
	 */
	//NoteModel queryOneNote() ;
    
    /**
     * ������������
     * @return List
     */
    //List<NoteModel> queryAllNoteDays() ;
    
    /**
     * �����μ�ID��ѯ�μ�
     * @param note_id
     * @return
     */
    List<NoteModel> queryNoteById(Integer note_id) ;
    
    /**
     * ����
     * @param noteModel
     */ 
    void save(NoteModel noteModel) ;
    
    /**
     * ɾ��ѡ�е��μ�
     * @param note_id
     */
    void delete(Integer note_id) ;
    
    /**
     * �޸��μ�
     * @param QuestionModel �μǶ���
     */ 
    void update(NoteModel noteModel) ;
    
    /**
     * �����μ�ID��ѯ����
     * @param note_id
     * @return
     */
    List<CommentModel> queryComment(Integer note_id) ;
    
    /**
     * ��������ID��ѯ����
     * @param comment_id
     * @return
     */
    CommentModel queryCommentById(Integer comment_id) ;
    
    /**
     * ������������
     * @param commentModel
     */
    void save(CommentModel commentModel) ;
    
    /**
     * ɾ������
     * @param comment_id
     */
    void deleteComm(Integer comment_id) ;
}
