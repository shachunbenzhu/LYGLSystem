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
    
    <title>国家管理页面</title>
    
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
		function ChkSonClick(sonName, cbAllId) {
			var arrSon = document.getElementsByName(sonName);
			var cbAll = document.getElementById(cbAllId);
			
			// 查看选中的项的个数 
			var num = 0 ; 
			
			for(var i=0; i<arrSon.length; i++) {
				if(!arrSon[i].checked) {		//当不再选择时，文本框变为不可编辑
					cbAll.checked = false;
				} else {
					num++ ;	
				}
			}
			if(num == arrSon.length) {
				cbAll.checked = true;
			}
			  
			if (num == 0) {
				alert("您未勾选任何选项！") ;
				return false ;
			} else {
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
		
		function deleteClick(sonName) {
			var num = 0;
			var province_ids = "";
			var form1 = document.getElementById("form1");
			var arrSon = document.getElementsByName(sonName);
			for(var i=0; i<arrSon.length; i++) {		
				if(arrSon[i].checked) {
					province_ids += arrSon[i].value + ";";
  					num ++ ;
				}
			}
			if(num == 0){ 
				alert('请勾选所要删除的数据！'); 
					return false;
			} else if(num >= 20) {
				if(confirm("您选择数据多余20条，确定要删除吗？")) {
					form1.action = "deleteProvince.action?province_ids=" + province_ids;
					form1.submit();
				} else {
					return false ;
				}
			} else {
				if(confirm("确定要删除吗？")) {
					form1.action = "deleteProvince.action?province_ids=" + province_ids;
					form1.submit();
				} else {
					return false ;
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
	    	var province_name_add = document.getElementsByName("province_name_add")[0].value ;
	    	var nation_name_add = document.getElementsByName("nation_name_add")[0].value ;
	    	addform.action = "addProvince.action?province_name_add = " + province_name_add + "&nation_name_add = "
	    						+ nation_name_add ;
	    	addform.submit() ;
	    }
	    
	    function addnation() {
			var openChild=window.open("./jsp/addNation.jsp" , "" ,"width=500,height=300,left=500,top=100,menubar=no,toolbar=no,location=no,scrollbars=yes,location=no");
		}
	        
		function validate() {
			var page = document.getElementsByName("page")[0].value ; 
			if(page > <s:property value="pageBean.totalPage"/>) {
				alert("你输入的页数大于最大页数");                                    
				return false;             
			}              
			return true;         
		}  
		
		function refresh() 
		{
			//window.opener.location.href=window.opener.location.href;
			//window.close(); 
			//if(openChild==0){window.location.reload();}
			//window.location.reload();
		}    
	</script>
  </head>
  
  <body onload="refresh()">
    <s:form method="post" action="queryProvince.action" name="form2">
    	<table border="0" width="725" align="center">
    	<tr>
        	<td colspan="7">
            	<p align="center" class="titlename">省|市|洲信息管理</p>
            </td>
        </tr>
        <tr height="30"></tr>
        <tr>
            <td width="100" colspan="2">
                名称：<input type="text" size="5" border="1" name="province_name_select" value="<s:property value="%{province_name_select}"/>" />
            </td>
            
            <td colspan="2" align="left">
                <input type="submit" border="0" value="查询" />
            </td>
            <td colspan="3" align="center">
                <input type="button" value="添加" onclick="show()" />
            </td>
        </tr>
    </table>
    </s:form>
    <br/>
    <s:form method="post" action="queryAllProvince.action" id="form1">
    <table width="725" border="0" align="center" bordercolor="#FF66FF">    
		<tr align="center" bgcolor="#00CCCC">
        	<td width="65" height="31" bgcolor="#e9f1f6">
            	<input type="checkbox" name="per" id="chkAll" onclick="ChkAllClick('province_id' , 'chkAll')" />全选
      		</td>
			<td width="90" bgcolor="#e9f1f6">名称</td>
			<td width="60" bgcolor="#e9f1f6">所属国家</td>
		</tr>
		<s:iterator value="pageBean.list">
		<tr align="center">
			<td width="65" height="29" bgcolor="#fcefe8">
				<input type="checkbox" value="<s:property value="province_id"/>" name="province_id" onclick="ChkSonClick('province_id','chkAll')"/>
			</td> 
			<td width="90" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="province_name" value="%{province_name}" 
							readonly="true" theme="simple" size="3"/></td>
			<td width="60" bgcolor="#fcefe8">
				<s:textfield cssClass="wenbenkuang" name="nation_name" value="%{nation_name}" 
							readonly="true" theme="simple" size="3"/>&nbsp;
			</td>
		</tr>
		</s:iterator>
        <tr style="display: none" id="showadd" align="center">
        	<td width="65" height="29" bgcolor="#fcefe8">
        		<!-- 名称不可以和方法名相同 -->
				<input type="submit" class="tianjia" value="+" name="adbtn" onclick="addBtn()" />
			</td> 
			
			<td width="90" bgcolor="#fcefe8"><s:textfield cssClass="addwenbenkuang" name="province_name_add"
							theme="simple" size="8"/></td>
							
			<td width="60" bgcolor="#fcefe8">
				<s:select name="nation_name_add" list="allNationName" headerKey="-1" theme="simple" 
							headerValue="--请选择问题标签--" listKey="nation_name" listValue="nation_name"/>
				<a class="gl" onclick="addnation()">添加国家</a>
			</td>
        </tr>
       
		<tr align="center" bgcolor="#00CCCC">
				<td width="65" bgcolor="#e9f1f6">
                	<input type="checkbox" name="per" id="chkOpp" onclick="ChkOppClick('province_id')" />反选
                </td>
				<td colspan="11" bgcolor="#e9f1f6">
					<input type="submit" value="删除" onClick="return deleteClick('province_id')">
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
        		<a href="managerProvince.action?page=1"><font face="webdings" color="#00CCCC"> 9 </font></a>
				<a href="managerProvince.action?page=1"/><font face="webdings" color="#00CCCC"> 7 </font></a>
		</s:if>
		<s:else>
				<a href="managerProvince.action?page=1"><font face="webdings" color="#00CCCC"> 9 </font></a>
				<a href=managerProvince.action?page=<s:property value="%{pageBean.currentPage-1}"/>"/><font face="webdings" color="#00CCCC"> 7 </font></a>
        </s:else>
        <font size="3">
			<font color="#FF66FF"><s:property value="pageBean.currentPage"/></font>
		</font>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
				<a href="managerProvince.action?page=<s:property value="%{pageBean.currentPage+1}"/>"/><font face="webdings" color="#00CCCC"> 8 </font></a>
				<a href="managerProvince.action?page=<s:property value="pageBean.totalPage"/>"><font face="webdings" color="#00CCCC"> : </font></a>
		</s:if>
		<s:else>
        		<a href="managerProvince.action?page=<s:property value="%{pageBean.currentPage}"/>"><font face="webdings" color="#00CCCC"> 8 </font></a>
				<a href="managerProvince.action?page=<s:property value="%{pageBean.currentPage}"/>"><font face="webdings" color="#00CCCC"> : </font></a>
		</s:else>	
		<s:form action="managerProvince.action" onsubmit="return validate();">
			<s:textfield name="page" label="跳转至" theme="simple" size="3"/>页&nbsp;&nbsp;
			<s:submit value="跳转" theme="simple"/>
		</s:form>
        
</center>  
	<?php
		}
	?>
  </body>
</html>
