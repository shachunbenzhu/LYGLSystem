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
 * �����Լ�ʵ�ֵ�һ�����������ڽ�ServletתΪSpring�����Servlet Bean
 * @author ��ٻ
 * @date 2017-5-23
 *
 */
public class ServletToBeanProxy extends GenericServlet {

	private String targetBean;//��ǰ�ͻ��������Servlet����  
    private Servlet proxy;//����Servlet
    
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		//��service�����е���bean��service������servlet����ݿͻ�������ȥ������Ӧ�����󷽷���Get/Post�� 
		proxy.service(arg0, arg1);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		/**
	      *
	      * ��Servlet��ע�����Ĳ���:
	      * 1.ȡ��ServletContext
	      * 2.����Spring�Ĺ�����WebApplicationContextUtils�õ�WebApplicationContext
	      * 3.WebApplicationContext����һ��BeanFactory,���о���һ��getBean����
	      * 4.������������Ϳ���ƽ��һ��Ϊ����Ϊ��
	      *
	      */  
		WebApplicationContext wac =   
            WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext()); //��ʼ��Spring����  
        this.targetBean = getServletName();  
        this.proxy = (Servlet) wac.getBean(targetBean);//����ServletBean  
        proxy.init(getServletConfig());//���ó�ʼ��������ServletConfig����Bean
	}
	
	

}
