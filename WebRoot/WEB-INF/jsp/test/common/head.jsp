<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil,com.knx.web.util.BrandUtil,com.knx.web.util.CategoryUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div>
	<div>
		<a href="index.do">logo</a>
		<a href="#"><%=LocalizationUtil.getClientString("Forum", request)%></a>
		<div>
			<%if(WebUtil.isGuest()){ %>
			<a href="registerPage.do"><%=LocalizationUtil.getClientString("Register", request)%></a> | <a href="pLogin.do"><%=LocalizationUtil.getClientString("Login", request)%></a>
			<%}else{ %>
				<%=WebUtil.getUserId(request) %>
			<%} %>
			<span> <a href="switchLan.do?lan=zh">CN</a> <a
				href="switchLan.do?lan=en">EN</a>
			</span>
		</div>
	</div>
	<div>
		<div>
			<ul>
				<li class=""><a href="index.do"><%=LocalizationUtil.getClientString("Nav.index", request)%></a></li>
				<li class=""><a href="news.do"><%=LocalizationUtil.getClientString("Nav.news", request)%></a></li>
				<li class=""><a href="#"><%=LocalizationUtil.getClientString("Nav.brand", request)%></a></li>
				<li class=""><a href="#"><%=LocalizationUtil.getClientString("Nav.category", request)%></a></li>
				<li class=""><a href="training.do"><%=LocalizationUtil.getClientString("Nav.training", request)%></a></li>
				<li class=""><a href="other.do"><%=LocalizationUtil.getClientString("Nav.other", request)%></a></li>
				<li class=""><a href="about.do"><%=LocalizationUtil.getClientString("Nav.about", request)%></a></li>
				<li class=""><a href="contact.do"><%=LocalizationUtil.getClientString("Nav.contact", request)%></a></li>
			</ul>
		</div>
		<div>
			<form name="form1" METHOD="POST" ACTION="product.do?action=list">
				<input type="text" name="wd" value="${wd}" /> <input name="ok"
					type="submit" value="搜索" />

			</form>
		</div>
	</div>
</div>

<!-- 
5.品牌（Brand）
5.1 前台
1）点击导航上的品牌，弹出品牌列表框
2）选择列表中的一个品牌，记住品牌id，然后弹出所有分类列表，选择一个分类，记住分类id，跳转到产品页，过滤出所有相关品牌和分类下的产品
5.2 后台
品牌管理：品牌列表，添加品牌，编辑品牌，删除品牌
品牌表单字段（品牌名称：name，品牌介绍：introduction）

6.分类（Category）
6.1 前台
1）点击导航上的分类，弹出分类列表框
2）选择列表中的一个分类，记住分类id，然后弹出所有品牌列表，选择一个品牌，记住分类id，跳转到产品页，过滤出所有相关品牌和分类下的产品
6.2 后台
分类管理：分类列表，添加分类，编辑分类，删除分类
分类表单字段（分类名称：name）

选择后跳转的连接为:brand.do?action=detail&id=1&categoryId=1

产品详情页：product.do?action=detail&id=1

搜索后的产品列表页：product.do?action=list&wd=
-->

<c:set var="brandTreeCache" value="<%=BrandUtil.getBrandTree()%>" scope="page" />
<div>品牌</div>
<c:forEach items="${brandTreeCache}" var="brandDTOEntry">
	<div>${brandDTOEntry.key}</div>
	<c:forEach items="${brandDTOEntry.value}" var="brandDTO">
		<div><a href="brand.do?action=detail&id=${brandDTO.idBrd}">${brandDTO.nameBrd}</a></div>
	</c:forEach>
</c:forEach>


<c:set var="categoryTreeCache" value="<%=CategoryUtil.getCategoryTree()%>" scope="page" />
<div>分类</div>
	<c:forEach items="${categoryTreeCache}" var="categoryDTO">
		<div><a href="brand.do?action=detail&id=1&categoryId=${categoryDTO.idCat}">${categoryDTO.nameCat}</a></div>
	</c:forEach>