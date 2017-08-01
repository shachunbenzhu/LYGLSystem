package com.cn.ncist.rq.question.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.cn.ncist.rq.question.dao.QuestionDao;
import com.cn.ncist.rq.question.vo.QuestionModel;

public class QuestionDaoImpl extends HibernateDaoSupport implements QuestionDao {

	@SuppressWarnings("unchecked")
	public List<QuestionModel> queryAllQuestion() {
		List<QuestionModel> list = null ;

		try {
			String hql="select qm from QuestionModel qm" ;
			list=this.getHibernateTemplate().find(hql) ;
		} catch (Exception e) {
			e.printStackTrace() ;
		}
		
		if(list == null) {
			System.out.println("null") ;
			return null ;
		}
		if(list.size() < 1) {
			System.out.println("size = 0") ;
			return null ;
		} else {
			return list;			
		}
	}

	public List<QuestionModel> queryQuesByLabel(String question_label) {
		List<QuestionModel> questionModelList = null ;
		
		try {
			String hql = "select qm from QuestionModel qm where qm.question_label = '" ;
			hql = hql + question_label ;
			hql = hql + "' order by question_id" ;
			questionModelList = this.getHibernateTemplate().find(hql);	
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(questionModelList == null)
		{
			System.out.println("null");
			return null;
		}
		if(questionModelList.size() < 1)
		{
			System.out.println("size = 0");
			return null;
		}
		return questionModelList;
	}
	
	@SuppressWarnings("unchecked")
	public List<QuestionModel> queryQuestionById(Integer question_id) {
		List<QuestionModel> questionModelList = null ;
		
		try {
			String hql = "select qm from QuestionModel qm where qm.question_id = " ;
			hql = hql + question_id ;
			questionModelList = this.getHibernateTemplate().find(hql);	
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(questionModelList == null)
		{
			System.out.println("null");
			return null;
		}
		if(questionModelList.size() < 1)
		{
			System.out.println("size = 0");
			return null;
		}
		return questionModelList;
	}
	
	@SuppressWarnings("unchecked")
	public void delete(Integer question_id) {
		List<QuestionModel> questionModelList = null ;
    	try {
    		System.out.println(question_id);
			String hql = "select qm from QuestionModel qm where qm.question_id = " ;
			hql = hql + question_id ;
			System.out.println(hql);
			questionModelList = this.getHibernateTemplate().find(hql);
			if (questionModelList != null)
			{
				for (QuestionModel questionModel:questionModelList) {
					this.getHibernateTemplate().delete(questionModel);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    public void update(QuestionModel questionModel) {
    	this.getHibernateTemplate().update(questionModel) ;
    }
    
    public void save(QuestionModel questionModel) {
		this.getHibernateTemplate().save(questionModel) ;
    }

}
