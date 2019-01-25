<%--
  Created by IntelliJ IDEA.
  User: 0
  Date: 2019/1/24
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Regist</title>
    <style>
        span{color: red}
    </style>
</head>
<body>
<form action="regist" method="post">
    账户：<input type="text" value="${username}"  name="username">
    &nbsp;<span>${existedUsernameError}</span>
    <span>${NullUsernameError}</span>
    <span>${usernameHasNullStringError}</span>
    <br>

    密码：<input type="password" name="password">
    &nbsp;<span>${NullPasswordError}</span>
    <span>${passwordHasNullStringError}</span>
    <br>

    <input type="submit" value="注册">
</form>
</body>
</html>
