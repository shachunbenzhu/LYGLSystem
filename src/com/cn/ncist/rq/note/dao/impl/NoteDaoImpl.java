package com.cn.ncist.rq.note.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cn.ncist.rq.destination.vo.DestinationModel;
import com.cn.ncist.rq.note.dao.NoteDao;
import com.cn.ncist.rq.note.vo.CommentModel;
import com.cn.ncist.rq.note.vo.NoteModel;

public class NoteDaoImpl extends HibernateDaoSupport implements NoteDao {

	@SuppressWarnings("unchecked")
	public List<NoteModel> queryAllNote() {
		List<NoteModel> list = new ArrayList<NoteModel>() ;

		try {
			String hql="select nm from NoteModel nm" ;
			System.out.println(hql) ;
			//pageBean = pageService.queryForPage(hql , 10 , page) ;
			//list = this.getSession().createQuery(hql).list() ;
			HibernateTemplate ht = this.getHibernateTemplate() ;
			list=ht.find(hql) ;
			this.getSession().close() ;
		} catch (Throwable et) {
			et.printStackTrace() ;
		}
		
		if(list == null) {
			System.out.println("null") ;
			return null ;
		}
		if(list.size() < 1) {
			System.out.println("size = 0") ;
			return null ;
		} else {
			return list;			// 要是返回Integer.parseInt(list.get(0).getUser_id())就不对
		}
	}

	/*public List<NoteModel> queryAllNoteDays() {
		List<NoteModel> allNoteDays = null ;
		
		try {
			String hql="select nm.note_id, nm.note_days from NoteModel nm" ;
			allNoteDays = this.getHibernateTemplate().find(hql);	
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(allNoteDays == null)
		{
			System.out.println("null");
			return null;
		}
		if(allNoteDays.size() < 1)
		{
			System.out.println("size = 0");
			return null;
		}
		return allNoteDays;
	}*/
	
