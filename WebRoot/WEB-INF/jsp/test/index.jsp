<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/common.jsp" %>
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
	<!--
<link href="http://stat2.ablesky.cn/stata/images/favicon_fc8244f0.ico" rel="shortcut icon" type="image/x-icon">
  -->
  </head>
  
  <body>
   <%@ include file="common/head.jsp" %>
  <table style="width: 100%;">
		<tr>
			<td style="width: 30%;">首页图片区域</td>
			<td style="width: 70%;">图片</td>
		</tr>
		<tbody>
			<tr>
				<td>第一排第一列</td>
				<td><table>
						<c:forEach items="${r1c1IndexDtoList}" var="indexDto">
							<tr>
								<td><img src="${indexDto.path}"></img>
									<c:if test="${indexDto.typeIdx=='video'}">
										${indexDto.playcodeIdx}
									</c:if>
								</td>
						</c:forEach>
					</table></td>
			</tr>
			<tr>
				<td>第一排第二列</td>
				<td><img src="${r1c2IndexDto.path}"></img></td>
			</tr>
			<tr>
				<td>第一排第三列</td>
				<td><img src="${r1c3IndexDto.path}"></img></td>
			</tr>
			<tr>
				<td>第二排第一列</td>
				<td><img src="${r2c1IndexDto.path}"></img></td>
			</tr>
			<tr>
				<td>第二排第二列</td>
				<td><img src="${r2c2IndexDto.path}"></img></td>
			</tr>
			<tr>
				<td>第二排第三列</td>
				<td><img src="${r2c3IndexDto.path}"></img></td>
			</tr>
		</tbody>
	</table>
	<%@ include file="common/footer.jsp" %>
  </body>
</html>
