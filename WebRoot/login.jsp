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
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="./css/model_style_login.css" rel="stylesheet" type="text/css">

	<SCRIPT src="./js/jquery-1.9.1.min.js" type="text/javascript"></SCRIPT>
     
	<SCRIPT type="text/javascript">
	$(function(){
		//得到焦点
		$("#password").focus(function(){		// 与<input>中的ID同
			$("#left_hand").animate({
				left: "150",
				top: " -38"
			},{step: function(){
				if(parseInt($("#left_hand").css("left"))>140){
					$("#left_hand").attr("class","left_hand");
				}
			}}, 2000);
			$("#right_hand").animate({
				right: "-64",
				top: "-38px"
			},{step: function(){
				if(parseInt($("#right_hand").css("right"))> -70){
					$("#right_hand").attr("class","right_hand");
				}
			}}, 2000);
		});
		//失去焦点
		$("#password").blur(function(){
			$("#left_hand").attr("class","initial_left_hand");
			$("#left_hand").attr("style","left:100px;top:-12px;");
			$("#right_hand").attr("class","initial_right_hand");
			$("#right_hand").attr("style","right:-112px;top:-12px");
		});
	});
	</SCRIPT>
	
	<script language="javascript">
		function check(form) {
			if(form.admin_name.value=="") {
				alert("请输入用户名!") ;
				form.admin_name.select() ;
				return(false) ;
			}
			if(form.admin_pwd.value=="") {
				alert("请输入密码!") ;
				form.admin_pwd.select() ;
				return(false) ;
			}
			return(true) ;
		}
		
	</script>
  </head>
  
  <BODY>
        <DIV class="top_div"></DIV>
        <DIV style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 200px; text-align: center;">
            <DIV style="width: 165px; height: 96px; position: absolute;">
            <DIV class="tou"></DIV>
            <DIV class="initial_left_hand" id="left_hand"></DIV>
            <DIV class="initial_right_hand" id="right_hand"></DIV></DIV>
            <s:form action="login.action" id="form1" validate="true" method="post" onsubmit="return check(this)">
                <P style="padding: 30px 0px 10px; position: relative;">
                    <SPAN class="u_logo"></SPAN> 
                    <INPUT class="ipt" type="text" placeholder="请输入用户名" value="" name="admin_name">  
                    <!--<s:textfield cssClass="ipt" label="用户名" name="user_name" maxlength="10" size="20" />-->       
                </P>
                <P style="position: relative;">
                    <SPAN class="p_logo"></SPAN>  
                    <INPUT class="ipt" id="password" type="password" placeholder="请输入密码" value="" name="admin_pwd">
                    <!--<s:password cssClass="ipt" label="密码" name="user_pwd" maxlength="10" size="20"/> -->      
                </P>
                <DIV style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
                    <P style="margin: 0px 35px 20px 45px; color: #FFF;">
                        <SPAN style="float: left;">
                            <A style="color: #999;" href="#">忘记密码?</A>
                        </SPAN> 
                        <SPAN style="float: right;">
                            <A class="registerbutton" href="http://localhost:8080/LYGLSystem/register.action" >注册</A>  
                            <s:submit value="登录" cssClass="loginbutton" theme="simple"/>
                        </SPAN>         
                    </P>
                </DIV>
            </s:form>
        </DIV>
        <DIV style="text-align:center;"></DIV>
	</BODY>
</html>
