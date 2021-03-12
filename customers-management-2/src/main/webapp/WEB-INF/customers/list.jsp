<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="/showAdd">Add</a>
</div>
<div>
    <table>
        <thead>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>email</td>
            <td>address</td>
            <td>action</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><a href="/view/${customer.id}">${customer.id}</a></td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>
                    <a href="/showEdit/${customer.id}">Edit</a>
                    <a href="/delete/${customer.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
