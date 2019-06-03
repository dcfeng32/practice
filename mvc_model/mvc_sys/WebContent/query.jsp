<%@page import="com.yh.sys.domain.Role_info"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>query</title>
</head>
<body>
	<form action="query" method="post">
		角色名称：<input type="text" name="name" /> 
		       <input type="submit" value="查询" /> 
		       <a href="add.jsp">添加角色</a><br> <br> <br>
	</form>
	<table border="1">
		<tr> 
			<td>员工id</td>
			<td>名字</td>
			<td>简述</td>
			<td>用户标识</td>
			<td>操作</td>
		</tr>
		<%
			List<Role_info> list = (List<Role_info>) request.getAttribute("list");
			if (list != null && list.size() > 0) {
				for (Role_info info : list) {
		%>
		<tr>
			<td><%=info.getRole_id()%></td>
			<td><%=info.getRole_name()%></td>
			<td><%=info.getRole_desc()%></td>
			<td><%=info.getRole_mark()%></td>
			<td><a href="update?roleId=<%=info.getRole_id()%>">修改</a> | <a
				href="delete?id=<%=info.getRole_id()%>">删除</a></td>
		</tr>
		<%
			}
			}
		%>
	</table>
	<br>

	<form action="exit" method="post">
		<input type="submit" value="退出">
	</form>

</body>
</html>