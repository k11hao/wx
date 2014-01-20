<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>触屏手机幻灯片代码 - 站长素材 sc.chinaz.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='resources/plugs/swipe/css/google.css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="resources/plugs/swipe/css/idangerous.swiper.css">
<link rel="stylesheet" href="resources/plugs/swipe/css/style.css?v=1.8">
<link rel="stylesheet" href="resources/plugs/swipe/css/swiper-demos.css?v=1.8">
<script  src="resources/plugs/swipe/js/jquery-1.7.1.min.js"></script>
<!-- Swiper -->
<script  src="resources/plugs/swipe/js/idangerous.swiper-1.9.1.min.js"></script>
<!-- Swiper Scrollbar plugin -->
<script  src="resources/plugs/swipe/js/idangerous.swiper.scrollbar-1.2.js"></script>
<!-- Demos code -->
<script  src="resources/plugs/swipe/js/swiper-demos.js"></script>


<script type="text/javascript" src="resources/plugs/jquery.dialogr.v.2.1/js/jquery-ui-1.8.6.custom.min.js"></script>
<script type="text/javascript" src="resources/plugs/dialog/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="resources/plugs/dialog/js/jquery-AeroWindow.js"></script>
<link href="resources/plugs/dialog/css/AeroWindow.css" rel="stylesheet" type="text/css" />
<style>
body{
	background-image: url("bg.jpg");
}

li{
	list-style: none;
}
#content{
	text-align:left;
	width: 90%;
	height: 100%;
	margin-top: 60px;
	max-width: 1000px;
	height:80%;
}
#content li{
	padding-top:20px;
	padding:10px;
	float:left;
	list-style: none;
	width:130px;
	height:130px;
	text-align:center;
}
#content li .text{
	border-radius: 7px;
	height:25px;
	line-height:25px;
	width:80%;
	margin:0 auto;
	background: blue;
	text-align: center;
	color:white;
	-moz-opacity:0.6;
	background: rgba(0, 0, 0, 0.6);
	filter: alpha(opacity=60);
	font-size: 12px;
}

.iconImg{
	width:50px;
	height:50px;
	margin-top: 10px;
}
.topDiv{
	position:absolute;
	margin:0 auto;
	background-color:white;
	width: 170px;
	height: 34px;
	top:10px; 
	left:50%;
	margin-left:-100px;
	text-align: center;
}
.topDiv li{
	width: 40px;
	height:34px;
	float: left;
	line-height: 34px;
	cursor: pointer;
}
.draggable { width: 100px; height: 100px; float: left; margin: 0 10px 10px 0;
	-moz-opacity:0;
	background: rgba(175, 175, 175, 0);
	border-radius: 10px;
    filter: alpha(opacity=0);
    border: 0px;
}
.draggable:HOVER { width: 100px; height: 100px; float: left; margin: 0 10px 10px 0;
	-moz-opacity:0.5;
	background: rgba(175, 175, 175, 0.5);
	border-radius: 10px;
    filter: alpha(opacity=50);   
}
</style>
<script>
var opend="";
$(document).ready(function(){
	$("#content li div[class^='draggable ui-widget-content']").each(function(){
		//$(this).draggable({ containment: "#content",grid: [ 150, 150 ] });
		//$(this).draggable({ containment: "#content"});
		$(this).bind("click",function(){
			var cid=$(".text",this).attr("id");
			var width=$(".text",this).attr("postion").split(",")[0];
			var height=$(".text",this).attr("postion").split(",")[1];
			if(opend.indexOf(cid)==-1){
				opend+=$(".text",this).attr("id")+",";
				var dialog="<div id='app_"+cid+"'><iframe src='"+$(".text",this).attr("href")+"' frameborder='0' scrolling='auto' width='100%' height='100%'  ></iframe></div>";
				$(document).append(dialog);
				$('#Window1').AeroWindow({
			            WindowTitle:          $(".text",this).html(),
			            WindowPositionTop:    'center',
			            WindowPositionLeft:   'center',
			            WindowWidth:          width,
			            WindowHeight:         height,
			            WindowAnimation:      'easeOutCubic'
		          });
			}
		});
	});
	
	
});

</script>
</head>

<body>

<div role="main" id="content" class="main">
  
<div class="pagination pagination1"></div>
  
  <div class="home-device"></a>
    <div class="swiper-main">
      <div class="swiper-container swiper1">
        <div class="swiper-wrapper">
          <div class="swiper-slide"> 
          
				<div id="d1">
				<ul>
				<c:forEach items="${flst }" var="lst" >
				  <c:forEach items="${lst.ptFuns }" var="lst2">
				<li> 
				<div class="draggable ui-widget-content">
				<image  src='http://localhost/doc/${lst2.bigIconPath }' class="iconImg" />
				<div postion="${lst2.postion }" href="<%=path %>/${lst2.url }" id="${lst2.id }" class="text">${lst2.name }</div>
				</div>
				</li>
				</c:forEach>
				</c:forEach>
				</ul>
				</div>
          </div>
          <div class="swiper-slide"> adsa </div>
          
          <div class="swiper-slide">
            
sadasdas
          </div>
        </div>
      </div>
    </div>

  </div>
  

 
    <style>
	/*
	Bad practise to use inline styles but good place to show you as an example
	*/
	.swiper-scrollbar {
		width: 100%;
		height: 4px;
		border-radius: 10px;
		position: absolute;
		left:0;
		bottom:2px;
		-ms-touch-action: none;
		background: none
	}
	.swiper-scrollbar-drag {
		height: 100%;
		width: 100%;
		position: relative;
		background: rgba(0,0,0,0.5);
		border-radius: 10px;
		
	}
	</style>

  
</div>
<div id="Window1">
      <p>
        JquerySchool网站
      </p>
      <ul>
        <li>JquerySchool提供了一个让网友们为共同进步这一个目标出发，互相学习，互相帮助，取人之长，补已之短，共同进步的网站平台。</li>
		<li>JquerySchool开放此模块专门给网友们提供了前端设计的精选文章，这样就避免了网友在互联网上频繁的去搜索，进入Jquery学堂模块就可以快速的看到自己想要的文章，主要分为Jquery知识、插件详解、常用功能、 div+css、前端开发利器、HTML5、原生Javascript等分类的文章。</li>
		<li><a href="http://www.jq-school.com">www.jq-school.com</a></li>
		</ul>

      
    </div>
</body>
</html>