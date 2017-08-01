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
    
    <title>游记管理页面</title>
    
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
			
			//initial() ;
			
			// 查看选中的项的个数 
			var num = 0 ; 
			
			//alert(arrSon.length) ;
			
			for(var i=0; i<arrSon.length; i++) {
				//alert(i) ;
				//alert("checked"+arrSon[i].checked) ;
				if(!arrSon[i].checked) {
					cbAll.checked = false;
					
					//note_title[i].readOnly = true ;
					//note_title[i].className = 'wenbenkuang' ;
					//note_date[i].readOnly = true ;
					//note_date[i].className = 'wenbenkuang' ;
					
				} else {
					num++ ;	
					//alert("checked"+num) ;
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
		
		function deletecilck(sonName) {
			var num = 0;
			var note_ids = "";
			var form1 = document.getElementById("form1");
			var arrSon = document.getElementsByName(sonName);
			//alert(arrSon.length);
			for(var i=0; i<arrSon.length; i++) {		
				if(arrSon[i].checked) {
					//alert("aaa" + arrSon[i].value);		// 检查是否有值
					note_ids += arrSon[i].value + ";";
					//alert("222" + personIDs);
  					num ++ ;
				}
			}
			if(num == 0){ 
				alert('请勾选所要删除的数据！'); 
				//if(confirm("请勾选所要删除的数据！")) {			// 如果要使用此，点击确定，会报错误
					return false;
				//}
			} else if(num >= 20) {
				if(confirm("您选择数据多余20条，确定要删除吗？")) {
					form1.action = "deleteNote.action?note_ids=" + note_ids;
					form1.submit();
				} else {
					return false ;
				}
			} else {
				if(confirm("确定要删除吗？")) {
					form1.action = "deleteNote.action?note_ids=" + note_ids;
					form1.submit();
				} else {
					return false ;
				}
			}
		} 
	            
		function validate() {
			var page = document.getElementsByName("page")[0].value ; 
			if(page > <s:property value="pageBean.totalPage"/>) {
				alert("你输入的页数大于最大页数");                                    
				return false;             
			}              
			return true;         
		} 
		
		/*function detile(id) {
			window.open("goods_detile.php?id=" + id , "newframe" ,"width=400,height=500,left=500,top=100,menubar=no,toolbar=no,location=no,scrollbars=yes,location=no");
		}*/          
	</script>
  </head>
  
  <body>
	<!--<?php
		$sql = mysql_query("select count(*)  from tb_goods " , $conn) ;
		$result = mysql_fetch_array($sql) ;
		$count = $result[0] ;
		if($count == 0) {
			echo "暂无商品,快去添加吧!<br/><a href='goods_add.php'>添加商品</a>" ;
		} else {
	?>-->
    
    <s:form method="post" action="queryNote.action" name="form2">
    	<table border="0" width="725" align="center">
    	<tr>
        	<td colspan="7">
            	<p align="center" class="titlename">游记信息管理</p>
            </td>
        </tr>
        <tr height="30"></tr>
        <tr>
        	<td width="120">
        	<!-- listKey即对应于select标签中的value(传入后台的值)， listValue即对应于select标签中的option(用户看到的下拉选项) 
        		name不可以和下面的一样，因为js中获取是通过name，要是相同，此在下面的前面，获取的就是现在的组件
        		给标题加value后，使得上一次的值保留-->
                标题：<input type="text" size="5" border="1" name="note_title_select" value="<s:property value="%{note_title_select}"/>" />
            </td>
            <td width="100">
            	<!-- 由于note_days是integer类型，所以不可以写headerValue -->
                <s:select name="note_days_select" list="allNoteDays" headerKey="-1" theme="simple" headerValue="--请选择游记天数--" listKey="note_days" listValue="note_days"/>
            </td>
            <td width="150">
                <s:select name="note_address_select" list="allNoteAddress" headerKey="-1" headerValue="--请选择游记地址--" theme="simple" listKey="note_address" listValue="note_address"/>
            </td>
            <td colspan="3" align="center">
                <input type="submit" border="0" value="查询" />
            </td>
            <td colspan="3" align="center">
                
            </td>
        </tr>
    </table>
    </s:form>
    <br/>
    <s:form method="post" action="queryMainNote.action" id="form1">
    <table width="725" border="0" align="center" bordercolor="#FF66FF">    
		<tr align="center" bgcolor="#00CCCC">
        	<td width="65" height="31" bgcolor="#e9f1f6">
            	<input type="checkbox" name="per" id="chkAll" onclick="ChkAllClick('note_id' , 'chkAll')" />全选
      		</td>
			<td width="90" bgcolor="#e9f1f6">标题</td>
			<td width="60" bgcolor="#e9f1f6">日期</td>
			<td width="50" bgcolor="#e9f1f6">天数</td> 
			<td width="60" bgcolor="#e9f1f6">花费</td>
			<td width="60" bgcolor="#e9f1f6">用户</td>
      		<td width="85" bgcolor="#e9f1f6">地址</td>
			<td width="60" bgcolor="#e9f1f6">点赞数</td>
			<td width="60" bgcolor="#e9f1f6">浏览数</td>
			<td width="60" bgcolor="#e9f1f6">评论数</td>
            <td width="60" bgcolor="#e9f1f6"></td>
		</tr>
		<%
			//List list = (List)request.getAttribute("note") ;
			//NoteModel noteModel = (NoteModel)list.get(0) ;
			//System.out.println("aa" + noteModel.getNote_id()) ;
			
		 %>
		 <!-- 在此list中必须存放实体 -->
		<s:iterator value="pageBean.list">
		<tr align="center">
			<td width="65" height="29" bgcolor="#fcefe8">
				<!--<s:checkbox id="note_id" name="note_id" fieldValue="%{note_id}" 
							theme="simple" onclick="ChkSonClick('note_id','chkAll','buttonId','saveButton')">
				</s:checkbox>-->
				<input type="checkbox" value="<s:property value="note_id"/>" id="note_id" name="note_id" onclick="ChkSonClick('note_id','chkAll')"/>
			</td> 
			
			<!-- struts标签好像不可以设置样式 -->
			<td width="90" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="note_title" name="note_title" value="%{note_title}" 
							readonly="true" theme="simple" size="12"/></td>
							
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="note_date" name="note_date" value="%{note_date}" 
							readonly="true" theme="simple" size="8"/></td>
							
			<td width="50" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="note_days" name="note_days" value="%{note_days}" 
							readonly="true" theme="simple" size="3"/></td> 
							
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="note_expend" name="note_expend" value="%{note_expend}" 
							readonly="true" theme="simple" size="5"/></td>
			
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="user_name" name="user_name" value="%{user_name}" 
							readonly="true" theme="simple" size="5"/></td>
							
			<td width="85" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="note_address" name="note_address" value="%{note_address}" 
							readonly="true" theme="simple" size="4"/></td>
							
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="note_zannumber" name="note_zannumber" value="%{note_zannumber}" 
							readonly="true" theme="simple" size="5"/></td>
							
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="note_seenumber" name="note_seenumber" value="%{note_seenumber}" 
							readonly="true" theme="simple" size="5"/></td>
							
			<td width="60" bgcolor="#fcefe8"><s:textfield cssClass="wenbenkuang" id="note_commentnumber" name="note_commentnumber" value="%{note_commentnumber}" 
							readonly="true" theme="simple" size="5"/></td>
							
			<td width="60" bgcolor="#fcefe8">
				<!-- <input class="xq" type="button" value="详情" onclick="javascript:window.location='queryNoteDetile.action?note_id='%{note_id}''"/> -->
				<a href="queryNoteDetile.action?note_id=<s:property value="%{note_id}"/>" class="gl">详情</a>
			</td>
		</tr>
		</s:iterator>
        
		<tr align="center" bgcolor="#00CCCC">
				<td width="65" bgcolor="#e9f1f6">
                	<input type="checkbox" name="per" id="chkOpp" onclick="ChkOppClick('note_id')" />反选
                </td>
				<td colspan="11" bgcolor="#e9f1f6">
					<input type="submit" value="删除" onClick="return deletecilck('note_id')">
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
        		<a href="managerNote.action?page=1"><font face="webdings" color="#00CCCC"> 9 </font></a>
				<a href="managerNote.action?page=1"/><font face="webdings" color="#00CCCC"> 7 </font></a>
		</s:if>
		<s:else>
				<a href="managerNote.action?page=1"><font face="webdings" color="#00CCCC"> 9 </font></a>
				<a href="managerNote.action?page=<s:property value="%{pageBean.currentPage-1}"/>"/><font face="webdings" color="#00CCCC"> 7 </font></a>
        </s:else>
        <font size="3">
			<font color="#FF66FF"><s:property value="pageBean.currentPage"/></font>
		</font>
        <s:if test="%{pageBean.currentPage != pageBean.totalPage}">
				<a href="managerNote.action?page=<s:property value="%{pageBean.currentPage+1}"/>"/><font face="webdings" color="#00CCCC"> 8 </font></a>
				<a href="managerNote.action?page=<s:property value="pageBean.totalPage"/>"><font face="webdings" color="#00CCCC"> : </font></a>
		</s:if>
		<s:else>
        		<a href="managerNote.action?page=<s:property value="%{pageBean.currentPage}"/>"><font face="webdings" color="#00CCCC"> 8 </font></a>
				<a href="managerNote.action?page=<s:property value="%{pageBean.currentPage}"/>"><font face="webdings" color="#00CCCC"> : </font></a>
		</s:else>	
		<s:form action="managerNote.action" onsubmit="return validate();">
			<s:textfield name="page" label="跳转至" theme="simple" size="3"/>页&nbsp;&nbsp;
			<s:submit value="跳转" theme="simple"/>
		</s:form>
        
</center>  
	<!-- <?php
		}
	?> -->
  </body>
</html>
