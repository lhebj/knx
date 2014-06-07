<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/common.jsp" %> 
<c:set var="nameBrd" value="${brandDetailDTO.nameBrd}" scope="page"></c:set>
<% navBar.put("brand", "selected"); %>
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
  </head>
  
  <body>
	  <%@ include file="common/head.jsp" %>

		<!-- 搜索后的产品列表 -->
		<div>
				<c:forEach items="${productDTOList}" var="productDTO">
							<div>
								<a href="product.do?action=detail&id=${productDTO.idPrd}">
									<img src="${productDTO.logoPath}" />
								</a>
							</div>
							<div>
								<span class="show">${productDTO.namePrd}</span>
								<span class="show">${productDTO.modelPrd}</span>
							</div>
				</c:forEach>
		</div>
	    ${pageutil}
	    	
	      <%@ include file="common/footer.jsp" %>
  </body>
</html>
