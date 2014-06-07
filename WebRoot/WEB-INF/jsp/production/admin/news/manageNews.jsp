<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil" %>
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
		<h1>新闻管理</h1>
	</div>
	<div>
		<a href="admin.do?action=postNews"><button
				style="width: 82px;" class="btn btn-primary" type="button">添加</button></a>
	</div>
	<table style="width:100%;" class="table table-bordered table-condensed table-hover">
		<tr>
			<td style="width:20%;">标题</td>
			<td style="width:40%;">内容</td>
			<td style="width:20%;">图片</td>
			<td style="width:10%;">发布时间</td>
			<td style="width:10%;">操作</td>
		</tr>
		<tbody>
			<c:forEach items="${newsDtoList}" var="newsDto">
				<tr>
					<td>${newsDto.titleN}</td>
					<td>${newsDto.contentN}</td>
					<td><div style="width: 200px; height: 200px"><img src="${newsDto.pic}"></img></div></td>
					<td>${newsDto.dateCreateN}</td>
					<td><a
						href="admin.do?action=postNews&id=${newsDto.idN}"><button style="width: 82px;"
				class="btn btn-primary" type="button">编辑</button></a>
						<a href="newsAdmin.do?action=delete&id=${newsDto.idN}"  onclick="javascript:return del_sure()"><button style="width: 82px;"
				class="btn btn-primary" type="button">删除</button></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	${pageutil}


	<%@ include file="../homeFoot.jsp"%>

  </body>
</html>
