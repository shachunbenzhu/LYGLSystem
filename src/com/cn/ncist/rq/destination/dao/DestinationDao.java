package com.cn.ncist.rq.destination.dao;

import java.util.List;
import com.cn.ncist.rq.destination.vo.DestinationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;


/**
 * @author  ��ٻ
 * @version  1.0
 */
public interface DestinationDao {

	/**
     * ����Ŀ�ĵ�ID��ѯĿ�ĵ�
     * @param question_id
     * @return
     */
    List<DestinationModel> queryDestinationById(Integer destination_id) ;
    
    /**
     * ���ݾ������Ʋ�ѯ����
     * @param destination_name
     * @return
     */
    List<DestinationModel> queryDestinationByName(String destination_name) ;
    /**
     * ����ʡ�����Ʋ�ѯĿ�ĵ�
     * @param province_name
     * @return
     */
    List<DestinationModel> queryDestinationByProvinceName(String province_name) ;
    
    /**
     * ���ݹ������Ʋ�ѯĿ�ĵ�
     * @param nation_name
     * @return
     */
    List<DestinationModel> queryDestinationByNationName(String nation_name) ;
    
    /**
     * ����
     * @param destinationModel 
     */ 
    void save(DestinationModel destinationModel) ;
    
    /**
     * ɾ��ѡ�е�Ŀ�ĵ�
     * @param note_id
     */
    void delete(Integer destination_id) ;
    
    /**
     * �޸�Ŀ�ĵ�
     * @param Destination 
     */ 
    void update(DestinationModel destinationModel) ;
    
}
