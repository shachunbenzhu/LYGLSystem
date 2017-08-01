package com.cn.ncist.rq.page.service;

import com.cn.ncist.rq.page.vo.PageBean;

public interface PageService {
	/**
     * 分页查询
     * @param currentPage 当前页数
     * @param pageSize 每页大小
     * @return PageBean
     */
    PageBean queryPageNote(String hql , int pageSize , int currentPage , String model , int flag) ;
    
    PageBean queryPageQuestion(String hql , int pageSize , int currentPage , String model) ;
    
    PageBean queryPageDestination(String hql , int pageSize , int currentPage , String model , int flag) ;
    
    PageBean queryPageProvince(String hql , int pageSize , int currentPage , String model , int flag) ;
 
    
}
