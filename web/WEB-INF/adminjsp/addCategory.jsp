<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/9
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加分类-RenAiClub-super root权限</title>
</head>
<body>
<br/><br/>
<a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a><br/><br/>
    <form action="${pageContext.request.contextPath}/Admin/AddCategory.action" method="post">
        <table width="500px;">
            <tr>
                <td>分类名称：</td>
                <td><input type="text" name="name" style="width: 200px"></td>
            <tr>
            <tr>
                <td>分类描述：</td>
                <td><textarea rows="4" cols="40" name="description"></textarea></td>
            </tr>
            <tr>
                <td>所属模块：</td>
                <td>
                    <select name="modularId">
                        <c:forEach items="${modular}" var="item">
                            <option value="${item.mid}">${item.name}</option>
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
