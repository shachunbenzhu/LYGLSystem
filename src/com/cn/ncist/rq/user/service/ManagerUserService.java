package com.cn.ncist.rq.user.service;

import java.util.List;

import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.user.vo.UserModel;

/**
 * @author  任倩
 * @version  1.0
 */
public interface ManagerUserService {
	
	//=================================管理员===================================
    /**
     * 根据用户名、密码验证是否登录成功
     * @param admin_name 用户名
     * @param admin_pwd 用户密码
     * @return 用户id
     */
    Integer validLogin(String admin_name , String admin_pwd) throws ManagerException ;
    
    /**
     * 根据用户名、密码进行注册
     * @param admin_name 用户名
     * @param admin_pwd 用户密码
     * @return 用户id
     */
    Integer validRegister(String admin_name , String admin_pwd , String admin_question , String answer) throws ManagerException ;
    
    /**
     * 测试注册时用户名是否已经存在
     * @param admin_name
     * @return
     * @throws ManagerException
     */
    Integer testAdminName(String admin_name) throws ManagerException ;
    
    /**
     * 通过id查看密码是否正确
     * @param admin_id
     * @return
     * @throws ManagerException
     */
    String queryAdminPwdById(Integer admin_id , String admin_pwd) throws ManagerException ;
    /**
     * 修改用户密码
     * @param admin_id
     * @param admin_new_pwd
     * @return
     * @throws ManagerException
     */
    String updatePwd(Integer admin_id , String admin_new_pwd) throws ManagerException ;
    
  //=================================用户===================================
    
    UserModel getUserByName(String user_name) throws ManagerException ;
    
    /**
     * 删除选中的用户
     * @param user_id
     * @return
     * @throws ManagerException
     */
    String deleteUser(Integer user_id) throws ManagerException ;
    
    /**
     * 更新
     * @param user_id
     * @param user_name
     * @param user_pwd
     * @param user_pocket
     * @param user_point
     * @return
     * @throws ManagerException
     */
    String updateUser(Integer user_id , String user_name , String user_pwd , 
    		String user_pocket , String user_point) throws ManagerException ;
    
    /**
     * 根据用户名修改用户记住密码的状态
     * @param user_name
     * @param user_repwd
     * @return
     * @throws ManagerException
     */
    String updateUserByName(String user_name , String user_repwd) throws ManagerException ;
    
    /**
     * 添加用户
     * @param user_name
     * @param user_pwd
     * @param user_pocket
     * @param user_point
     * @return
     * @throws ManagerException
     */
    String addUser(String user_name , String user_pwd , 
    		String user_pocket , String user_point) throws ManagerException ;
}
