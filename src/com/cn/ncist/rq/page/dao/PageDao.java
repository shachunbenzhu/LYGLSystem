package com.cn.ncist.rq.page.dao;

import java.util.List;
import com.cn.ncist.rq.destination.vo.DestinationModel;
import com.cn.ncist.rq.note.vo.NoteModel;
import com.cn.ncist.rq.province.vo.ProvinceModel;


public interface PageDao {
	/**
     * ��ҳ��ѯ
     * @param hql ��ѯ���
     * @param offset ��ʼ��¼
     * @param length һ�β�ѯ�ļ�¼��
     * @return
     */
	List<NoteModel> queryForPageNote(final String hql , final int offset , final int length , final int flag) ;
	
	List<ProvinceModel> queryForPageQuestion(final String hql , final int offset , final int length) ;
	
	List<DestinationModel> queryForPageDestination(final String hql , final int offset , final int length , final int flag) ;
	
	List<ProvinceModel> queryForPageProvince(final String hql , final int offset , final int length , final int flag) ;
	
    /**
     * ��ѯ���м�¼��
     * @param hql ��ѯ���
     * @return �ܼ�¼��
     */
    int getAllRowCount(String hql) ;

}
