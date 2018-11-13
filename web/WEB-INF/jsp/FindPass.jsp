<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/18
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码-RenAiClub</title>
</head>
<body>
<br><br>
<a href="${pageContext.request.contextPath}/UILoad/LoadIndex.action">去首页</a>
<br><br>
    <form action="${pageContext.request.contextPath}/LoginAndRegist/seachAccount.action" method="post">
        <table>
            <tbody>
            <tr>
                <td>请输入忘记密码的账号：</td>
                <td><input type="text" name="username" value="${user.username}"></td>
            </tr>
            <tr>
                <td colspan="2">${message}</td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="好 的"></td>
            </tr>
            </tbody>
        </table>
    </form>

    <c:if test="${userSecurity!=null}">
        <form action="${pageContext.request.contextPath}/LoginAndRegist/findAccount.action" method="post">
            <table>
                <tbody>
                <tr>
                    <td>密保问题：</td>
                    <td><input type="text" name="question" value="${userSecurity.question}" readonly  unselectable="on" ></td>
                </tr>
                <tr>
                    <td>密保答案：</td>
                    <td><input type="text" name="answer" ></td>
                </tr>
                <tr>
                    <td colspan="2">${message2}</td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="提 交"></td>
                </tr>
                </tbody>
            </table>
        </form>
    </c:if>

</body>
</html>
