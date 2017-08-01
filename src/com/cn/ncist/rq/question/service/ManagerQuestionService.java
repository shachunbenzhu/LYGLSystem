package com.cn.ncist.rq.question.service;

import java.util.List;
import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.question.vo.QuestionModel;

public interface ManagerQuestionService {
	
	/**
	 * 查询所有问题
	 * @return
	 * @throws ManagerException
	 */
	List<QuestionModel> queryQuestion() throws ManagerException ;
	
	/**
	 * 根据问题类别查询问题
	 * @param questionLabel
	 * @return
	 * @throws ManagerException
	 */
	List<QuestionModel> queryQuestionByLabel(String question_label) throws ManagerException ;
    /**
     * 删除选中的问题
     * @param question_id
     * @return
     * @throws ManagerException
     */
    String deleteQuestion(Integer question_id) throws ManagerException ;
    
    String updateQuestion(Integer question_id , String question_content , String question_answer , 
    		String question_label) throws ManagerException ;
    
    String addQuestion(String question_content , String question_answer , 
    		String question_label) throws ManagerException ;
}
