<%--
  Created by IntelliJ IDEA.
  User: 青墨
  Date: 2018/8/30
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情</title>
    <style type="text/css">
        input{
            border: none;
            width: 100%;
        }
        td{
            padding: auto;
            margin: auto;
        }
        textarea{
            border: none;
            width: auto;
            height: auto;
        }
    </style>
    <script>
        var p = ${p};
        if(p!="" || p!=null){
            alert("修改成功");
        }
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath}/Admin3/ListPro.action">返回</a>

<form action="${pageContext.request.contextPath}/Admin3/ChangPro.action" method="post">

    <input type="hidden" name="id" value="${programe.id}">
    <table align="center" border="1">
        <tr>
            <td>标题</td>
            <td><input type="text" name="title" value="${programe.title}"></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><input type="text" name="category" value="${programe.category}"></td>
        </tr>
        <tr>
            <td>领域</td>
            <td><input type="text" name="field" value="${programe.field}"></td>
        </tr>
        <tr>
            <td>介绍</td>
            <td><textarea name="content" id="content">${programe.content}</textarea></td>
        </tr>
        <tr>
            <td>链接</td>
            <td><input type="text" name="href" value="${programe.href}"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password" value="${programe.password}"></td>
        </tr>
        <tr>
            <td>文件名</td>
            <td><input type="text" name="filename" value="${programe.filename}"></td>
        </tr>
        <tr>
            <td>文件位置</td>
            <td>${programe.fileposition}</td>
        </tr>
        <tr>
            <td>操作</td>
            <td><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
