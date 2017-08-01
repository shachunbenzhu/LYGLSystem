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
     * ��ҳ��ѯ,�Ӳ�ͬ�����ѯʱList�д��Object�������޸�Ϊʵ��,��ͬһ�����ѯʱList�д��ʵ�壬����ֱ�ӷ���
     * @param hql ��ѯ���
     * @param offset ��ʼ��¼
     * @param length һ�β�ѯ�ļ�¼��
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
				//list1�д�ŵ��Ǹ������飬һ������һ����¼����һ����������Ƕ�����飬ÿ��������һ������Ҳ����һ���ֶ�
				for(int i = 0; i < list1.size(); i++){
					Object[] objects = (Object[]) list1.get(i) ;
					if(objects.length>0){
						NoteModel noteModel = new NoteModel() ;
						noteModel.setNote_id((Integer)objects[0]) ;   //��ֵ��������,��ǿ��ת��
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
     * ��ѯ���м�¼��
     * @param hql ��ѯ���
     * @return �ܼ�¼��
     */
    public int getAllRowCount(String hql) {
    	return this.getHibernateTemplate().find(hql).size() ;
    	
    }
}
