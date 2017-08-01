package com.cn.ncist.rq.user.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cn.ncist.rq.province.vo.ProvinceModel;
import com.cn.ncist.rq.user.dao.UserDao;
import com.cn.ncist.rq.user.vo.AdminModel;
import com.cn.ncist.rq.user.vo.UserModel;

/**
 * @author  任倩
 * @version  1.0
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@SuppressWarnings("unchecked")
	/**
     * 根据用户名和密码查找用户
     * @param username 用户名
     * @param userPassword 用户密码
     * @return 用户对象
     */ 
    public AdminModel findAdminIdByNameAndPwd(String admin_name , String admin_pwd) {
		List<AdminModel> list = null ;

		try {
			String hql="select am from AdminModel am where am.admin_name like '%" ;
			hql = hql + admin_name ;
			hql = hql + "%' and am.admin_pwd like '%" ;
			hql = hql + admin_pwd ;
			hql = hql + "%'" ;
			System.out.println(hql) ;		
			list = this.getHibernateTemplate().find(hql) ;
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
		}
		if (list.size() == 1){
			return (AdminModel)list.get(0);			// 要是返回Integer.parseInt(list.get(0).getUser_id())就不对
		}
		return null;
	}
	
	public Integer queryAdminIdByName(String admin_name) {
		List list = null ;

		try {
			String hql="select am from AdminModel am where am.admin_name = '" ;
			hql = hql + admin_name ;
			hql = hql + "'" ;
			System.out.println(hql) ;		
			list = this.getHibernateTemplate().find(hql) ;
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
		}
		if (list.size() == 1){
			Object object = list.get(0) ;
			return Integer.valueOf(object.toString());			// 要是返回Integer.parseInt(list.get(0).getUser_id())就不对
		}
		return null;
	}
	
	public AdminModel queryAdminById(Integer admin_id) {
		List<AdminModel> list = null ;

		try {
			String hql="select am from AdminModel am where am.admin_id = " ;
			hql = hql + admin_id ;
			list = this.getHibernateTemplate().find(hql) ;
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
		}
		if (list.size() == 1){
			return (AdminModel)list.get(0);			// 要是返回Integer.parseInt(list.get(0).getUser_id())就不对
		}
		return null;
	}
	
	public void update(AdminModel adminModel) {
    	this.getHibernateTemplate().update(adminModel) ;
    }
	
	public void save(AdminModel adminModel) {
    	this.getHibernateTemplate().save(adminModel) ;
    }
	
	public UserModel queryUserIdByName(String user_name) {
		List list = null ;

		try {
			String hql="select um from UserModel um where um.user_name = '" ;
			hql = hql + user_name ;
			hql = hql + "'" ;
			System.out.println(hql) ;		
			list = this.getHibernateTemplate().find(hql) ;
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
		}
		if (list.size() == 1){
			/*
			 * 只是查询用户ID并返回时
			 * Object object = list.get(0) ;
			return Integer.valueOf(object.toString());*/			// 要是返回Integer.parseInt(list.get(0).getUser_id())就不对
			return (UserModel) list.get(0) ;
		}
		return null;
	}
	
	public UserModel queryUserNameById(Integer user_id) {
		List<UserModel> list = null ;

		try {
			String hql="select um from UserModel um where um.user_id = " ;
			hql = hql + user_id ;
			System.out.println(hql) ;		
			list = this.getHibernateTemplate().find(hql) ;
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
		}
		if (list.size() == 1){
			return (UserModel)list.get(0);			// 要是返回Integer.parseInt(list.get(0).getUser_id())就不对
		}
		return null;
	}
	
    public void save(UserModel userModel) {
    	this.getHibernateTemplate().save(userModel) ;
    }
    
    public void delete(Integer user_id) {
		List<UserModel> userModelList = null ;
    	try {
			String hql = "select um from UserModel um where um.user_id = " ;
			hql = hql + user_id ;
			userModelList = this.getHibernateTemplate().find(hql);
			if (userModelList != null)
			{
				for (UserModel userModel:userModelList) {
					this.getHibernateTemplate().delete(userModel);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    public void update(UserModel userModel) {
    	this.getHibernateTemplate().update(userModel) ;
    }
}
