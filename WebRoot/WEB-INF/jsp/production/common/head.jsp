<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil,com.knx.web.util.BrandUtil,com.knx.web.util.CategoryUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="brandTreeCache" value="<%=BrandUtil.getBrandTree()%>" scope="page" />
<c:set var="categoryTreeCache" value="<%=CategoryUtil.getCategoryTree()%>" scope="page" />
<script type="text/javascript" src="<%=JS_PATH %>jquery.js"></script>
<script type="text/javascript" src="<%=JS_PATH %>header.js?version=<%=version%>"></script>
<div class="logoWrap">
	<a href="/" class="logo">
		<img src="<%= IMAGE_PATH %>/logo.png" alt="logo"/>
	</a>
</div>
		<div class="headerWrap clearfix">
			<div class="navContainer">
				<ul>
					<li><a href="index.do" class='<%=navBar.get("index")%>'><%=LocalizationUtil.getClientString("Nav.index", request) %></a></li>
					<li><a href="news.do" class='<%=navBar.get("news")%>'><%=LocalizationUtil.getClientString("Nav.news", request) %></a></li>
					<li><a href="javascript:;" id="J_brand" class='<%=navBar.get("brand")%>'><%=LocalizationUtil.getClientString("Nav.brand", request) %></a></li>
					<li><a href="javascript:;" id="J_classify" class='nav'><%=LocalizationUtil.getClientString("Nav.category", request) %></a></li>
					<li><a href="training.do" class='<%=navBar.get("training")%>'><%=LocalizationUtil.getClientString("Nav.training", request) %></a></li>
					<li><a href="other.do" class='<%=navBar.get("other")%>'><%=LocalizationUtil.getClientString("Nav.other", request) %></a></li>
					<li><a href="about.do" class='<%=navBar.get("about")%>'><%=LocalizationUtil.getClientString("Nav.about", request) %></a></li>
					<li><a href="contact.do" class='<%=navBar.get("contact")%>'><%=LocalizationUtil.getClientString("Nav.contact", request) %></a></li>
				</ul>
			</div>
			<div class="searchWrap">
				<div class="rightAside">
					<span class="en"><a href="switchLan.do?lan=en">EN</a></span>
					<span class="cn"><a href="switchLan.do?lan=zh">CN</a></span>
					<a href="javascript:;" class="forum"><%=LocalizationUtil.getClientString("Forum", request) %></a>
					<%if(WebUtil.isGuest()){ %>
					<a class="userBtn registration" href="javascript:;"><%=LocalizationUtil.getClientString("Register", request) %></a>|
					<a class="userBtn login" href="javascript:;"><%=LocalizationUtil.getClientString("Login", request) %></a>
					<%}else{ %>
						<%=WebUtil.getUserId(request) %>|<a class="userBtn login" href="logout.do"><%=LocalizationUtil.getClientString("Logout", request) %></a>
					<%} %>
				</div>
				<div style="text-align:right;">
					<form name="form1" METHOD="POST" ACTION="product.do?action=list">
					<input type="text" class="searchText" name="wd" value="${wd}" />
					<input class="submitBtn" name="<%=LocalizationUtil.getClientString("Nav.search", request) %>" type= "submit" value="搜索"/>
					</form>
				</div> 
			</div>
	    </div>
	    <div class="wrap brand_submenubox">
			<div class="subcate">
				<ul id="head_brand_ul">
					<!-- 
					<c:forEach items="${brandTreeCache}" var="brandDTOEntry">
						<li>
							<span class="sort_title">${brandDTOEntry.key}</span>
							<div class="detail">
								<c:forEach items="${brandDTOEntry.value}" var="brandDTO">
								<a href="javascript:;" data-id="${brandDTO.idBrd}" class="nav_item">${brandDTO.nameBrd}</a>
								</c:forEach>
							</div>
						</li>
					</c:forEach>
					 -->
				</ul>
			</div>
		</div>
		<div class="wrap classify_submenubox">
			<div class="subcate">
				<ul id="head_category_ul">
				<!-- 
					<c:forEach items="${categoryTreeCache}" var="categoryDTO">
						<li><a href="javascript:;" class="nav_item" data-id="${categoryDTO.idCat}">${categoryDTO.nameCat}</a></li>
					</c:forEach>
				-->
				</ul>
			</div>
		</div>

		<!--注册 && 登陆-->
		<div class="registrationWrap">
			  <!--  <form name="form1" id="form1" method="POST">   -->
					<div class="registration_info">
						<h2><%=LocalizationUtil.getClientString("Register", request) %></h2>
						<p class="wrap">
							<label for=""><%=LocalizationUtil.getClientString("username", request) %></label>
							<input type="text" class="reg_txt userName">
							<span class="require_icon">*</span>
						</p>
						<p class="wrap">
							<label for=""><%=LocalizationUtil.getClientString("email", request) %></label>
							<input type="text" class="reg_txt email">
							<span class="require_icon">*</span>
						</p>
						<p class="wrap">
							<label for=""><%=LocalizationUtil.getClientString("weixin", request) %></label>
							<input type="text" class="reg_txt weiXin">
							<span class="require_icon">*</span>
						</p>
						<p class="wrap">
							<label for=""><%=LocalizationUtil.getClientString("newpassword", request) %></label>
							<input type="password" class="reg_txt password">
							<span class="require_icon">*</span>
						</p>
						<p class="wrap">
							<label for=""><%=LocalizationUtil.getClientString("passwordConfirm", request) %></label>
							<input type="password" class="reg_txt rePassword">
							<span class="require_icon">*</span>
						</p>
						<!-- <p class="send_email">
							<input type="checkbox"><span>是的。请发送给我关于KNX MALL最新资料和优惠计划的电子邮件</span>
						</p>
						<p class="agreement">
							<input type="checkbox"><span>我同意KNX<a href="#">网页条款</a>和<a href="#">许可协议条款</a></span>
						</p> -->
						<p class="required">
							<span class="require_icon_des">*</span><span><%=LocalizationUtil.getClientString("infoRequired", request) %></span>
						</p>
						<p id="tip" class="tip_error"></p>
						<a class="submit" href="javascript:void(0)"><%=LocalizationUtil.getClientString("Register", request) %></a>
					</div>
			    <!-- </form> -->
				<div class="login_info">
					<h2><%=LocalizationUtil.getClientString("Login", request) %></h2>
					<p class="wrap">
						<label for=""><%=LocalizationUtil.getClientString("username", request) %></label>
						<input type="text" id="j_username">
					</p>
					<p class="wrap">
						<label for=""><%=LocalizationUtil.getClientString("password", request) %></label>
						<input type="password" id="j_password">
					</p>
					<p class="login_error"><%=LocalizationUtil.getClientString("LoginError", request) %></p>
					<button class="login_btn"><%=LocalizationUtil.getClientString("Login", request) %></button><span><%=LocalizationUtil.getClientString("ForgotPassword", request) %></span>
				</div>
			</div>
			<!-- 隐藏的iframe 表单注册登陆提交不刷新页面 -->
			<!-- <div id="sbIframeDiv" style="display: none;">
			   <iframe id="userFrame" name="sbIframe"></iframe>
			</div> -->
