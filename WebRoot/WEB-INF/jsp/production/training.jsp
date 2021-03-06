<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% navBar.put("training", "nav  current"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 01//EN" "http://www.worg/TR/html4/strict.dtd">   
<html>
<head>
    <base href="<%=BASE_Path%>">
    
	<title>${currentTrainingDTO.titleTra}-<%=LocalizationUtil.getClientString("SEO.Title", request) %></title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	<meta http-equiv="description" content="<%=LocalizationUtil.getClientString("SEO.Description", request) %>">
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH %>global.css?version=<%=version%>">
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH %>news.css?version=<%=version%>">

<%@ include file="common/tongji.jsp"%>
</head>
<body>
	<div class="container clearfix">
		<%@ include file="common/head.jsp" %>
		<div class="content">
			<%@ include file="common/left-brand-category.jsp" %>
			<div class="listContainer clearfix">
				<div class="news-title">${currentTrainingDTO.titleTra}</div>
	    		<div><img src="${currentTrainingDTO.pic}"></div>
	    		<div class="news-content">${currentTrainingDTO.contentTra}</div>
			</div>
			<%@ include file="common/footer.jsp" %>
		</div>

	</div>
</body>
</html>