package com.cn.ncist.rq.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cn.ncist.rq.user.service.ManagerUserService;
import com.cn.ncist.rq.user.service.impl.ManagerUserServiceImpl;
import com.cn.ncist.rq.user.vo.UserModel;

public class LoginServlet extends HttpServlet {

	private ManagerUserService mus ;
	
	public ManagerUserService getMus() {
		return mus;
	}

	public void setMus(ManagerUserService mus) {
		this.mus = mus;
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
		//super.doPost(req, resp);如果不引去，客户端接收到的HTTP响应代码是405
		
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
			
			if (action.equals("login")) {
				UserModel userModel = mus.getUserByName(reqObject.getJSONObject(0).getString("userName")) ;
				
				if (userModel == null) {//用户名不存在
					/*jo = new JSONObject() ;
					jo.put("userId" , -1) ;
					jo.put("userName" , "") ;*/
					respObject = new JSONArray().put(new JSONObject().put("userId" , -1).put("userName" , "")) ;
				} else if (!userModel.getUser_pwd().equals(reqObject.getJSONObject(0).getString("pwd"))) {//密码错误
					respObject = new JSONArray().put(new JSONObject().put("userId" , 0).put("userName" , "")) ;
				} else {
					respObject = new JSONArray().put(new JSONObject()
								.put("userId" , userModel.getUser_id())
								.put("userName" , userModel.getUser_name())) ;
				}
			} else if (action.equals("updateRePwd")) {
				String flag = mus.updateUserByName(reqObject.getJSONObject(0).getString("userName") , reqObject.getJSONObject(0).getString("repwd")) ;
				respObject = new JSONArray().put(new JSONObject().put("result", flag)) ;
			} else if (action.equals("testUserName")) {
				UserModel userModel = mus.getUserByName(reqObject.getJSONObject(0).getString("userName")) ;
				if (userModel == null) {//用户名不存在
					respObject = new JSONArray().put(new JSONObject().put("userId" , -1)) ;
				} else {
					respObject = new JSONArray().put(new JSONObject()
								.put("userId" , userModel.getUser_id())
								.put("repwd", userModel.getUser_repwd())
								.put("pwd", userModel.getUser_pwd())) ;
				}
			} else if (action.equals("register")) {
				String flag = mus.addUser(reqObject.getJSONObject(0).getString("userName"), reqObject.getJSONObject(0).getString("pwd"), "0", "0") ;
				respObject = new JSONArray().put(new JSONObject().put("result", flag)) ;
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
