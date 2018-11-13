<%--
  Created by IntelliJ IDEA.
  User: 青墨
  Date: 2018/8/29
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加项目领域类型</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/Admin3/AddProCateField.action">
        id: <input type="text" id="id" name="id"><br/>
        项目领域名称:<input type="text" id="field" name="field"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
