<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/18
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入学年份列表-RenAiClub</title>
</head>
<body>
<br/><br/>
<a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a>
<table border="2px" width="90%">
    <caption><h2>班级信息</h2></caption>
    <tr>
        <td>入学年份</td>
        <td>操作</td>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.year }</td>
            <td>
                <a href="javascript:void(0);" onclick="deleteitem('${list.eYId}')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<script type="text/javascript">
    function deleteitem(entranceyear_id){
        var b=window.confirm("确定删除该年份?");
        if(b){
            window.location="${pageContext.request.contextPath }/Admin/DeleteEntranceYear.action?entranceyear_id="+entranceyear_id;
        }
    }
</script>
</body>
</html>
