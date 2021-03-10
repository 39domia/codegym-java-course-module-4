<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Domia
  Date: 3/10/2021
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <a href="/showAdd">Add</a>
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>email</td>
        <td>address</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cuslist}" var="cus">
        <tr>
            <td>${cus.id}</td>
            <td>${cus.name}</td>
            <td>${cus.email}</td>
            <td>${cus.address}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
