package com.cn.ncist.rq.page.service;

import com.cn.ncist.rq.page.vo.PageBean;

public interface PageService {
	/**
     * ��ҳ��ѯ
     * @param currentPage ��ǰҳ��
     * @param pageSize ÿҳ��С
     * @return PageBean
     */
    PageBean queryPageNote(String hql , int pageSize , int currentPage , String model , int flag) ;
    
    PageBean queryPageQuestion(String hql , int pageSize , int currentPage , String model) ;
    
    PageBean queryPageDestination(String hql , int pageSize , int currentPage , String model , int flag) ;
    
    PageBean queryPageProvince(String hql , int pageSize , int currentPage , String model , int flag) ;
 
    
}
