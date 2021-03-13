<%--
  Created by IntelliJ IDEA.
  User: Domia
  Date: 3/13/2021
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Cal</title>
</head>
<body>
<h2>Calculator</h2>
<form action="cal">
    <div>
        <input type="text" name="one">
        <input type="text" name="two">
    </div>
    <div>
        <input type="submit" value="add" name="func">
        <input type="submit" value="sub" name="func">
        <input type="submit" value="mul" name="func">
        <input type="submit" value="div" name="func">
    </div>
    <h3>${result}</h3>
</form>
</body>
</html>
