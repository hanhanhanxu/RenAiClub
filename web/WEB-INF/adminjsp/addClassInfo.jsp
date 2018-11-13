<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/18
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加年级信息-RenAiClub</title>
</head>
<body>
<br/>
<a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a><br/><br/>

    <form action="${pageContext.request.contextPath}/Admin/AddClassInfo.action" method="post">
        <table>
            <tbody>
            <tr>
                <td>班级代号：</td>
                <td><input type="text" name="classnum"></td>
            </tr>
            <tr>
                <td>班级名称：</td>
                <td><input type="text" name="classname"></td>
            </tr>
            </tbody>
        </table>

        <input type="submit" value="提 交">
    </form>

</body>
</html>
