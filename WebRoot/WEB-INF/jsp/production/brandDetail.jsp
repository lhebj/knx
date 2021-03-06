<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/common.jsp" %>
<% navBar.put("brand", "nav  current"); %> 
<c:set var="nameBrd" value="${brandDetailDTO.nameBrd}" scope="page"></c:set>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<title><%=LocalizationUtil.getClientString("SEO.Title", request) %></title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	<meta http-equiv="description" content="<%=LocalizationUtil.getClientString("SEO.Description", request) %>">
	<!--css文件-->
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>global.css?version=<%=version%>">
	<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>classify.css?version=<%=version%>">
	
	<%@ include file="common/tongji.jsp"%>
  </head>
  
  <body onselectstart="return false">
	  <div class="container clearfix">
	  <%@ include file="common/head.jsp" %>
	  
	  	
	   <div class="content">
			<%@ include file="common/left-brand-category.jsp" %>
			<!-- 品牌下的产品列表 -->
			<div style="float:left;">
				<div class="detail_top_wrap">
					<div class="detail_top"><a href="javascript:;"><img src="${brandDetailDTO.logoPath}" onload="imagezoom.call(this, 354, 218);" /></a></div>
					<div class="detail_top">${brandDetailDTO.introductionBrdd}
					</div>
				</div>
				<div class="listContainer">
					 <!-- 品牌详情页面logo 和 简介 -->
		  			<!-- <p><img src="${brandDetailDTO.logoPath}" /></p>
		  				  	 		<p> ${brandDetailDTO.introductionBrdd} </p>  -->
					<ul class="clearfix">
					<c:forEach items="${productDTOList}" var="productDTO">
					    <li>
							<div class="listWrap">
								<a href="product.do?action=detail&id=${productDTO.idPrd}">
									<img src="${productDTO.logoPath}" onload="imagezoom.call(this, 120, 150);" alt="img">
							    </a>
								<div class="toolInfo">
									<p class="detailInfo">${productDTO.namePrd}</p>
									<p class="detailInfo">${productDTO.modelPrd}</p>
								</div>
							</div>
						</li>
					</c:forEach>
					</ul>
					<div class="pageWrap">
						${pageutil}	
					</div>
				</div>
		   </div>
	   </div>
	   <%@ include file="common/footer.jsp" %>
	</div>
  </body>
</html>
