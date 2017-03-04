<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>赞</title>
<meta name="Keywords" content="" />
<meta name="author" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />


<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/shoot.css" rel="stylesheet" type="text/css" />
<script src="js/shoot.js" type="text/javascript"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-2 col-sm-2 total-head">
				<a href="home_page.html"> <img src="icons/back.jpg"
					class="img-header" />
				</a>
			</div>
			<div class="col-xs-4 col-sm-4 text-center">
				<h3>
					评论<span id="p_cnumber"></span>
				</h3>
			</div>
			<div class="col-xs-4 col-sm-4 text-center">
				<h3>
					赞<span id="p_favornumber"></span>
				</h3>
				<img src="icons/strping.jpg">
			</div>
			<div class="col-xs-2 col-sm-2"></div>
		</div>
	</div>
	<hr class="hr" />

	<div id="d_prasie">
		<div class="blank-middle1">
			<div class="media">
				<p class="pull-left">
					<img class="media-object img-circle"
						src="icons/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg"
						id="u_headurl">
				</p>
				<div class="media-body">
					<h4 class="media-heading" id="u_name">大王叫我去巡山</h4>
					<p id="f_time">2015.12.3 11:11</p>
				</div>
			</div>
		</div>
		<div class="blank-middle1">
			<div class="media">
				<p class="pull-left">
					<img class="media-object img-circle"
						src="icons/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg"
						id="u_headurl">
				</p>
				<div class="media-body">
					<h4 class="media-heading" id="u_name">大王叫我去巡山</h4>
					<p id="f_time">2015.12.3 11:11</p>
				</div>
			</div>
		</div>

		<div class="blank-middle1">
			<div class="media">
				<p class="pull-left">
					<img class="media-object img-circle"
						src="icons/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg"
						id="u_headurl">
				</p>
				<div class="media-body">
					<h4 class="media-heading" id="u_name">大王叫我去巡山</h4>
					<p id="f_time">2015.12.3 11:11</p>
				</div>
			</div>
		</div>

		<div class="blank-middle1">
			<div class="media">
				<p class="pull-left">
					<img class="media-object img-circle"
						src="icons/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg"
						id="u_headurl">
				</p>
				<div class="media-body">
					<h4 class="media-heading" id="u_name">大王叫我去巡山</h4>
					<p id="f_time">2015.12.3 11:11</p>
				</div>
			</div>
		</div>

		<div class="blank-middle1">
			<div class="media">
				<p class="pull-left">
					<img class="media-object img-circle"
						src="icons/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg"
						id="u_headurl">
				</p>
				<div class="media-body">
					<h4 class="media-heading" id="u_name">大王叫我去巡山</h4>
					<p id="f_time">2015.12.3 11:11</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
