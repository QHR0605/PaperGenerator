<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<h1>用户注册</h1>
	<!-- 数据私密、太长要使用post传输给服务器 -->
	<!--  -->
	<form action="sendsms.do" method="post">
		<p>请输入手机号:</p>
		<p>
			<input type = "text" name="number" />
		</p>
		<p>请输入验证码:</p>
		<p>
			<input type = "text" name="varifcode" />
		</p>
		<p>
			<input type="submit" value="提交" />
		</p>

	</form>

</body>
</html>