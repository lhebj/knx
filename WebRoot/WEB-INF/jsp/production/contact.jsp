<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
<% navBar.put("contact", "nav  current"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 01//EN" "http://www.worg/TR/html4/strict.dtd">   
<html>
<head>
	<title><%=LocalizationUtil.getClientString("SEO.Title", request) %></title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	<meta http-equiv="description" content="<%=LocalizationUtil.getClientString("SEO.Description", request) %>">
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH %>global.css?version=<%=version%>">
<link rel="stylesheet" type="text/css" href="<%=CSS_PATH %>contact.css?version=<%=version%>">
</head>
<body>
	<div class="container clearfix">
		<%@ include file="common/head.jsp" %>
		<div class="content">
			<%@ include file="common/left-brand-category.jsp" %>
			<div class="listContainer clearfix">
				<div class="address_container">
					<!-- 
					<div class="time">
						<p>工作时间</p>
						<p>周一到周五</p>
						<p>09:00-18:00</p>
					</div>
					<div class="phone">
						<p>电话</p>
						<p>010-60258878</p>
						<p>传真</p>
					</div>
					<div class="email">
						<p>邮件</p>
						<p>beijng@poss.com.cn</p>
					</div>
					 -->
					 ${contact.contentAb}
				</div>
				<div class="map_address">
					<!-- <img src="<%=IMAGE_PATH %>map_address.png"/> -->
					<div id="my_address">
						<iframe width="604" height="465" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://j.map.baidu.com/WDBib"></iframe>
					</div>
					<p class="callout">
						地图位标注仅供参考，具体情况以实际位置为主
					</p>
				</div>
			</div>
		</div>
		<div class="contact-footer-locale">
			<%@ include file="common/footer.jsp" %>
		</div>
	</div>	
</body>
</html>
