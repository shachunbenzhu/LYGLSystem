package com.cn.ncist.rq.page.vo;

import java.util.List;

public class PageBean {
	private List list ;        // Ҫ���ص�ĳһҳ�ļ�¼�б�
    
    private int allRow ;         // �ܼ�¼��
    private int totalPage ;        // ��ҳ��
    private int currentPage ;    // ��ǰҳ
    private int pageSize ;        // ÿҳ��¼��
    
    private boolean isFirstPage ;    // �Ƿ�Ϊ��һҳ
    private boolean isLastPage ;        // �Ƿ�Ϊ���һҳ
    private boolean hasPreviousPage ;    // �Ƿ���ǰһҳ
    private boolean hasNextPage ;        // �Ƿ�����һҳ
    
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
     * ��ʼ����ҳ��Ϣ
     */
    public void init() {
    	this.isFirstPage = isFirstPage() ;
    	this.isLastPage = isLastPage() ;
    	this.hasPreviousPage = isHasPreviousPage() ;
    	this.hasNextPage = isHasNextPage() ;
    }
    
    /**
     * �ж��Ƿ�Ϊ��һҳ
     * @return boolean
     */
    public boolean isFirstPage() {
    	return currentPage == 1 ;			// �����ǰҳ�ǵ�һҳ
    }
    
    /**
     * �ж��Ƿ�Ϊ���һҳ
     * @return boolean
     */
    public boolean isLastPage() {
    	return currentPage == totalPage ;			// �����ǰҳ�����һҳ������ҳ��
    }
    
    /**
     * �ж��Ƿ���ǰһҳ
     * @return boolean
     */
    public boolean isHasPreviousPage() {
    	return currentPage != 1 ;			// �����ǰҳ���ǵ�һҳ
    }
    
    /**
     * �ж��Ƿ�����һҳ
     * @return boolean
     */
    public boolean isHasNextPage() {
    	return currentPage != totalPage ;			// �����ǰҳ�������һҳ
    }
    
    /**
     * ������ҳ��
     * @param pageSize ÿҳ��¼��
     * @param allRow �ܼ�¼��
     * @return ��ҳ��
     */
    public static int countTotalPage(final int pageSize , final int allRow) {
    	int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1 ;
    	return totalPage ;
    }
    
    /**
     * ���㵱ǰҳ��ʼ��¼
     * @param pageSize ÿҳ��¼��
     * @param currentPage ��ǰ�ڼ�ҳ
     * @return ��ǰҳ��ʼ��¼��
     */
    public static int countOffSet(final int pageSize , final int currentPage) {
    	final int offSet = pageSize * (currentPage - 1) ;
    	return offSet ;
    }
    
    /**
     * ���㵱ǰҳ
     * @param page �û������ҳ��������Ϊ�գ���Ϊ1
     * @return ��ǰҳ
     */
    public static int countCurrentPage(int page) {
    	final int currentPage = page == 0 ? 1 : page ;
    	return currentPage ;
    }
}
