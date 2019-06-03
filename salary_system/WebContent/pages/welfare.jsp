<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<LINK href="/css/Manage2.css" type=text/css rel=stylesheet>
<LINK href="/css/Manage.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/layer/layer.js"></script>
</head>
<body>
	<FORM id="empForm" name="empForm" action="/empListServlet" method=post>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="/images/new_019.jpg" border=0></TD>
					<TD width="100%" background="/images/new_020.jpg" height=20></TD>
					<TD width=15><IMG src="/images/new_021.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=/images/new_022.jpg><IMG
						src="/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：工资管理</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>

						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR style="height: 40px">
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>

													<TD><input type="button" value="修改"
														onclick="updateui1()" /></TD>

												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>

								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none; height: 30px">
													<td>操作</td>
													<TD>序号</TD>
													<TD>员工名称</TD>
													<TD>基本工资</TD>
													<TD>绩效金</TD>
													<TD>全勤奖励</TD>
													<TD>总工资</TD>

												</TR>

												<c:forEach items="${welfareList}" var="list" varStatus="s">
													<TR
														style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none; height: 30px">
														<TD><input type="checkbox" name="ids"
															value="${list.id }" /></TD>
														<TD>${s.count}</TD>
														<TD>${list.name }</TD>
														<TD>${list.base_salary }</TD>
														<TD>${list.base_welfare }</TD>
														<TD>${list.base_award }</TD>
														<TD>${list.base_salary+list.base_welfare+list.base_award }</TD>
													</TR>
												</c:forEach>

											</TBODY>
										</TABLE>
									</TD>
								</TR>



							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="/images/new_023.jpg"><IMG
						src="/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="/images/new_024.jpg" border=0></TD>
					<TD align=middle width="100%" background="/images/new_025.jpg"
						height=15></TD>
					<TD width=15><IMG src="/images/new_026.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>

	<SCRIPT language=javascript>
		// 跳转到修改的页面
		function updateui1() {
			// 调用获取选中长度的方法
			var len = selCheckboxNum();
			// 判断
			if (len == 1) {
				// 说明选中一个
				var id = $("input[name='ids']:checked").val();
				location.href = "/SalUpdateuiServlet?id=" + id;
			} else {
				// 提示
				layer.msg('请选择一个', {
					offset : '100px'
				});
			}
		}

		// 使用jquery获取到选中的复选框个数
		function selCheckboxNum() {
			// 获取选中的长度
			return $("input[name='ids']:checked").size();
		}
	</SCRIPT>
</body>
</html>