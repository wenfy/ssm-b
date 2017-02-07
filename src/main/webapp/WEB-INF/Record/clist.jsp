<%--
  Created by IntelliJ IDEA.
  User: w-fy
  Date: 2017/1/12
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/laydate/laydate.js"></script>
    <script type="text/javascript" src="js/layer/layer.js"></script>
    <script  type="text/javascript"  src="js/H-ui.js"></script>
    <script  type="text/javascript"   src="js/H-ui.admin.js"></script>
    <style>

    </style>
</head>
<body>
<span class="span" name="comments">${requestScope.clist}</span><br>
<a href="http://localhost:8080/Record/index">返回</a>
</body>
</html>
