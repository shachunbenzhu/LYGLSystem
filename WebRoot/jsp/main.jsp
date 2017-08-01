<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body topmargin="0" leftmargin="0" bottommargin="0" class="scrollbar">
	<table width="1000" align="center" cellpadding="1" cellspacing="0" bordercolor="#CCCCCC">
	  <tr>
	    <td>
	        <table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
	          <tr>
	            <td height="120">
	                <div align="center">
	                    <IFRAME frameBorder=0 id=top name=top scrolling=no src="./jsp/top.jsp" 
	         style="HEIGHT: 120px; VISIBILITY: inherit; WIDTH: 1000px; Z-INDEX: 3"> </IFRAME>
	            	</div>
	             </td>
	          </tr>
	        </table>
	      <table width="1000" height="620" border="0" align="center" cellpadding="0" cellspacing="0">
	        <tr>
	          <td width="220" height="620" valign="top" background="../images/leftbg.jpg" id="lt" style="display:"><div align="center">
	              <IFRAME frameBorder=0 id=left name=left src="./jsp/left.jsp" 
	      style="HEIGHT: 620px; VISIBILITY: inherit; WIDTH: 220px; Z-INDEX: 2"> </IFRAME>
	          </div></td>
	          <td width="20" height="620"><div align="center"></div></td>
	          <td width="760" bgcolor="" id="mn"  height="620"><div align="center">
	              <IFRAME frameBorder=0 id=main name=main scrolling=yes src="managerNote.action" 
	      style="HEIGHT: 620px; VISIBILITY: inherit; WIDTH: 750px; Z-INDEX: 1"> </IFRAME>
	          </div></td>
	        </tr>
	      </table>
	      <table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
	          <tr>
	            <td height="100" width="1000"><div align="center">
	                <IFRAME frameBorder=0 id=bottom name=bottom scrolling=no src="./jsp/bottom.jsp" 
	         style="HEIGHT: 100px; VISIBILITY: inherit; WIDTH: 1000px; Z-INDEX: 4"> </IFRAME>
	            </div></td>
	          </tr>
	        </table>
	      </td>
	  </tr>
	</table>
  </body>
</html>
