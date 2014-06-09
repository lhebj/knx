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

<title><%=LocalizationUtil.getClientString("Title.admin", request)%></title>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<%@ include file="../homeHead.jsp"%>

	<div class="page-header">
		<h1>品牌分类管理</h1>
		<h2>品牌：${brandDTO.nameBrd}</h2>
	</div>
	<table class="table table-bordered table-condensed table-hover"
		style="width: 100%;">
		<tr>
			<td>未选分类</td>
			<td>已选分类</td>
		</tr>
		<tbody>
			<tr>
				<td>
					<FORM class="form-horizontal" name="form1" METHOD="POST"
						ACTION="brandCategoryCombinationAdmin.do?action=save">
						<input name="brandId" type="hidden" value="${brandDTO.idBrd}" />
						<table class="table table-bordered table-condensed table-hover"
							style="width: 100%;">
							<tr>
								<td>ID</td>
								<td><input class="btn btn-primary" name="ok" type="submit"
									value="添加"></td>
							</tr>
							<c:forEach items="${allCategoryDTOList}" var="categoryDto">
								<c:if test="${categoryDto.show==false}">
									<tr>
										<td><input type="checkbox" name="categoryIds"
											value="${categoryDto.idCat}">${categoryDto.idCat}</td>
										<td>${categoryDto.nameCat}</td>
									</tr>
								</c:if>
							</c:forEach>
						</table>
					</FORM>
				</td>
				<td>
					<FORM class="form-horizontal" name="form1" METHOD="POST"
						ACTION="brandCategoryCombinationAdmin.do?action=delete">
						<input name="brandId" type="hidden" value="${brandDTO.idBrd}" />
						<table class="table table-bordered table-condensed table-hover"
							style="width: 100%;">
							<tr>
								<td>ID</td>
								<td><input class="btn btn-primary" name="ok" type="submit"
									value="删除"></td>
							</tr>
							<c:forEach items="${categoryDTOList}" var="categoryDto">
								<tr>
									<td><input type="checkbox" name="categoryIds"
										value="${categoryDto.idCat}">${categoryDto.idCat}</td>
									<td>${categoryDto.nameCat}</td>
								</tr>
							</c:forEach>
						</table>
					</FORM>
				</td>
			</tr>
		</tbody>
	</table>

	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
