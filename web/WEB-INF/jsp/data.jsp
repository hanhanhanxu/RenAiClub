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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/data.css" />
</head>

<body>

<div class="heard">

    <div class="biao_ti">
        <h1>学习资料</h1>
    </div>
    <div class="header_nav">

        <ul  class="header_nav_ul">
            <li><a href="${pageContext.request.contextPath}/index.jsp">去首页</a></li>
            <li> <a href="https://pan.baidu.com/disk/home?#/all?path=%2F&vmode=list" target="_blank"> 百度网盘</a></li>
        </ul>

    </div>

</div>


<div class="main">
    <div class="center">

        <div id="div1">

            <table  class="center_table"  cellpadding="0" cellspacing="0">

                <tr>
                    <td width="150px">${mname}</td>
                </tr>
                <c:forEach items="${categoryItems}" var="item">
                    <tr>
                        <td width="150px"><a href="${pageContext.request.contextPath}/DataInfo/GetInfo.action?cid=${item.cid}">${item.name}</a></td>
                    </tr>
                </c:forEach>

            </table>
        </div>


        <div id="div2">
            <table  class="center_table_two" cellpadding="0" cellspacing="10px">

                <tr>
                    <td >名称</td>
                    <td >链接</td>
                    <td >密码</td>
                    <td >介绍</td>
                </tr >
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

            </table>
        </div>

    </div>
</div>
<div class="footer">
    <ul class="foot_list">
        <li>微笑</li>
        <li>合作</li>
        <li>钻研</li>
        <li>无止境</li>
        <li>仁爱工作室</li>
    </ul>
</div>


</body>
</html>
