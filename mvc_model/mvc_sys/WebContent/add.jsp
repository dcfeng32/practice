<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>添加用户</title>
</head>
<body>
	<div>
		<form action="add" method="post">
			<div>
				用户名：<input type="text" name="username">
			</div>
			<div>
				描&nbsp;&nbsp;&nbsp;&nbsp;述：<input type="text" name="userdesc">
			</div>
			<div>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="submit" value="添加">&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="reset" value="重置">
			</div>
		</form>
	</div>

</body>
</html>