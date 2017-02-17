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
    <base href="../">
    <script type="text/javascript" src="js/jquery/1.9.1/jquery.min.js"></script>
    <style>
        #a2{margin-left: 1300px;margin-top: 2px}
    </style>
</head>
<body>
<a id="a2" href="http://localhost:8080/login">退出</a>
<table border="2" >
    <thead>
    <tr>
        <th width="20%">标题</th>
        <th width="10%">时间</th>
        <th width="15%">操作</th>
    </tr>
    </thead>
    <tbody align="center">
    <c:forEach items="${requestScope.recordList}" var="row">
        <tr>
            <td >${row.name}</td>
            <td >${row.data}</td>
            <td >
                <a href="../Record/look?id=${row.id}">查看内容</a>||
               <a href="../Record/delete?id=${row.id}">删除</a>
            </td>

        </tr>
    </c:forEach>
    </div>
    </tbody>

</table>
 <a href="../Record/add">编写日志</a>

</body>
</html>
