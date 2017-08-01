package com.cn.ncist.rq.user.dao;

import java.util.List;

import com.cn.ncist.rq.province.vo.ProvinceModel;
import com.cn.ncist.rq.user.vo.AdminModel;
import com.cn.ncist.rq.user.vo.UserModel;


/**
 * @author  任倩
 * @version  1.0
 */
public interface UserDao {
	//public boolean IsUserIsOk(String user, String password,String verifycode);
	//=================================管理员===================================
	/**
     * 根据用户名、密码查找管理员
     * @param admin_name 用户名
     * @param admin_pwd 用户密码
     * @return 用户对象
     */ 
    AdminModel findAdminIdByNameAndPwd(String admin_name , String admin_pwd) ;
    
    /**
     * 根据名称找ID
     * @param admin_name
     * @return
     */
    Integer queryAdminIdByName(String admin_name) ;
    
    AdminModel queryAdminById(Integer admin_id) ;
    
    /**
     * 保存管理员
     * @param adminModel
     */
    void save(AdminModel adminModel) ;
    
    /**
     * 修改管理员
     * @param adminModel
     */
    void update(AdminModel adminModel) ;
    
  //=================================用户===================================
    /**
     * 根据用户名查找用户ID
     * @param user_name
     * @return Integer
     */
    UserModel queryUserIdByName(String user_name) ;
    
    /**
     * 根据用户Id查找用户
     * @param user_id
     * @return 用户对象
     */
    UserModel queryUserNameById(Integer user_id) ;
    
    /**
     * 保存用户
     * @param userModel 用户对象
     */ 
    void save(UserModel userModel) ;
    
    /**
     * 删除用户
     * @param user_id
     */
    void delete(Integer user_id) ;
    
    /**
     * 修改用户
     * @param UserModel 
     */ 
    void update(UserModel userModel) ;
    
}
