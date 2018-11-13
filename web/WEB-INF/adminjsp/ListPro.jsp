<%--
  Created by IntelliJ IDEA.
  User: 青墨
  Date: 2018/8/29
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>项目管理</title>
    <script>
        function DeletePro(id) {
            var p = confirm('是否删除');
            if(p!=null && p!="" && p!=false){
                window.location.href="${pageContext.request.contextPath}/Admin3/DeletePro.action?id="+id;
            }
        }
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a>
<br/><br/>
    <form action="${pageContext.request.contextPath}/Admin3/ListProBySelect.action">
        类型：<select name="category" id="category" >
            <c:forEach items="${ProCate}" var="Procate">
                <option value="${Procate.category}">${Procate.category}</option>
            </c:forEach>
        </select>
        领域：<select name="field" id="field">
            <c:forEach items="${Profield}" var="ProField">
                <option value="${ProField.field}">${ProField.field}</option>
            </c:forEach>
        </select> <input type="submit" value="检索">
    </form>

    <table border="1">
        <tr>
            <th>类型</th>
            <th>领域</th>
            <th>标题</th>
            <th>文件名</th>
            <th>文件位置</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${ListPro}" var="Admin3">
         <tr>
             <td WIDTH="100">${Admin3.category}</td>
             <td WIDTH="100">${Admin3.field}</td>
             <td WIDTH="100">${Admin3.title}</td>
             <td WIDTH="100">${Admin3.filename}</td>
             <td WIDTH="100">${Admin3.fileposition}</td>
             <td WIDTH="100"><a href="${pageContext.request.contextPath}/Admin3/SelectById.action?id=${Admin3.id}">详情</a> <a href="#" onclick="DeletePro(${Admin3.id})">删除</a></td>
         </tr>
        </c:forEach>
    </table>

</body>
</html>
