package com.cn.ncist.rq.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cn.ncist.rq.question.service.ManagerQuestionService;
import com.cn.ncist.rq.question.vo.QuestionModel;


public class QuestionServlet extends HttpServlet {

	private ManagerQuestionService mqs ;
	
	public ManagerQuestionService getMqs() {
		return mqs;
	}

	public void setMqs(ManagerQuestionService mqs) {
		this.mqs = mqs;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		doPost(req, resp) ;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String reqMessage , respMessage ;
		JSONArray reqObject = null ;
		JSONArray respObject = null ;
		req.setCharacterEncoding("UTF-8") ;
		resp.setContentType("text/json;charset=UTF-8") ;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					req.getInputStream(), "UTF-8")) ;
			StringBuffer sb = new StringBuffer("") ;
			String temp ;
			while ((temp = br.readLine()) != null) {
				sb.append(temp) ;
			}
			br.close() ;
			reqMessage = sb.toString() ;
			System.out.println("请求报文:" + reqMessage) ;
			reqObject = new JSONArray(reqMessage) ;
			
			JSONObject jo ;
			String action = reqObject.getJSONObject(0).getString("action") ;
			
			if (action.equals("queryQuestion")) {
				List<QuestionModel> questionList = mqs.queryQuestionByLabel(reqObject.getJSONObject(0).getString("questionLabel")) ;
				
				if (questionList == null) {//无问题
					respObject = new JSONArray().put(new JSONObject().put("result" , -1)) ;
				} else {
					respObject = new JSONArray() ;
					for(int i = 0; i < questionList.size(); i++) {
						respObject.put(new JSONObject()
								.put("result" , 0)
								.put("questionId", questionList.get(i).getQuestion_id())
								.put("questionContent", questionList.get(i).getQuestion_content())
								.put("questionAnswer", questionList.get(i).getQuestion_content())) ;
					}
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			respMessage = respObject == null ? "" : respObject.toString();
			System.out.println("返回报文:" + respMessage);
			PrintWriter pw = resp.getWriter();
			pw.write(respMessage);
			pw.flush();
			pw.close();
		}
	}
	
}
