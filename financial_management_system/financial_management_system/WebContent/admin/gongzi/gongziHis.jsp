<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/jsxx/jsxxBus.js"></script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<%-- <tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background="<%=path %>/img/tbg.gif">&nbsp;个人历史工资&nbsp;</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td colspan="6" >
						<form action="<%=path %>/zhigong?type=zhigongMana" method="post">
							职工编号:<input type="text" name="bianhao" value="${bianhao }"/>
							<input type="submit" value="查询"/>
						</form>
					</td>
				</tr> --%>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td>编号</td>
					<td>基本工资</td>
					<td>工龄工资</td>
					<td>职务工资</td>
					<td>补贴工资</td>
					<td>合计</td>
					<td>日期</td>
		        </tr>	
				<c:forEach items="${history}" var="zhigong1">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${zhigong1.id}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zhigong1.jiben}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zhigong1.gongling}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zhigong1.zhiwu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zhigong1.butie}
					</td>
						<td bgcolor="#FFFFFF" align="center">
						${zhigong1.hj}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zhigong1.date}
					</td>				
				</tr>
				</c:forEach>
			</table>
			
			<!-- <table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="zhigongAdd()" />
			    </td>
			  </tr>
		    </table> -->
	</body>
</html>
