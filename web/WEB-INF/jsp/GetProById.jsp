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
<form action="${pageContext.request.contextPath}/Admin3/DownLoadFile.action" method="post">

    <input type="hidden" name="id" value="${programe.id}">
    <table align="center" border="1">
        <tr>
            <td>标题</td>
            <td>${programe.title}</td>
        </tr>
        <tr>
            <td>类型</td>
            <td>${programe.category}</td>
        </tr>
        <tr>
            <td>领域</td>
            <td>${programe.field}</td>
        </tr>
        <tr>
            <td>介绍</td>
            <td>${programe.content}</td>
        </tr>
        <tr>
            <td>链接</td>
            <td>${programe.href}</td>
        </tr>
        <tr>
            <td>密码</td>
            <td>${programe.password}</td>
        </tr>
        <tr>
            <td>操作</td>
            <td><input type="submit" value="下载"></td>
        </tr>
    </table>
</form>
</body>
</html>