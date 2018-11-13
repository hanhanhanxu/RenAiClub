<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/9
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加资料-RenAiClub-super root权限</title>
</head>
<body>
<br/><br/>
<a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a><br/><br/>
    <form action="${pageContext.request.contextPath}/Admin/AddDataInfo.action" method="post">
        <table width="70%;" border="2px">
            <tr>
                <td>资料名称：</td>
                <td><input type="text" name="name" style="width: 200px"></td>
            <tr>
            <tr>
                <td>资料链接：</td>
                <td><input type="text" name="infourl" style="width: 200px" width="300px"></td>
            <tr>
            <tr>
                <td>资料密码：</td>
                <td><input type="text" name="infokey" style="width: 200px"></td>
            <tr>
            <tr>
                <td>资料介绍：</td>
                <td><textarea rows="4" cols="40" name="introduce"></textarea></td>
            </tr>
            <tr>
                <td>所属模块：</td>
                <td>
                    <select name="categoryId">
                        <c:forEach items="${category}" var="item">
                            <option value="${item.cid}">${item.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td><td><input type="submit" value="添加分类"></td>
            </tr>
        </table>
    </form>
</body>
</html>
