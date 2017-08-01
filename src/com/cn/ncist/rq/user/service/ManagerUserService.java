package com.cn.ncist.rq.user.service;

import java.util.List;

import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.user.vo.UserModel;

/**
 * @author  ��ٻ
 * @version  1.0
 */
public interface ManagerUserService {
	
	//=================================����Ա===================================
    /**
     * �����û�����������֤�Ƿ��¼�ɹ�
     * @param admin_name �û���
     * @param admin_pwd �û�����
     * @return �û�id
     */
    Integer validLogin(String admin_name , String admin_pwd) throws ManagerException ;
    
    /**
     * �����û������������ע��
     * @param admin_name �û���
     * @param admin_pwd �û�����
     * @return �û�id
     */
    Integer validRegister(String admin_name , String admin_pwd , String admin_question , String answer) throws ManagerException ;
    
    /**
     * ����ע��ʱ�û����Ƿ��Ѿ�����
     * @param admin_name
     * @return
     * @throws ManagerException
     */
    Integer testAdminName(String admin_name) throws ManagerException ;
    
    /**
     * ͨ��id�鿴�����Ƿ���ȷ
     * @param admin_id
     * @return
     * @throws ManagerException
     */
    String queryAdminPwdById(Integer admin_id , String admin_pwd) throws ManagerException ;
    /**
     * �޸��û�����
     * @param admin_id
     * @param admin_new_pwd
     * @return
     * @throws ManagerException
     */
    String updatePwd(Integer admin_id , String admin_new_pwd) throws ManagerException ;
    
  //=================================�û�===================================
    
    UserModel getUserByName(String user_name) throws ManagerException ;
    
    /**
     * ɾ��ѡ�е��û�
     * @param user_id
     * @return
     * @throws ManagerException
     */
    String deleteUser(Integer user_id) throws ManagerException ;
    
    /**
     * ����
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
     * �����û����޸��û���ס�����״̬
     * @param user_name
     * @param user_repwd
     * @return
     * @throws ManagerException
     */
    String updateUserByName(String user_name , String user_repwd) throws ManagerException ;
    
    /**
     * ����û�
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
