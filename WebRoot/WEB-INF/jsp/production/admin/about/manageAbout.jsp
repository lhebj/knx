<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

    <title><%=LocalizationUtil.getClientString("Title.admin", request) %></title>

</head>

<body>
	<%@ include file="../homeHead.jsp"%>

	<div class="page-header">
		<c:if test="${about.typeAb == 'about'}">
			<h1>关于管理</h1>
		</c:if>
		<c:if test="${about.typeAb == 'contact'}">
			<h1>联系管理</h1>
		</c:if>
	</div>
	<div>
		<a href="admin.do?action=postAbout&type=${about.typeAb}"><button
				style="width: 82px;" class="btn btn-primary" type="button">编辑</button></a>
	</div>
	<table class="table table-bordered table-condensed table-hover"
		style="width: 100%;">
		<tbody>
			<tr>
				<td>${about.contentAb}</td>
			</tr>
		</tbody>
	</table>

	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
