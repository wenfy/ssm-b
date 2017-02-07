<%--
  Created by IntelliJ IDEA.
  User: w-fy
  Date: 2017/1/11
  Time: 16:40
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

</head>
<body>
<c:if test="${requestScope.info==null }">
    <form class="f1" action="insert" method="post">
        <label class="title"><b>标题：</b></label><br>
        <input name="name" /><br>

        <label class="title"><b>日志内容：</b></label><br>
        <textarea name="comments" type="text"></textarea><br>
        <button type="submit">保存</button>
    </form>
</c:if>


<c:if test="${requestScope.info!=null }">
    <form class="f2" action="update" method="post">
        <input type="hidden" name="id" value="${requestScope.info.id}"/><br>

        <label class="title"><b>标题：</b></label><br>
        <input name="name" value="${requestScope.info.name}"/><br>

        <label class="title"><b>日志内容：</b></label><br>
        <textarea name="comments" type="text" >${requestScope.info.comments}</textarea><br>
        <button type="submit">保存</button>
    </form>
</c:if>

</body>
</html>
