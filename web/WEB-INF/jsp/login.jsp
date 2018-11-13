<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/2
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>RenAiClub-登录或创建账号</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body>
    <div style="text-align: center">
        <br>
        <h1>登录到RenAiClub以了解更多内容</h1>
        <br><br>
        <span>输入您的RenAi账户</span>
        <span id="forget"><a href="${pageContext.request.contextPath}/UILogin/FindPass.action">我忘记了我的密码</a></span>
        <br><br>
        ${message}
        <br><br>
        <span>
        <form action="${pageContext.request.contextPath}/LoginAndRegist/login.action" method="post">
            *您的登录账号：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="username" onkeyup="this.value=this.value.replace(/\s+/g,'')" required>
            ${form.errors.username}
            <br>
            *您的登录密码：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="password" name="password" onkeyup="this.value=this.value.replace(/\s+/g,'')" required>
            ${form.errors.password}
            <br><br><br><br>
            <input type="submit" value="继   续">
        </form>
    </span>

        <br>
        <%--<input type="checkbox" name="remeber" value="yes">记住我--%>
        <br>
        没有账号？<a href="${pageContext.request.contextPath}/UILoad/LoadRegist.action">加入RenAi</a>

    </div>
</body>
</html>
