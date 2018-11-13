<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/9
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网站管理-RenAiClub-super root</title>
    <style type="text/css">
        .dc {
            display: none;
            margin-left: 10px;
        }
    </style>
    <script language="javascript">
        function test(e) {
            e.style.display = e.style.display == 'block' ? 'none' : 'block' ;
        }
    </script>
</head>
<body>
    <a href="/UILogin/ToMyInfo.action">返回</a>
    ${warning}
    <br>
    <br>
    学习资料模块：*****************************************<br>
    <div style="color:#0000ff" onclick="test(children[0])">外层模块管理
        <div class="dc">
            <a href="${pageContext.request.contextPath }/UIAdmin/addModular.action">添加模块</a><br/>
            <a href="${pageContext.request.contextPath }/Admin/ListModular.action">查看模块</a><br/>
        </div>
    </div>

    <br>
    <br>
    <div style="color:#0000ff" onclick="test(children[0])">分类管理
        <div class="dc">
            <a href="${pageContext.request.contextPath }/UIAdmin/addCategory.action">添加分类</a><br/>
            <a href="${pageContext.request.contextPath }/Admin/ListCategory.action">查看分类</a><br/>
        </div>
    </div>

    <br>
    <br>
    <div style="color:#0000ff" onclick="test(children[0])">资料管理
        <div class="dc">
            <a href="${pageContext.request.contextPath }/UIAdmin/addDataInfo.action">添加资料</a><br/>
            <a href="${pageContext.request.contextPath }/Admin/ListDataInfo.action">查看资料</a><br/>
        </div>
    </div>

    <br>
    <br>
    <br><br><br><br>
    问题讨论模块：*****************************************<br>


    <br>
    <br>
    <br><br><br><br>
    项目分享模块：*****************************************<br>
    <br><br>
    ${message}
    <br><br>
    <a href="${pageContext.request.contextPath}/Admin3/ProCategory.action">项目类型</a><br/>
    <br>
    <br>
    <a href="${pageContext.request.contextPath}/Admin3/ProCategoryField.action">项目领域</a><br/>
    <br>
    <br>
    <div style="color:#0000ff" onclick="test(children[0])">项目管理
        <div class="dc">
            <a href="${pageContext.request.contextPath}/Admin3/AddPro.action">添加项目</a><br/>
            <a href="${pageContext.request.contextPath}/Admin3/ListPro.action">查看项目</a><br/>
        </div>
    </div>
    <br>
    <br>

</body>
</html>
