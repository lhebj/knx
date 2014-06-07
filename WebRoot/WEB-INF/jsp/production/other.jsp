<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% navBar.put("other", "nav  current"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 01//EN" "http://www.worg/TR/html4/strict.dtd">   
<html>
<head>
	<title><%=LocalizationUtil.getClientString("SEO.Title", request) %></title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	<meta http-equiv="description" content="<%=LocalizationUtil.getClientString("SEO.Description", request) %>">
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH %>global.css?version=<%=version%>">
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH %>other.css?version=<%=version%>">
</head>
<body>
	<div class="container clearfix">
		<%@ include file="common/head.jsp" %>
		<div class="content">
			<div  class="tip_icon">
				<img src="<%=IMAGE_PATH %>tip_icon.png" alt="">
			</div>
			<div class="tip">
				页面建设中…………
			</div>
		</div>
	</div>
	
</body>
</html>

