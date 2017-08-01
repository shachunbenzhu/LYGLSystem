<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>游记详情页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/style_detile.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
    <p align="center" class="titlename">游记详细信息</p>
    <s:form action="updateNoteDetile.action?note_id='%{note_id}'" method="post" name="form1" enctype="multipart/form-data">
    <s:iterator value="noteModelList">
	<table width="400" border="0" align="center" bordercolor="#FF66FF">
		<tr align="center">
        	<td rowspan="2" align="center" bgcolor="#e9f1f6">
           	  <img src="<s:property value="%{note_bgimg}"/>" alt="暂无图片" name="note_bgimg" width="80" height="80" align="middle" /><br/>
                <input type="file" name="note_bgimg_new" style="visibility:hidden" />
            </td>
            <td width="100" bgcolor="#e9f1f6">游记标题</td>
            <td width="100" bgcolor="#e9f1f6">游记日期</td>
            <td width="100" bgcolor="#e9f1f6">游记天数</td>
            <td bgcolor="#e9f1f6">用户</td>
        	<td bgcolor="#e9f1f6">花销</td>
        </tr>
        <tr align="center">
            <td width="200" bgcolor="#fcefe8">
        		<s:textfield cssClass="wenbenkuang" name="note_title" value="%{note_title}" readonly="true" theme="simple" size="10"/>
        	</td>
        	<td width="200" bgcolor="#fcefe8">
        		<s:textfield cssClass="wenbenkuang" name="note_date" value="%{note_date}" readonly="true" theme="simple" size="10"/>
        	</td>
        	<td width="200" bgcolor="#fcefe8">
        		<s:textfield cssClass="wenbenkuang" name="note_days" value="%{note_days}" readonly="true" theme="simple" size="10"/>
        	</td>
        	<td bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="user_name" value="%{user_name}" readonly="true" theme="simple" size="10"/></td>
			<td bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="note_expend" value="%{note_expend}" readonly="true" theme="simple" size="10"/></td>
		</tr>
        <tr align="center">
        	<td bgcolor="#e9f1f6">同伴</td>
        	<td bgcolor="#e9f1f6">点赞数量</td>
        	<td bgcolor="#e9f1f6">浏览数量</td>
        	<td bgcolor="#e9f1f6">评论数量</td>
        	<td bgcolor="#e9f1f6">游记地址</td>
        	<td bgcolor="#e9f1f6">评论内容</td>
        <tr align="center">
        	<td bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="note_partner" value="%{note_partner}" readonly="true" theme="simple" size="10"/></td>
        	<td bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="note_zannumber" value="%{note_zannumber}" readonly="true" theme="simple" size="10"/></td>
        	<td bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="note_seenumber" value="%{note_seenumber}" readonly="true" theme="simple" size="10"/></td>
        	<td bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="note_commentnumber" value="%{note_commentnumber}" readonly="true" theme="simple" size="10"/></td>
        	<td bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="note_address" value="%{note_address}" readonly="true" theme="simple" size="10"/></td>
        	<td bgcolor="#fcefe8">
        		<a href="queryAllComment.action?note_id=<s:property value="%{note_id}"/>" class="gl">管理</a>
        	</td>
		</tr>
     	<tr align="center">
        	<td colspan="6" bgcolor="#fcefe8"><textarea rows="10" class="wenbenkuang" cols="70" placeholder="<s:property value="%{note_content}"/>" name="note_content" readonly="readonly"></textarea></td>
		</tr>
        <tr align="center">
        	<% 
        		//String[] note_img1 = note_img.split(";") ;
        	%>
        	<td rowspan="2" bgcolor="#fcefe8" align="center" colspan="6">
        		<s:iterator value="allNoteImg" id="noteImg">
        			<img src="<s:property value="#noteImg"/>" alt="暂无图片" name="note_img" width="80" height="80" align="middle" />&nbsp;&nbsp;
        		</s:iterator>
        	</td>
        	
		</tr>
	</table>
	<table width="400" border="0" align="center">
		<tr><td>&nbsp;</td></tr>
		<tr align="center">
        	<td colspan="6">
        		<a href="managerNote.action?" class="gl">返回</a>|
        		<a href="deleteNote.action?note_ids=<s:property value="%{note_id + ';'}"/>" class="gl">删除</a>
            </td>
		</tr>
	</table>
	</s:iterator>
    </s:form>
    
    <s:iterator value="allComment">
    <table width="725" border="0" align="center" bordercolor="#FF66FF">    
				<tr align="center">
					<td width="90" bgcolor="#fcefe8" colspan="2">
						<s:textfield cssClass="wenbenkuang"name="comment_date" value="%{comment_date}" 
							readonly="true" theme="simple" size="8"/>&nbsp;&nbsp;
						<s:textfield cssClass="wenbenkuang" name="user_name" value="%{user_name}" 
							readonly="true" theme="simple" size="3"/>
					</td>
					<td colspan="4">&nbsp;</td>
				</tr>
				<tr align="center">
					<td width="90" bgcolor="#fcefe8" colspan="5"><textarea rows="5" class="texta" cols="70" placeholder="<s:property value="%{comment_content}"/>" 
							name="comment_content" readonly="readonly"></textarea></td>
					<td width="90"><a href="deleteComment.action?comment_id=<s:property value="%{comment_id}"/>" class="gl">删除</a></td>
				</tr>
				<tr align="center">
					<td bgcolor="#fcefe8" colspan="2">&nbsp;</td>
					<td width="90" bgcolor="#fcefe8" colspan="3">
						<s:textfield cssClass="wenbenkuang" name="response_date" value="%{response_date}" 
							readonly="true" theme="simple" size="8"/>&nbsp;
						作者回复：<textarea rows="5" class="texta" cols="70" placeholder="<s:property value="%{response_content}"/>" 
							name="response_content" readonly="readonly"></textarea></td>
					<td>&nbsp;</td>
				</tr>
	</table>
	</s:iterator>
  </body>
</html>
