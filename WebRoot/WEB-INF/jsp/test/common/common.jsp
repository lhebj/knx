<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.HashMap" %>
<%
	String version="201404261010";
	String PATH = request.getContextPath();
	String BASE_Path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+PATH+"/";
	String STATIC_PATH = BASE_Path + "static/";
	String CSS_PATH = STATIC_PATH + "css/";
	String JS_PATH = STATIC_PATH + "js/";
	String IMAGE_PATH = STATIC_PATH + "image/";
	HashMap<String,String> navBar = new HashMap<String, String>();
	navBar.put("index", "nav");
	navBar.put("news", "nav");
	navBar.put("brand", "nav");
	navBar.put("category", "nav");
	navBar.put("training", "nav");
	navBar.put("other", "nav");
	navBar.put("about", "nav");
	navBar.put("contact", "nav");
%>