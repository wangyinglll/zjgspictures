<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论</title>
<meta name="Keywords" content="" />
<meta name="author" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />


<script type="text/javascript" src="/pictures/js/jquery-3.1.1.min.js"></script>
<script src="/pictures/js/bootstrap.min.js" type="text/javascript"></script>
<link href="/pictures/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="/pictures/css/shoot.css" rel="stylesheet" type="text/css" />
<script src="/pictures/js/shoot.js" type="text/javascript"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-2 col-sm-2 total-head">
				<a href="home_page.html"> <img src="/pictures/icons/back.jpg"
					class="img-header" />
				</a>
			</div>
			<div class="col-xs-4 col-sm-4 text-center">
				<h3 id="p_content">
					评论&nbsp;<small id="p_cnumber"><c:out value="${p_cnumber}"/></small>
				</h3>
				<img src="/pictures/icons/strping.jpg" id="i_content">
			</div>
			<div class="col-xs-4 col-sm-4 text-center">
				<h3 id="p_prasie">
					赞&nbsp;<small id="p_favornumber"><c:out value="${p_favornumber}"/></small>
				</h3>
				<img src="/pictures/icons/strping.jpg" style="display:none"
					id="i_prasie">
			</div>
			<div class="col-xs-2 col-sm-2"></div>
		</div>
	</div>
	<hr class="hr" />

	<div id="d_content">
		
		<form class="content" action="/pictures/picture/commentsave">
			<input type="hidden" name="p_id" value="<c:out value="${p_id}"/>">
			<input type="text" name="c_content" class="i_c" id="c_content"
				onpropertychange="check();" /> <input class="l_c" type="submit"
				value="评论" name="comment1" disabled />
		</form>
		<c:forEach items="${comm}" var="c">
			<div class="blank-middle1">
				<div class="media">
					<p class="pull-left">
						<img class="media-object img-circle" src="${c.u_headurl}"
							id="u_headurl">
					</p>
					<div class="media-body">
						<h4 class="media-heading" id="u_name">${c.u_name}</h4>
						<p id="c_time">${c.c_time}</p>
					</div>
					<p id="c_content">${c.c_content}</p>
				</div>
			</div>
		</c:forEach>
	</div>

	<c:forEach items="${favor}" var="f">
		<div id="d_prasie" style="display:none;">
			<div class="blank-middle1">
				<div class="media">
					<p class="pull-left">
						<img class="media-object img-circle" src="${f.u_headurl}"
							id="u_headurl">
					</p>
					<div class="media-body">
						<h4 class="media-heading" id="u_name">${f.u_name}</h4>
						<p id="f_time">${f.f_time}</p>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>


</body>
</html>
