<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="p" uri="/WEB-INF/mytag.tld" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>/resources/css/mytable.css" type="text/css" media="screen" />

<link href="<%=path %>/resources/plugs/jquery-ui-1.10.3/css/start/jquery-ui-1.10.3.custom.css" rel="stylesheet">
<script src="<%=path %>/resources/plugs/jquery-ui-1.10.3/js/jquery-1.9.1.js"></script>
<script src="<%=path %>/resources/plugs/jquery-ui-1.10.3/js/jquery-ui-1.10.3.custom.js"></script>

<script type="text/javascript" src="<%=path %>/sys/script/userMgr.js" ></script>

<script>
var path="<%=path %>";

function setData(data){
	if(data!="error"){
		$("#frm #data").html(data);
	}else{
		alert("系统异常");
	}
}

</script>
</head>
<body>
<form id="frm" action="<%=path%>/sys_userList.do" method="post">
<div style="text-align: right;padding-right: 50px">
<input type="text" name="cod['loginname']"  />
<input type="button" onclick="frmGo()" value="查询" />
</div>
<table class="mytable">
	<thead>
	<tr>
		<th>ＩＤ</th>
		<th>登录名</th>
		<th>用户名</th>
		<th>邮箱</th>
		<th>性别</th>
		<th>手机</th>
		<th>注册时间</th>
		<th>类型</th>
		<th>状态</th>
		<th>&nbsp;</th>
	</tr>
	</thead>
	
	<tbody id="data">
	<c:forEach items="${ulst }" var="lst" >
	<tr>
		<td>${lst.userid }</td>
		<td>${lst.loginname }</td>
		<td>${lst.username }</td>
		<td>${lst.email }</td>
		<td>${lst.sex=='1'?'男':'女' }</td>
		<td>${lst.mobile }</td>
		<td>${lst.cttime }</td>
		<td>${lst.userType=='0'?'<font color=red>试用</font>':'正式' }</td>
		<td>${lst.state=='0'?'<font color=red>禁用</font>':'正常' }</td>
		<td>
		<a title="Edit" href="#"><img alt="Edit" src="<%=path %>/resources/login/images/icons/pencil.png"></a>
		<a title="Delete" href="#"><img alt="Delete" src="<%=path %>/resources/login/images/icons/cross.png"></a>
		<a title="Edit Meta" href="javascript:editMeta(${lst.userid })"><img alt="Edit Meta" src="<%=path %>/resources/login/images/icons/hammer_screwdriver.png"></a>
	</tr>
	</c:forEach>
	</tbody>
	
	<tfoot>
        <tr>
          <td colspan="10" align="right" >
            <p:pager callback="setData" formid="frm" />
          </td>
        </tr>
     </tfoot>

</table>
<div id="editMetaDiv" title="权限设置">
dsafdsafds
</div>
</body>
</html>