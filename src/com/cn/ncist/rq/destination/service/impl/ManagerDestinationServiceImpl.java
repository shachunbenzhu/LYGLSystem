package com.cn.ncist.rq.destination.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import com.cn.ncist.rq.destination.dao.DestinationDao;
import com.cn.ncist.rq.destination.service.ManagerDestinationService;
import com.cn.ncist.rq.destination.vo.DestinationModel;
import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.note.vo.NoteModel;
import com.cn.ncist.rq.province.dao.ProvinceDao;
import com.cn.ncist.rq.province.vo.ProvinceModel;

public class ManagerDestinationServiceImpl implements ManagerDestinationService {
	static Logger log = Logger.getLogger(ManagerDestinationServiceImpl.class.getName()) ;
	private DestinationDao destinationDao ;
	private ProvinceDao provinceDao ;
	
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		ManagerDestinationServiceImpl.log = log;
	}

	public DestinationDao getDestinationDao() {
		return destinationDao;
	}

	public void setDestinationDao(DestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}

	public ProvinceDao getProvinceDao() {
		return provinceDao;
	}

	public void setProvinceDao(ProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}

	public List<DestinationModel> queryAllDestination(String province_name) throws ManagerException {
		try {
            return destinationDao.queryDestinationByProvinceName(province_name) ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询目的地出现异常,请重试") ;
        }
	}
	
	public List<DestinationModel> queryDestination(String nation_name) throws ManagerException {
		try {
            return destinationDao.queryDestinationByNationName(nation_name) ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询目的地出现异常,请重试") ;
        }
	}
	
	public String deleteDestination(Integer destination_id) throws ManagerException {
    	try {
    		destinationDao.delete(destination_id);    
    		return "ok" ;
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("删除目的地出现异常,请重试") ;
        }
    }
	
	public String updateDestination(Integer destination_id , String destination_name , String destination_pinyin , 
    		Integer destination_number , String province_name , String nation_name) throws ManagerException {
    	try {
    		Integer province_id = provinceDao.queryProvinceIdByName(province_name.trim()) ;
    		Integer nation_id = provinceDao.queryNationIdByName(nation_name.trim()) ;
    		DestinationModel destinationModel = destinationDao.queryDestinationById(destination_id).get(0) ;
    		
    		destinationModel.setDestination_id(destination_id) ;
			destinationModel.setDestination_name(destination_name.trim()) ;
			destinationModel.setDestination_pinyin(destination_pinyin.trim()) ;
			destinationModel.setDestination_number(destination_number) ;
			destinationModel.setProvince_id(province_id) ;
			destinationModel.setNation_id(nation_id) ;
    		
			destinationDao.update(destinationModel);
    		return "ok" ;          
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("修改目的地信息出现异常,请重试") ;
        }
    }
	
	public void updateDesNum(String destination_name) throws ManagerException {
    	try {
    		
    		DestinationModel destinationModel = destinationDao.queryDestinationByName(destination_name).get(0) ;
    		Integer num = destinationModel.getDestination_number() + 1 ;
    		destinationModel.setDestination_number(num) ;
    		destinationDao.update(destinationModel);    
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("更新游记点赞数量出现异常,请重试") ;
        }
    }
	
	public String addDestination(String destination_name , String destination_pinyin , 
    		Integer destination_number , String province_name , String nation_name) throws ManagerException {
		try {
			Integer province_id = provinceDao.queryProvinceIdByName(province_name.trim()) ;
    		Integer nation_id = provinceDao.queryNationIdByName(nation_name.trim()) ;
    		
			DestinationModel destinationModel = new DestinationModel() ;
			destinationModel.setDestination_name(destination_name.trim()) ;
			destinationModel.setDestination_pinyin(destination_pinyin.trim()) ;
			destinationModel.setDestination_number(destination_number) ;
			destinationModel.setDestination_img("./images/common_default_des_img.jpg") ;
			destinationModel.setDestination_imgarr("./images/common_default_des_img.jpg;") ;
			destinationModel.setProvince_id(province_id) ;
			destinationModel.setNation_id(nation_id) ;
			
			destinationDao.save(destinationModel);
			return "ok" ;
		} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("添加目的地信息出现异常,请重试") ;
        }
	}
	
}
