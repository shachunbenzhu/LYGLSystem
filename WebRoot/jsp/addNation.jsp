<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增国家页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./css/style_add.css">
  </head>
  
  <script type="text/javascript">
  	function save() {
  		var form1 = document.getElementById("form1") ;
  		//window.RetrunValue=0;
  		window.close();
  		form1.action="addNation.action?nation_name = " + document.getElementById("nation_name").value;
  		form1.submit() ;
  	}
  </script>
  
  <body>
    <div id="pop-uppage" style="width:520px;">
  <div id="current">当前位置：目的地管理 > 地区管理 > 新增国家</div>
  <!-- <div class="xxpage" style="width:500px;"> -->
  	<form action="addNation.action" method="post" id="form1" >
    <table width="500" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="50" align="center" style="font-size:16px; font-weight:bold; border-bottom:#cdd0d3 1px double;">新增国家信息</td>
      </tr>
    
      <tr>
        <td height="5"></td>
      </tr>
  
    <!-- <table width="500" border="0" cellspacing="0" cellpadding="0"> -->
      <tr align="center">
        <td width="80" class="xxpage_td2">
        	国家名称：<input name="nation_name" id="nation_name" type="text" size="16" />
        </td>
      </tr>
    <tr>
      <td height="30" align="center">
      	<input type="submit" name="Submit" class="btn_2" value=" 保存 " onclick="save()"/>
      	<input type="button" name="Submit" class="btn_2" value=" 取消 " onclick="window.close();" />
      </td>
    </tr>
  </table>
  </form>
</div>
  </body>
</html>
