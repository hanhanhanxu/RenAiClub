<%--
  Created by IntelliJ IDEA.
  User: 青墨
  Date: 2018/8/29
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>项目领域管理</title>
    <script type="text/javascript">
        function ChangeToProCateField(id) {
            var ProCate = prompt("请输入修改后的领域名称");
            window.location.href="${pageContext.request.contextPath}/Admin3/ChangeProCateField.action?id="+id+"&field="+ProCate;
        }
    </script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a><br/>
    <br/>
        <a href="${pageContext.request.contextPath}/UIAdmin/addProCateField.action">添加项目所属领域</a>
        <table width="500px" border="1">
            <tr>
                <th>id</th>
                <th>领域名</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${ProCategoryfields}" var="ProCateFile">
                <tr>
                    <td>${ProCateFile.id}</td>
                    <td>${ProCateFile.field}</td>
                    <td><a href="#" onclick="ChangeToProCateField(${ProCateFile.id})">修改</a> <a href="${pageContext.request.contextPath}/Admin3/DeleteProCateField.action?id=${ProCateFile.id}" onclick="javascript:confirm('您确定要删除吗？') ">删除</a></td>
                </tr>
            </c:forEach>
        </table>

</body>
</html>
