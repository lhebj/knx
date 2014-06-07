<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.HashMap" %>
<%
	String version="201405301010";
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

<script>
function imagezoom(new_w, new_h){
    var img = document.createElement('img');
    img.src = this.src;
    var src_w = img.width;
    var src_h = img.height;
   
    var zoom_w = 0, zoom_h = 0;
    if(src_w > new_w || src_h > new_h){
        var scale_w = new_w / src_w;
        var scale_h = new_h / src_h;
        var b = scale_w < scale_h;
           
        if(b){
            zoom_w = src_w * scale_w;
            zoom_h = src_h * scale_w;
        }else{
            zoom_w = src_w * scale_h;
            zoom_h = src_h * scale_h;
        }
    }else{
        zoom_w = src_w;
        zoom_h = src_h;
    }
       
    this.style.marginLeft = Math.abs(new_w-zoom_w)/2+'px';
    this.style.marginTop = Math.abs(new_h-zoom_h)/2+'px';
    this.style.marginRight = Math.abs(new_w-zoom_w)/2+'px';
    this.style.marginBottom = Math.abs(new_h-zoom_h)/2+'px';
   
    this.width = zoom_w;
    this.height = zoom_h;
}
</script>