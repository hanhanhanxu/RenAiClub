<%--
  Created by IntelliJ IDEA.
  User: 青墨
  Date: 2018/8/25
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加项目类型</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/Admin3/AddProCate.action">
        id: <input type="text" id="id" name="id"><br/>
        项目类型:<input type="text" id="category" name="category"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
