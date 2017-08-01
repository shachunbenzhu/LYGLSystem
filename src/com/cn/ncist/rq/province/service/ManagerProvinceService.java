package com.cn.ncist.rq.province.service;

import java.util.List;
import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.province.vo.NationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;

public interface ManagerProvinceService {
	
	/**
	 * ��ѯ����ʡ��
	 * @return
	 * @throws ManagerException
	 */
	List<ProvinceModel> queryProvince() throws ManagerException ;
	
	/**
     * ����ʡ�����Ʋ�ѯID
     * @param province_name
     * @return
     * @throws ManagerException
     */
    Integer queryProvinceIdByName(String province_name) throws ManagerException ;
    
    /**
     * ���ݹ������Ʋ�ѯʡ��
     * @param nation_name
     * @return
     * @throws ManagerException
     */
    List<ProvinceModel> queryProvinceByNation(Integer nation_id) throws ManagerException ;
    
    /**
     * ���ݹ������Ʋ�ʡ��
     * @param nation_name
     * @return
     * @throws ManagerException
     */
    List<ProvinceModel> queryProvinceByNationName(String nation_name) throws ManagerException ;
    
	List<NationModel> queryNation() throws ManagerException ;
    /**
     * ɾ��ѡ�е�ʡ��
     * @param province_id
     * @return
     * @throws ManagerException
     */
    String deleteProvince(Integer province_id) throws ManagerException ;
    
    String addProvince(String province_name , String nation_name) throws ManagerException ;
    
    /**
     * ��������
     * @param nation_name
     * @return
     * @throws ManagerException
     */
    String addNation(String nation_name) throws ManagerException ;
}
