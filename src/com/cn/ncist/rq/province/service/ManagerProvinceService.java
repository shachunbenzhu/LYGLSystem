package com.cn.ncist.rq.province.service;

import java.util.List;
import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.province.vo.NationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;

public interface ManagerProvinceService {
	
	/**
	 * 查询所有省份
	 * @return
	 * @throws ManagerException
	 */
	List<ProvinceModel> queryProvince() throws ManagerException ;
	
	/**
     * 根据省份名称查询ID
     * @param province_name
     * @return
     * @throws ManagerException
     */
    Integer queryProvinceIdByName(String province_name) throws ManagerException ;
    
    /**
     * 根据国家名称查询省份
     * @param nation_name
     * @return
     * @throws ManagerException
     */
    List<ProvinceModel> queryProvinceByNation(Integer nation_id) throws ManagerException ;
    
    /**
     * 根据国家名称查省份
     * @param nation_name
     * @return
     * @throws ManagerException
     */
    List<ProvinceModel> queryProvinceByNationName(String nation_name) throws ManagerException ;
    
	List<NationModel> queryNation() throws ManagerException ;
    /**
     * 删除选中的省份
     * @param province_id
     * @return
     * @throws ManagerException
     */
    String deleteProvince(Integer province_id) throws ManagerException ;
    
    String addProvince(String province_name , String nation_name) throws ManagerException ;
    
    /**
     * 新增国家
     * @param nation_name
     * @return
     * @throws ManagerException
     */
    String addNation(String nation_name) throws ManagerException ;
}
