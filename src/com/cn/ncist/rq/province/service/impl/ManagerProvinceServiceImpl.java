package com.cn.ncist.rq.province.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.province.dao.ProvinceDao;
import com.cn.ncist.rq.province.service.ManagerProvinceService;
import com.cn.ncist.rq.province.vo.NationModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;

public class ManagerProvinceServiceImpl implements ManagerProvinceService {
	static Logger log = Logger.getLogger(ManagerProvinceServiceImpl.class.getName()) ;
	private ProvinceDao provinceDao ;
	
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		ManagerProvinceServiceImpl.log = log;
	}
	
	public ProvinceDao getProvinceDao() {
		return provinceDao;
	}

	public void setProvinceDao(ProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}

	public List<ProvinceModel> queryProvince() throws ManagerException  {
		try {
            return provinceDao.queryAllProvince() ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询省份出现异常,请重试") ;
        }
	}
	
	public  Integer queryProvinceIdByName(String province_name) throws ManagerException {
		
		try {
			return provinceDao.queryProvinceIdByName(province_name.trim()) ;
		} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询省份信息出现异常,请重试") ;
        }
	}
	
	public List<ProvinceModel> queryProvinceByNation(Integer nation_id) throws ManagerException {
		try {
			return provinceDao.queryProvinceByNationId(nation_id) ;
		} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询省份信息出现异常,请重试") ;
        }
	}
	
	public List<ProvinceModel> queryProvinceByNationName(String nation_name) throws ManagerException {
		try {
			int nation_id = provinceDao.queryNationIdByName(nation_name) ;
			return provinceDao.queryProvinceByNationId(nation_id) ;
		} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询省份信息出现异常,请重试") ;
        }
	}
	
	public List<NationModel> queryNation() throws ManagerException  {
		try {
            return provinceDao.queryAllNation() ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询国家出现异常,请重试") ;
        }
	}
	
	public String deleteProvince(Integer province_id) throws ManagerException {
    	try {
    		provinceDao.delete(province_id);    
    		return "ok" ;
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("删除省份出现异常,请重试") ;
        }
    }
	
	public String addProvince(String province_name, String nation_name) throws ManagerException {
		try {
			Integer nation_id = provinceDao.queryNationIdByName(nation_name.trim()) ;
			
			ProvinceModel provinceModel = new ProvinceModel() ;
			provinceModel.setProvince_name(province_name.trim()) ;
			provinceModel.setNation_id(nation_id) ;
			
			provinceDao.save(provinceModel);
			return "ok" ;
		} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("添加省份信息出现异常,请重试") ;
        }
	}
	
	public String addNation(String nation_name) throws ManagerException {
		try {
			
			NationModel nationModel = new NationModel() ;
			nationModel.setNation_name(nation_name.trim()) ;
			
			provinceDao.save(nationModel);
			return "ok" ;
		} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("添加国家信息出现异常,请重试") ;
        }
	}

}
