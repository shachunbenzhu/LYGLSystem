package com.cn.ncist.rq.page.vo;

import java.util.List;

public class PageBean {
	private List list ;        // 要返回的某一页的记录列表
    
    private int allRow ;         // 总记录数
    private int totalPage ;        // 总页数
    private int currentPage ;    // 当前页
    private int pageSize ;        // 每页记录数
    
    private boolean isFirstPage ;    // 是否为第一页
    private boolean isLastPage ;        // 是否为最后一页
    private boolean hasPreviousPage ;    // 是否有前一页
    private boolean hasNextPage ;        // 是否有下一页
    
    public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
    
	/**
     * 初始化分页信息
     */
    public void init() {
    	this.isFirstPage = isFirstPage() ;
    	this.isLastPage = isLastPage() ;
    	this.hasPreviousPage = isHasPreviousPage() ;
    	this.hasNextPage = isHasNextPage() ;
    }
    
    /**
     * 判断是否为第一页
     * @return boolean
     */
    public boolean isFirstPage() {
    	return currentPage == 1 ;			// 如果当前页是第一页
    }
    
    /**
     * 判断是否为最后一页
     * @return boolean
     */
    public boolean isLastPage() {
    	return currentPage == totalPage ;			// 如果当前页是最后一页，即总页数
    }
    
    /**
     * 判断是否有前一页
     * @return boolean
     */
    public boolean isHasPreviousPage() {
    	return currentPage != 1 ;			// 如果当前页不是第一页
    }
    
    /**
     * 判断是否有下一页
     * @return boolean
     */
    public boolean isHasNextPage() {
    	return currentPage != totalPage ;			// 如果当前页不是最后一页
    }
    
    /**
     * 计算总页数
     * @param pageSize 每页记录数
     * @param allRow 总记录数
     * @return 总页数
     */
    public static int countTotalPage(final int pageSize , final int allRow) {
    	int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1 ;
    	return totalPage ;
    }
    
    /**
     * 计算当前页开始记录
     * @param pageSize 每页记录数
     * @param currentPage 当前第几页
     * @return 当前页开始记录号
     */
    public static int countOffSet(final int pageSize , final int currentPage) {
    	final int offSet = pageSize * (currentPage - 1) ;
    	return offSet ;
    }
    
    /**
     * 计算当前页
     * @param page 用户传入的页数，可能为空，则为1
     * @return 当前页
     */
    public static int countCurrentPage(int page) {
    	final int currentPage = page == 0 ? 1 : page ;
    	return currentPage ;
    }
}
