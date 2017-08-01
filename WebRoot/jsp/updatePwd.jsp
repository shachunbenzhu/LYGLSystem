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
		function check(form){
			if (form.admin_pwd.value == "") {
				alert("请输入原密码!");
				form.admin_pwd.focus();
				return false;
			}
			if (form.admin_new_pwd.value == "") {
				alert("请输入新密码!");
				form.admin_new_pwd.focus();
				return false;
			}	
			if (form.admin_new_pwd_confirm.value == "") {
				alert("请输入确认新密码!");
				form.admin_new_pwd_confirm.focus();
				return false;
			}	
			if (form.admin_new_pwd.value != form.admin_new_pwd_confirm.value) {
				alert("您两次输入的新密码不一致，请重新输入!");
				form.admin_new_pwd.value = "";
				form.admin_new_pwd_confirm.value = "";
				form.admin_new_pwd.focus();
				return false;
			}
			if (form.admin_pwd.value == form.admin_new_pwd.value) {
				alert("您输入的原密码与新密码一致，请重新输入!");
				form.admin_pwd.value = "";
				form.admin_new_pwd.value = "";
				form.admin_pwd.focus();
				return false;
			}
		}
		
	</script>
  </head>
  
  <body>
    <s:form action="updatePwd.action" id="form1" validate="true" method="post">
    	<table align="center">
    		<tr>
    			<s:textfield label="原始密码" name="admin_pwd" maxlength="10" size="20"/>
    		</tr>
    		<tr>
    			<s:textfield label="新密码" name="admin_new_pwd" maxlength="10" size="20"/>
    		</tr>
    		<tr>
    			<s:password label="确认新密码" name="admin_new_pwd_confirm" maxlength="10" size="20"/>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
          			<s:submit value="提交" theme="simple" onclick="return check(form1)"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          			<s:reset value="重置" theme="simple"/>
          		</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>
