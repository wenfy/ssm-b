<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="../">
    <script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/laydate/laydate.js"></script>
    <script type="text/javascript" src="js/layer/layer.js"></script>
    <script  type="text/javascript"  src="js/H-ui.js"></script>
    <script  type="text/javascript"   src="js/H-ui.admin.js"></script>
</head>
<body>
<table border="2" >
    <thead>
    <tr>
        <th width="20%">名字</th>
        <th width="10%">身份</th>
        <th width="15%">操作</th>
    </tr>
    </thead>
    <tbody align="center">
    <c:forEach items="${requestScope.userList}" var="row">
        <tr>
            <td >${row.name}</td>
            <td >${row.statusname}</td>
            <td >
                <a href="edit?id=${row.id}">修改密码</a>|
                <a href="delete?id=${row.id}">注销</a>
            </td>

        </tr>
    </c:forEach>
    </div>
    </tbody>

</table>
</body>
</html>