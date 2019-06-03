<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Admin Header</title>
    <link href="/css/header.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" language="javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript">
        var oplist = new Array('about', 'user', 'news', 'mars', 'jielong', 'box', 'school', 'config', 'other');
        $(document).ready(function() {
            $('#nav').find("a").click(function() {
                var id = $(this).attr('id');
                $.each(oplist, function(i, n) {
                    $('#'+n).attr('class', 'inactive');
                });
                $(this).parents("li").attr('class', 'active');
            });
        });
    </script>
</head>

<body>
<div id="all">
    <div id="banner"><h1>信息管理系统&nbsp;&nbsp;&nbsp;</h1></div>
    <div id="nav">
        <ul>
            <li class="inactive" id="other"><a href="https://www.ahedu.gov.cn/zwgkpage" target="_blank">省教育厅</a></li>
            <li class="inactive" id="about"><a href="https://wenku.baidu.com/view/dab594e9571252d380eb6294dd88d0d233d43c8e.html" target="_blank">实习公司</a></li>
            <li class="inactive" id="user"><a href="http://www.wendaedu.com.cn" target="_blank">文达学院</a></li>
        </ul>
    </div>
    <div id="main">
        <div id="welcome">
            欢迎您：${user.nickname}
            <%--<img src="/images/clock.gif" />--%>
        </div>
        <div id="adminop">
            <ul>
                <li><a href="/userExistServlet" target="_parent">用户退出</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