	public List<NoteModel> queryAllNoteAndUser(int flag , String note_address) {
		List list1 = null ;
    	List<NoteModel> listModel = new ArrayList<NoteModel>() ;
		try {
			String hql="select nm.note_id , nm.note_title , nm.note_date , nm.note_days , nm.note_expend , nm.note_partner , " +
					"nm.note_seenumber , nm.note_zannumber , nm.note_commentnumber , nm.note_bgimg , nm.note_img , nm.note_address , " +
					"nm.note_content , um.user_name , um.user_touxiang from NoteModel nm,UserModel um where nm.user_id = um.user_id" ;	
			if(!note_address.equals("")) {
				hql = hql + " and nm.note_address = '" ;
				hql = hql + note_address ;
				hql = hql + "'" ;
			}
			hql = hql + " order by nm.note_date desc , note_seenumber desc" ;
			
			Query query = this.getSession().createQuery(hql) ;
			
			if (flag == 0) {//只查询第一条数据（头条）
				query.setFirstResult(0) ;
				query.setMaxResults(1) ;
			}
			list1 = query.list() ;
			
			for(int i = 0; i < list1.size(); i++){
				Object[] objects = (Object[]) list1.get(i) ;
				if(objects.length>0){
					NoteModel noteModel = new NoteModel() ;
					noteModel.setNote_id((Integer)objects[0]) ;
					noteModel.setNote_title((String)objects[1]) ;
					noteModel.setNote_date((String)objects[2]) ;
					noteModel.setNote_days((Integer)objects[3]) ;
					noteModel.setNote_expend((String)objects[4]) ;
					noteModel.setNote_partner((String)objects[5]== null ? "" : (String)objects[5]) ;
					noteModel.setNote_seenumber((Integer)objects[6]) ;
					noteModel.setNote_zannumber((Integer)objects[7]) ;
					noteModel.setNote_commentnumber((Integer)objects[8]) ;
					noteModel.setNote_bgimg((String)objects[9] == null ? "./images/common_default_bg.jpg" : (String)objects[9]) ;
					noteModel.setNote_img((String)objects[10] == null ? "" : (String)objects[10]) ;
					noteModel.setNote_address((String)objects[11]) ;
					noteModel.setNote_content((String)objects[12]) ;
					noteModel.setUser_name((String)objects[13]) ;
					noteModel.setUser_touxiang((String)objects[14] == null ? "./images/common_default_tx_wawa_small.png" : (String)objects[14]) ;
						
					listModel.add(noteModel) ;
				}
			}
			return listModel ;
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
	}
	
	public NoteModel queryNoteAndUser(int note_id) {
		List list1 = null ;
    	List<NoteModel> listModel = new ArrayList<NoteModel>() ;
		try {
			String hql="select nm.note_id , nm.note_title , nm.note_date , nm.note_days , nm.note_expend , nm.note_partner , " +
					"nm.note_seenumber , nm.note_zannumber , nm.note_commentnumber , nm.note_bgimg , nm.note_img , nm.note_address , " +
					"nm.note_content , um.user_name , um.user_touxiang from NoteModel nm,UserModel um where nm.user_id = um.user_id" + 
					"and nm.note_id = " ;
			
			hql = hql + note_id ;
			
			Query query = this.getSession().createQuery(hql) ;
			
			list1 = query.list() ;
			
			for(int i = 0; i < list1.size(); i++){
				Object[] objects = (Object[]) list1.get(i) ;
				if(objects.length>0){
					NoteModel noteModel = new NoteModel() ;
					noteModel.setNote_id((Integer)objects[0]) ;
					noteModel.setNote_title((String)objects[1]) ;
					noteModel.setNote_date((String)objects[2]) ;
					noteModel.setNote_days((Integer)objects[3]) ;
					noteModel.setNote_expend((String)objects[4]) ;
					noteModel.setNote_partner((String)objects[5]== null ? "" : (String)objects[5]) ;
					noteModel.setNote_seenumber((Integer)objects[6]) ;
					noteModel.setNote_zannumber((Integer)objects[7]) ;
					noteModel.setNote_commentnumber((Integer)objects[8]) ;
					noteModel.setNote_bgimg((String)objects[9] == null ? "./images/common_default_bg.jpg" : (String)objects[9]) ;
					noteModel.setNote_img((String)objects[10] == null ? "" : (String)objects[10]) ;
					noteModel.setNote_address((String)objects[11]) ;
					noteModel.setNote_content((String)objects[12]) ;
					noteModel.setUser_name((String)objects[13]) ;
					noteModel.setUser_touxiang((String)objects[14] == null ? "./images/common_default_tx_wawa_small.png" : (String)objects[14]) ;
						
					listModel.add(noteModel) ;
				}
			}
			return listModel.get(0) ;
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
	}
	
	public List<NoteModel> queryAllMyNote(int user_id) {
		List list1 = null ;
    	List<NoteModel> listModel = new ArrayList<NoteModel>() ;
		try {
			String hql="select nm.note_id , nm.note_title , nm.note_date , nm.note_days , nm.note_expend , nm.note_partner , " +
					"nm.note_seenumber , nm.note_zannumber , nm.note_commentnumber , nm.note_bgimg , nm.note_img , nm.note_address , " +
					"nm.note_content from NoteModel nm,UserModel um where nm.user_id = um.user_id and nm.user_id = " + user_id +
					" order by nm.note_date desc , note_seenumber desc" ;	
			Query query = this.getSession().createQuery(hql) ;
			list1 = query.list() ;
			
			for(int i = 0; i < list1.size(); i++){
				Object[] objects = (Object[]) list1.get(i) ;
				if(objects.length>0){
					NoteModel noteModel = new NoteModel() ;
					noteModel.setNote_id((Integer)objects[0]) ;
					noteModel.setNote_title((String)objects[1]) ;
					noteModel.setNote_date((String)objects[2]) ;
					noteModel.setNote_days((Integer)objects[3]) ;
					noteModel.setNote_expend((String)objects[4]) ;
					noteModel.setNote_partner((String)objects[5]== null ? "" : (String)objects[5]) ;
					noteModel.setNote_seenumber((Integer)objects[6]) ;
					noteModel.setNote_zannumber((Integer)objects[7]) ;
					noteModel.setNote_commentnumber((Integer)objects[8]) ;
					noteModel.setNote_bgimg((String)objects[9] == null ? "./images/common_default_bg.jpg" : (String)objects[9]) ;
					noteModel.setNote_img((String)objects[10] == null ? "" : (String)objects[10]) ;
					noteModel.setNote_address((String)objects[11]) ;
					noteModel.setNote_content((String)objects[12]) ;
						
					listModel.add(noteModel) ;
				}
			}
			return listModel ;
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
	}
	
	public List<NoteModel> queryNoteById(Integer note_id) {
		List<NoteModel> noteModelList = null ;
		
		try {
			String hql = "select nm from NoteModel nm where nm.note_id = " ;
			hql = hql + note_id ;
			noteModelList = this.getHibernateTemplate().find(hql);
			this.getSession().close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(noteModelList == null)
		{
			System.out.println("null");
			return null;
		}
		if(noteModelList.size() < 1)
		{
			System.out.println("size = 0");
			return null;
		}
		return noteModelList;
	}
	
	@SuppressWarnings("unchecked")
	public void delete(Integer note_id) {
		List<NoteModel> noteModelList = null ;
    	try {
    		System.out.println(note_id);
			String hql = "select nm from NoteModel nm where nm.note_id = " ;
			hql = hql + note_id ;
			System.out.println(hql);
			noteModelList = this.getHibernateTemplate().find(hql);
			
			if (noteModelList != null)
			{
				for (NoteModel noteModel:noteModelList) {
					this.getHibernateTemplate().delete(noteModel);
				}
			}
			this.getSession().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    public void update(NoteModel noteModel) {
    	this.getHibernateTemplate().update(noteModel) ;
    }
    
    public void save(NoteModel noteModel) {
		this.getHibernateTemplate().save(noteModel) ;
		this.getSession().close();
    }
    
    public List<CommentModel> queryComment(Integer note_id) {
    	List list = null ;
    	List<CommentModel> commentModellist = new ArrayList<CommentModel>() ;
    	
    	try {
			String hql="select cm.comment_id, cm.comment_date, cm.comment_content, cm.response_date, cm.response_content, " +
				"um.user_name, um.user_touxiang from NoteModel nm, UserModel um, CommentModel cm where um.user_id = cm.user_id and cm.note_id = nm.note_id " +
				"and cm.note_id = " + note_id ;
			System.out.println(hql) ;
			list = this.getHibernateTemplate().find(hql) ;
			this.getSession().close();
			
			for(int i = 0; i < list.size(); i++){
				Object[] objects = (Object[]) list.get(i) ;
				if(objects.length>0){
					CommentModel commentModel = new CommentModel() ;
					commentModel.setComment_id((Integer)objects[0]) ;   //把值赋给属性,并强制转换
					commentModel.setComment_date((String)objects[1]) ;
					commentModel.setComment_content((String)objects[2]) ;
					commentModel.setResponse_date((String)objects[3] == null ? "" : (String)objects[3]) ;
					commentModel.setResponse_content((String)objects[4] == null ? "" : (String)objects[4]) ;
					commentModel.setUser_name((String)objects[5]) ;
					commentModel.setUser_touxiang((String)objects[6] == null ? "./images/common_default_tx_wawa_small.png" : (String)objects[6]) ;
					commentModellist.add(commentModel) ;
				}
			}
			return commentModellist ;
			
		} catch (Exception e) {
			e.printStackTrace() ;
			return null ;
		}
    }
    
    public CommentModel queryCommentById(Integer comment_id) {
    	List list = null ;
    	
    	try {
			String hql="select cm from CommentModel cm where cm.comment_id = " + comment_id ;
			System.out.println(hql) ;
			list = this.getHibernateTemplate().find(hql) ;		
			this.getSession().close();
		} catch (Exception e) {
			e.printStackTrace() ;
		} 
		
		if(list == null) {
			System.out.println("null") ;
			return null ;
		}
		if(list.size() < 1) {
			System.out.println("size = 0") ;
			return null ;
		} else {
			return (CommentModel) list.get(0) ;			
		}
    }
    
    
    public void save(CommentModel commentModel) {
		this.getHibernateTemplate().save(commentModel) ;
		this.getSession().close();
    }
    
    public void deleteComm(Integer comment_id) {
		List<CommentModel> commentModelList = null ;
    	try {
			String hql = "select cm from CommentModel cm where cm.comment_id = " ;
			hql = hql + comment_id ;
			commentModelList = this.getHibernateTemplate().find(hql);
			if (commentModelList != null)
			{
				for (CommentModel commentModel:commentModelList) {
					this.getHibernateTemplate().delete(commentModel);
				}
			}
			this.getSession().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
