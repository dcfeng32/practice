<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login.jsp</title>
    <style type="text/css">
        * {
            padding: 0px;
            margin: 0px;
        }

        body {
            background: url(./images/01.jpeg) no-repeat center center;
            background-size: cover;
            background-attachment: fixed;
        }
        #center {
            width: 580px;
            height: 780px;
            margin: 500px auto;
            folat: left;
            background-color: darkturquoise;
        }
        #use_name {
            padding-left: 50px;
            padding-top: 80px;
        }
        #password {
            padding-left: 50px;
            padding-top: 40px;
        }
        #identifying_code {
            float: left;
            padding-left: 50px;
            padding-top: 40px;
        }
        #validate {
            float: left;
            padding-left: 10px;
            padding-top: 40px;
        }
        #z{
            folate:leaf;
        }
        #login {
            float: left;
            padding-left: 50px;
            padding-top: 180px;
        }
        #register {
            float: left;
            padding-left: 20px;
            padding-top: 180px;
        }

    </style>
</head>
<body>

<div id="center">
    <div id="use_name">
        <input type="text" name="usename" placeholder="请输入用户名"
               style="font-size:40px;width: 460px;height:80px"/>
    </div>

    <div id="password">
        <input type="password" name="password" placeholder="请输入密码"
               style="font-size:40px;width:460px; height:80px"/>
    </div>
    <div>
        <div id="identifying_code">
            <input type="text" name="name"  placeholder="验证码"
                   style="width:250px; height:80px;
                background-color:ghostwhite;font-size:40px "/>
        </div>
        <div id="validate">
            <img src="images/03.JPG" height="80px" />
        </div>
    </div>
    <div id="z">
        <div id="login">
            <button onclick="sub()" style="font-size:40px;width:220px; height:80px;
            background-color:springgreen">登录
            </button>
        </div>
        <div id="register">
            <button onclick="" style='font-size:40px;background-color:springgreen;
            width:220px; height:80px'>注册
            </button>
        </div>
    </div>
</div>
    <script type="text/javascript">
        function sub() {
            alert("登录成功")
        }
    </script>
</body>
</html>
