<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 01//EN" "http://www.worg/TR/html4/strict.dtd">
<html>
<head>
<base href="<%=basePath%>">

<title><%=LocalizationUtil.getClientString("SEO.Title", request)%></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- Le styles -->
<style type="text/css">
#top {
	width: 1000px;
	height: 150px;
	margin: 0 auto;
}
</style>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<link href="assets/css/bootstrap-responsive.min.css" rel="stylesheet">

<%@ include file="common/tongji.jsp"%>
</head>

<body>

	<div align="center">
		<div class="page-header">
			<h1>登录</h1>
		</div>
		<FORM class="form-horizontal" name="form1" METHOD="POST">
			<table>
				<tr>
					<td width='60'>用户名</td>
					<td width='200'><input name="j_username" id="j_username" type="text" value="" /></td>
				</tr>
				<tr>
					<td width='60'>密 码</td>
					<td width='200'><input name="j_password" id="j_password" type="password"
						value="" /></td>
				</tr>
				<c:if test="${type == 'fail'}">
					<tr>
						<td></td>
						<td><b>用户名或密码错误</b></td>
					</tr>
				</c:if>
				<tr>
					<td width='60'></td>
					<td width='200'><input class="btn btn-primary" name="login_btn" id="login_btn"
						type="button" value="登录"> <input type="button" value="取消"
						class="btn" onclick="javascript:window.history.go(-1);" /></td>
				</tr>

			</table>
		</form>
	</div>
	<script src="assets/js/jquery-2.1.0.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/knx/login.js"></script>
</body>
</html>
