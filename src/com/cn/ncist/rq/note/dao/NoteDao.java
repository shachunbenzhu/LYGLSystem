package com.cn.ncist.rq.note.dao;

import java.util.List;

import com.cn.ncist.rq.note.vo.CommentModel;
import com.cn.ncist.rq.note.vo.NoteModel;

/**
 * @author  任倩
 * @version  1.0
 */
public interface NoteDao {
	//public boolean IsUserIsOk(String user, String password,String verifycode);
	/**
     * 查找所有NOte
     * @return 
     */ 
	List<NoteModel> queryAllNote() ;
	
	/**
	 * 查询所有游记包括用户
	 * @return
	 */
	List<NoteModel> queryAllNoteAndUser(int flag , String note_address) ;
	
	List<NoteModel> queryAllMyNote(int user_id) ;
	
	NoteModel queryNoteAndUser(int note_id) ;
	/**
	 * 查询最新最精华的一条游记
	 * @return
	 */
	//NoteModel queryOneNote() ;
    
    /**
     * 查找所有天数
     * @return List
     */
    //List<NoteModel> queryAllNoteDays() ;
    
    /**
     * 根据游记ID查询游记
     * @param note_id
     * @return
     */
    List<NoteModel> queryNoteById(Integer note_id) ;
    
    /**
     * 保存
     * @param noteModel
     */ 
    void save(NoteModel noteModel) ;
    
    /**
     * 删除选中的游记
     * @param note_id
     */
    void delete(Integer note_id) ;
    
    /**
     * 修改游记
     * @param QuestionModel 游记对象
     */ 
    void update(NoteModel noteModel) ;
    
    /**
     * 根据游记ID查询评论
     * @param note_id
     * @return
     */
    List<CommentModel> queryComment(Integer note_id) ;
    
    /**
     * 根据评论ID查询评论
     * @param comment_id
     * @return
     */
    CommentModel queryCommentById(Integer comment_id) ;
    
    /**
     * 保存评论内容
     * @param commentModel
     */
    void save(CommentModel commentModel) ;
    
    /**
     * 删除评论
     * @param comment_id
     */
    void deleteComm(Integer comment_id) ;
}
