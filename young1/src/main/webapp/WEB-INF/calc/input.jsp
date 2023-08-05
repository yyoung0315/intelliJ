<%--
  Created by IntelliJ IDEA.
  User: eornz
  Date: 2023-08-04
  Time: 오후 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/calc/makeResult" method="post">
        <input type="number" name="num1"/>
        <input type="number" name="num2">
        <button type="submit"> SEND </button>
    </form>
</body>
</html>
