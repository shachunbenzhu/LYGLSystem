package com.cn.ncist.rq.page.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.cn.ncist.rq.destination.vo.DestinationModel;
import com.cn.ncist.rq.note.vo.NoteModel;
import com.cn.ncist.rq.page.dao.PageDao;
import com.cn.ncist.rq.province.vo.ProvinceModel;

public class PageDaoImpl extends HibernateDaoSupport implements PageDao {
	/**
     * 分页查询,从不同表里查询时List中存放Object，必须修改为实体,从同一表里查询时List中存放实体，可以直接返回
     * @param hql 查询语句
     * @param offset 开始记录
     * @param length 一次查询的记录数
     * @return
     */
    public List<NoteModel> queryForPageNote(final String hql , final int offset , final int length , final int flag ) {
    	List list1 = null ;
    	List<NoteModel> listModel = new ArrayList<NoteModel>() ;
    	try {	
			Query query = this.getSession().createQuery(hql) ;
			query.setFirstResult(offset) ;
			query.setMaxResults(length) ;
			list1 = query.list() ;
			
			if(flag == 0) {
				return list1 ;
			} else {
				//list1中存放的是各个数组，一个数组一条记录，而一个数组中又嵌套数组，每个数组存放一个属性也就是一个字段
				for(int i = 0; i < list1.size(); i++){
					Object[] objects = (Object[]) list1.get(i) ;
					if(objects.length>0){
						NoteModel noteModel = new NoteModel() ;
						noteModel.setNote_id((Integer)objects[0]) ;   //把值赋给属性,并强制转换
						noteModel.setNote_title((String)objects[1]) ;
						noteModel.setNote_date((String)objects[2]) ;
						noteModel.setNote_days((Integer)objects[3]) ;
						noteModel.setNote_expend((String)objects[4]) ;
						noteModel.setUser_name((String)objects[5]) ;
						noteModel.setNote_address((String)objects[6]) ;
						noteModel.setNote_zannumber((Integer)objects[7]) ;
						noteModel.setNote_seenumber((Integer)objects[8]) ;
						noteModel.setNote_commentnumber((Integer)objects[9]) ;
						listModel.add(noteModel) ;
					}
				}
				return listModel ;
			}
			
			/*NoteModel mm = new NoteModel();
			Iterator it = list.iterator();
			mm.setNote_id(it.next()) ;*/
			//list.add(mm);
//	         NoteModel noteModel = new NoteModel() ;
//	         for(int i = 0; i < list.size(); i++) {
//	        	 noteModel.setNote_id(list.get(i).getClass()) ;
//	        	 listModel.add(noteModel) ;
//	         }
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
    }
    
    public List<ProvinceModel> queryForPageQuestion(final String hql , final int offset , final int length ) {
    	List list1 = null ;
    	try {	
			Query query = this.getSession().createQuery(hql) ;
			query.setFirstResult(offset) ;
			query.setMaxResults(length) ;
			list1 = query.list() ;
			
			this.getSession().close() ;
			return list1 ;
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
    }
    
    public List<DestinationModel> queryForPageDestination(final String hql , final int offset , final int length , final int flag ) {
    	List list1 = null ;
    	List<DestinationModel> listModel = new ArrayList<DestinationModel>() ;
    	try {	
			Query query = this.getSession().createQuery(hql) ;
			query.setFirstResult(offset) ;
			query.setMaxResults(length) ;
			list1 = query.list() ;
			
			if(flag == 0) {
				return list1 ;
			} else {
				for(int i = 0; i < list1.size(); i++){
					Object[] objects = (Object[]) list1.get(i) ;
					if(objects.length>0){
						DestinationModel destinationModel = new DestinationModel() ;
						destinationModel.setDestination_id((Integer)objects[0]) ;
						destinationModel.setDestination_name((String)objects[1]) ;
						destinationModel.setDestination_pinyin((String)objects[2]) ;
						destinationModel.setDestination_number((Integer)objects[3]) ;
						destinationModel.setDestination_img((String)objects[4]) ;
						destinationModel.setProvince_name((String)objects[5]) ;
						destinationModel.setNation_name((String)objects[6]) ;
						
						listModel.add(destinationModel) ;
					}
				}
				return listModel ;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
    }
    
    public List<ProvinceModel> queryForPageProvince(final String hql , final int offset , final int length , final int flag ) {
    	List list1 = null ;
    	List<ProvinceModel> listModel = new ArrayList<ProvinceModel>() ;
    	try {	
			Query query = this.getSession().createQuery(hql) ;
			query.setFirstResult(offset) ;
			query.setMaxResults(length) ;
			list1 = query.list() ;
			
			if(flag == 0) {
				return list1 ;
			} else {
				for(int i = 0; i < list1.size(); i++){
					Object[] objects = (Object[]) list1.get(i) ;
					if(objects.length>0){
						ProvinceModel provinceModel = new ProvinceModel() ;
						provinceModel.setProvince_id((Integer)objects[0]) ;
						provinceModel.setProvince_name((String)objects[1]) ;
						provinceModel.setNation_name((String)objects[2]) ;
						
						listModel.add(provinceModel) ;
					}
				}
				return listModel ;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null ;
		}
    }
    
    /**
     * 查询所有记录数
     * @param hql 查询语句
     * @return 总记录数
     */
    public int getAllRowCount(String hql) {
    	return this.getHibernateTemplate().find(hql).size() ;
    	
    }
}
