<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/9
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分类列表-RenAiClub</title>
</head>
<body>
    <br/><br/>
    <a href="${pageContext.request.contextPath}/UIAdmin/WebSet.action">返回</a><br/><br/>
    <table border="2px" width="90%">
        <caption><h2>分类信息</h2></caption>
        <tr>
            <td>分类名称</td>
            <td>分类描述</td>
            <td>
                所属模块
                <%--<select name="modularId">加一个选择只看某个模块的，对select加点击事件
                    <c:forEach items="${modular}" var="item">
                        <option value="${item.mid}">${item.name}</option>
                    </c:forEach>
                </select>--%>
            </td>
            <td>操作</td>
        </tr>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.pojo.name }</td>
                <td>${list.pojo.description }</td>
                <td>${list.mname}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/UIAdmin/updateCategory.action?cid=${list.pojo.cid}">修改</a>
                    <a href="javascript:void(0);" onclick="deleteitem('${list.pojo.cid}')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <script type="text/javascript">
        function deleteitem(category_id){
            var b=window.confirm("删除后该类别下的所有资料也将被删除?");
            if(b){
                window.location="${pageContext.request.contextPath }/Admin/DeleteCategory.action?category_id="+category_id;
            }
        }
    </script>
</body>
</html>
