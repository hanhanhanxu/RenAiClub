<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/3
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.removeAttribute("form");
%>
    <jsp:forward page="/WEB-INF/jsp/regist.jsp"></jsp:forward>
</body>
</html>
