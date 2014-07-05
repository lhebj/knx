<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.knx.web.dto.ProductDetailDTO"%>
<%@ include file="common/common.jsp"%>
<%
	navBar.put("brand", "nav  current");
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>${productDetailDTO.productDTO.namePrd}-<%=LocalizationUtil.getClientString("SEO.Title", request)%></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="${seoKey}">
<meta http-equiv="description" content="${seoDescription}">
<!--css文件-->
<link rel="stylesheet" type="text/css"
	href="<%=CSS_PATH%>global.css?version=<%=version%>">
<link rel="stylesheet" type="text/css"
	href="<%=CSS_PATH%>detail.css?version=<%=version%>">
</head>

<body onselectstart="return false">
	<div class="container clearfix">
		<%@ include file="common/head.jsp"%>

		<div class="content">
			<%@ include file="common/left-brand-category.jsp"%>
			<div class="listContainer clearfix">
				<!--产品型号-->
				<h2 class="type">${productDetailDTO.productDTO.modelPrd}</h2>
				<div class="item_container clearfix">
					<div class="left_item">
						<!--产品大图-->
						<div class="product_img">
							<a href="javascript:;"> <img
								src="${productDetailDTO.idbigpicPrdd}"
								alt="${productDetailDTO.idbigpicNamePrdd}" class="img"
								id="largeImg" onload="imagezoom.call(this, 184, 184);"></a>
						</div>
						<!--产品小图-->
						<div class="listWrap clearfix">
							<ul>
								<li class="list"><a href="javascript:;" class="img_item">
										<img src="${productDetailDTO.idsmallpic1Prdd}"
										alt="${productDetailDTO.idsmallpic1NamePrdd}"
										onload="imagezoom.call(this, 64, 64);">
								</a></li>
								<li class="list"><a href="javascript:;" class="img_item"><img
										src="${productDetailDTO.idsmallpic2Prdd}"
										alt="${productDetailDTO.idsmallpic2NamePrdd}"
										onload="imagezoom.call(this, 64, 64);"></a></li>
								<li class="list noLeft"><a href="javascript:;"
									class="img_item"><img
										src="${productDetailDTO.idsmallpic3Prdd}"
										alt="${productDetailDTO.idsmallpic3NamePrdd}"
										onload="imagezoom.call(this, 64, 64);"></a></li>
								<li class="list"><a href="javascript:;" class="img_item"><img
										src="${productDetailDTO.idsmallpic4Prdd}"
										alt="${productDetailDTO.idsmallpic4NamePrdd}"
										onload="imagezoom.call(this, 64, 64);"></a></li>
								<li class="list"><a href="javascript:;" class="img_item"><img
										src="${productDetailDTO.idsmallpic5Prdd}"
										alt="${productDetailDTO.idsmallpic5NamePrdd}"
										onload="imagezoom.call(this, 64, 64);"></a></li>
								<li class="list noLeft"><a href="javascript:;"
									class="img_item"><img
										src="${productDetailDTO.idsmallpic6Prdd}"
										alt="${productDetailDTO.idsmallpic6NamePrdd}"
										onload="imagezoom.call(this, 64, 64);"></a></li>
							</ul>
						</div>
						<!--供货商中文地址-->
						<div class="address_supplier_zh">
							<p>
								<span class="supplier_zh">供货商</span><br/> 
								<%if(WebUtil.isGuest()) { %>
									<span>请登陆后了解详情</span>
								<%} else {%>
									<span>${productDetailDTO.supplierPrdd}</span>
								<%} %>
							</p>
						</div>
						<!--英文地址-->
						<!-- 
						<div class="address_supplier_en">
							<p>
								<span class="supplier_en">供货商</span><br /> <span
									class="address_en">${productDetailDTO.supplierPrdd}</span>
							</p>
						</div>
						-->
					</div>
					<div class="right_item">
						<div class="list_des_wrap ico_des">
							<a href="javascript:;"> <img
								src="${productDetailDTO.iddetaillogoPrdd}" class="topImg"
								alt="${productDetailDTO.iddetaillogoNamePrdd}"
								onload="imagezoom.call(this, 243, 54);">
							</a>
						</div>
						<div class="list_des_wrap clearfix">
							<!--产品型号-->
							<h2 class="type">${productDetailDTO.productDTO.modelPrd}</h2>
							<div class="left_list">
								<ul>
									<li class="list_des"><label class="name">名称：</label> <span
										class="des_content">${productDetailDTO.productDTO.namePrd}
									</span></li>
									<li class="list_des"><label class="name">品牌：</label> <span
										class="des_content">${productDetailDTO.brandDTO.nameBrd}
									</span></li>
								</ul>
							</div>
							<div class="right_list">
								<ul>
									<li class="list_des"><label class="name">产地：</label> <span
										class="des_content">${productDetailDTO.placePrdd} </span></li>
									<li class="list_des"><label class="name">分类：</label> <span
										class="des_content">${productDetailDTO.categoryDTO.nameCat}
									</span></li>
								</ul>
							</div>
						</div>
						<div class="list_des_wrap">
							<h2 class="type">产品描述</h2>
							<%if(WebUtil.isGuest()){ %>
								<p class="product_detail">请登陆后了解详情</p>
							<%} else { %>
								<p class="product_detail">${productDetailDTO.introductionPrdd}</p>
							<%} %>							
						</div>
						<div class="list_des_wrap clearfix">
							<!--产品参数-->
							<h2 class="type">产品参数</h2>
							<!--段落型 -->
							<%if(WebUtil.isGuest()){ %>
								<p class="product_detail">请登陆后了解详情</p>
							<%} else { %>
								<p class="product_detail">${productDetailDTO.parametersPrdd}</p>
							<%} %>
							<!--list 型-->
							<!-- <div class="left_list">
								<ul>
									<li class="list_des">
										<label class="name">长度：</label>
										<span class="des_content">XXXX</span>
									</li>
									<li class="list_des">
										<label class="name"高度：</label>
										<span class="des_content">XXXX</span>
									</li>
									<li class="list_des">
										<label class="name">厚度：</label>
										<span class="des_content">XXXX</span>
									</li>
									<li class="list_des">
										<label class="name">玻璃面板厚度：</label>
										<span class="des_content">XXXX</span>
									</li>
								</ul>
							</div>
							<div class="right_list">
								<ul>
									<li class="list_des">
										<label class="name">按键数量：</label>
										<span class="des_content">XXXX</span>
									</li>
									<li class="list_des">
										<label class="name">供电电源：</label>
										<span class="des_content">XXXX</span>
									</li>
								</ul>
							</div> -->

						</div>
						<div class="list_des_wrap">
							<!--产品特性-->
							<h2 class="type">产品特性</h2>
							<!--段落型 || list 任选一-->
							<%if(WebUtil.isGuest()){ %>
								<p class="product_detail">请登陆后了解详情</p>
							<%} else { %>
								<p class="product_detail">${productDetailDTO.featuresPrdd}</p>
							<%} %>
							
							<!--list 型-->
							<!-- <ul class="product_des_list">
								<li><span class="des_ico">•</span><span>描述</span></li>
								<li><span class="des_ico">•</span><span>描述</span></li>
								<li><span class="des_ico">•</span><span>描述</span></li>
								<li><span class="des_ico">•</span><span>描述</span></li>
							</ul> -->
							<!--list-->
						</div>
						<!--start 下载专区-->
						<div class="list_des_wrap download_wrap clearfix">
							<h2 class="type">相关下载</h2>
							<%if(WebUtil.isGuest()){ %>
								<p class="product_detail">请登陆后了解详情</p>
							<%} else { %>
								<ul>
								<c:forEach items="${pdownloadDTOList}" var="pdownloadDTO">
									<li class="list_des"><label class="name">${pdownloadDTO.namePrdl}</label>
										<a href="product.do?action=download&id=${pdownloadDTO.idPrdl}"
										title="${pdownloadDTO.fileNamePrdl}" class="des_content">${pdownloadDTO.fileNamePrdl}</a></li>
								</c:forEach>
								</ul>
							<%} %>
							
						</div>
						<!--end 下载专区-->
					</div>
				</div>
			</div>
		</div>
		<%@ include file="common/footer.jsp"%>
	</div>

	<script type="text/javascript" src="<%=JS_PATH%>detail.js?version=<%=version%>"></script>
</body>
</html>
