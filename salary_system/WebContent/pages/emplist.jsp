<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <TITLE>客户列表</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="/css/Manage2.css" type=text/css rel=stylesheet>
    <LINK href="/css/Manage.css" type=text/css rel=stylesheet>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/layer/layer.js"></script>

    <SCRIPT language=javascript>
        // 点击上一页或者下一页时，执行的方法，给隐藏域赋值，然后提交表单
        function to_page(num){
            // 如果传入了数字
            if(num){
                // 给隐藏域赋值
                $("#page").val(num);
            }
            // 提交form表单
            document.empForm.submit();
        }

        // 跳转到添加页面
        function add(){
            location.href = "/pages/empadd.jsp";
        }

        // 跳转到修改的页面
        function updateui(){
            // 调用获取选中长度的方法
            var len = selCheckboxNum();
            // 判断
            if(len == 1){
                // 说明选中一个
                var id = $("input[name='ids']:checked").val();
                location.href = "/empUpdateuiServlet?id="+id;
            }else{
                // 提示
                layer.msg('请选择一个',{
                    offset:'100px'
                });
            }
        }

        // 删除
        function del(){
            // 调用获取选中长度的方法
            var len = selCheckboxNum();
            // 判断
            if(len == 1){
                layer.confirm('确定删除吗?', {
                    btn: ['确定','取消'],
                    offset:'100px'
                }, function(){
                    var id = $("input[name='ids']:checked").val();
                    location.href = "/empDeleteServlet?id="+id;
                });
            }else{
                // 提示
                layer.msg('请选择一个',{
                    offset:'100px'
                });
            }
        }

        // 使用jquery获取到选中的复选框个数
        function selCheckboxNum(){
            // 获取选中的长度
            return $("input[name='ids']:checked").size();
        }

    </SCRIPT>

</HEAD>
<BODY>

<FORM id="empForm" name="empForm" action="/empListServlet" method=post>

    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15><IMG src="/images/new_019.jpg" border=0></TD>
            <TD width="100%" background="/images/new_020.jpg" height=20></TD>
            <TD width=15>
                <IMG src="/images/new_021.jpg" border=0>
            </TD>
        </TR>
        </TBODY>
    </TABLE>

    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15 background=/images/new_022.jpg>
                <IMG src="/images/new_022.jpg" border=0>
            </TD>
            <TD vAlign=top width="100%" bgColor=#ffffff>
                <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                    <TR>
                        <TD class=manageHead>当前位置：员工管理 &gt; 员工列表</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>

                <TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
                    <TBODY>
                    <TR style="height: 40px">
                        <TD height=25>
                            <TABLE cellSpacing=0 cellPadding=2 border=0>
                                <TBODY>
                                <TR>
                                    <TD>
                                        <input type="button" value="添加" onclick="add()"/>
                                    </TD>
                                    <TD>
                                        <input type="button" value="修改" onclick="updateui()"/>
                                    </TD>
                                    <TD>
                                        <input type="button" value="删除" onclick="del()"/>
                                    </TD>
                                    <td>总工资:${allMoney}</td>
                                </TR>
                                </TBODY>
                            </TABLE>
                        </TD>
                    </TR>

                    <TR>
                        <TD>
                            <TABLE id=grid style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
                                   cellSpacing=1 cellPadding=2 rules=all border=0>
                                <TBODY>
                                <TR style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none; height: 30px">
                                    <TD>操作</TD>
                                    <TD>序号</TD>
                                    <TD>员工名称</TD>
                                    <TD>员工年龄</TD>
                                    <TD>员工性别</TD>
                                    <TD>员工工资</TD>
                                    <TD>员工生日</TD>
                                    <TD>入职日期</TD>
                                </TR>

                                <c:forEach items="${page.beanList}" var="emp" varStatus="s">
                                    <TR style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none; height: 30px">
                                        <TD>
                                            <input type="checkbox" name="ids" value="${ emp.id }"/>
                                        </TD>
                                        <TD>${s.count}</TD>
                                        <TD>${emp.ename }</TD>
                                        <TD>${emp.age }</TD>
                                        <TD>${emp.sex }</TD>
                                        <TD>${emp.sal }</TD>
                                        <TD>${emp.birthday }</TD>
                                        <TD>${emp.edate }</TD>
                                    </TR>
                                </c:forEach>

                                </TBODY>
                            </TABLE>
                        </TD>
                    </TR>

                    <TR>
                        <TD>
                            <SPAN id=pagelink>
                                <DIV style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: center">
                                    <A href="javascript:to_page(${page.pageCode-1})">前一页</A>&nbsp;
                                    第<B>${page.pageCode}</B>页&nbsp;
                                    <A href="javascript:to_page(${page.pageCode+1})">后一页</A>&nbsp;
                                    共<B>${page.totalPage}</B>页&nbsp;
                                    <input type="hidden" size="3" id="page" name="pageCode"/>
                                </DIV>
                            </SPAN>
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
            <TD width=15><IMG src="/images/new_024.jpg"
                              border=0></TD>
            <TD align=middle width="100%"
                background="/images/new_025.jpg" height=15></TD>
            <TD width=15><IMG src="/images/new_026.jpg"
                              border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
</FORM>
</BODY>
</HTML>

