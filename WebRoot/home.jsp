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
<title>首页</title>
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
<script src="/pictures/jquery.touchslider.js" type="text/javascript"></script>
<link href="/pictures/css/shoot.css" rel="stylesheet" type="text/css" />
<script src="/pictures/shoot.js" type="text/javascript"></script>

</head>
<body>

	<div id="moveDiv" style="position:absolute;">
		<div class="container">
			<div class="row">
				<div class="col-xs-3 col-sm-3 total-head">
					<img src="/pictures/icons/select.jpg" class="img-header" id="btn" />
				</div>
				<div class="col-xs-6 col-sm-6">
					<h3 class="text-center">商大摄影圈</h3>
				</div>
				<div class="col-xs-3 col-sm-3 total-head right">
					<img src="/pictures/icons/list.jpg" class="img-header" id="btn1" />
				</div>
			</div>
		</div>
		<hr class="hr" />

		<div id="h_page">
			<c:forEach items="${card}" var="p">
				<div class="blank-middle">
					<div class="media">
						<p class="pull-left">
							<img class="media-object img-circle"
								src="/pictures/icons/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg"
								id="u_headurl">
						</p>

						<div class="media-body">
							<h4 class="media-heading" id="u_name">${p.u_name}</h4>
							<p id="p_time">${p.p_time}</p>
						</div>
					</div>
					<hr />
					<div style="height:16rem;text-align:center;padding:1rem">
						<img src="${p.p_url}" class="img-centre" id="p_url" />
					</div>
					<p class="p-three" id="p_description">${p.p_description}</p>
					<p class="right" id="p_name">————${p.p_name}</p>
				</div>

				<div class="container">
					<div class="row">
						<div class="col-xs-6 col-sm-6 blank-bottom">
							<form action="/pictures/picture/comment">
								<input type="hidden" name="p_id" value="${p.p_id}"> <input
									type="hidden" name="p_favornumber" value="${p.p_favornumber}"><input
										type="hidden" name="p_cnumber" value="${p.p_cnumber}">
											<p id="b_content">
												<input type="submit" src="/pictures/icons/comment.jpg"
													class="img-bottom" />评论
											</p>
							</form>
						</div>
						<div class="col-xs-6 col-sm-6 blank-bottom right">
							<form action="/pictures/picture/favor">
								<input type="hidden" name="u_id" value="${p.u_id}"> <input
									type="hidden" name="p_id" value="${p.p_id}">

										<p id="b_like">
											<input type="submit" background="/pictures/icons/praise.jpg"
												class="img-bottom" id="love" />喜欢
										</p>
							</form>
						</div>
					</div>
			</c:forEach>
		</div>
	</div>


	<c:forEach items="${list}" var="pl">
		<div id="h_page_two" style="display:none">
			<ul class="list-group">
				<li><a href="${pl.p_url} "><img src="${pl.p_url}"></a></li>
			</ul>
		</div>
	</c:forEach>

	<div id="mySelect" style=" background-color:#fff;">
		<p>
			<img class="img-circle"
				src="/pictures/icons/Cg-4y1ULoXCII6fEAAeQFx3fsKgAAXCmAPjugYAB5Av166.jpg"
				id="u_headurl">
		</p>
		<p id="u_name">叶晨轶</p>
		<p>
			<img src="/pictures/icons/praise1.jpg" style="height:1rem;" />收获的赞：
			<span id="u_favornumber">1506</span>
		</p>
		<div class="list-group">
			<a href="/pictures/picture/upload" class="list-group-item">
				<h4 class="list-group-item-heading">上传照片</h4> <img
				src="/pictures/icons/line.jpg" width="100%">
			</a> <a href="my_photo.html" class="list-group-item">
				<h4 class="list-group-item-heading">我的照片</h4> <img
				src="/pictures/icons/line.jpg" width="100%">
			</a> <a href="my_like.html" class="list-group-item">
				<h4 class="list-group-item-heading">我喜欢的</h4> <img
				src="/pictures/icons/line.jpg" width="100%">
			</a> <a href="/pictures/picture/picturerank" class="list-group-item">
				<h4 class="list-group-item-heading">照片排行</h4> <img
				src="/pictures/icons/line.jpg" width="100%">
			</a>
		</div>
	</div>
</body>
</html>
