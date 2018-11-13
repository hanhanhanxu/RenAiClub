<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/9
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加模块-RenAiClub-super root权限</title>
</head>
<body>
<br/><br/>
<a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a><br/><br/>
    <form action="${pageContext.request.contextPath}/Admin/AddModular.action" method="post">
        <table width="500px;">

            <tr>
                <td>模块名称：</td>
                <td><input type="text" name="name" style="width: 200px"></td>
            <tr>
            <tr>
                <td>模块描述：</td>
                <td><textarea rows="4" cols="40" name="description"></textarea></td>
            </tr>
            <tr>
                <td></td><td><input type="submit" value="添加模块"></td>
            </tr>
        </table>
    </form>
</body>
</html>
