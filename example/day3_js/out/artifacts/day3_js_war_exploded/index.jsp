<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>

  <body>
<h2>热门动漫</h2>
  <table  border = "1" width="300px ">
    <tr> <td>动漫名字</td> <td>类型</td> <td>播放量</td></tr>
    <tr> <td>斗罗大陆</td> <td>魔幻</td> <td>52亿</td></tr>
    <tr> <td>狐妖小红娘</td> <td>爱情</td> <td id = "td_box_office">播放量</td></tr>
  </table><br/>
  <input type = "text" name = "name" id = "box_office">
  <button onclick = "sub()">设置票房</button>

  <script type = "text/javascript">
    function sub(){
        var box_office = Document.getElementById("box_office");
        var value = box_office.value;//input中默认有value，可以直接使用

        var td_box_office = Document.getElementById("td_box_office");
        td_box_office.innerHTML = value;
    }
  </script>

  </body>
</html>
