package com.cn.ncist.rq.note.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.note.dao.NoteDao;
import com.cn.ncist.rq.note.service.ManagerNoteService;
import com.cn.ncist.rq.note.vo.CommentModel;
import com.cn.ncist.rq.note.vo.NoteModel;
import com.cn.ncist.rq.page.vo.PageBean;
import com.cn.ncist.rq.user.dao.UserDao;

public class ManagerNoteServiceImpl implements ManagerNoteService {
	static Logger log = Logger.getLogger(ManagerNoteServiceImpl.class.getName()) ;
	private NoteDao noteDao ;
	private UserDao userDao ;
	
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		ManagerNoteServiceImpl.log = log;
	}

	public NoteDao getNoteDao() {
		return noteDao;
	}

	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*public PageBean queryAllNote() {
		String hql="select nm from NoteModel nm" ;
		PageBean pageBean = pageService.queryForPage(hql , 10 , page) ;
		PageBean pageBean = noteDao.queryAllNote() ;
		return null;
	}*/

	/*public PageBean queryForPage(String hql, int pageSize, int currentPage) {
		return null;
	}*/

	public List<NoteModel> queryNote() throws ManagerException  {
		try {
            return noteDao.queryAllNote() ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询游记出现异常,请重试") ;
        }
	}
	
	public List<NoteModel> queryAllNote(String note_address) throws ManagerException  {
		try {
            return noteDao.queryAllNoteAndUser(1 , note_address) ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询游记出现异常,请重试") ;
        }
	}
	
	public NoteModel queryNoteById(int note_id) throws ManagerException  {
		try {
            return noteDao.queryNoteAndUser(note_id) ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询游记出现异常,请重试") ;
        }
	}
	
	public List<NoteModel> queryMyNote(int user_id) throws ManagerException  {
		try {
            return noteDao.queryAllMyNote(user_id) ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询游记出现异常,请重试") ;
        }
	}
	
	/*public List<NoteModel> queryNoteDays() throws ManagerException  {
		try {
            return noteDao.queryAllNote() ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询游记天数出现异常,请重试") ;
        }
	}*/
	
	public NoteModel queryTtNote() throws ManagerException  {
		try {
            return noteDao.queryAllNoteAndUser(0 , "").get(0) ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询游记出现异常,请重试") ;
        }
	}
	
	public List<NoteModel> queryNoteDetile(Integer note_id) throws ManagerException  {
		try {
            List<NoteModel> list = noteDao.queryNoteById(note_id) ;   
            NoteModel noteModel = list.get(0) ;
            list.remove(0) ;
            noteModel.setUser_name(userDao.queryUserNameById(noteModel.getUser_id()).getUser_name()) ;
            list.add(noteModel) ;
            return list ;
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询游记出现异常,请重试") ;
        }
	}
	
	public String deleteNote(Integer note_id) throws ManagerException {
    	try {
    		noteDao.delete(note_id);    
    		return "ok" ;
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("删除游记出现异常,请重试") ;
        }
    }
	
	public String saveNote(NoteModel noteModel) throws ManagerException {
    	try {
    		noteDao.save(noteModel);    
    		return "ok" ;
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("保存游记出现异常,请重试") ;
        }
    }
	
	public Integer updateNoteZan(Integer note_id) throws ManagerException {
    	try {
    		NoteModel noteModel = noteDao.queryNoteById(note_id).get(0) ;
    		Integer zannum = noteModel.getNote_zannumber() + 1 ;
    		noteModel.setNote_zannumber(zannum) ;
    		noteDao.update(noteModel);    
    		return zannum ;
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("更新游记点赞数量出现异常,请重试") ;
        }
    }
	
	/*public String updateNote(Integer note_id , String note_title , String note_date , 
    		Integer note_days , Double note_expend , String note_address , 
    		Integer note_zannumber , Integer note_seenumber , Integer note_commentnumber , 
    		String user_name) throws ManagerException {
    	try {
    		Integer user_id = userDao.queryUserIdByName(user_name.trim()) ;
    		NoteModel noteModel = noteDao.queryNoteById(note_id).get(0) ;
    		noteModel.setNote_title(note_title.trim()) ;
    		noteModel.setNote_date(note_date.trim()) ;
    		noteModel.setNote_days(note_days) ;
    		noteModel.setNote_expend(note_expend) ;
    		noteModel.setNote_address(note_address.trim()) ;
    		noteModel.setNote_zannumber(note_zannumber) ;
    		noteModel.setNote_seenumber(note_seenumber) ;
    		noteModel.setNote_commentnumber(note_commentnumber) ;
    		noteModel.setUser_id(user_id) ;
    		
    		noteDao.update(noteModel);
    		return "ok" ;          
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("修改游记信息出现异常,请重试") ;
        }
    }*/

	public List<CommentModel> queryAllComment(Integer note_id) throws ManagerException {
		try {
			return noteDao.queryComment(note_id) ;
		} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询评论出现异常,请重试") ;
        }
	}
	
	public Integer queryNoteIdByCommentId(Integer comment_id) throws ManagerException  {
		try {
            return noteDao.queryCommentById(comment_id).getNote_id() ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询游记出现异常,请重试") ;
        }
	}
	
	public String addComment(CommentModel commentModel) throws ManagerException {
    	try {
    		noteDao.save(commentModel);    
    		return "ok" ;
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("保存游记出现异常,请重试") ;
        }
    }
	
	public String deleteComment(Integer comment_id) throws ManagerException {
    	try {
    		noteDao.deleteComm(comment_id);    
    		return "ok" ;
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("删除评论出现异常,请重试") ;
        }
    }
}
