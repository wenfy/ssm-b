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
    <base href="../">
    <script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script>
    <script>
        function getUrl() {
            var url=document.getElementById("a").innerText;
            location.href="Record/urlSearch?fileUrl="+url;
        }
    </script>
</head>
<body>
<span class="span" name="comments">${requestScope.cList}</span><br>
<c:forEach items="${requestScope.nameList}" var="file" varStatus="r">
    <a id="a" href="javascript:getUrl()">${file}</a><br>
</c:forEach>
<a href="http://localhost:8080/Record/index2">返回</a>
</body>
</html>
