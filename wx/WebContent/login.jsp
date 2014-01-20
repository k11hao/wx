<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Simpla Admin </title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="<%=path %>/resources/login/css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="<%=path %>/resources/login/css/style.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="<%=path %>/resources/login/css/invalid.css" type="text/css" media="screen" />
<!--                       Javascripts                       -->
<!-- jQuery -->
<script type="text/javascript" src="<%=path %>/resources/login/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="<%=path %>/resources/login/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="<%=path %>/resources/login/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="<%=path %>/resources/login/scripts/jquery.wysiwyg.js"></script>
<script type="text/javascript" src="<%=path %>/resources/script/jquery.cookies.2.2.0.js"></script>
</head>
<body id="login">
<div id="login-wrapper" class="png_bg">
  <div id="login-top">
    <h1>Simpla Admin</h1>
    <!-- Logo (221px width) -->
    <a href="#"><img id="logo" src="<%=path %>/resources/login/images/logo.png" alt="Simpla Admin logo" /></a> </div>
  <!-- End #logn-top -->
  <div id="login-content">
    <form>
      <div class="notification information png_bg">
        <div id="msg" style="display:none" >&nbsp;<img width="10px" height="10px" src='<%=path %>/resources/images/loading.gif' /></div>
      </div>
      <p>
        <label>用　户　名</label>
        <input class="text-input" id="loginname" type="text" />
      </p>
      <div class="clear"></div>
      <p>
        <label>密　 码</label>
        <input class="text-input" type="password" id="pwd" />
      </p>
      <div class="clear"></div>
      <p id="remember-password">
        <input type="checkbox" id="remeberme" checked />
        	记住我</p>
      <div class="clear"></div>
      <p>
        <input class="button" type="button" id="btnLogin" value="登录" />
      </p>
    </form>
  </div>
  <!-- End #login-content -->
</div>
<!-- End #login-wrapper -->
<script>
$(document).ready(function(){
	 if($.cookies.get("loginname")!=null){
		 $("#loginname").val($.cookies.get("loginname"));
		 $("#pwd").val($.cookies.get("pwd"));
	 }
	 //$("#btnLogin").click();
});

$("#btnLogin").bind("click",function(){
	$("#msg").html("<img src='<%=path%>/resources/images/loading.gif' />");
	$("#msg").show();
	$.ajax({
	   type: "POST",
	   url: "<%=path%>/user_login.do",
	   dataType:"json",
	   data: {
		   loginname:$("#loginname").val(),
		   pwd:$("#pwd").val()
	   },
	   success: function(re){
	   		if(re.flag){
	   			$("#msg").hide();
	   			if($("#remeberme").attr("checked")){
	   				$.cookies.set("loginname",$("#loginname").val());
	   				$.cookies.set("pwd",$("#pwd").val());
	   			}else{
	   				$.cookies.del("loginname");
	   				$.cookies.del("pwd");
	   			}
	   			location.href="<%=path%>/toindex.do";
	   		}else{
	   			$("#msg").html("用户名或密码错误");
	   			$("#msg").show();
	   		}
	   },
	   error:function (XMLHttpRequest, textStatus, errorThrown) {
		    $("#msg").html("系统异常");
  			$("#msg").show();
		 }
	});
})
</script>
</body>
</html>
