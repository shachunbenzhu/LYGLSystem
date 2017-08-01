package com.cn.ncist.rq.page.dao;

import java.util.List;
import com.cn.ncist.rq.destination.vo.DestinationModel;
import com.cn.ncist.rq.note.vo.NoteModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;


public interface PageDao {
	/**
     * 分页查询
     * @param hql 查询语句
     * @param offset 开始记录
     * @param length 一次查询的记录数
     * @return
     */
	List<NoteModel> queryForPageNote(final String hql , final int offset , final int length , final int flag) ;
	
	List<ProvinceModel> queryForPageQuestion(final String hql , final int offset , final int length) ;
	
	List<DestinationModel> queryForPageDestination(final String hql , final int offset , final int length , final int flag) ;
	
	List<ProvinceModel> queryForPageProvince(final String hql , final int offset , final int length , final int flag) ;
	
    /**
     * 查询所有记录数
     * @param hql 查询语句
     * @return 总记录数
     */
    int getAllRowCount(String hql) ;

}
