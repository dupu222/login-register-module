<%--
  Created by IntelliJ IDEA.
  User: pu
  Date: 2015/10/30 0030
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>XX网站</title>
</head>
<body>
<h1>用户注册</h1>
<form action="${pageContext.request.contextPath}/RegistController" method="post">
    <table border="1" width="738">
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" value="${requestScope.webuserbean.username}"><font color="red">${requestScope.webuserbean.errors.username}<font>${requestScope.webuserbean.errors.username}</td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" value="${requestScope.webuserbean.password}"><font color="red">${requestScope.webuserbean.errors.password}<font></td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input type="password" name="repassword" value="${requestScope.webuserbean.repassword}"><font color="red">${requestScope.webuserbean.errors.repassword}<font></td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td><input type="text" name="email" value="${requestScope.webuserbean.email}"><font color="red">${requestScope.webuserbean.errors.email}<font></td>
        </tr>
        <tr>
            <td>出生日期(yyyy-MM-dd):</td>
            <td><input type="text" name="birthday" value="${requestScope.webuserbean.birthday}"><font color="red">${requestScope.webuserbean.errors.birthday}<font></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" ></td>
        </tr>
    </table>
</form>
</body>
</html>
