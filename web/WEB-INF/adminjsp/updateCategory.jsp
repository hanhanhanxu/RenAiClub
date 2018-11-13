<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/11
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改分类信息-RenAiClub</title>
    <%--<script>
        set_select_checked("select1","${item.pojo.modularId}")
        function set_select_checked(selectId, checkValue){
            var select = document.getElementById(selectId);
            for (var i = 0; i < select.options.length; i++){
                if (select.options[i].value == checkValue){
                    select.options[i].selected = true;
                    break;
                }
            }
        }
    </script>--%>
</head>
<body>
<br/><br/>
<a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a><br/><br/>
<form action="${pageContext.request.contextPath}/Admin/UpdateCategory.action" method="post">
    <table width="500px;">
        <tr>
            <td>分类名称：</td>
            <td><input type="text" name="name" style="width: 200px" value="${item.pojo.name}"></td>
        <tr>
        <tr>
            <td>分类描述：</td>
            <td><textarea rows="4" cols="40" name="description">${item.pojo.description}</textarea></td>
        </tr>
        <tr>
            <td>所属模块：</td>
            <td>
                <select id="select1" name="modularId" >
                    <c:forEach items="${modulars}" var="modular">
                        <option value="${modular.mid}">${modular.name}</option>
                    </c:forEach>
                </select>${item.mname}
            </td>
        </tr>
        <tr>
            <td></td><td><input type="submit" value="确认修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
