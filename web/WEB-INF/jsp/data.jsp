<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/7
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学习资料-RenAlCulb-Sharing-Info</title>
    <style>
        #div1{
            position: absolute;
            left: 30px;
            float: left;
        }
        #div2{
            width: 1000px;
            height: 600px;
            background-color: #25aae1;
            margin-left: 250px;
            float: left;
        }

    </style>
</head>
<body>

    <h1 align="center">学习资料</h1>
    <br><br>
    <a href="${pageContext.request.contextPath}/index.jsp">去首页</a>
    <br><br>
    <div id="div1">
        <table border="2px">
            <tbody>
                <tr>
                    <td width="150px">${mname}</td>
                </tr>
            <c:forEach items="${categoryItems}" var="item">
                <tr>
                    <td width="150px"><a href="${pageContext.request.contextPath}/DataInfo/GetInfo.action?cid=${item.cid}">${item.name}</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


    <div id="div2">
        <table border="1px">
            <tbody>
            <tr width="400px">
                <td>名称</td>
                <td>链接</td>
                <td>密码</td>
                <td>介绍</td>
            </tr>
            <c:forEach items="${datainfoItems}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>
                        <a href="${item.infourl}" target="_blank">${item.infourl}</a>
                    </td>
                    <td>${item.infokey}</td>
                    <td>${item.introduce}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>


</body>
</html>
