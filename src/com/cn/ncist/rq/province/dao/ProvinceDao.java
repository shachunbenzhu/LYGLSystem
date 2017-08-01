package com.cn.ncist.rq.province.dao;

import java.util.List;
import com.cn.ncist.rq.province.vo.NationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;

/**
 * @author  ��ٻ
 * @version  1.0
 */
public interface ProvinceDao {
	
	/**
     * ��������ʡ��
     * @return 
     */ 
	List<ProvinceModel> queryAllProvince() ;
	
	/**
     * ����ʡ�����Ʋ�ѯID
     * @param province_name
     * @return
     */
    Integer queryProvinceIdByName(String province_name) ;
    
    /**
     * ���ݹ���ID��ѯʡ��
     * @param nation_id
     * @return
     */
    List<ProvinceModel> queryProvinceByNationId(Integer nation_id) ;
    
	/**
     * ��������Nation
     * @return 
     */ 
	List<NationModel> queryAllNation() ;
	
	/**
     * ���ݹ������Ʋ�ѯID
     * @param continent_name
     * @return
     */
    Integer queryNationIdByName(String nation_name) ;
    
    /**
     * ����
     * @param provinceModel 
     */ 
    void save(ProvinceModel provinceModel) ;
    
    /**
     * ɾ��ѡ�е�ʡ��
     * @param province_id
     */
    void delete(Integer province_id) ;
    
    /**
     * �������
     * @param nationModel
     */
    void save(NationModel nationModel) ;
    
}
