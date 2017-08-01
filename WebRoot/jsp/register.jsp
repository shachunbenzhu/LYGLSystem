<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script language="javascript">
		function testusername() {
			var form1 = document.getElementById("form1");
			var adminname = document.getElementsByName("admin_name") ;
			form1.action = "testAdminName.action?admin_name = " + adminname ;
			form1.submit() ;
		}
	</script>
  </head>
  
  <body>
    <s:form action="register.action" id="form1" validate="true" method="post" validate="true">
    	<table align="center">
    		<tr>
    			<!--  onblur="return testusername()"失去焦点时 -->
    			<s:textfield label="用户名" name="admin_name" maxlength="10" size="20"/>
    		</tr>
    		<tr>
    			<s:password label="密码" name="admin_pwd" maxlength="10" size="20"/>
    		</tr>
    		<tr>
    			<s:textfield label="密保问题" name="admin_question" maxlength="10" size="20"/>
    		</tr>
    		<tr>
    			<s:textfield label="密保问题答案" name="admin_answer" maxlength="10" size="20"/>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
          			<s:submit value="注册" theme="simple"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          			<s:reset value="重置" theme="simple"/>
          		</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>
