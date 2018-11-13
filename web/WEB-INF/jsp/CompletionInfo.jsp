<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/17
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>完善信息-RenAiClub</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/UILogin/ToMyInfo.action">返回</a>
<br/>
${message}
<br/>
    <form action="${pageContext.request.contextPath}/UserInFo/Completion.action" method="post">
        昵称：     <input type="text" name="nickname" value="${user.nickname}">${user.errors.nickname}
        <br/><br/>
        联系号码： <input type="text" name="tel" value="${user.tel}">${user.errors.tel}
        <br/><br/>
        qq:        <input type="text" name="qq" value="${user.qq}">${user.errors.qq}
        <br/><br/>
        个人介绍：  <input type="text" name="introduce" value="${user.introduce}">${user.errors.introduce}
        <br/><br/>
        密保问题：   <select name="question">
                        <option value="?" selected>?</option>
                        <option value="您母亲的名字是">您母亲的名字是</option>
                        <option value="您父亲的名字是">您父亲的名字是</option>
                        <option value="您姐姐的名字是">您姐姐的名字是</option>
                        <option value="您弟弟的名字是">您弟弟的名字是</option>
                        <option value="您母校的名字是">您母校的名字是</option>
                        <option value="您童年老师的名字是">您童年老师的名字是</option>
                        <option value="您童年好友的名字是">您童年好友的名字是</option>
                        <option value="您记忆深刻的一个名字是">您记忆深刻的一个名字是</option>
                    </select><br/><br/>
        密保答案：<input type="text" name="answer"><br/><br/>

        <input type="submit" value="提 交"><br/><br/>
    </form>


</body>
</html>
