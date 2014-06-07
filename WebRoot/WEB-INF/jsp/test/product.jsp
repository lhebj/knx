<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.knx.web.dto.ProductDetailDTO" %>
<%@ include file="common/common.jsp" %>
<% 
navBar.put("brand", "selected"); 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>${productDetailDTO.productDTO.namePrd}-<%=LocalizationUtil.getClientString("SEO.Title", request) %></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	<meta http-equiv="description" content="<%=LocalizationUtil.getClientString("SEO.Description", request) %>">
  </head>
  
  <body>

	  <%@ include file="common/head.jsp" %>
	 <!-- 产品标题 -->
	 <div>${productDetailDTO.productDTO.namePrd}</div>
	 <!-- 产品型号 -->
	 <div>${productDetailDTO.productDTO.modelPrd}</div>
	 <!-- 产品品牌 -->
	 <div>${productDetailDTO.brandDTO.nameBrd}</div>
	 <!-- 产品分类 -->
	 <div>${productDetailDTO.categoryDTO.nameCat}</div>
	 <!-- 产品产地-->
	 <div>${productDetailDTO.placePrdd}</div>
	 <!-- 产品简介 -->
	 <div>${productDetailDTO.introductionPrdd}</div>
	 <!-- 产品参数 -->
	 <div>${productDetailDTO.parametersPrdd}</div>
	 <!-- 产品特性 -->
	 <div>${productDetailDTO.featuresPrdd}</div>
	 <!-- 产品供货商 -->
	 <div>${productDetailDTO.supplierPrdd}</div>
	 <!-- 产品大图地址 -->
	 <div>${productDetailDTO.idbigpicPrdd}</div>
	 <!-- 产品小图1地址 -->
	 <div>${productDetailDTO.idsmallpic1Prdd}</div>
	 <!-- 产品小图2地址 -->
	 <div>${productDetailDTO.idsmallpic2Prdd}</div>
	 <!-- 产品小图3地址 -->
	 <div>${productDetailDTO.idsmallpic3Prdd}</div>
	 <!-- 产品小图4地址 -->
	 <div>${productDetailDTO.idsmallpic4Prdd}</div>
	 <!-- 产品小图5地址 -->
	 <div>${productDetailDTO.idsmallpic5Prdd}</div>
	 <!-- 产品小图6地址 -->
	 <div>${productDetailDTO.idsmallpic6Prdd}</div>
	 <div>
		<table id="downloadFileTable">
			<tr>
				<td style="width:300px;">文件类型</td>
				<td>上传文件</td>
			</tr>

			<c:forEach items="${pdownloadDTOList}" var="pdownloadDTO">
				<tr>
					<td>${pdownloadDTO.namePrdl}</td>
					<td>${pdownloadDTO.fileNamePrdl}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	    <%@ include file="common/footer.jsp" %>
  </body>
</html>
