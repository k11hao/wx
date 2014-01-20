<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/plugs/jquery.dialogr.v.2.1/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="resources/plugs/jquery.dialogr.v.2.1/js/jquery-ui-1.8.6.custom.min.js"></script>
<script type="text/javascript" src="resources/plugs/jquery.dialogr.v.2.1/js/ui.dialogr.js"></script>
<script type="text/javascript" src="resources/plugs/jquery.dialogr.v.2.1/js/typeface-0.14.js"></script>
<script type="text/javascript" src="resources/plugs/jquery.dialogr.v.2.1/js/museo_700.typeface.js"></script>
<link href="resources/plugs/jquery.dialogr.v.2.1/css/ui-lightness/jquery-ui-1.8.6.custom.css" rel="stylesheet" type="text/css" />
<link href="resources/plugs/jquery.dialogr.v.2.1/css/jquery.dialogr.css" rel="stylesheet" type="text/css" />

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
var currentdiv=1;
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
				$(dialog).dialogr({
					title:$(".text",this).html(),
					width:width,
					height:height,
					maximized:false,
					resizable:false,
					close: function(event, ui) {
						opend=opend.replace(cid+",","");
					}
				});
			}
			//mm($(".text",this).html(),dialog);
			/*
			$(dialog).dialog({
				title:$(".text",this).html(),
				height: 400,
				width:600,
				modal: false
			});
			*/
		});
	});
	
	$(".topDiv li").each(function(){
		$(this).bind("click",function(){
			var thisindex=$(this).html();
			if(currentdiv!=thisindex){
				$("#d"+currentdiv).fadeOut("fast",function(){
					$("#d"+thisindex).fadeIn();
				});
				
				currentdiv=$(this).html();
			}
		});
	});
	
});

</script>
</head>
<body >
<center>

<div class="topDiv" >

<li>1</li>
<li>2</li>
<li>3</li>
<li>4</li>
</div>

<div id="content" >

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

<div id="d2"  style="display: none">
<ul>
<c:forEach items="${flst }" var="lst" >
  <c:forEach items="${lst.ptFuns }" var="lst2">
<li> 
<div class="draggable ui-widget-content">
<image  src='http://localhost/doc/${lst2.bigIconPath }' class="iconImg" />
<div postion="${lst2.postion }" href="<%=path %>/${lst2.url }" id="${lst2.id }" class="text">${lst2.name }2222</div>
</div>
</li>
</c:forEach>
</c:forEach>
</ul>
</div>

<div id="d3" style="display: none">
<ul>
<c:forEach items="${flst }" var="lst" >
  <c:forEach items="${lst.ptFuns }" var="lst2">
<li> 
<div class="draggable ui-widget-content">
<image  src='http://localhost/doc/${lst2.bigIconPath }' class="iconImg" />
<div postion="${lst2.postion }" href="<%=path %>/${lst2.url }" id="${lst2.id }" class="text">${lst2.name }3333</div>
</div>
</li>
</c:forEach>
</c:forEach>
</ul>
</div>

<div id="d4" style="display: none">
<ul>
<c:forEach items="${flst }" var="lst" >
  <c:forEach items="${lst.ptFuns }" var="lst2">
<li> 
<div class="draggable ui-widget-content">
<image  src='http://localhost/doc/${lst2.bigIconPath }' class="iconImg" />
<div postion="${lst2.postion }" href="<%=path %>/${lst2.url }" id="${lst2.id }" class="text">${lst2.name }4444</div>
</div>
</li>
</c:forEach>
</c:forEach>
</ul>
</div>

</div>
</center>
</body>
</html>