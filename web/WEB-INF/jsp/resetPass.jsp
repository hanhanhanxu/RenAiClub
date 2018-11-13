<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/18
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重置密码-RenAiClub</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/UserInFo/resetPass.action" method="post">
        新密码：<input type="password" name="password" onkeyup="this.value=this.value.replace(/\s+/g,'')" required="required"><br>
        确认密码：<input type="password" name="password2" onkeyup="this.value=this.value.replace(/\s+/g,'')" required="required"><br>
        ${message}<br>
        <input type="submit" value="更 改">
    </form>

</body>
</html>
