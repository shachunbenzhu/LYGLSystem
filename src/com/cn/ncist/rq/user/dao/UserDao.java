package com.cn.ncist.rq.user.dao;

import java.util.List;

import com.cn.ncist.rq.province.vo.ProvinceModel;
import com.cn.ncist.rq.user.vo.AdminModel;
import com.cn.ncist.rq.user.vo.UserModel;


/**
 * @author  ��ٻ
 * @version  1.0
 */
public interface UserDao {
	//public boolean IsUserIsOk(String user, String password,String verifycode);
	//=================================����Ա===================================
	/**
     * �����û�����������ҹ���Ա
     * @param admin_name �û���
     * @param admin_pwd �û�����
     * @return �û�����
     */ 
    AdminModel findAdminIdByNameAndPwd(String admin_name , String admin_pwd) ;
    
    /**
     * ����������ID
     * @param admin_name
     * @return
     */
    Integer queryAdminIdByName(String admin_name) ;
    
    AdminModel queryAdminById(Integer admin_id) ;
    
    /**
     * �������Ա
     * @param adminModel
     */
    void save(AdminModel adminModel) ;
    
    /**
     * �޸Ĺ���Ա
     * @param adminModel
     */
    void update(AdminModel adminModel) ;
    
  //=================================�û�===================================
    /**
     * �����û��������û�ID
     * @param user_name
     * @return Integer
     */
    UserModel queryUserIdByName(String user_name) ;
    
    /**
     * �����û�Id�����û�
     * @param user_id
     * @return �û�����
     */
    UserModel queryUserNameById(Integer user_id) ;
    
    /**
     * �����û�
     * @param userModel �û�����
     */ 
    void save(UserModel userModel) ;
    
    /**
     * ɾ���û�
     * @param user_id
     */
    void delete(Integer user_id) ;
    
    /**
     * �޸��û�
     * @param UserModel 
     */ 
    void update(UserModel userModel) ;
    
}
