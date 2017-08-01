package com.cn.ncist.rq.question.dao;

import java.util.List;
import com.cn.ncist.rq.question.vo.QuestionModel;

/**
 * @author  任倩
 * @version  1.0
 */
public interface QuestionDao {
	/**
     * 查找所有Question
     * @return 
     */ 
	List<QuestionModel> queryAllQuestion() ;
    
	/**
	 * 根据问题类别查询问题
	 * @param question_label
	 * @return
	 */
	List<QuestionModel> queryQuesByLabel(String question_label) ;
    /**
     * 根据问题ID查询问题
     * @param question_id
     * @return
     */
    List<QuestionModel> queryQuestionById(Integer question_id) ;
    
    /**
     * 保存
     * @param questionModel 
     */ 
    void save(QuestionModel questionModel) ;
    
    /**
     * 删除选中的问题
     * @param question_id
     */
    void delete(Integer question_id) ;
    
    /**
     * 修改问题
     * @param ProvinceModel 
     */ 
    void update(QuestionModel questionModel) ;
}
