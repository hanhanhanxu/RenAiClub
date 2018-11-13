<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/9
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资料列表-RenAiClub</title>
</head>
<body>
    <br/><br/>
    <a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a>
    <table border="2px" width="90%">
        <caption><h2>资料信息</h2></caption>
        <tr>
            <td>资料名称</td>
            <td>资料链接</td>
            <td>资料密码</td>
            <td>资料介绍</td>
            <td>所属分类</td>
            <td>操作</td>
        </tr>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.pojo.name }</td>
                <td>${list.pojo.infourl }</td>
                <td>${list.pojo.infokey}</td>
                <td>${list.pojo.introduce}</td>
                <td>${list.cname}</td>
                <td>
                    <a href="">修改</a>
                    <a href="javascript:void(0);" onclick="deleteitem('${list.pojo.did}')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <script type="text/javascript">
        function deleteitem(datainfo_id){
            var b=window.confirm("确定删除该资料?");
            if(b){
                window.location="${pageContext.request.contextPath }/Admin/DeleteDatainfo.action?datainfo_id="+datainfo_id;
            }
        }
    </script>
</body>
</html>
