<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="common/common.jsp"%>
<%
	navBar.put("index", "nav  current");
%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 01//EN" "http://www.worg/TR/html4/strict.dtd">
<html>
<head>
<title><%=LocalizationUtil.getClientString("SEO.Title", request)%></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords"
	content="<%=LocalizationUtil.getClientString("SEO.Keywords", request)%>">
<meta http-equiv="description"
	content="<%=LocalizationUtil.getClientString("SEO.Description", request)%>">
<link rel="stylesheet" type="text/css"
	href="<%=CSS_PATH%>global.css?version=<%=version%>">
<link rel="stylesheet" type="text/css"
	href="<%=CSS_PATH%>index.css?version=<%=version%>">
</head>
<body>
	<div class="container clearfix">
		<%@ include file="common/head.jsp"%>
		<div class="content clearfix">
			<div class="figure r1c1 slider-container">
				<!-- <a href="#" class="#"><img src="./image/index_1.png" alt=""></a> -->
				<ul class="slider-content">
					<!-- 
					<li class="sliderItem sliderCurrent"><a href="#"><img src="<%=IMAGE_PATH%>index_1.png"/></a></li>
	                <li class="sliderItem"><a href="#"><img src="<%=IMAGE_PATH%>index_1.png"/></a></li>
	                <li class="sliderItem"><a href="#"><img src="<%=IMAGE_PATH%>index_1.png"/></a></li>
	                 -->
					<c:forEach items="${r1c1IndexDtoList}" var="indexDto"
						varStatus="status">
						<!-- <c:if test="${status.index == 0}">
							<li class="sliderItem sliderCurrent"><a href="#"><img src="${indexDto.path}" alt=""></a></li>
						</c:if> -->

						<c:if test="${indexDto.typeIdx!='video'}">
							<li class="sliderItem sliderCurrent" data-type="img"><c:choose>
									<c:when test="${indexDto.linkIdx != null}">
										<a href="${indexDto.linkIdx}"> <img src="${indexDto.path}"
											onload="imagezoom.call(this, 680, 280);" alt=""></img>
										</a>
									</c:when>
									<c:otherwise>
										<img src="${indexDto.path}"
											onload="imagezoom.call(this, 680, 280);" alt=""></img>
									</c:otherwise>

								</c:choose></li>
						</c:if>
						<!--视频-->
						<c:if test="${indexDto.typeIdx=='video'}">
							<li class="sliderItem" data-type="video"><a href="#"><img
									src="${indexDto.path}" alt=""> </a>
								<div class="video_wrap" style="display:none;">
									${indexDto.playcodeIdx}</div></li>
						</c:if>
						<!-- 视频部分，判断如果是视频，点击图片后播放视频，视频代码 ${indexDto.playcodeIdx} -->
						<!-- 
									
						-->
					</c:forEach>

				</ul>
				<div class="sliderRank">
					<a href="Javascript:;" class="current"></a> <a href="Javascript:;"></a>
					<a href="Javascript:;"></a>
				</div>
			</div>
			<div class="figure r1c2">
				<c:choose>
					<c:when test="${r1c2IndexDto.linkIdx != null}">
						<a href="${r1c2IndexDto.linkIdx}"> <img
							src="${r1c2IndexDto.path}"
							onload="imagezoom.call(this, 165, 280);" alt=""></img>
						</a>
					</c:when>
					<c:otherwise>
						<img src="${r1c2IndexDto.path}"
							onload="imagezoom.call(this, 165, 280);" alt=""></img>
					</c:otherwise>

				</c:choose>

			</div>
			<div class="figure r1c3">
				<c:choose>
					<c:when test="${r1c3IndexDto.linkIdx != null}">
						<a href="${r1c3IndexDto.linkIdx}"> <img
							src="${r1c3IndexDto.path}"
							onload="imagezoom.call(this, 165, 280);" alt=""></img>
						</a>
					</c:when>
					<c:otherwise>
						<img src="${r1c3IndexDto.path}"
							onload="imagezoom.call(this, 165, 280);" alt=""></img>
					</c:otherwise>

				</c:choose>
			</div>
		</div>
		<div class="footer_wrap">
			<ul>
				<li><c:choose>
						<c:when test="${r2c1IndexDto.linkIdx != null}">
							<a href="${r2c1IndexDto.linkIdx}"> <img
								src="${r2c1IndexDto.path}"
								onload="imagezoom.call(this, 337, 185);" alt=""></img>
							</a>
						</c:when>
						<c:otherwise>
							<img src="${r2c1IndexDto.path}"
								onload="imagezoom.call(this, 337, 185);" alt=""></img>
						</c:otherwise>
					</c:choose></li>
				<li><c:choose>
						<c:when test="${r2c2IndexDto.linkIdx != null}">
							<a href="${r2c2IndexDto.linkIdx}"> <img
								src="${r2c2IndexDto.path}"
								onload="imagezoom.call(this, 337, 185);" alt=""></img>
							</a>
						</c:when>
						<c:otherwise>
							<img src="${r2c2IndexDto.path}"
								onload="imagezoom.call(this, 337, 185);" alt=""></img>
						</c:otherwise>
					</c:choose></li>
				<li><c:choose>
						<c:when test="${r2c3IndexDto.linkIdx != null}">
							<a href="${r2c3IndexDto.linkIdx}"> <img
								src="${r2c3IndexDto.path}"
								onload="imagezoom.call(this, 337, 185);" alt=""></img>
							</a>
						</c:when>
						<c:otherwise>
							<img src="${r2c3IndexDto.path}"
								onload="imagezoom.call(this, 337, 185);" alt=""></img>
						</c:otherwise>
					</c:choose></li>
			</ul>
		</div>
	</div>

	<script type="text/javascript" src="<%=JS_PATH%>jquery.js"></script>
	<script type="text/javascript" src="<%=JS_PATH%>index.js?version=<%=version%>"></script>
</body>
</html>
