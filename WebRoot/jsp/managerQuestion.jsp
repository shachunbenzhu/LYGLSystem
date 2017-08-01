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
    
    <title>问题管理页面</title>
    
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
			
			var question_content = document.getElementsByName("question_content") ;
			var question_answer = document.getElementsByName("question_answer") ;
			var question_label = document.getElementsByName("question_label") ;
			
			// 查看选中的项的个数 
			var num = 0 ; 
			var buttonId = document.getElementById(buttonname) ;
			var saveButton = document.getElementById(saveButName) ;
			
			for(var i=0; i<arrSon.length; i++) {
				if(!arrSon[i].checked) {		//当不再选择时，文本框变为不可编辑
					cbAll.checked = false;
					question_content[i].readOnly = true ;
					question_content[i].className = 'wenbenkuang' ;
					question_answer[i].readOnly = true ;
					question_answer[i].className = 'wenbenkuang' ;
					question_label[i].readOnly = true ;
					question_label[i].className = 'wenbenkuang' ;
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
			var question_ids = "";
			var form1 = document.getElementById("form1");
			var arrSon = document.getElementsByName(sonName);
			//alert(arrSon.length);
			for(var i=0; i<arrSon.length; i++) {		
				if(arrSon[i].checked) {
					question_ids += arrSon[i].value + ";";
  					num ++ ;
				}
			}
			if(num == 0){ 
				alert('请勾选所要删除的数据！'); 
					return false;
			} else if(num >= 20) {
				if(confirm("您选择数据多余20条，确定要删除吗？")) {
					form1.action = "deleteQuestion.action?question_ids=" + question_ids;
					form1.submit();
				} else {
					return false ;
				}
			} else {
				if(confirm("确定要删除吗？")) {
					form1.action = "deleteQuestion.action?question_ids=" + question_ids;
					form1.submit();
				} else {
					return false ;
				}
			}
		} 
		
		var initial = function init() {
			var question_content = document.getElementsByName("question_content") ;
			var question_answer = document.getElementsByName("question_answer") ;
			var question_label = document.getElementsByName("question_label") ;
			
		}
		
		function editClick(sonName) {
			var arrSon = document.getElementsByName(sonName) ;
			var question_content = document.getElementsByName("question_content") ;
			var question_answer = document.getElementsByName("question_answer") ;
			var question_label = document.getElementsByName("question_label") ;
			var question_label_edit = document.getElementsByName("question_label_edit") ;
			
			for(var i = 0;i < arrSon.length; i++) { 
				if(arrSon[i].checked) { 
					//alert("i："+i);
					question_content[i].readOnly = false ;
					question_content[i].focus ;				// 设置焦点
					//question_content[i].style.border="solid" ;
					question_content[i].className = 'addwenbenkuang' ;
					question_answer[i].readOnly = false ;
					question_answer[i].className = 'addwenbenkuang' ;
					
					if(question_label[i].style.display == ''){ 
				        question_label[i].style.display = 'none'; 
				    } else{ 
				        question_label[i].style.display = ''; 
				    } 
				    
					if(question_label_edit[i].style.display == 'none'){ 
						question_label_edit[i].style.display = ''; 
					} else{ 
						question_label_edit[i].style.display = 'none'; 
					} 
				} 
			}  
			return false ; 
		}
		
		function saveClick(sonName) {
			var question_infos = "" ;
			var arrSon = document.getElementsByName(sonName);
			
			var question_content = document.getElementsByName("question_content") ;
			var question_answer = document.getElementsByName("question_answer") ;
			var question_label_edit = document.getElementsByName("question_label_edit") ;
			
			for(var i = 0; i < arrSon.length; i++) {
				if(arrSon[i].checked) {
					question_infos += arrSon[i].value + ";";
					question_infos += question_content[i].value + ";";
					question_infos += question_answer[i].value + ";";
					question_infos += question_label_edit[i].value + ";";
					
					form1.action = "updateQuestion.action?question_infos=" + question_infos ;
					form1.submit();
				}
			}
		}
	    
	    function show() {
	    	var add = document.getElementById("showadd");
	    	//var addlabel = document.getElementByName("question_label_add");
	    	add.style.display="" ;
	    	//addlabel.focus ;
	    	return false ;
	    }  
	    
	    function addBtn() {
	    	var addform = document.getElementById("form1");
	    	var question_label_add = document.getElementsByName("question_label_add")[0].value ;
	    	var question_content_add = document.getElementsByName("question_content_add")[0].value ;
	    	var question_answer_add = document.getElementsByName("question_answer_add")[0].value ;
	    	addform.action = "addQuestion.action?question_label_add = " + question_label_add + "&question_content_add = "
	    						+ question_content_add + "&question_answer_add = " + question_answer_add ;
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
    <s:form method="post" action="queryQuestion.action" name="form2">
    	<table border="0" width="725" align="center">
    	<tr>
        	<td colspan="7">
            	<p align="center" class="titlename">问题信息管理</p>
            </td>
        </tr>
        <tr height="30"></tr>
        <tr>
            <td width="100" colspan="2">
                <s:select name="question_label_select" list="allQuestionLabel" headerKey="-1" theme="simple" headerValue="--请选择问题标签--" listKey="question_label" listValue="question_label"/>
            </td>
            
            <td colspan="2" align="left">
                <input type="submit" border="0" value="查询" />
            </td>
            <td colspan="3" align="center">
            	<!-- onclick="javascript:window.location='queryaddQuestion.action'" -->
                <input type="button" value="添加" onclick="show()" />
            </td>
        </tr>
    </table>
    </s:form>
    <br/>
    <s:form method="post" action="queryAllQuestion.action" id="form1">
    <table width="725" border="0" align="center" bordercolor="#FF66FF">    
		<tr align="center" bgcolor="#00CCCC">
        	<td width="65" height="31" bgcolor="#e9f1f6">
            	<input type="checkbox" name="per" id="chkAll" onclick="ChkAllClick('question_id' , 'chkAll')" />全选
      		</td>
			<td width="50" bgcolor="#e9f1f6">标签</td>
			<td width="60" bgcolor="#e9f1f6">问题</td>
			<td width="90" bgcolor="#e9f1f6">答案</td> 
		</tr>
		<s:iterator value="pageBean.list">
		<tr align="center">
			<td width="65" height="29" bgcolor="#fcefe8">
				<input type="checkbox" value="<s:property value="question_id"/>" name="question_id" onclick="ChkSonClick('question_id','chkAll','buttonId','saveButton')"/>
			</td> 
			<td width="50" bgcolor="#fcefe8">
				<s:textfield cssClass="wenbenkuang" name="question_label" value="%{question_label}" 
							readonly="true" theme="simple"/>
				<s:select name="question_label_edit" list="allQuestionLabel" headerKey="-1" theme="simple" headerValue="--请选择问题标签--" 
							listKey="question_label" listValue="question_label" cssStyle="display:none;"/>
			</td>
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="question_content" value="%{question_content}" 
							readonly="true" theme="simple"/></td>
							
			<td width="90" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" name="question_answer" value="%{question_answer}" 
							readonly="true" theme="simple"/></td> 
		</tr>
		</s:iterator>
        <!-- <form action="addQuestion.action" id="addform">javascript:window.location='addQuestion.action' -->
        <tr style="display: none" id="showadd" align="center">
        	<td width="65" height="29" bgcolor="#fcefe8">
        		<!-- 名称不可以和方法名相同 -->
				<input type="submit" class="tianjia" value="+" name="adbtn" onclick="addBtn()" />
			</td> 
			
			<td width="50" bgcolor="#fcefe8"><s:textfield cssClass="addwenbenkuang" id="question_label_add" name="question_label_add"
							theme="simple" size="3"/></td>
							
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="addwenbenkuang" id="question_content_add" name="question_content_add"
							theme="simple" size="8"/></td>
							
			<td width="90" bgcolor="#fcefe8"><s:textfield cssClass="addwenbenkuang" id="question_answer_add" name="question_answer_add"
							theme="simple" size="12"/></td>
        </tr>
       
		<tr align="center" bgcolor="#00CCCC">
				<td width="65" bgcolor="#e9f1f6">
                	<input type="checkbox" name="per" id="chkOpp" onclick="ChkOppClick('question_id')" />反选
                </td>
				<td colspan="11" bgcolor="#e9f1f6">
					<input type="submit" value="删除" onClick="return deleteClick('question_id')">
                    <input type="submit" id="buttonId" value="选择修改" disabled="disabled" onClick="return editClick('question_id')"/>
                    <input type="submit" id="saveButton" value="保存" disabled="disabled" onClick="return saveClick('question_id')"/>
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
        		<a href="managerQuestion.action?page=1"><font face="webdings" color="#00CCCC"> 9 </font></a>
				<a href="managerQuestion.action?page=1"/><font face="webdings" color="#00CCCC"> 7 </font></a>
		</s:if>
		<s:else>
				<a href="managerQuestion.action?page=1"><font face="webdings" color="#00CCCC"> 9 </font></a>
				<a href=managerQuestion.action?page=<s:property value="%{pageBean.currentPage-1}"/>"/><font face="webdings" color="#00CCCC"> 7 </font></a>
        </s:else>
        <font size="3">
			<font color="#FF66FF"><s:property value="pageBean.currentPage"/></font>
		</font>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
				<a href="managerQuestion.action?page=<s:property value="%{pageBean.currentPage+1}"/>"/><font face="webdings" color="#00CCCC"> 8 </font></a>
				<a href="managerQuestion.action?page=<s:property value="pageBean.totalPage"/>"><font face="webdings" color="#00CCCC"> : </font></a>
		</s:if>
		<s:else>
        		<a href="managerQuestion.action?page=<s:property value="%{pageBean.currentPage}"/>"><font face="webdings" color="#00CCCC"> 8 </font></a>
				<a href="managerQuestion.action?page=<s:property value="%{pageBean.currentPage}"/>"><font face="webdings" color="#00CCCC"> : </font></a>
		</s:else>	
		<s:form action="managerQuestion.action" onsubmit="return validate();">
			<s:textfield name="page" label="跳转至" theme="simple" size="3"/>页&nbsp;&nbsp;
			<s:submit value="跳转" theme="simple"/>
		</s:form>
        
</center>  
	<?php
		}
	?>
  </body>
</html>
