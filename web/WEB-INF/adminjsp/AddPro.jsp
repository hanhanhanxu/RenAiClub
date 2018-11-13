<%--
  Created by IntelliJ IDEA.
  User: 青墨
  Date: 2018/8/14
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加项目</title>
</head>
<body>
<br/>
${message}
<br/>

    <form action="${pageContext.request.contextPath}/Admin3/UpLoadPro.action" enctype="multipart/form-data" method="post">
        题目：<input type="text" name="title" id="title"><br/>
        介绍: <textarea style="resize: none" name="content" id="content" cols="30" rows="10"></textarea><br/>
        类型：<select name="category" id="category">
            <c:forEach items="${ProCate}" var="Procate">
                    <option value="${Procate.category}">${Procate.category}</option>
            </c:forEach>
        </select><br/>
        所属领域:<select name="field" id="field">
                    <c:forEach items="${Profield}" var="ProField">
                        <option value="${ProField.field}">${ProField.field}</option>
                    </c:forEach>
                </select><br/>
        链接: <input type="text" name="href" id="href"><br/>
        密码:<input type="text" name="password" id="password"><br/>
        上传文件：<input type="file" name="file"><br/>
        <input type="submit" value="提交"><br/>
    </form>
</body>
</html>
