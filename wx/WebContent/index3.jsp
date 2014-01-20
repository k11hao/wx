<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>深度阅读的后台</title>
<!--                       CSS                       -->
<!-- Reset Stylesheet -->
<link rel="stylesheet" href="<%=path %>/resources/login/css/reset.css" type="text/css" media="screen" />
<!-- Main Stylesheet -->
<link rel="stylesheet" href="<%=path %>/resources/login/css/style.css" type="text/css" media="screen" />
<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
<link rel="stylesheet" href="<%=path %>/resources/login/css/invalid.css" type="text/css" media="screen" />
<style>
body {
    font-family:"Microsoft YaHei","微软雅黑","黑体", Arial, Helvetica, sans-serif;
    color: #555;
    background: #f0f0f0 url('<%=path%>/resources/login/images/bg-body.gif') top left repeat-y;
    font-size: 12px;
}

</style>

<!--                       Javascripts                       -->
<!-- jQuery -->
<link rel="stylesheet" href="<%=path %>/resources/login/js/uploadify/uploadify.css" type="text/css"></link></head>
<script type="text/javascript" src="<%=path %>/resources/login/scripts/jquery-1.3.2.min.js"></script>
<!-- jQuery Configuration -->
<script type="text/javascript" src="<%=path %>/resources/login/scripts/simpla.jquery.configuration.js"></script>
<!-- Facebox jQuery Plugin -->
<script type="text/javascript" src="<%=path %>/resources/login/scripts/facebox.js"></script>
<!-- jQuery WYSIWYG Plugin -->
<script type="text/javascript" src="<%=path %>/resources/login/scripts/jquery.wysiwyg.js"></script>
<!-- jQuery Datepicker Plugin -->

<script>
function goURL(cmenu,url){
	if(cmenu!="-1"){
		$("a[custom='cmenu']").each(function(){
			$(this).attr("class","");
		});
		$("#"+cmenu).attr("class","current");
	}
	//$("#main-content").load(url);
	
	$("#f1").attr("src",url);
	
}
$(document).ready(function(){
	  $("#main-nav ul a").each(function(){
		  $(this).bind("click",function(){
			  $("#main-nav ul a").each(function(){
				  $(this).attr("class","");
			  });
			  $(this).attr("class","current");
		  });
	  });
	  
	  $("#main-nav .nav-top-item").each(function(){
		  $(this).bind("click",function(){
			  $("#main-nav .nav-top-item").each(function(){
				  $(this).attr("class","nav-top-item");
			  });
			  $(this).attr("class","nav-top-item current");
		  });
	  });
});



function selMenu(menu){
	$(".nav-top-item").each(function(){
		$(this).attr("class","nav-top-item");
	});
	$(menu).attr("class","nav-top-item current");
};

</script>
</head>
<body >
<div id="body-wrapper">
  <!-- Wrapper for the radial gradient background -->
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <!-- Sidebar with logo and menu -->
      <!-- Logo (221px wide) -->
      <img id="logo" src="<%=path %>/resources/login/images/logo.png" alt="访问深度阅读" /></a>
      <!-- Sidebar Profile links -->
      <div id="profile-links"> 你好, <a href="#" title="Edit your profile">${sessionScope.user.name }</a>, 你有 <a href="#messages" rel="modal" title="3 Messages">3 条信息</a><br />
        <br />
        <a href="#" title="Sign Out">退出</a> </div>
      <ul id="main-nav">
        <!-- Accordion Menu -->
        <c:forEach items="${flst }" var="lst" >
        <li> <a href="#" class="nav-top-item">
          <!-- Add the class "current" to current menu item -->
          ${lst.name } </a>
          <ul>
          <c:forEach items="${lst.ptFuns }" var="lst2">
            <li><a target="f1" href="<%=path %>${lst2.url }">${lst2.name }</a></li>
           </c:forEach> 
          </ul>
        </li>
        </c:forEach>
      </ul>
      <!-- End #main-nav -->
      <div id="messages" style="display: none">
        <!-- Messages are shown when a link with these attributes are clicked: href="#messages" rel="modal"  -->
        <h3>3条信息</h3>
        <p> <strong>17th May 2009</strong> by 管理员<br />
          日志 <small><a href="#" class="remove-link" title="Remove message">移动</a></small> </p>
        <p> <strong>2nd May 2009</strong> by Jane 管理员<br />
         日志 <small><a href="#" class="remove-link" title="Remove message">移动</a></small> </p>
        <p> <strong>25th April 2009</strong> by 管理员<br />
        日志 <small><a href="#" class="remove-link" title="Remove message">移动</a></small> </p>
        
          <h4>新信息</h4>
          <fieldset>
          <textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
          </fieldset>
          <fieldset>
          <select name="dropdown" class="small-input">
            <option value="option1">发送给</option>
            <option value="option2">每个人</option>
            <option value="option3">管理员</option>
          </select>
          <input class="button" type="submit" value="发送" />
          </fieldset>
        
      </div>
      <!-- End #messages -->
    </div>
  </div>
  <!-- End #sidebar -->
  <div id="main-content" style="width:80%;height:700px;margin-left: 235px" >
   <!-- <p id="page-intro">What would you like to do?</p>
 
  <ul class="shortcut-buttons-set">
      <li><a class="shortcut-button" href="#"><span> <img src="resources/login/images/icons/pencil_48.png" alt="icon"><br>
        Write an Article </span></a></li>
      <li><a class="shortcut-button" href="#"><span> <img src="resources/login/images/icons/paper_content_pencil_48.png" alt="icon"><br>
        Create a New Page </span></a></li>
      <li><a class="shortcut-button" href="#"><span> <img src="resources/login/images/icons/image_add_48.png" alt="icon"><br>
        Upload an Image </span></a></li>
      <li><a class="shortcut-button" href="#"><span> <img src="resources/login/images/icons/clock_48.png" alt="icon"><br>
        Add an Event </span></a></li>
      <li><a class="shortcut-button" href="#messages" rel="modal"><span> <img src="resources/login/images/icons/comment_48.png" alt="icon"><br>
        Open Modal </span></a></li>
    </ul>
     -->
    <iframe id="f1" name="f1" height="100%" width="100%" src="<%=path%>/sys_userList.do" border="0" frameborder="0" scrolling="auto">
  <!-- End #main-content -->
</div>
</body>
<!-- Download From www.exet.tk-->
</html>
