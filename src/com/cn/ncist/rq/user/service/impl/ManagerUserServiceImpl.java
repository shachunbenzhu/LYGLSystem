package com.cn.ncist.rq.user.service.impl;

import org.apache.log4j.Logger;

import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.province.vo.ProvinceModel;
import com.cn.ncist.rq.user.dao.UserDao;
import com.cn.ncist.rq.user.service.ManagerUserService;
import com.cn.ncist.rq.user.vo.AdminModel;
import com.cn.ncist.rq.user.vo.UserModel;

public class ManagerUserServiceImpl implements ManagerUserService {

	static Logger log = Logger.getLogger(ManagerUserServiceImpl.class.getName()) ;
    
    private UserDao userDao ;

	public UserDao getUserDao() {
		return userDao ;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao ;
	}
	
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		ManagerUserServiceImpl.log = log;
	}
	
	/**
     * �����û�����������֤�Ƿ��¼�ɹ�
     * @param admin_name �û���
     * @param admin_pwd �û�����
     * @return �û�id
     */
    public Integer validLogin(String admin_name, String admin_pwd) throws ManagerException {
    	try {
    		AdminModel adminModel = (AdminModel)userDao.findAdminIdByNameAndPwd(admin_name, admin_pwd) ;
    		if(adminModel != null) {
    			return  adminModel.getAdmin_id();   
    		} else {
    			return null ;
    		}
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("�û���¼�����쳣,������") ;
        }
    }
    
    /**
     * �����û������������ݽ���ע��
     * @param userName �û���
     * @param userPassword �û�����
     * @return �û�id
     */
    public Integer validRegister(String admin_name , String admin_pwd , String admin_question , String admin_answer) 
    					throws ManagerException {
    	try {
    		AdminModel adminModell = (AdminModel)userDao.findAdminIdByNameAndPwd(admin_name, admin_pwd) ;
    		if (adminModell == null) {
    			AdminModel adminModel = new AdminModel() ;
    			adminModel.setAdmin_name(admin_name) ;
    			adminModel.setAdmin_pwd(admin_pwd) ;
    			adminModel.setAdmin_question(admin_question) ;
    			adminModel.setAdmin_answer(admin_answer) ;
            	userDao.save(adminModel) ;
            	return adminModel.getAdmin_id() ;
            } else {
            	return null ;
            }           
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ManagerException("ע���û������쳣,������") ;
        }
    }
    
    public Integer testAdminName(String adminName) throws ManagerException {
    	try {
    		return userDao.queryAdminIdByName(adminName) ;         
        } catch (Exception e) {
            log.debug(e.getMessage());
            throw new ManagerException("�û����Ѵ���,������") ;
        }
    } 
    
    public String queryAdminPwdById(Integer admin_id , String admin_pwd) throws ManagerException {
    	try {
    		String admin_pwd_query =  userDao.queryAdminById(admin_id).getAdmin_pwd();
    		if(admin_pwd_query.equals(admin_pwd)) {
        		return "ok" ;
        	}
    	} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("��ѯ�û���������쳣,������") ;
            
        }
    	return null ;
    }
    
    public String updatePwd(Integer admin_id , String admin_new_pwd) throws ManagerException {
    	try {
    		AdminModel adminModel = userDao.queryAdminById(admin_id) ;
        	adminModel.setAdmin_pwd(admin_new_pwd) ;
        	userDao.update(adminModel);
    		return "ok" ;     
    	} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("�޸��û���������쳣,������") ;
        }
    }   
    
    public UserModel getUserByName(String user_name) throws ManagerException {
    	try {
    		return userDao.queryUserIdByName(user_name) ;
    	} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("��ѯ�û������쳣,������") ;
        }
    }
    
    public String deleteUser(Integer user_id) throws ManagerException {
    	try {
    		userDao.delete(user_id);    
    		return "ok" ;
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("ɾ���û������쳣,������") ;
        }
    }
    
    public String updateUser(Integer user_id , String user_name , String user_pwd , 
    		String user_pocket , String user_point) throws ManagerException {
    	try {
    		UserModel userModel = userDao.queryUserNameById(user_id) ;
    		userModel.setUser_name(user_name.trim()) ;
    		userModel.setUser_pwd(user_pwd.trim()) ;
    		userModel.setUser_pocket(user_pocket.trim()) ;
    		userModel.setUser_point(user_point.trim()) ;
    		
    		userDao.update(userModel);
    		return "ok" ;          
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("�޸��û���Ϣ�����쳣,������") ;
        }
    }
    
    public String updateUserByName(String user_name , String user_repwd) throws ManagerException {
    	try {
    		UserModel userModel = userDao.queryUserIdByName(user_name) ;
    		userModel.setUser_repwd(user_repwd.trim()) ;
    		
    		userDao.update(userModel);
    		return "ok" ;          
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("�޸��û���Ϣ�����쳣,������") ;
        }
    }

	public String addUser(String user_name , String user_pwd , 
    		String user_pocket , String user_point) throws ManagerException {
		try {
			UserModel userModel = new UserModel() ;
			userModel.setUser_name(user_name.trim()) ;
    		userModel.setUser_pwd(user_pwd.trim()) ;
    		userModel.setUser_pocket(user_pocket.trim()) ;
    		userModel.setUser_point(user_point.trim()) ;
    		userModel.setUser_repwd("no") ;
    		userModel.setUser_touxiang("./images/common_default_tx_wawa.png") ;
			
			userDao.save(userModel);
			return "ok" ;
		} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("����û���Ϣ�����쳣,������") ;
        }
	}

}
