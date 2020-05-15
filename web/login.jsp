<%--
  Created by IntelliJ IDEA.
  User: Shoaib
  Date: 14-May-20
  Time: 2:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Welcome, please login</h2>

<form action="login" method="post">
    <label>Login-name</label>
    <input type="text" name="loginname" width="30"/>
    <label>Password</label>
    <input type="password" name="password" width="10"/>
    <input type="submit" value="submit">
</form>
<p style="color: red;">${errorMessage}</p>


</body>
</html>
