package com.cn.ncist.rq.page.service.impl;

import java.util.List;
import com.cn.ncist.rq.destination.vo.DestinationModel;
import com.cn.ncist.rq.note.vo.NoteModel;
import com.cn.ncist.rq.page.dao.PageDao;
import com.cn.ncist.rq.page.service.PageService;
import com.cn.ncist.rq.page.vo.PageBean;
import com.cn.ncist.rq.province.vo.ProvinceModel;

public class PageServiceImpl implements PageService{
	private PageDao pageDao ;

	public PageDao getPageDao() {
		return pageDao;
	}

	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}
	
	public PageBean initPageBean(String hql , int pageSize , int currentPage) {
		int allRow = pageDao.getAllRowCount(hql) ;    //总记录数
        int totalPage = PageBean.countTotalPage(pageSize , allRow) ;    //总页数
        final int currenPage = PageBean.countCurrentPage(currentPage) ;
        
        PageBean pageBean = new PageBean() ;
        pageBean.setPageSize(pageSize) ;   
        pageBean.setAllRow(allRow) ;
        pageBean.setTotalPage(totalPage) ;
        pageBean.setCurrentPage(currenPage) ;
        return pageBean ;
	}
	/**
     * 分页查询
     * @param currentPage 当前页数
     * @param pageSize 每页大小
     * @param model 当将Page提取后，传递具体的Model的名称，在此用反射机制创建类
     * @return PageBean
     */
    public PageBean queryPageNote(String hql , int pageSize , int currentPage , String model , int flag) {
    	 //int allRow = pageDao.getAllRowCount(hql) ;    //总记录数
         //int totalPage = PageBean.countTotalPage(pageSize , allRow) ;    //总页数
         final int offset = PageBean.countOffSet(pageSize , currentPage) ;    //当前页开始记录
         final int length = pageSize ;    //每页记录数
         //final int currenPage = PageBean.countCurrentPage(currentPage) ;
         
         //Object object = getInstance(model) ;
         /*Class<?> class1 = Class.forName(model) ;
         class1 d = new class1();*/
         List<NoteModel> list = pageDao.queryForPageNote(hql , offset , length , flag) ;        //"一页"的记录
        /* List<NoteModel> listModel = null ;
         NoteModel noteModel = new NoteModel() ;
         for(int i = 0; i < list.size(); i++) {
        	 noteModel = (NoteModel) list.get(i) ;//强制类型转化错误
        	 listModel.add(noteModel) ;
         }*/
         
         /*PageBean pageBean = new PageBean() ;
         pageBean.setPageSize(pageSize) ;   
         pageBean.setAllRow(allRow) ;
         pageBean.setTotalPage(totalPage) ;
         pageBean.setCurrentPage(currenPage) ;
         pageBean.setList(list) ;*/
         PageBean pageBean = initPageBean(hql , pageSize , currentPage) ;
         pageBean.setList(list) ;
         pageBean.init() ;
         return pageBean ;
    }
    
    /**
     * 分页查询
     * @param currentPage 当前页数
     * @param pageSize 每页大小
     * @param model 当将Page提取后，传递具体的Model的名称，在此用反射机制创建类
     * @return PageBean
     */
    public PageBean queryPageQuestion(String hql , int pageSize , int currentPage , String model) {
         final int offset = PageBean.countOffSet(pageSize , currentPage) ;    //当前页开始记录
         final int length = pageSize ;    //每页记录数
         
         List<ProvinceModel> list = pageDao.queryForPageQuestion(hql , offset , length) ;        //"一页"的记录
        
         PageBean pageBean = initPageBean(hql , pageSize , currentPage) ;
         pageBean.setList(list) ;
         pageBean.init() ;
         return pageBean ;
    }
    
    public PageBean queryPageDestination(String hql , int pageSize , int currentPage , String model , int flag) {
        final int offset = PageBean.countOffSet(pageSize , currentPage) ;    //当前页开始记录
        final int length = pageSize ;    //每页记录数
        
        List<DestinationModel> list = pageDao.queryForPageDestination(hql , offset , length , flag) ;        //"一页"的记录
       
        PageBean pageBean = initPageBean(hql , pageSize , currentPage) ;
        pageBean.setList(list) ;
        pageBean.init() ;
        return pageBean ;
   }
    
    public PageBean queryPageProvince(String hql , int pageSize , int currentPage , String model , int flag) {
        final int offset = PageBean.countOffSet(pageSize , currentPage) ;    //当前页开始记录
        final int length = pageSize ;    //每页记录数
        
        List<ProvinceModel> list = pageDao.queryForPageProvince(hql , offset , length , flag) ;        //"一页"的记录
       
        PageBean pageBean = initPageBean(hql , pageSize , currentPage) ;
        pageBean.setList(list) ;
        pageBean.init() ;
        return pageBean ;
   }
    
    public Object getInstance(String className){
    	
    	Object theInst = null;
    	try{
	    	Class<?> theObject = Class.forName(className);
			theInst=theObject.newInstance();
    	}
    	catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	return theInst;
    }
}
