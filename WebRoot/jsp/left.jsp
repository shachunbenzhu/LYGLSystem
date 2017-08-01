<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
		#apDiv1 {
			position:absolute;
			left:1px;
			top:11px;
			width:215px;
			height:317px;
			z-index:1;
			font-size: 18px;
			background:url(./images/leftbg.jpg);
			color: #000;
		}
	</style>
	<script src="./SpryAssets/SpryCollapsiblePanel.js" type="text/javascript"></script>
	<link href="./SpryAssets/SpryCollapsiblePanel.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		a:link {
			color: #000;
			text-decoration: none;
		}
		a:visited {
			text-decoration: none;
			color: #000;
		}
		a:hover {
			color:#00CCCC;
			text-decoration: none;
		}
		a:active {
			color:#00CCCC;
			text-decoration: none;
		}
		#apDiv2 {
			position:absolute;
			left:5px;
			top:421px;
			width:231px;
			height:19px;
			z-index:2;
		}
	</style>

  </head>
  
  <body style="border:#CCCCCC;">
    <div id="apDiv1">
	  <div id="CollapsiblePanel1" class="CollapsiblePanel" align="center">
	    <div class="CollapsiblePanelTab" tabindex="0">游记管理</div>
	    <div class="CollapsiblePanelContent">
	      <p align="left">■<a href="managerNote.action" target="main">游记管理</a></p>
	      <p>&nbsp;</p>
	    </div>
	  </div>
	  <div id="CollapsiblePanel3" class="CollapsiblePanel" align="center">
	    <div class="CollapsiblePanelTab" tabindex="0">目的地管理</div>
	    <div class="CollapsiblePanelContent">
	      <p align="left">■<a href="managerProvince.action" target="main">地区管理</a></p>
	      <p align="left">■<a href="managerDestination.action" target="main">景点管理</a></p>
	      <p>&nbsp;</p>
	    </div>
	  </div>
	  <div id="CollapsiblePanel4" class="CollapsiblePanel" align="center">
	    <div class="CollapsiblePanelTab" tabindex="0">问题管理</div>
	    <div class="CollapsiblePanelContent">
          <p align="left">■<a href="managerQuestion.action" target="main">问题管理</a></p>
	      <p>&nbsp;</p>
	    </div>
	  </div>
	  <div id="CollapsiblePanel5" class="CollapsiblePanel" align="center">
	    <div class="CollapsiblePanelTab" tabindex="0">用户管理</div>
	    <div class="CollapsiblePanelContent">
	      <p align="left">■<a href="managerUser.action" target="main">用户信息管理</a></p>
	      <p align="left">■<a href="updatePwd.action" target="main">修改密码</a></p>
	      <p>&nbsp;</p>
	    </div>
	  </div>
	<h1>&nbsp; </h1>
	<p>&nbsp; </p>
	<p>&nbsp; </p>
    </div>
	<script type="text/javascript">
		var CollapsiblePanel1 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel1", {contentIsOpen:false});
		var CollapsiblePanel3 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel3", {contentIsOpen:false});
		var CollapsiblePanel4 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel4", {contentIsOpen:false});
		var CollapsiblePanel5 = new Spry.Widget.CollapsiblePanel("CollapsiblePanel5", {contentIsOpen:false});
	</script>
  </body>
</html>
