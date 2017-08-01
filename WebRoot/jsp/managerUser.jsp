<%@ page language="java" import="java.util.*" import="com.cn.ncist.rq.note.vo.NoteModel" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/style_manager.css">
	<script type="text/javascript"> 
		
		// --列头全选框被单击---
		function ChkAllClick(sonName , cbAllId) {
			var arrSon = document.getElementsByName(sonName) ;
			var cbAll = document.getElementById(cbAllId) ;
			
			var tempState = cbAll.checked ;
			for(i = 0; i < arrSon.length; i++) {
				if(arrSon[i].checked != tempState) {
					arrSon[i].click() ;
				}
			}
			return false ;
		}
		
		// --子项复选框被单击---
		function ChkSonClick(sonName, cbAllId , buttonname,saveButName) {
			var arrSon = document.getElementsByName(sonName);
			var cbAll = document.getElementById(cbAllId);
			
			initial() ;
			
			// 查看选中的项的个数 
			var num = 0 ; 
			var buttonId = document.getElementById(buttonname) ;
			var saveButton = document.getElementById(saveButName) ;
			
			//alert(arrSon.length) ;
			
			for(var i=0; i<arrSon.length; i++) {
				//alert(i) ;
				//alert("checked"+arrSon[i].checked) ;
				if(!arrSon[i].checked) {
					cbAll.checked = false;
					
					user_name[i].readOnly = true ;
					user_name[i].className = 'wenbenkuang' ;
					user_pwd[i].readOnly = true ;
					user_pwd[i].className = 'wenbenkuang' ;
					
				} else {
					num++ ;	
				}
			}
			if(num == arrSon.length) {
				cbAll.checked = true;
			}
			  
			if (num == 0) {
				buttonId.disabled = true ;
				saveButton.disabled = true ;
				alert("您未勾选任何选项！") ;
				return false ;
			} else if (num == 1) {
				buttonId.disabled = false ;				// 可以点击此按钮
				saveButton.disabled = false ;
				return false ;
			} else {
				buttonId.disabled = true ;
				saveButton.disabled = true ;
				alert("您只可以修改一项，但是可以删除！") ;
				return false ;
			}
		}
		
		// --反选被单击---
		function ChkOppClick(sonName){
			var arrSon = document.getElementsByName(sonName);
			for(var i = 0; i < arrSon.length; i++) {
				arrSon[i].click();
			}
			return false;
		}
		
		function deletecilck(sonName) {
			var num = 0;
			var user_ids = "";
			var form1 = document.getElementById("form1");
			var arrSon = document.getElementsByName(sonName);
			for(var i=0; i<arrSon.length; i++) {		
				if(arrSon[i].checked) {
					user_ids += arrSon[i].value + ";";
  					num ++ ;
				}
			}
			if(num == 0){ 
				alert('请勾选所要删除的数据！'); 
					return false;
			} else if(num >= 20) {
				if(confirm("您选择数据多余20条，确定要删除吗？")) {
					form1.action = "deleteUser.action?user_ids=" + user_ids;
					form1.submit();
				} else {
					return false ;
				}
			} else {
				if(confirm("确定要删除吗？")) {
					form1.action = "deleteUser.action?user_ids=" + user_ids;
					form1.submit();
				} else {
					return false ;
				}
			}
		} 
		
		var initial = function init() {
			var user_name = document.getElementsByName("user_name") ;
			var user_pwd = document.getElementsByName("user_pwd") ;
			var user_pocket = document.getElementsByName("user_pocket") ;
			var user_point = document.getElementsByName("user_point") ;
		}
		
		function editClick(sonName) {
			var arrSon = document.getElementsByName(sonName) ;
			initial() ;
			
			for(var i = 0;i < arrSon.length; i++) { 
				if(arrSon[i].checked) { 
					user_name[i].readOnly = false ;
					user_name[i].focus ;				// 设置焦点
					user_name[i].className = 'addwenbenkuang' ;
					user_pwd[i].readOnly = false ;
					user_pwd[i].className = 'addwenbenkuang' ;
				} 
			}  
			return false ; 
		}
		
		function saveClick(sonName) {
			var user_infos = "" ;
			var arrSon = document.getElementsByName(sonName);
			
			initial() ;
			
			for(var i = 0; i < arrSon.length; i++) {
				if(arrSon[i].checked) {
					user_infos += arrSon[i].value + ";";
					user_infos += user_name[i].value + ";";
					user_infos += user_pwd[i].value + ";";
					user_infos += user_pocket[i].value + ";";
					user_infos += user_point[i].value + ";";
					
					
					form1.action = "updateUser.action?user_infos=" + user_infos ;
					form1.submit();
				}
			}
		}
	    
	    function show() {
	    	var add = document.getElementById("showadd");
	    	add.style.display="" ;
	    	return false ;
	    }  
	    
	    function addBtn() {
	    	var addform = document.getElementById("form1");
	    	var user_name_add = document.getElementsByName("user_name_add")[0].value ;
	    	var user_pwd_add = document.getElementsByName("user_pwd_add")[0].value ;
	    	var user_pocket_add = document.getElementsByName("user_pocket_add")[0].value ;
	    	var user_point_add = document.getElementsByName("user_point_add")[0].value ;
	    	addform.action = "addUser.action?user_name_add = " + user_name_add + "&user_pwd_add = "
	    						+ user_pwd_add + "&user_pocket_add = " + user_pocket_add
	    						+ "&user_point_add = " + user_point_add ;
	    	addform.submit() ;
	    }
	    
		function validate() {
			var page = document.getElementsByName("page")[0].value ; 
			if(page > <s:property value="pageBean.totalPage"/>) {
				alert("你输入的页数大于最大页数");                                    
				return false;             
			}              
			return true;         
		} 
		     
	</script>
  </head>
  
  <body>
    <s:form method="post" action="queryUser.action" name="form2">
    	<table border="0" width="725" align="center">
    	<tr>
        	<td colspan="7">
            	<p align="center" class="titlename">用户信息管理</p>
            </td>
        </tr>
        <tr height="30"></tr>
        <tr>
        	<td width="150">
                用户名：<input type="text" size="5" border="1" name="user_name_select" value="<s:property value="%{user_name_select}"/>" />
            </td>
            <td colspan="3" align="center">
                <input type="submit" border="0" value="查询" />
            </td>
            <td colspan="3" align="center">
                <input type="button" value="添加" onclick="show()" />
            </td>
        </tr>
    </table>
    </s:form>
    <br/>
    <s:form method="post" action="queryAllUser.action" id="form1">
    <table width="725" border="0" align="center" bordercolor="#FF66FF">    
		<tr align="center" bgcolor="#00CCCC">
        	<td width="65" height="31" bgcolor="#e9f1f6">
            	<input type="checkbox" name="per" id="chkAll" onclick="ChkAllClick('user_id' , 'chkAll')" />全选
      		</td>
      		<td width="90" bgcolor="#e9f1f6">头像</td>
			<td width="90" bgcolor="#e9f1f6">用户名</td>
			<td width="60" bgcolor="#e9f1f6">密码</td>
			<td width="50" bgcolor="#e9f1f6">钱包</td> 
			<td width="60" bgcolor="#e9f1f6">积分</td>
			<td width="60" bgcolor="#e9f1f6">游记</td>
		</tr>
		<s:iterator value="pageBean.list">
		<tr align="center">
			<td width="65" height="29" bgcolor="#fcefe8">
				<input type="checkbox" value="<s:property value="user_id"/>" id="user_id" name="user_id" onclick="ChkSonClick('user_id','chkAll','buttonId','saveButton')"/>
			</td> 
			
			<!-- struts标签好像不可以设置样式 -->
			<td width="90" bgcolor="#fcefe8"><img src="<s:property value="%{user_touxiang}"/>" alt="暂无图片" name="user_touxiang" width="80" 
							height="80" align="middle" /></td>
			<td width="90" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="user_name" name="user_name" value="%{user_name}" 
							readonly="true" theme="simple" size="8"/></td>
							
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="user_pwd" name="user_pwd" value="%{user_pwd}" 
							readonly="true" theme="simple" size="8"/></td>
							
			<td width="50" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="user_pocket" name="user_pocket" value="%{user_pocket}" 
							readonly="true" theme="simple" size="3"/></td> 
							
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="user_point" name="user_point" value="%{user_point}" 
							readonly="true" theme="simple" size="5"/></td>
			
			<td width="60" bgcolor="#fcefe8">
				<!-- <input class="gl" type="button" value="管理" onclick="javascript:window.location='queryUserNote.action?user_id='%{user_id}''"/> -->
				<a href="queryUserNote.action?user_id=<s:property value="%{user_id}"/>" class="gl">管理</a>
			</td>
		</tr>
		</s:iterator>
        
        <tr style="display: none" id="showadd" align="center">
        	<td width="65" height="29" bgcolor="#fcefe8">
				<input type="submit" class="tianjia" value="+" name="adbtn" onclick="addBtn()" />
			</td> 
			
			<td width="90" bgcolor="#fcefe8"><img src="./images/common_default_tx_wawa.png" alt="暂无图片" name="user_touxiang" width="80" 
							height="80" align="middle" /></td>
			<td width="90" bgcolor="#fcefe8"><s:textfield cssClass="addwenbenkuang" name="user_name_add"
							theme="simple" size="8"/></td>
							
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="addwenbenkuang" name="user_pwd_add"
							theme="simple" size="8"/></td>
							
			<td width="50" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="user_pocket_add"
							theme="simple" size="3" readonly="true" value="0"/></td>
							
			<td width="50" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="user_point_add"
							theme="simple" size="3" readonly="true" value="0"/></td>
			<td width="50" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="addtext"
							theme="simple" size="3" readonly="true"/></td>
        </tr>
        
		<tr align="center" bgcolor="#00CCCC">
				<td width="65" bgcolor="#e9f1f6">
                	<input type="checkbox" name="per" id="chkOpp" onclick="ChkOppClick('user_id')" />反选
                </td>
				<td colspan="11" bgcolor="#e9f1f6">
					<input type="submit" value="删除" onClick="return deletecilck('user_id')">
                    <input type="submit" id="buttonId" value="选择修改" disabled="disabled" onClick="return editClick('user_id')"/>
                    <input type="submit" id="saveButton" value="保存" disabled="disabled" onClick="return saveClick('user_id')"/>
				</td>
			</tr>
	</table>
    </s:form> 
	<br/>
	<center>
		<font size="3">共
			<font color="#FF66FF"><s:property value="pageBean.allRow"/></font>
			条记录&nbsp;
		</font>
		<font size="3">第
			<font color="#FF66FF"><s:property value="pageBean.currentPage"/></font>
			页 /
		</font>
        <font size="3">共
		    <font color="#FF66FF"><s:property value="pageBean.totalPage"/></font>
			页&nbsp;
		</font>
    	<s:if test="%{pageBean.currentPage == 1}">
        		<a href="managerUser.action?page=1"><font face="webdings" color="#00CCCC"> 9 </font></a>
				<a href="managerUser.action?page=1"/><font face="webdings" color="#00CCCC"> 7 </font></a>
		</s:if>
		<s:else>
				<a href="managerUser.action?page=1"><font face="webdings" color="#00CCCC"> 9 </font></a>
				<a href="managerUser.action?page=<s:property value="%{pageBean.currentPage-1}"/>"/><font face="webdings" color="#00CCCC"> 7 </font></a>
        </s:else>
        <font size="3">
			<font color="#FF66FF"><s:property value="pageBean.currentPage"/></font>
		</font>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
				<a href="managerUser.action?page=<s:property value="%{pageBean.currentPage+1}"/>"/><font face="webdings" color="#00CCCC"> 8 </font></a>
				<a href="managerUser.action?page=<s:property value="pageBean.totalPage"/>"><font face="webdings" color="#00CCCC"> : </font></a>
		</s:if>
		<s:else>
        		<a href="managerUser.action?page=<s:property value="%{pageBean.currentPage}"/>"><font face="webdings" color="#00CCCC"> 8 </font></a>
				<a href="managerUser.action?page=<s:property value="%{pageBean.currentPage}"/>"><font face="webdings" color="#00CCCC"> : </font></a>
		</s:else>	
		<s:form action="managerUser.action" onsubmit="return validate();">
			<s:textfield name="page" label="跳转至" theme="simple" size="3"/>页&nbsp;&nbsp;
			<s:submit value="跳转" theme="simple"/>
		</s:form>
        
</center>  
	<?php
		}
	?>
  </body>
</html>
