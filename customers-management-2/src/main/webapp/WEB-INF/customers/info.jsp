<%--
  Created by IntelliJ IDEA.
  User: Domia
  Date: 3/12/2021
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tbody>
    <tr>
        <td>ID:</td>
        <td>${customer.id}</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${customer.name}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${customer.email}</td>
    </tr>
    <tr>
        <td>Address:</td>
        <td>${customer.address}</td>
    </tr>
    </tbody>
    <a href="/index">Back</a>
</table>
</body>
</html>
