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
    账号：<input type="text" value="${username}"  name="username">

    <%-- 提示此账号已被注册--%>
    &nbsp;<span>${existedUsernameError}</span>

    <%-- 提示请输入账号--%>
    <span>${NullUsernameError}</span>

    <%-- 提示格式错误，不能包含空格--%>
    <span>${usernameHasNullStringError}</span>

    <br>

    密码：<input type="password" name="password">

    <%-- 提示请输入密码--%>
    &nbsp;<span>${NullPasswordError}</span>

    <%-- 提示格式错误，不能包含空格--%>
    <span>${passwordHasNullStringError}</span>

    <br>

    <input type="submit" value="注册">
</form>
</body>
</html>
