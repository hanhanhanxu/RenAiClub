<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/17
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码-RenAiClub</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/UserInFo/ModifyPass.action" method="post">
        <table>
            <tbody>
                <tr>
                    <td>旧密码：<input type="text" name="oldPass"></td>
                </tr>
                <tr>
                    <td>新密码：<input type="password" name="password" onkeyup="this.value=this.value.replace(/\s+/g,'')" required="required"></td>
                </tr>
                <tr>
                    <td>确认密码：<input type="password" name="password2" onkeyup="this.value=this.value.replace(/\s+/g,'')" required="required"></td>
                </tr>
                <tr>
                    <td>${message}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="提 交"></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
