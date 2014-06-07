<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ include file="../../common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><%=LocalizationUtil.getClientString("Title.admin", request)%></title>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>global.css">
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH%>index.css">
</head>

<body>
	<%@ include file="../homeHead.jsp"%>

	<div class="page-header">
		<h1>首页图片/视频管理</h1>
	</div>


	<table class="table table-bordered table-condensed table-hover"
		style="width: 100%;">
		<tr>
			<td style="width: 20%;">首页图片/视频区域</td>
			<td style="width: 60%;">图片/视频</td>
			<td style="width: 15%;">操作</td>
		</tr>
		<tbody>
			<tr>
				<td>第一排第一列</td>
				<td><table>
						<c:forEach items="${r1c1IndexDtoList}" var="indexDto">
							<tr>
								<td><img src="${indexDto.path}"></img></td>
								<td><a
									href="indexAdmin.do?action=delete&id=${indexDto.idIdx}"
									onclick="javascript:return del_sure()"><button
											style="width: 82px;" class="btn btn-primary" type="button">删除</button></a></td>

							</tr>
						</c:forEach>
					</table></td>
				<td><a href="admin.do?action=postIndex&position=r1c1"><button
									style="width: 82px;" class="btn btn-primary" type="button">添加</button></a></td>
			</tr>
			<tr>
				<td>第一排第二列</td>
				<td><c:choose>
						<c:when test="${r1c3IndexDto != null}">
							<img src="${r1c2IndexDto.path}"></img>
						</c:when>

						<c:otherwise>
							无图片
						</c:otherwise>

					</c:choose></td>
				<td><c:choose>
						<c:when test="${r1c2IndexDto != null}">
							<a href="indexAdmin.do?action=delete&id=${r1c2IndexDto.idIdx}"
								onclick="javascript:return del_sure()"><button
									style="width: 82px;" class="btn btn-primary" type="button">删除</button></a>
						</c:when>

						<c:otherwise>
							<a href="admin.do?action=postIndex&position=r1c2"><button
									style="width: 82px;" class="btn btn-primary" type="button">添加</button></a>
						</c:otherwise>

					</c:choose></td>
			</tr>
			<tr>
				<td>第一排第三列</td>
				<td><c:choose>
						<c:when test="${r1c3IndexDto != null}">
							<img src="${r1c3IndexDto.path}"></img>
						</c:when>

						<c:otherwise>
							无图片
						</c:otherwise>

					</c:choose></td>
				<td><c:choose>
						<c:when test="${r1c3IndexDto != null}">
							<a href="indexAdmin.do?action=delete&id=${r1c3IndexDto.idIdx}"
								onclick="javascript:return del_sure()"><button
									style="width: 82px;" class="btn btn-primary" type="button">删除</button></a>
						</c:when>

						<c:otherwise>
							<a href="admin.do?action=postIndex&position=r1c3"><button
									style="width: 82px;" class="btn btn-primary" type="button">添加</button></a>
						</c:otherwise>

					</c:choose></td>
			</tr>
			<tr>
				<td>第二排第一列</td>
				<td><c:choose>
						<c:when test="${r2c1IndexDto != null}">
							<img src="${r2c1IndexDto.path}"></img>
						</c:when>

						<c:otherwise>
							无图片
						</c:otherwise>

					</c:choose></td>
				<td><c:choose>
						<c:when test="${r2c1IndexDto != null}">
							<a href="indexAdmin.do?action=delete&id=${r2c1IndexDto.idIdx}"
								onclick="javascript:return del_sure()"><button
									style="width: 82px;" class="btn btn-primary" type="button">删除</button></a>
						</c:when>

						<c:otherwise>
							<a href="admin.do?action=postIndex&position=r2c1"><button
									style="width: 82px;" class="btn btn-primary" type="button">添加</button></a>
						</c:otherwise>

					</c:choose></td>
			</tr>
			<tr>
				<td>第二排第二列</td>
				<td><c:choose>
						<c:when test="${r2c2IndexDto != null}">
							<img src="${r2c2IndexDto.path}"></img>
						</c:when>
						<c:otherwise>
							无图片
						</c:otherwise>
					</c:choose></td>
				<td><c:choose>
						<c:when test="${r2c2IndexDto != null}">
							<a href="indexAdmin.do?action=delete&id=${r2c2IndexDto.idIdx}"
								onclick="javascript:return del_sure()"><button
									style="width: 82px;" class="btn btn-primary" type="button">删除</button></a>
						</c:when>

						<c:otherwise>
							<a href="admin.do?action=postIndex&position=r2c2"><button
									style="width: 82px;" class="btn btn-primary" type="button">添加</button></a>
						</c:otherwise>

					</c:choose></td>
			</tr>
			<tr>
				<td>第二排第三列</td>
				<td><c:choose>
						<c:when test="${r2c3IndexDto != null}">
							<img src="${r2c3IndexDto.path}"></img>
						</c:when>

						<c:otherwise>
							无图片
						</c:otherwise>
					</c:choose></td>
				<td><c:choose>
						<c:when test="${r2c3IndexDto != null}">
							<a href="indexAdmin.do?action=delete&id=${r2c3IndexDto.idIdx}"
								onclick="javascript:return del_sure()"><button
									style="width: 82px;" class="btn btn-primary" type="button">删除</button></a>
						</c:when>

						<c:otherwise>
							<a href="admin.do?action=postIndex&position=r2c3"><button
									style="width: 82px;" class="btn btn-primary" type="button">添加</button></a>
						</c:otherwise>

					</c:choose></td>
			</tr>
		</tbody>
	</table>
	<!-- 
	<div>
		<a href="admin.do?action=postIndex"><button style="width: 82px;"
				class="btn btn-primary" type="button">添加</button></a>
	</div>
	<table class="table table-bordered table-condensed table-hover"
		style="width: 100%;">
		<thread>
		<tr>
			<td>类型</td>
			<td>图片</td>
			<td>操作</td>
		</tr>
		</thread>
		<tbody>
			<c:forEach items="${indexDtoList}" var="indexDto">
				<tr>
					<td><c:if test="${indexDto.typeIdx =='pic'}">
							图片
						</c:if> <c:if test="${indexDto.typeIdx =='video'}">
							视频</c:if></td>
					<td><c:if test="${indexDto.typeIdx =='pic'}">
							<img src="${indexDto.path}"></img>
						</c:if> <c:if test="${indexDto.typeIdx =='video'}">
							${indexDto.playcodeIdx}</c:if></td>
					<td><a href="indexAdmin.do?action=delete&id=${indexDto.idIdx}" onclick="javascript:return del_sure()"><button style="width: 82px;"
				class="btn btn-primary" type="button">删除</button></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	-->

	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
