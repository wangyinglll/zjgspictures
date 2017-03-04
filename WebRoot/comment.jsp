<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'comment.jsp' starting page</title>

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



	<table>

		<tr>

			<th>评论内容</th>
			<th>评论时间</th>
			<th>用户名</th>
			<th>用户头像</th>
		</tr>
		<c:forEach items="${comm}" var="c">
			<tr>

				<td><p>${c.c_content}</p></td>
				<td><p>${c.c_time}</p></td>
				<td><p>${c.u_name}</p></td>
				<td><p>${c.u_headurl}</p></td>
			</tr>
		</c:forEach>
	</table>



	<form action="/pictures/picture/commentsave">

		<input type="hidden" name="p_id" value="<c:out value="${p_id}"/>">

		<input type="text" name="c_content" placeholder="请输入评论" />
		<p>
			<button type="submit">评论</button>
		</p>
	</form>



	<form action="/pictures/picture/comment">
		<c:forEach items="${page}" var="page">
			<input type="submit" name="pageNumber" value="${page}">
		</c:forEach>
	</form>




</body>
</html>
