<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/2
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建My RenAi account</title>
    <script type="text/javascript">
        function changeImage(img){
            img.src = img.src + "?" + new Date().getTime();
        }
    </script>
</head>
<body>
<br><br>
<a href="${pageContext.request.contextPath}/UILoad/LoadIndex.action">去首页</a>
<br><br>
    <div>
        <form action="${pageContext.request.contextPath}/LoginAndRegist/regist.action" method="post">
            <table>
                <tbody>
                <tr>
                    <td> *登录账号：</td>
                    <td><input type="text" name="username" value="${form.username}" onkeyup="this.value=this.value.replace(/\s+/g,'')" required="required"></td>
                    <td>${form.errors.username}</td>
                </tr>
                <tr>
                    <td>*登录密码：</td>
                    <td><input type="password" name="password" value="${form.password}" onkeyup="this.value=this.value.replace(/\s+/g,'')" required="required"></td>
                    <td>${form.errors.password}</td>
                </tr>
                <tr>
                    <td>*确认密码：</td>
                    <td><input type="password" name="password2" value="${form.password2}" onkeyup="this.value=this.value.replace(/\s+/g,'')" required="required"></td>
                    <td>${form.errors.password2}</td>
                </tr>
                <tr>
                    <td>*昵称：</td>
                    <td><input type="text" name="nickname" value="${form.nickname}" onkeyup="this.value=this.value.replace(/\s+/g,'')" required="required"></td>
                    <td>${form.errors.nickname}</td>
                </tr>
                <tr>
                    <td>&nbsp联系电话：</td>
                    <td><input type="text" name="tel" value="${form.tel}" onkeyup="this.value=this.value.replace(/\s+/g,'')"></td>
                </tr>
                <tr>
                    <td>&nbspQQ：</td>
                    <td><input type="text" name="qq" value="${form.qq}" onkeyup="this.value=this.value.replace(/\s+/g,'')"></td>
                </tr>
                <tr>
                    <td>*班级：</td>
                    <td>
                        <select name="classid">
                            <c:forEach items="${ClassInfo}" var="item">
                                <option value="${item.classnum}">${item.classname}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>*入学年份：</td>
                    <td>
                        <select name="entrance">
                            <c:forEach items="${EntranceYear}" var="item">
                                <option value="${item.year}">${item.year}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>*性别：</td>
                    <td>
                        <input type="radio" name="sex" value="男" checked>男
                        <input type="radio" name="sex" value="女">女
                    </td>
                </tr>
                <tr>
                    <td>&nbsp个人介绍：</td>
                    <td><textarea name="introduce" value="${form.introduce}" rows="5" cols="30" maxlength="128"></textarea></td>
                </tr>
                <tr>
                    <td>*图片认证:</td>
                    <td>
                        <input type ="text" name="checkcode" required>
                        <img src="${pageContext.request.contextPath}/IdentifyCode" onclick="changeImage(this)" title="换一张" style="cursor:pointer">
                        (请输入图中数字)
                    </td>
                    <td>${form.errors.checkcode}</td>
                </tr>
                </tbody>
            </table>
            <input type="submit" value="继 续">
        </form>

    </div>

</body>
</html>
