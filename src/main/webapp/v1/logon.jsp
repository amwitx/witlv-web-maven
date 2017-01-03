<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<script type="text/javascript">
	//刷新验证码
	function changeImg() {
		document.getElementById("valicode_img").src = "http://localhost:8080/witlv-web-maven/ValicodeServlet?"
				+ Math.random();
	}
</script>
</head>
<body>
	<a href="index.jsp">首页</a>|
	<a href="reg.jsp">注册</a>
	<hr />
	<form action="/LoginServlet" method="post">
		<input type="text" name="valicode" /> <img alt="看不清换一张" title="看不清换一张"
			src="http://localhost:8080/witlv-web-maven/ValicodeServlet" id="valicode_img" onclick="changeImg();" />
	</form>
</body>
</html>