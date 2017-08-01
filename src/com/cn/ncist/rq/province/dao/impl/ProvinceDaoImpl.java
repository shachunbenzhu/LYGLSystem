package com.cn.ncist.rq.province.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.cn.ncist.rq.province.dao.ProvinceDao;
import com.cn.ncist.rq.province.vo.NationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;

public class ProvinceDaoImpl extends HibernateDaoSupport implements ProvinceDao {

	public List<ProvinceModel> queryAllProvince() {
		List<ProvinceModel> list = null ;

		try {
			String hql="select pm from ProvinceModel pm" ;
			System.out.println(hql) ;
			list=this.getHibernateTemplate().find(hql) ;
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
			return list;			
		}
	}
	
	public Integer queryProvinceIdByName(String province_name) {
		List<ProvinceModel> provinceModelList = null ;
		
		try {
			String hql = "select pm from ProvinceModel pm where province_name like '" + province_name + "'" ;
			provinceModelList = this.getHibernateTemplate().find(hql) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(provinceModelList == null) {
			System.out.println("null") ;
			return null ;
		}
		if(provinceModelList.size() < 1) {
			System.out.println("size = 0") ;
			return null ;
		} else {
			return provinceModelList.get(0).getProvince_id();			// 要是返回Integer.parseInt(list.get(0).getUser_id())就不对
		}
	}
	
	public List<ProvinceModel> queryProvinceByNationId(Integer nation_id) {
		List<ProvinceModel> list = null ;

		try {
			String hql="select pm from ProvinceModel pm where pm.nation_id = " + nation_id ;
			System.out.println(hql) ;
			list=this.getHibernateTemplate().find(hql) ;
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
			return list;			
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<NationModel> queryAllNation() {
		List<NationModel> list = null ;

		try {
			String hql="select nm from NationModel nm order by nm.nation_id" ;
			list=this.getHibernateTemplate().find(hql) ;
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
			return list;			
		}
	}
	
	public Integer queryNationIdByName(String nation_name) {
		List<NationModel> nationModelList = null ;
		
		try {
			String hql = "select nm from NationModel nm where nation_name = '" + nation_name + "'" ;
			nationModelList = this.getHibernateTemplate().find(hql) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(nationModelList == null) {
			System.out.println("null") ;
			return null ;
		}
		if(nationModelList.size() < 1) {
			System.out.println("size = 0") ;
			return null ;
		} else {
			return nationModelList.get(0).getNation_id() ;			// 要是返回Integer.parseInt(list.get(0).getUser_id())就不对
		}
	}
	
	@SuppressWarnings("unchecked")
	public void delete(Integer province_id) {
		List<ProvinceModel> provinceModelList = null ;
    	try {
			String hql = "select pm from ProvinceModel pm where pm.province_id = " ;
			hql = hql + province_id ;
			provinceModelList = this.getHibernateTemplate().find(hql);
			if (provinceModelList != null)
			{
				for (ProvinceModel provinceModel:provinceModelList) {
					this.getHibernateTemplate().delete(provinceModel);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void save(ProvinceModel provinceModel) {
		this.getHibernateTemplate().save(provinceModel) ;
    }
    
    public void save(NationModel nationModel) {
		this.getHibernateTemplate().save(nationModel) ;
    }

}
