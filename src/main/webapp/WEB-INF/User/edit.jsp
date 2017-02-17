<%--
  Created by IntelliJ IDEA.
  User: w-fy
  Date: 2017/1/12
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="../">
    <script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script>
    <script>
    </script>

</head>
<body>


<c:if test="${requestScope.info==null }">
    <form class="f1" action="User/insert" method="post">
        <label  class="title"><b>姓名：</b></label><br>
        <input id="input1" name="name" /><br>

        <label class="title"><b>密码：</b></label><br>
        <input id="input2" name="password" type="text"></input><br>

        <label class="title"><b>身份：</b></label><br>
        <select class="input" name="status">
        <c:forEach var="r" items="${requestScope.status }" varStatus="v">
            <option value="${v.index}">${r }</option>
        </c:forEach>
    </select><br>

        <button type="submit" >保存</button>
    </form>
</c:if>

</body>
</html>
