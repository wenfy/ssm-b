<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script>
    <style>
        button{margin-left: 60px}
        a{margin-left: 60px;margin-top: 0px}
    </style>
</head>
<body>
<table>
    <form class="f1" action="User/seach" method="post">
        <label  class="title"><b>姓名：</b></label>
        <input id="input1" name="name" /><br>

        <label class="title"><b>密码：</b></label>
        <input id="input2" name="password" type="text"></input><br>
        <button type="submit" >登录</button>
    </form>
</table>

</body>
</html>
