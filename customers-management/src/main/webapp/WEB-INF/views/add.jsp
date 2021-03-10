<%--
  Created by IntelliJ IDEA.
  User: Domia
  Date: 3/10/2021
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<c:form action="/add" method="post" modelAttribute="customer">
    <c:input path="id" type="number" min="0" step="1" /><br>
    <c:input type="text" path="name"/><br>
    <c:input type="email" path="email"/><br>
    <c:input path="address"/><br>
    <input type="submit" value="Send">
</c:form>
</body>
</html>
