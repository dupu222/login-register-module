<%--
  Created by IntelliJ IDEA.
  User: pu
  Date: 2015/10/30 0030
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>XX网站</title>
</head>
<body>
<h1>XX网站</h1>
<form action="${pageContext.request.contextPath}/LoginController" method="post">
    <table border="1" width="738">
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
'${pageContext.request.contextPath}'
</body>
</html>
