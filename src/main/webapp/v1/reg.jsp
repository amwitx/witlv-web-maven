<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
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
	<a href="logon.jsp">登录</a>
	<hr/>
	<form action="<%=request.getContextPath()%>/RegServlet" method="post">
	<input type="text" name="username" /><br/>
	<input type="text" name="password" /><br/>
	<select name="depart">
	<option>aa</option>
	<option selected="selected">bb</option>
	<option>cc</option>
	</select><br/>
	<input type="radio" name="sex" value="男"/>男
	<input type="radio" name="sex" value="女"/>女<br/>
	<input type="checkbox" name="role" value="0"/>管理员
	<input type="checkbox" name="role" value="1"/>普通员工<br/>
		<input type="text" name="valicode" /> <img alt="看不清换一张" title="看不清换一张"
			src="<%=request.getContextPath() %>/ValicodeServlet" id="valicode_img" onclick="changeImg();" />
			<input type="submit" value="提交"/>
	</form>
</body>
</html>