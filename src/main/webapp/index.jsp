<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pu
  Date: 2015/10/30 0030
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>XX网站</title>
</head>
<body>
<h1>XX网站</h1>
<c:if test="${sessionScope.user==null}">
    <a href="${pageContext.request.contextPath}/login.jsp">登录</a>
    <a href="${pageContext.request.contextPath}/regist.jsp">注册</a>
</c:if>
<c:if test="${sessionScope.user!=null}">
    欢迎您,${sessionScope.user.username}!
    <a href="${pageContext.request.contextPath}/LogoutController">注销</a>
</c:if>
</body>
</html>
