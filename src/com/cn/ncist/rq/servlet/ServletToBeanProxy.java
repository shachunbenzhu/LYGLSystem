package com.cn.ncist.rq.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cn.ncist.rq.api.LoginServlet;

/**
 * 我们自己实现的一个代理类用于将Servlet转为Spring管理的Servlet Bean
 * @author 任倩
 * @date 2017-5-23
 *
 */
public class ServletToBeanProxy extends GenericServlet {

	private String targetBean;//当前客户端请求的Servlet名字  
    private Servlet proxy;//代理Servlet
    
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		//在service方法中调用bean的service方法，servlet会根据客户的请求去调用相应的请求方法（Get/Post） 
		proxy.service(arg0, arg1);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		/**
	      *
	      * 在Servlet中注入对象的步骤:
	      * 1.取得ServletContext
	      * 2.利用Spring的工具类WebApplicationContextUtils得到WebApplicationContext
	      * 3.WebApplicationContext就是一个BeanFactory,其中就有一个getBean方法
	      * 4.有了这个方法就可像平常一样为所欲为了
	      *
	      */  
		WebApplicationContext wac =   
            WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext()); //初始化Spring容器  
        this.targetBean = getServletName();  
        this.proxy = (Servlet) wac.getBean(targetBean);//调用ServletBean  
        proxy.init(getServletConfig());//调用初始化方法将ServletConfig传给Bean
	}
	
	

}
