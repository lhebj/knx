<%@ page language="java" pageEncoding="utf-8"
	import="java.util.*,com.knx.web.util.WebUtil,com.knx.web.util.LocalizationUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style type="text/css">
#top {
	width: 1000px;
	height: 150px;
	margin: 0 auto;
}
</style>

<!-- Le styles -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}
</style>
<link href="assets/css/bootstrap-responsive.min.css" rel="stylesheet">
<%
String urlQueryString = request.getQueryString();

%>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a class="brand" href="index.do">KNX</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li <%if(urlQueryString.contains("action=manageUsers")){ %>class="active"<%} %>><a href="admin.do?action=manageUsers">用户</a></li>
					<li <%if(urlQueryString.contains("action=manageIndex")){ %>class="active"<%} %>><a href="admin.do?action=manageIndex">首页</a></li>
					<li <%if(urlQueryString.contains("action=manageNews")){ %>class="active"<%} %>><a href="admin.do?action=manageNews">新闻</a></li>
					<li <%if(urlQueryString.contains("action=manageBrand")){ %>class="active"<%} %>><a href="admin.do?action=manageBrand">品牌</a></li>					
					<li <%if(urlQueryString.contains("action=manageCategory")){ %>class="active"<%} %>><a href="admin.do?action=manageCategory">分类</a></li>
					<li <%if(urlQueryString.contains("action=manageProduct")){ %>class="active"<%} %>><a href="admin.do?action=manageProduct">产品</a></li>
					<li <%if(urlQueryString.contains("action=manageTraining")){ %>class="active"<%} %>><a href="admin.do?action=manageTraining">培训</a></li>					
					<li <%if(urlQueryString.contains("action=manageAbout")){ %>class="active"<%} %>><a href="admin.do?action=manageAbout">关于</a></li>
					<li <%if(urlQueryString.contains("action=manageContact")){ %>class="active"<%} %>><a href="admin.do?action=manageContact">联系</a></li>
					<!-- <li class="active">用户：<%=WebUtil.getUserId(request)%>|<a href="logout.do">退出</a></li> -->
				</ul>
						<div class="navbar-text pull-right">用户：<%=WebUtil.getUserId(request)%> | <a href="logout.do">退出</a></div>
					
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>


<div id="top">