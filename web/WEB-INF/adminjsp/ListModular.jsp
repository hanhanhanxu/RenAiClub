<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/9
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模块列表-RenAiClub</title>
</head>
<body>
    <br/><br/>
    <a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a>
    <table border="2px" width="90%">
        <caption><h2>模块信息</h2></caption>
        <tr>
            <td>模块名称</td>
            <td>模块描述</td>
            <td>操作</td>
        </tr>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.name }</td>
                <td>${list.description }</td>
                <td>
                    <a href="">修改</a>
                    <a href="javascript:void(0);" onclick="deleteitem('${list.mid}')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <script type="text/javascript">
        function deleteitem(modular_id){
            var b=window.confirm("删除后该模块下的所有类别和资料也将被删除?");
            if(b){
                window.location="${pageContext.request.contextPath }/Admin/DeleteModular.action?modular_id="+modular_id;
            }
        }
    </script>
</body>
</html>
