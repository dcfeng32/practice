<%@page import="com.yh.sys.domain.Role_info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色修改</title>
</head>
<body>
	<form action="update" method="post">
		<%
			Role_info info = (Role_info) request.getAttribute("info");
		%>

		<input type="hidden" name="roleId" value="${info.role_id }" />
		
		<h5>基本信息</h5>
		<div>
			角色名称 <input type="text" name="roleName" value="${info.role_name }" />
		</div>
		<h5>描述信息</h5>
		角色描述<input type="text" name="roleDesc" value="${info.role_desc }"><br>
		<br> <input type="submit" value="保存角色" /> <input type="reset"
			value="重置信息" />
	</form>
</body>
</html>



