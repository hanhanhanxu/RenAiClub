<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/9/5
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>身份管理-RenAiClub-super root</title>
</head>
<body>
    <h1 align="center">
        身份管理
    </h1>
    <br>

    <a href="/UILogin/ToMyInfo.action">返回</a>
    <br/>

    <form action="${pageContext.request.contextPath}/Admin2/queryByDouble.action" method="post" style="text-align: center">
        检索条件：USERNAME(登录账号):
        <input type="text" name="username">
        NICKNAME(用户名):
        <input type="text" name="nickname">
        <input type="submit" value="搜 索">
    </form>

    <table border="2px" align="center">
        <tbody>
            <tr>
                <td>USERNAME(登录账号)</td>
                <td>NICKNAME(用户名)</td>
                <td>SEX(性别)</td>
                <td>是否仁爱成员</td>
                <td>操作</td>
            </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.pojo.username}</td>
                <td>${user.pojo.nickname}</td>
                <td>${user.pojo.sex}</td>
                <td>
                    <c:if test="${user.usersch.isrenai==1}">
                        &#10004
                    </c:if>
                    <c:if test="${user.usersch.isrenai!=1}">
                        &#10006
                    </c:if>
                </td>
                <td>
                    <c:if test="${user.usersch.isrenai==1}">
                        <a href="javascript:void(0);" onclick="removeRenai('${user.pojo.uid}')">移出&nbsp仁爱工作室</a>&nbsp&nbsp&nbsp
                    </c:if>
                    <c:if test="${user.usersch.isrenai!=1}">
                        <a href="javascript:void(0);" onclick="joinRenai('${user.pojo.uid}')">加入&nbsp仁爱工作室</a>&nbsp&nbsp&nbsp
                    </c:if>
                    <a href="#">详情资料</a>&nbsp&nbsp&nbsp
                    <a href="#">近期动态</a>&nbsp&nbsp&nbsp
                    <a href="javascript:void(0);" onclick="deleteUser('${user.pojo.uid}')">注销账户</a>&nbsp&nbsp&nbsp
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>





    <script type="text/javascript">
        function joinRenai(uid){
            var b=window.confirm("确定将该成员添加至仁爱工作室？");
            if(b){
                window.location="${pageContext.request.contextPath }/Admin2/joinRenAii.action?uid="+uid;
            }
        }
        function removeRenai(uid){
            var b=window.confirm("确定将该成员移出仁爱工作室？");
            if(b){
                window.location="${pageContext.request.contextPath }/Admin2/removeRenAii.action?uid="+uid;
            }
        }
        function deleteUser(uid){
            var b=window.confirm("确定完全删除该账户？");
            if(b){
                window.location="${pageContext.request.contextPath }/Admin2/deleteUser.action?uid="+uid;
            }
        }
    </script>

</body>
</html>
