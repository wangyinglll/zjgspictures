<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排行榜</title>
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
			<div class="col-xs-3 col-sm-3 total-head">
				<a href="home_page.html"> <img src="/pictures//icons/back.jpg"
					class="img-header" />
				</a>
			</div>
			<div class="col-xs-6 col-sm-6">
				<h3 class="text-center">排行榜</h3>
			</div>
			<div class="col-xs-3 col-sm-3"></div>
		</div>
	</div>
	<hr class="hr" />
	<c:forEach items="${rank}" var="c">
		<div class="blank-middle1">
			<div class="media">
				<p class="pull-left">
					<img class="media-object img-circle"
						src="/pictures/icons/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg"
						id="u_headurl">
				</p>
				<div class="media-body">
					<div class="row">
						<div class="col-xs-8 col-sm-8">
							<h4 class="media-heading" id="u_name">${c.u_name}</h4>
							<p id="p_time">${c.p_time}</p>
						</div>
						<div class="col-xs-4 col-sm-4">
							<a href="comment.html" id="p_favornumber"><img
								src="/pictures/icons/praise1.jpg" style="height:1.5rem;" />${c.p_favornumber}</a>
						</div>
					</div>
				</div>
			</div>
			<div class="media">
				<img class="pull-left media-object head-portrait1" src="${c.p_url}"
					id="p_url">
				<div class="media-body">
					<h5 class="media-heading" id="p_name">${c.p_name}</h5>
					<p id="p_description" class="flow">${c.p_description}</p>
				</div>
			</div>
		</div>
	</c:forEach>

	</div>
</body>
</html>
