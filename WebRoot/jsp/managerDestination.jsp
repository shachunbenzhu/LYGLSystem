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
    
    <title>目的地管理页面</title>
    
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
			
			var destination_name = document.getElementsByName("destination_name") ;
			var destination_pinyin = document.getElementsByName("destination_pinyin") ;
			var destination_number = document.getElementsByName("destination_number") ;
			var nation_name = document.getElementsByName("nation_name") ;
			var province_name = document.getElementsByName("province_name") ;
			
			var province_name_dselect = document.getElementsByName("province_name_dselect") ;
			var nation_name_dselect = document.getElementsByName("nation_name_dselect") ;
			var line = document.getElementsByName("line") ;
			
			// 查看选中的项的个数 
			var num = 0 ; 
			var buttonId = document.getElementById(buttonname) ;
			var saveButton = document.getElementById(saveButName) ;
			
			for(var i=0; i<arrSon.length; i++) {
				if(!arrSon[i].checked) {		//当不再选择时，文本框变为不可编辑
					cbAll.checked = false;
					destination_name[i].readOnly = true ;
					destination_name[i].className = 'wenbenkuang' ;
					destination_pinyin[i].readOnly = true ;
					destination_pinyin[i].className = 'wenbenkuang' ;
					province_name[i].readOnly = true ;
					province_name[i].className = 'wenbenkuang' ;
					nation_name[i].readOnly = true ;
					nation_name[i].className = 'wenbenkuang' ;
					line[i].readOnly = true ;
					line[i].className = 'wenbenkuang' ;
					
					province_name[i].style.display = ''; 
					nation_name[i].style.display = ''; 
					line[i].style.display = ''; 
					province_name_dselect[i].style.display = 'none'; 
					nation_name_dselect[i].style.display = 'none'; 
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
		
		function deleteClick(sonName) {
			var num = 0;
			var destination_ids = "";
			var form1 = document.getElementById("form1");
			var arrSon = document.getElementsByName(sonName);
			for(var i=0; i<arrSon.length; i++) {		
				if(arrSon[i].checked) {
					destination_ids += arrSon[i].value + ";";
  					num ++ ;
				}
			}
			if(num == 0){ 
				alert('请勾选所要删除的数据！'); 
					return false;
			} else if(num >= 20) {
				if(confirm("您选择数据多余20条，确定要删除吗？")) {
					form1.action = "deleteDestination.action?destination_ids=" + destination_ids;
					form1.submit();
				} else {
					return false ;
				}
			} else {
				if(confirm("确定要删除吗？")) {
					form1.action = "deleteDestination.action?destination_ids=" + destination_ids;
					form1.submit();
				} else {
					return false ;
				}
			}
		} 
		
		//不可以调用方法
		var initial = function init() {
			var destination_name = document.getElementsByName("destination_name") ;
			var destination_pinyin = document.getElementsByName("destination_pinyin") ;
			var destination_number = document.getElementsByName("destination_number") ;
			var nation_name = document.getElementsByName("nation_name") ;
			var province_name = document.getElementsByName("province_name") ;
		}
		
		function editClick(sonName) {
			var arrSon = document.getElementsByName(sonName) ;
			
			var destination_name = document.getElementsByName("destination_name") ;
			var destination_pinyin = document.getElementsByName("destination_pinyin") ;
			var destination_number = document.getElementsByName("destination_number") ;
			var nation_name = document.getElementsByName("nation_name") ;
			var province_name = document.getElementsByName("province_name") ;
			var province_name_dselect = document.getElementsByName("province_name_dselect") ;
			var nation_name_dselect = document.getElementsByName("nation_name_dselect") ;
			var line = document.getElementsByName("line") ;
			
			for(var i = 0;i < arrSon.length; i++) { 
				if(arrSon[i].checked) { 
					//alert("i："+i);
					destination_name[i].readOnly = false ;
					destination_name[i].focus ;				// 设置焦点
					destination_name[i].className = 'addwenbenkuang' ;
					destination_pinyin[i].readOnly = false ;
					destination_pinyin[i].className = 'addwenbenkuang' ;
					
					if(nation_name[i].style.display == ''){ 
				        nation_name[i].style.display = 'none'; 
				        line[i].style.display = 'none' ;
				        province_name[i].style.display = 'none';
				    } else{ 
				        nation_name[i].style.display = ''; 
				        line[i].style.display = '' ;
				        province_name[i].style.display = ''; 
				    } 
				    
					if(nation_name_dselect[i].style.display == 'none'){ 
						nation_name_dselect[i].style.display = ''; 
						province_name_dselect[i].style.display = ''; 
					} else{ 
						nation_name_dselect[i].style.display = 'none';
						province_name_dselect[i].style.display = 'none';  
					} 
				} 
			}  
			return false ; 
		}
		
		function saveClick(sonName) {
			var destination_infos = "" ;
			var arrSon = document.getElementsByName(sonName);
			
			var destination_name = document.getElementsByName("destination_name") ;
			var destination_pinyin = document.getElementsByName("destination_pinyin") ;
			var destination_number = document.getElementsByName("destination_number") ;
			var province_name_dselect = document.getElementsByName("province_name_dselect") ;
			var nation_name_dselect = document.getElementsByName("nation_name_dselect") ;
			
			for(var i = 0; i < arrSon.length; i++) {
				if(arrSon[i].checked) {
					destination_infos += arrSon[i].value + ";";
					destination_infos += destination_name[i].value + ";";
					destination_infos += destination_pinyin[i].value + ";";
					destination_infos += destination_number[i].value + ";";
					destination_infos += province_name_dselect[i].value + ";";
					destination_infos += nation_name_dselect[i].value + ";";
					
					form1.action = "updateDestination.action?destination_infos=" + destination_infos ;
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
	    	var destination_name_add = document.getElementsByName("destination_name_add")[0].value ;
	    	var destination_pinyin_add = document.getElementsByName("destination_pinyin_add")[0].value ;
	    	var destination_number_add = document.getElementsByName("destination_number_add")[0].value ;
	    	var nation_name_add = document.getElementsByName("nation_name_add")[0].value ;
	    	var province_name_add = document.getElementsByName("province_name_add")[0].value ;
	    	addform.action = "addDestination.action?destination_name_add = " + destination_name_add + "&destination_pinyin_add = "
	    						+ destination_pinyin_add + "&destination_number_add = " + destination_number_add + "&nation_name_add = "
	    						+ nation_name_add + "&province_name_add = " + province_name_add ;
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
    <s:form method="post" action="queryDestination.action" name="form2">
    	<table border="0" width="725" align="center">
    	<tr>
        	<td colspan="7">
            	<p align="center" class="titlename">目的地信息管理</p>
            </td>
        </tr>
        <tr height="30"></tr>
        <tr>
        	<td width="100" colspan="2">
                名称：<input type="text" size="5" border="1" name="destination_name_select" value="<s:property value="%{destination_name_select}"/>" />
            </td>
            <td width="100" colspan="2">
                <s:select name="province_name_select" list="allProvinceName" headerKey="-1" theme="simple" headerValue="--请选择所在省份--" listKey="province_name" listValue="province_name"/>
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
    <s:form method="post" action="queryAllDestination.action" id="form1" name="form1">
    <table width="725" border="0" align="center" bordercolor="#FF66FF">    
		<tr align="center" bgcolor="#00CCCC">
        	<td width="65" height="31" bgcolor="#e9f1f6">
            	<input type="checkbox" name="per" id="chkAll" onclick="ChkAllClick('destination_id' , 'chkAll')" />全选
      		</td>
      		<td width="90" bgcolor="#e9f1f6">图片</td>
			<td width="50" bgcolor="#e9f1f6">名称</td>
			<td width="70" bgcolor="#e9f1f6">拼音</td>
			<td width="50" bgcolor="#e9f1f6">游记次数</td> 
			<td width="50" bgcolor="#e9f1f6" colspan="2">所属省份</td> 
		</tr>
		<s:iterator value="pageBean.list">
		<tr align="center">
			<td width="65" height="29" bgcolor="#fcefe8">
				<input type="checkbox" value="<s:property value="destination_id"/>" name="destination_id" onclick="ChkSonClick('destination_id','chkAll','buttonId','saveButton')"/>
			</td> 
			<td width="90" bgcolor="#fcefe8"><img src="<s:property value="%{destination_img}"/>" alt="暂无图片" name="destination_img" width="80" 
							height="80" align="middle" /></td>
			<td width="50" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="destination_name" value="%{destination_name}" 
							readonly="true" theme="simple" size="3"/></td>
			<td width="70" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="destination_pinyin" value="%{destination_pinyin}" 
							readonly="true" theme="simple" size="3"/></td>
							
			<td width="50" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="destination_number" value="%{destination_number}" 
							readonly="true" theme="simple" size="3"/></td>
			<td width="50" bgcolor="#fcefe8" colspan="2" align="center">
				<s:textfield cssClass="wenbenkuang" name="nation_name" value="%{nation_name}" 
							readonly="true" theme="simple" size="3"/>
				<input type="text" value="--" name="line" readonly="readonly" class="wenbenkuang">
				<s:textfield cssClass="wenbenkuang" name="province_name" value="%{province_name}" 
							readonly="true" theme="simple" size="3"/>
				<div class="doubleselect">
				<s:doubleselect list="allNationName" listKey="nation_id" listValue="nation_name" name="nation_name_dselect"
							doubleList="allProNameByNati.get(top.nation_id)" doubleListKey="province_id" doubleListValue="province_name"
							doubleName="province_name_dselect" cssStyle="display:none"></s:doubleselect>
				</div>
			</td>
		</tr>
		</s:iterator>
        <tr style="display: none" id="showadd" align="center">
        	<td width="65" height="29" bgcolor="#fcefe8">
        		<!-- 名称不可以和方法名相同 -->
				<input type="submit" class="tianjia" value="+" name="adbtn" onclick="addBtn()" />
			</td> 
			
			<td width="90" bgcolor="#fcefe8"><img src="./images/common_default_des_img.jpg" alt="暂无图片" name="destination_img" width="80" 
							height="80" align="middle" /></td>
							
			<td width="90" bgcolor="#fcefe8"><s:textfield cssClass="addwenbenkuang" name="destination_name_add"
							theme="simple" size="8"/></td>
							
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="addwenbenkuang" name="destination_pinyin_add"
							theme="simple" size="8"/></td>
							
			<td width="50" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="destination_number_add"
							theme="simple" size="3" readonly="true"/></td>
							
			<td width="50" bgcolor="#fcefe8"><s:textfield cssClass="addwenbenkuang" name="province_name_add"
							theme="simple" size="3"/></td>
			
			<td width="50" bgcolor="#fcefe8"><s:textfield cssClass="addwenbenkuang" name="nation_name_add"
							theme="simple" size="3"/></td>
        </tr>
       
		<tr align="center" bgcolor="#00CCCC">
				<td width="65" bgcolor="#e9f1f6">
                	<input type="checkbox" name="per" id="chkOpp" onclick="ChkOppClick('destination_id')" />反选
                </td>
				<td colspan="11" bgcolor="#e9f1f6">
					<input type="submit" value="删除" onClick="return deleteClick('destination_id')">
                    <input type="submit" id="buttonId" value="选择修改" disabled="disabled" onClick="return editClick('destination_id')"/>
                    <input type="submit" id="saveButton" value="保存" disabled="disabled" onClick="return saveClick('destination_id')"/>
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
        		<a href="managerDestination.action?page=1"><font face="webdings" color="#00CCCC"> 9 </font></a>
				<a href="managerDestination.action?page=1"/><font face="webdings" color="#00CCCC"> 7 </font></a>
		</s:if>
		<s:else>
				<a href="managerDestination.action?page=1"><font face="webdings" color="#00CCCC"> 9 </font></a>
				<a href="managerDestination.action?page=<s:property value="%{pageBean.currentPage-1}"/>"/><font face="webdings" color="#00CCCC"> 7 </font></a>
        </s:else>
        <font size="3">
			<font color="#FF66FF"><s:property value="pageBean.currentPage"/></font>
		</font>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
				<a href="managerDestination.action?page=<s:property value="%{pageBean.currentPage+1}"/>"/><font face="webdings" color="#00CCCC"> 8 </font></a>
				<a href="managerDestination.action?page=<s:property value="pageBean.totalPage"/>"><font face="webdings" color="#00CCCC"> : </font></a>
		</s:if>
		<s:else>
        		<a href="managerDestination.action?page=<s:property value="%{pageBean.currentPage}"/>"><font face="webdings" color="#00CCCC"> 8 </font></a>
				<a href="managerDestination.action?page=<s:property value="%{pageBean.currentPage}"/>"><font face="webdings" color="#00CCCC"> : </font></a>
		</s:else>	
		<s:form action="managerDestination.action" onsubmit="return validate();">
			<s:textfield name="page" label="跳转至" theme="simple" size="3"/>页&nbsp;&nbsp;
			<s:submit value="跳转" theme="simple"/>
		</s:form>
        
</center>  
	<?php
		}
	?>
  </body>
</html>
