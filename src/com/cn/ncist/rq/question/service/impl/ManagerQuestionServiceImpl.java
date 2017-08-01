package com.cn.ncist.rq.question.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import com.cn.ncist.rq.exception.ManagerException;
import com.cn.ncist.rq.question.dao.QuestionDao;
import com.cn.ncist.rq.question.service.ManagerQuestionService;
import com.cn.ncist.rq.question.vo.QuestionModel;

public class ManagerQuestionServiceImpl implements ManagerQuestionService {
	static Logger log = Logger.getLogger(ManagerQuestionServiceImpl.class.getName()) ;
	private QuestionDao questionDao ;
	
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		ManagerQuestionServiceImpl.log = log;
	}
	
	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public List<QuestionModel> queryQuestion() throws ManagerException  {
		try {
            return questionDao.queryAllQuestion() ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询问题出现异常,请重试") ;
        }
	}
	
	public List<QuestionModel> queryQuestionByLabel(String question_label) throws ManagerException  {
		try {
            return questionDao.queryQuesByLabel(question_label) ;           
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("查询问题出现异常,请重试") ;
        }
	}
	
	public String deleteQuestion(Integer question_id) throws ManagerException {
    	try {
    		questionDao.delete(question_id);    
    		return "ok" ;
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("删除问题出现异常,请重试") ;
        }
    }
	
	public String updateQuestion(Integer question_id , String question_content , String question_answer , 
    		String question_label) throws ManagerException {
    	try {
    		QuestionModel questionModel = questionDao.queryQuestionById(question_id).get(0) ;
    		questionModel.setQuestion_content(question_content.trim()) ;
    		questionModel.setQuestion_answer(question_answer.trim()) ;
    		questionModel.setQuestion_label(question_label.trim()) ;
    		
    		questionDao.update(questionModel);
    		return "ok" ;          
        } catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("修改问题信息出现异常,请重试") ;
        }
    }

	public String addQuestion(String question_content, String question_answer,
			String question_label) throws ManagerException {
		try {
			QuestionModel questionModel = new QuestionModel() ;
			questionModel.setQuestion_content(question_content.trim()) ;
			questionModel.setQuestion_answer(question_answer.trim()) ;
			questionModel.setQuestion_label(question_label.trim()) ;
			
			questionDao.save(questionModel);
			return "ok" ;
		} catch (Exception e) {
            log.debug(e.getMessage()) ;
            throw new ManagerException("添加问题信息出现异常,请重试") ;
        }
	}

}
