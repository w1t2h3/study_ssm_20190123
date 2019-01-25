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
            账号：<input type="text" value="${username}" name="username">

            <%-- 输入的账户名在表中没有查到用户时，提示此账户名不存在 --%>
            &nbsp;<span>${notExistUsernameError}</span>

            <%-- 如果输入账号为空，提示请输入账户名 --%>
            <span>${NullUsernameError}</span>

            <br>

            密码：<input type="password" value="${password}" name="password">

            <%-- 如果输入密码与表中查到的密码不一致时，提示密码错误 --%>
            &nbsp;<span>${passwordError}</span>

            <%-- 如果输入密码为空，提示请输入密码 --%>
           <span>${NullPasswordError}</span>

            <br>

            <input type="submit" value="登录">
        </form>
</body>
</html>
