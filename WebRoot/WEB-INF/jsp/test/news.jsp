<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/common.jsp" %>
<% navBar.put("news", "selected"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=BASE_Path%>">
    
    <title>${currentNewsDTO.titleN}-<%=LocalizationUtil.getClientString("SEO.Title", request) %></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	<meta http-equiv="description" content="<%=LocalizationUtil.getClientString("SEO.Description", request) %>">
  </head>
  
  <body>
  	<div class="main-section">
	  <%@ include file="common/head.jsp" %>
	    <c:forEach items="${newsSimpleDtoList}" var="newsDto">
	    	<!-- 左侧标题列表 -->
			<div ><span><b><a href="news.do?id=${newsDto.idN}">${newsDto.titleN}</a></b></div>							
	    </c:forEach>
	    <!-- 当前新闻  -->
	    <div>${currentNewsDTO.titleN}</div>
	    <div><img src="${currentNewsDTO.pic}"></div>
	    <div>${currentNewsDTO.contentN}</div>
	    
	    <%@ include file="common/footer.jsp" %>
    </div>
  </body>
</html>
