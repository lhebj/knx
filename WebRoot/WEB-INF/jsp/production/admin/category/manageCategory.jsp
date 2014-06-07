<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.weather.util.WebUtil,com.weather.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><%=LocalizationUtil.getClientString("Title.admin", request) %></title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <%@ include file="../homeHead.jsp" %>
  
 	 	
  	<div class="page-header">
		<h1>分类管理</h1>
	</div>
	<div>
		<a href="admin.do?action=postCategory"><button style="width: 82px;"
				class="btn btn-primary" type="button">添加分类</button></a>
	</div>
	<table class="table table-bordered table-condensed table-hover"
		style="width: 100%;">
		<tr>
			<td >分类名</td>
			<td >操作</td>
		</tr>
		<tbody>
			<c:forEach items="${categoryDTOList}" var="categoryDTO">
				<tr>
					<td>${categoryDTO.nameCat}</td>
					<td><a
						href="admin.do?action=postCategory&id=${categoryDTO.idCat}"><button
								style="width: 82px;" class="btn btn-primary" type="button">编辑</button></a>
						<a href="categoryAdmin.do?action=delete&id=${categoryDTO.idCat}" onclick="javascript:return del_sure()" ><button
								style="width: 82px;" class="btn btn-primary" type="button">删除</button></a>
						<a
						href="admin.do?action=manageProduct&categoryId=${categoryDTO.idCat}"><button
								style="width: 82px;" class="btn btn-primary" type="button">产品管理</button></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
       
    <%@ include file="../homeFoot.jsp" %>
  </body>
</html>
