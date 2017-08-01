package com.cn.ncist.rq.destination.service;

import java.util.List;

import com.cn.ncist.rq.destination.vo.DestinationModel;
import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.province.vo.ProvinceModel;

public interface ManagerDestinationService {

	/**
	 * ����ʡ�ݲ�ѯ����Ŀ�ĵ�
	 * @param province_name
	 * @return
	 * @throws ManagerException
	 */
	List<DestinationModel> queryAllDestination(String province_name) throws ManagerException ;
	
	/**
	 * ���ݹ��Ҳ�ѯ����Ŀ�ĵ�
	 * @param nation_name
	 * @return
	 * @throws ManagerException
	 */
	List<DestinationModel> queryDestination(String nation_name) throws ManagerException ;
    /**
     * ɾ��ѡ�е�Ŀ�ĵ�
     * @param destination_id
     * @return
     * @throws ManagerException
     */
    String deleteDestination(Integer destination_id) throws ManagerException ;
    
    /**
     * ����Ŀ�ĵ�
     * @param destination_id
     * @param destination_name
     * @param destination_pinyin
     * @param destination_number
     * @param province_name
     * @param nation_name
     * @return
     * @throws ManagerException
     */
    String updateDestination(Integer destination_id , String destination_name , String destination_pinyin , 
    		Integer destination_number , String province_name , String nation_name) throws ManagerException ;
    
    void updateDesNum(String destination_name) throws ManagerException ;
    
    /**
     * ���Ŀ�ĵ�
     * @param destination_name
     * @param destination_pinyin
     * @param destination_number
     * @param province_name
     * @param nation_name
     * @return
     * @throws ManagerException
     */
    String addDestination(String destination_name , String destination_pinyin , 
    		Integer destination_number , String province_name , String nation_name) throws ManagerException ;
    
}
