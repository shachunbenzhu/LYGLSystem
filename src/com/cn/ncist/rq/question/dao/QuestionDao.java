package com.cn.ncist.rq.question.dao;

import java.util.List;
import com.cn.ncist.rq.question.vo.QuestionModel;

/**
 * @author  ��ٻ
 * @version  1.0
 */
public interface QuestionDao {
	/**
     * ��������Question
     * @return 
     */ 
	List<QuestionModel> queryAllQuestion() ;
    
	/**
	 * ������������ѯ����
	 * @param question_label
	 * @return
	 */
	List<QuestionModel> queryQuesByLabel(String question_label) ;
    /**
     * ��������ID��ѯ����
     * @param question_id
     * @return
     */
    List<QuestionModel> queryQuestionById(Integer question_id) ;
    
    /**
     * ����
     * @param questionModel 
     */ 
    void save(QuestionModel questionModel) ;
    
    /**
     * ɾ��ѡ�е�����
     * @param question_id
     */
    void delete(Integer question_id) ;
    
    /**
     * �޸�����
     * @param ProvinceModel 
     */ 
    void update(QuestionModel questionModel) ;
}
