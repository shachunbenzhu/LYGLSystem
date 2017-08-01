package com.cn.ncist.rq.destination.dao;

import java.util.List;
import com.cn.ncist.rq.destination.vo.DestinationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;


/**
 * @author  任倩
 * @version  1.0
 */
public interface DestinationDao {

	/**
     * 根据目的地ID查询目的地
     * @param question_id
     * @return
     */
    List<DestinationModel> queryDestinationById(Integer destination_id) ;
    
    /**
     * 根据景点名称查询景点
     * @param destination_name
     * @return
     */
    List<DestinationModel> queryDestinationByName(String destination_name) ;
    /**
     * 根据省份名称查询目的地
     * @param province_name
     * @return
     */
    List<DestinationModel> queryDestinationByProvinceName(String province_name) ;
    
    /**
     * 根据国家名称查询目的地
     * @param nation_name
     * @return
     */
    List<DestinationModel> queryDestinationByNationName(String nation_name) ;
    
    /**
     * 保存
     * @param destinationModel 
     */ 
    void save(DestinationModel destinationModel) ;
    
    /**
     * 删除选中的目的地
     * @param note_id
     */
    void delete(Integer destination_id) ;
    
    /**
     * 修改目的地
     * @param Destination 
     */ 
    void update(DestinationModel destinationModel) ;
    
}
