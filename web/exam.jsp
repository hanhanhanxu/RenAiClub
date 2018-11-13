<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/19
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试专区-RenAiClub</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/exam.css" />
</head>
<body style="background-image:url('${pageContext.request.contextPath}/img/exam.jpg');">
${message}
<br/>
    <div>
        <form action="${pageContext.request.contextPath}/UploadExam/UploadFile.action" method="post"  enctype="multipart/form-data">
            <table  style="border-collapse:separate; border-spacing:0px 30px;">
                <tbody>
                <tr>
                    <td>姓名：</td>
                    <td><input class="in" type="text" name="sname" value="${vo.sname}" onkeyup="this.value=this.value.replace(/\s+/g,'')" required="required"></td>
                    <td>${vo.errors.sname}</td>
                </tr>
                <tr>
                    <td>学号：</td>
                    <td><input class="in" type="text" name="sid" value="${vo.sid}" onkeyup="this.value=this.value.replace(/\s+/g,'')" required="required"></td>
                    <td>${vo.errors.sid}</td>
                </tr>
                <tr>
                    <td>班级：</td>
                    <td>
                        <select class="in" name="classid">
                            <c:forEach items="${ClassInfo}" var="item">
                                <option value="${item.classname}">${item.classname}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>第一题</td>
                    <td><input type="file" name="file" width="120px"></td>
                </tr>
                <tr>
                    <td>第二题：</td>
                    <td><input type="file" name="file" width="120px"></td>
                </tr>
                <tr>
                    <td>第三题：</td>
                    <td><input type="file" name="file" width="120px"></td>
                </tr>
                <tr>
                    <td>第四题：</td>
                    <td><input type="file" name="file" width="120px"></td>
                </tr>
                <tr>
                    <td>第五题：</td>
                    <td><input type="file" name="file" width="120px"></td>
                </tr>
                <tr>
                    <td>第六题：</td>
                    <td><input type="file" name="file" width="120px"></td>
                </tr>
                <tr>
                    <td>第七题：</td>
                    <td><input type="file" name="file" width="120px"></td>
                </tr>
                <tr>
                    <td>第八题：</td>
                    <td><input type="file" name="file" width="120px"></td>
                </tr>
                </tbody>
            </table>

            <input id="sub" type="submit" value="O   K">
        </form>
    </div>

</body>
</html>
