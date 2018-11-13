<%@ page import="cn.renai.pojo.Programecategory" %><%--
  Created by IntelliJ IDEA.
  User: 青墨
  Date: 2018/8/25
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>项目类型管理</title>
   
    <script type="text/javascript">
        function ChangeToProCate(id) {
            var ProCate = prompt("请输入修改后的名称");
            window.location.href="${pageContext.request.contextPath}/Admin3/ChangeProCate.action?id="+id+"&category="+"'"+ProCate+"'";
        }
    </script>

</head>
<body>
    <a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a><br/>
    <br/>
    <a href="${pageContext.request.contextPath}/UIAdmin/addProCate.action">添加项目类型</a>
    <table width="500px" border="1">
        <tr>
            <th>id</th>
            <th>类型</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${Procategorys}" var="Procate">
        <tr>
                <td>${Procate.id}</td>
                <td>${Procate.category}</td>
                <td><a href="#" onclick="ChangeToProCate(${Procate.id})">修改</a> <a href="${pageContext.request.contextPath}/Admin3/DeleteProCate.action?id=${Procate.id}" onclick="javascript:confirm('您确定要删除吗？') ">删除</a></td>
        </tr>
        </c:forEach>
    </table>

</body>
</html>
