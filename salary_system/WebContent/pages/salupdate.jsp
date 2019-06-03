<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <TITLE>修改员工</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="/css/Manage2.css" type=text/css rel=stylesheet>
    <LINK href="/css/Manage.css" type=text/css rel=stylesheet>
    <%--引入日期选择插件--%>
    <script type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script>

    <%--引入JQ--%>
    <script src="/js/jquery.min.js" type="text/javascript"></script>
    <%--消息--%>
    <script src="/js/messages_zh.js" type="text/javascript"></script>
    <%--引入校验框架--%>
    <script src="/js/jquery.validate.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(function(){
            // 对表单进行数据校验
            $("#form1").validate({
                // 表单提交句柄,为一回调函数，带一个参数：form
                submitHandler: function(form){
                    // 提交表单
                    form.submit();
                },
                rules:{
                    name:{
                        required:true
                    },
                    salary:{
                        required:true
                    },
                    welfare:{
                        required:true
                    },
                    award:{
                        required:true
                    }
                },
                messages:{
                    ename:{
                        required:"不能为空"
                    },
                    salary:{
                        required: "不能为空"
                    },
                    welfare:{
                        required: "不能为空"
                    },
                    award:{
                    	required: "不能为空"
                    }
                }
            });
        });

    </script>

</HEAD>
<BODY>

<FORM id="form1" name="form1" action="/SalupdateServlet" method="post">

    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
            <TR>
                <TD width=15>
                    <IMG src="/images/new_019.jpg" border=0>
                </TD>
                <TD width="100%" background="/images/new_020.jpg" height=20></TD>
                <TD width=15>
                    <IMG src="/images/new_021.jpg"border=0>
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
                        <TD class=manageHead>当前位置：工资管理 &gt; 修改工资</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>

                <TABLE cellSpacing=0 cellPadding=5  border=0>

                    <input type="hidden" name="id" value="${sal.id}"/>

                    <TR>
                        <td>员工名称</td>
                        <td>
                            <INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="name" value="${sal.name}" readonly="readonly">
                        </td>
                        <td>基本工资</td>
                        <td>
                            <INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="salary" value="${sal.base_salary}">
                        </td>
                        <td>绩效金</td>
                        <td>
                            <INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="welfare" value="${sal.base_welfare}">
                        </td>
                        <td>全勤奖励</td>
                        <td>
                            <INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="award" value="${sal.base_award}">
                        </td>
                    </TR>
					<tr>
                        <td rowspan=2>
                            <INPUT class=button id=sButton2 type=submit value="保存" name=sButton2>
                        </td>
                    </tr>
                    
                </TABLE>

            </TD>
            <TD width=15 background="/images/new_023.jpg">
                <IMG src="/images/new_023.jpg" border=0>
            </TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15>
                <IMG src="/images/new_024.jpg" border=0>
            </TD>
            <TD align=middle width="100%" background="/images/new_025.jpg" height=15></TD>
            <TD width=15>
                <IMG src="/images/new_026.jpg" border=0>
            </TD>
        </TR>
        </TBODY>
    </TABLE>
</FORM>
</BODY>
</HTML>