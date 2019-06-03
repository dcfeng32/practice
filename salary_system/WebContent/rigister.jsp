<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册中心</title>
</head>
<body>
	<form action="RigisterServlet" method="post">
		请输入姓名：<input type="text" name="name"><br> 
		请输入年龄：<input type="text" name="age"><br> 
		请输入性别：<input type="text" name="sex"><br> 
		请输入帐号：<input type="text" name="account"><br>
		请输入密码：<input type="password" name="pwd"><br> 
		请确认密码：<input type="password" name="pwd1"><br>
		<button type="submit">提交</button> <br>
	</form>
</body>
</html>