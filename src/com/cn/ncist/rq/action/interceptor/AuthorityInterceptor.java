package com.cn.ncist.rq.action.interceptor;

import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.*;
import java.util.Map;


/**
 * @author  ศฮูป
 * @version  1.0
 */
@SuppressWarnings("serial")
public class AuthorityInterceptor extends AbstractInterceptor
{
    public String intercept(ActionInvocation invocation) throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		Object user_id = session.get("user_id");
		if (user_id == null)
		{
			return "login";
		}
		else
		{
			return invocation.invoke();
		}
    }
}