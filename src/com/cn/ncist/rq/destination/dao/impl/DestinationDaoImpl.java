package com.cn.ncist.rq.destination.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.cn.ncist.rq.destination.dao.DestinationDao;
import com.cn.ncist.rq.destination.vo.DestinationModel;
import com.cn.ncist.rq.note.vo.NoteModel;
import com.cn.ncist.rq.province.vo.NationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;


public class DestinationDaoImpl extends HibernateDaoSupport implements DestinationDao {

	public List<DestinationModel> queryDestinationById(Integer destination_id) {
		List<DestinationModel> destinationModelList = null ;
		
		try {
			String hql = "select dm from DestinationModel dm where dm.destination_id = " ;
			hql = hql + destination_id ;
			destinationModelList = this.getHibernateTemplate().find(hql);	
			this.getSession().close() ;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(destinationModelList == null)
		{
			System.out.println("null");
			return null;
		}
		if(destinationModelList.size() < 1)
		{
			System.out.println("size = 0");
			return null;
		}
		return destinationModelList;
	}
	
	public List<DestinationModel> queryDestinationByName(String destination_name) {
		List<DestinationModel> destinationModelList = null ;
		
		try {
			String hql = "select dm from DestinationModel dm where dm.destination_name = '" ;
			hql = hql + destination_name ;
			hql = hql + "'" ;
			destinationModelList = this.getHibernateTemplate().find(hql);	
			this.getSession().close() ;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(destinationModelList == null)
		{
			System.out.println("null");
			return null;
		}
		if(destinationModelList.size() < 1)
		{
			System.out.println("size = 0");
			return null;
		}
		return destinationModelList;
	}
	
	
	public List<DestinationModel> queryDestinationByProvinceName(String province_name) {
		List list1 = null ;
		List<DestinationModel> destinationModelList = new ArrayList<DestinationModel>() ;
		
		try {
			String hql = "select dm.destination_id, dm.destination_name, dm.destination_pinyin, dm.destination_number, " +
				"dm.destination_img , dm.destination_imgarr , dm.destination_desc , pm.province_name from DestinationModel dm, " +
				"ProvinceModel pm where pm.province_id = dm.province_id" ;
			
			if(!province_name.equals("")) {
				hql = hql + " and pm.province_name = '" ;
				hql = hql + province_name ;
				hql = hql + "'" ;
			}
			hql = hql + " order by dm.destination_id" ;
			
			Query query = this.getSession().createQuery(hql) ;
			list1 = query.list() ;
			
			for(int i = 0; i < list1.size(); i++){
				Object[] objects = (Object[]) list1.get(i) ;
				if(objects.length>0){
					DestinationModel destinationModel = new DestinationModel() ;
					destinationModel.setDestination_id((Integer)objects[0]) ;
					destinationModel.setDestination_name((String)objects[1]) ;
					destinationModel.setDestination_pinyin((String)objects[2]== null ? "" : (String)objects[2]) ;
					destinationModel.setDestination_number((Integer)objects[3]) ;
					destinationModel.setDestination_img((String)objects[4]== null ? "./images/common_default_bg.png" : (String)objects[4]) ;
					destinationModel.setDestination_imgarr((String)objects[5]== null ? "./images/common_default_bg.png;" : (String)objects[5]) ;
					destinationModel.setDestination_desc((String)objects[6]== null ? "" : (String)objects[6]) ;
					destinationModel.setProvince_name((String)objects[7]== null ? "" : (String)objects[7]) ;
						
					destinationModelList.add(destinationModel) ;
				}
			}
			this.getSession().close() ;
			return destinationModelList ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<DestinationModel> queryDestinationByNationName(String nation_name) {
		List list1 = null ;
		List<DestinationModel> destinationModelList = new ArrayList<DestinationModel>() ;
		
		try {
			String hql = "select dm.destination_id, dm.destination_name, dm.destination_pinyin, dm.destination_number, " +
				"dm.destination_img , dm.destination_imgarr , dm.destination_desc , pm.province_name from DestinationModel dm, " +
				"NationModel nm, ProvinceModel pm where nm.nation_id = dm.nation_id and dm.province_id = pm.province_id and nm.nation_name = '" ;
			
			hql = hql + nation_name ;
			hql = hql + "' order by dm.destination_id" ;
			
			Query query = this.getSession().createQuery(hql) ;
			list1 = query.list() ;
			
			for(int i = 0; i < list1.size(); i++){
				Object[] objects = (Object[]) list1.get(i) ;
				if(objects.length>0){
					DestinationModel destinationModel = new DestinationModel() ;
					destinationModel.setDestination_id((Integer)objects[0]) ;
					destinationModel.setDestination_name((String)objects[1]) ;
					destinationModel.setDestination_pinyin((String)objects[2]== null ? "" : (String)objects[2]) ;
					destinationModel.setDestination_number((Integer)objects[3]) ;
					destinationModel.setDestination_img((String)objects[4]== null ? "./images/common_default_bg.png" : (String)objects[4]) ;
					destinationModel.setDestination_imgarr((String)objects[5]== null ? "./images/common_default_bg.png;" : (String)objects[5]) ;
					destinationModel.setDestination_desc((String)objects[6]== null ? "" : (String)objects[6]) ;
					destinationModel.setProvince_name((String)objects[7]== null ? "" : (String)objects[7]) ;
						
					destinationModelList.add(destinationModel) ;
				}
			}
			this.getSession().close() ;
			return destinationModelList ;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void delete(Integer destination_id) {
		List<DestinationModel> destinationModelList = null ;
    	try {
    		String hql = "select dm from DestinationModel dm where dm.destination_id = " ;
			hql = hql + destination_id ;
			System.out.println(hql);
			destinationModelList = this.getHibernateTemplate().find(hql);
			if (destinationModelList != null)
			{
				for (DestinationModel destinationModel:destinationModelList) {
					this.getHibernateTemplate().delete(destinationModel);
				}
			}
			this.getSession().close() ;
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    public void update(DestinationModel destinationModel) {
    	this.getHibernateTemplate().update(destinationModel) ;
    	this.getSession().close() ;
    }
    
    public void save(DestinationModel destinationModel) {
		this.getHibernateTemplate().save(destinationModel) ;
		this.getSession().close() ;
    }

}
