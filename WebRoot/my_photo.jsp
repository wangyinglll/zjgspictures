<%@ page language="java" import="java.util.*" pageEncoding="utf_8"%>
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
<title>我的照片</title>
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
			<div class="col-xs-3 col-sm-3 total-head">
				<a href="home_page.html"> <img src="icons/back.jpg"
					class="img-header" />
				</a>
			</div>
			<div class="col-xs-6 col-sm-6">
				<h3 class="text-center">我的照片</h3>
			</div>
			<div class="col-xs-3 col-sm-3 total-head right">
				<img src="icons/list.jpg" class="img-header" id="btn1" />
			</div>
		</div>
	</div>
	<hr class="hr" />

	<div id="h_page">
		<div class="blank-middle">
			<div class="media">
				<p class="pull-left">
					<img class="media-object img-circle"
						src="icons/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg"
						id="u_headurl">
				</p>
				<div class="media-body">
					<div class="row">
						<div class="col-xs-8 col-sm-8">
							<h4 class="media-heading" id="u_name">大王叫我去巡山</h4>
							<p id="p_time">2015.12.3 11:11</p>
						</div>
						<div class="col-xs-4 col-sm-4">
							<img src="icons/praise1.jpg" style="height:1.5rem;" /> <a
								href="" id="p_favornumber">1506</a>
						</div>
					</div>

				</div>
			</div>
			<hr />
			<div style="height:16rem;text-align:center;padding:1rem">
				<img src="images/2140.jpg" class="img-centre" id="p_url" />
			</div>
			<p class="p-three" id="p_description">饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！饿了吗？快点吃！</p>
			<p class="right" id="p_name">————来自麻麻的提醒</p>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-xs-6 col-sm-6 blank-bottom">
					<a href="comment.html" id="b_content"> <img
						src="icons/comment.jpg" class="img-bottom" />评论
					</a>
				</div>
				<div class="col-xs-6 col-sm-6 blank-bottom right">
					<a href="" id="last">
						<p id="">下一张</p>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div id="h_page_two" style="display:none">
		<ul class="list-group">
			<li><a href="#"><img src="images/2140.jpg"></a></li>
			<li><a href="#"><img
					src="images/76094b36acaf2edd4509ec048f1001e938019367.jpg"></a></li>
			<li><a href="#"><img src="images/231316p19paxp1p8q118qj.jpg"></a>
			</li>
			<li><a href="#"><img src="images/318752-15030309221958.jpg"></a>
			</li>
			<li><a href="#"><img src="images/111010114Z4-16.jpg"></a>
			</li>
			<li><a href="#"><img src="images/20110906212618_8GZcM.jpg"></a>
			</li>
			<li><a href="#"><img
					src="images/20130901131015_kyk8r.thumb.700_0.jpg"></a></li>
			<li><a href="#"><img
					src="images/20131104215251_ruRek.thumb.700_0.jpg"></a></li>
			<li><a href="#"><img src="images/20110906212618_8GZcM.jpg"></a>
			</li>
			<li><a href="#"><img
					src="images/u=789299692,3717548639&fm=21&gp=0.jpg"></a></li>
			<li><a href="#"><img src="images/20110906212618_8GZcM.jpg"></a>
			</li>
			<li><a href="#"><img
					src="images/20130901131015_kyk8r.thumb.700_0.jpg"></a></li>
			<li><a href="#"><img
					src="images/20131104215251_ruRek.thumb.700_0.jpg"></a></li>
			<li><a href="#"><img src="images/20110906212618_8GZcM.jpg"></a>
			</li>
			<li><a href="#"><img
					src="images/u=789299692,3717548639&fm=21&gp=0.jpg"></a></li>
		</ul>

	</div>

</body>
</html>
