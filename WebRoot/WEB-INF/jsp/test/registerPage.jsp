<%@ page language="java" pageEncoding="utf-8" import="java.util.*,com.weather.util.WebUtil,com.weather.util.LocalizationUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title><%=LocalizationUtil.getClientString("SEO.Title", request) %></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="<%=LocalizationUtil.getClientString("SEO.Keywords", request) %>">
	<meta http-equiv="description" content="<%=LocalizationUtil.getClientString("SEO.Description", request) %>">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
 <%@ include file="common/head.jsp" %>
  
    <br>
    <FORM name="form1" METHOD="POST" ACTION="register.do">   
    <table>    
    	<tr><td><%=LocalizationUtil.getClientString("username", request) %>： <input name="username" type= "text" value="" /></td></tr>
		<tr><td><%=LocalizationUtil.getClientString("email", request) %>： <input name="email" type= "text" value="" /></td></tr>
		<tr><td><%=LocalizationUtil.getClientString("weixin", request) %>： <input name="weixin" type= "text" value="" /></td></tr>
		<tr><td><%=LocalizationUtil.getClientString("password", request) %>： <input name="p" type= "password" value="" /></td></tr>
		<tr><td><%=LocalizationUtil.getClientString("passwordConfirm", request) %>： <input name="pc" type= "password" value="" /></td></tr>
		
		<tr><td><input name="ok" type= "submit" value="提交"></td></tr>
	</table>
	</FORM>
  </body>
</html>
