<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Domia
  Date: 3/12/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="customer" action="update" method="post" >
    ID:
    <form:input path="id"/><br>
    Name:
    <form:input path="name"/><br>
    Email:
    <form:input path="email"/><br>
    Address:
    <form:input path="address"/><br>
    <input type="submit" value="Send">

</form:form>
</body>
</html>
