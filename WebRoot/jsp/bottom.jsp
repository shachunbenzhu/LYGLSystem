<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bottom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/style.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body background="./images/bottombg.jpg">
    <table width="1000" border="0" align="center">
      <tr>
        <td align="center" class="bql"><br/>CopyRight 2017-2036 By <font class="bqlname">任倩</font> All Rights Reserved</td>
      </tr>
      <tr>
        <td align="center" class="bql">客服热线15732632715 <a href="mailto:15732632715@163.com">Email:15732632715@163.com</a>
          <p></p>
        </td>
      </tr>
    </table>
  </body>
</html>
