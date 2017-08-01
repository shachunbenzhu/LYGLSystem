package com.cn.ncist.rq.province.dao;

import java.util.List;
import com.cn.ncist.rq.province.vo.NationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;

/**
 * @author  任倩
 * @version  1.0
 */
public interface ProvinceDao {
	
	/**
     * 查找所有省份
     * @return 
     */ 
	List<ProvinceModel> queryAllProvince() ;
	
	/**
     * 根据省份名称查询ID
     * @param province_name
     * @return
     */
    Integer queryProvinceIdByName(String province_name) ;
    
    /**
     * 根据国家ID查询省份
     * @param nation_id
     * @return
     */
    List<ProvinceModel> queryProvinceByNationId(Integer nation_id) ;
    
	/**
     * 查找所有Nation
     * @return 
     */ 
	List<NationModel> queryAllNation() ;
	
	/**
     * 根据国家名称查询ID
     * @param continent_name
     * @return
     */
    Integer queryNationIdByName(String nation_name) ;
    
    /**
     * 保存
     * @param provinceModel 
     */ 
    void save(ProvinceModel provinceModel) ;
    
    /**
     * 删除选中的省份
     * @param province_id
     */
    void delete(Integer province_id) ;
    
    /**
     * 保存国家
     * @param nationModel
     */
    void save(NationModel nationModel) ;
    
}
