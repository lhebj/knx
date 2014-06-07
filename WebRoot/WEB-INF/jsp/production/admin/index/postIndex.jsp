<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.weather.util.WebUtil,com.weather.util.LocalizationUtil"%>
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
		<h1>添加首页图片</h1>
	</div>
	<FORM class="form-horizontal" name="form1" METHOD="POST"
		ACTION="indexAdmin.do?action=save" ENCTYPE="multipart/form-data">
		<input name="positionIdx" type="hidden" value="${positionIdx}" />
		<table>
			<tr>
				<td width='150'></td>
				<td>
				<c:choose>
					<c:when test="${positionIdx=='r1c1'}">
						<input type="radio" name="typeIdx" value="pic"
							checked="checked" onclick="document.getElementById('showPlaycode').style.display='none';document.getElementById('showLink').style.display='';" />图片 | <input type="radio" name="typeIdx"
							value="video"
							onclick="document.getElementById('showPlaycode').style.display='';document.getElementById('showLink').style.display='none';" />视频
					</c:when>

					<c:otherwise>
							图片
						</c:otherwise>

				</c:choose>
				</td>
			</tr>
			<tr id="showPlaycode" style="display:none;">
				<td width='150'>视频代码(width=680,height=280)</td>
				<td><textarea style="width:400px;height:200px"
						name="playcodeIdx"></textarea></td>
			</tr>
			<tr id="showLink" >
				<td width='150'>设置链接</td>
				<td><input name="linkIdx" type="text"
					style="width:400px;height:30px" value="" /></td>
			</tr>
			<tr id="showImageUpload">
				<td width='150'>选择上传图片</td>
				<td><input name="attach1" type="FILE" id="attach1" size="50"></td>
			</tr>

			<tr>
				<td width='150'></td>
				<td><input class="btn btn-primary" name="ok" type="submit"
					value="提交"> <input type="button" value="取消" class="btn"
					onclick="javascript:window.history.go(-1);" /></td>
			</tr>

		</table>
	</form>

	<%@ include file="../homeFoot.jsp"%>
</body>
</html>
