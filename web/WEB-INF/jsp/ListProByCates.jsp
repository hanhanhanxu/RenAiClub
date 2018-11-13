<%--
  Created by IntelliJ IDEA.
  User: 青墨
  Date: 2018/9/1
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>列表</title>
</head>
<body>

    <form align="center" action="${pageContext.request.contextPath}/Admin3/SelectProByFAC.action" method="post">
        <input type="hidden" name="category" value="${sessionScope.categoryname}">
        <select name="field" id="field">
            <c:forEach items="${ListProField}" var="ProField">
                <option value="${ProField.field}">${ProField.field}</option>
            </c:forEach>
        </select> <input type="submit" value="搜寻"><br/>
    </form>
        <table align="center" >
            <c:forEach items="${ListProByCates}" var="programe">
                <a href="${pageContext.request.contextPath}/Admin3/GetProById.action?id=${programe.id}">${programe.title}</a><br/>
            </c:forEach>
        </table>

</body>
</html>
