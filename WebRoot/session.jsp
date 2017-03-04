<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<jsp:directive.page import="com.helloweenvsfei.sessionWeb.bean.Person"/>
<jsp:directive.page import="java.text.SimpleDateFormat"/>
<jsp:directive.page import="java.text.DateFormat"/>
<jsp:directive.page import="java.util.Date"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!
    DateFormat dateFormat = newSimpleDateFormat("yyyy-MM-dd");         // 日期格式化器
%>
<%
    response.setCharacterEncoding("UTF-8");        // 设置request编码
    %>
    
    
    
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'session.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
