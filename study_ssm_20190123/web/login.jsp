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
    <title>Login</title>
    <style>
        span{color: red}
    </style>
</head>
<body>
        <form action="login" method="get">
            账户：<input type="text" value="${username}" name="username">
            &nbsp;<span>${notExistUsernameError}</span>
            <span>${NullUsernameError}</span>
            <br>
            密码：<input type="password" value="${password}" name="password">
            &nbsp;<span>${passwordError}</span>
           <span>${NullPasswordError}</span>
            <br>
            <input type="submit" value="登录">
        </form>
</body>
</html>
