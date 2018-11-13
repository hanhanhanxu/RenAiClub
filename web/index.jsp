<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2018/8/7
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>RenAiclub-南阳理工学院</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:if test="${modularItems==null}">
    <jsp:forward page="${pageContext.request.contextPath}/UILoad/LoadIndex.action"></jsp:forward>
</c:if>

<div class="div1">
        <div class="nav">
                <ul class="menu">
                <li>
                    <a class="active" href="javascript:;">首页</a>
                </li>
                <li>
                    <a href="javascript:;">学习资料</a>
                    <ul class="menu-a">
                        <c:forEach items="${modularItems}" var="item">
                            <li>
                                <a href="/UILoad/Data.action?mid=${item.mid}">${item.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;">问题讨论</a>
                    <ul class="menu-a">
                        <li>
                            <a href="javascript:;">仁爱工作室</a>
                        </li>
                        <li>
                            <a href="javascript:;">C/C++</a>
                        </li>
                        <li>
                            <a href="javascript:;">java</a>
                        </li>
                        <li>
                            <a href="javascript:;">python</a>
                        </li>
                        <li>
                            <a href="javascript:;">HTML</a>
                        </li>
                        <li>
                            <a href="javascript:;">web开发</a>
                        </li>
                        <li>
                            <a href="javascript:;">游戏开发</a>
                        </li>
                        <li>
                            <a href="javascript:;">Linux</a>
                        </li>
                        <li>
                            <a href="javascript:;">其他</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:;">项目分享</a>
                    <ul class="menu-a">
                        <c:forEach items="${ProCate}" var="cate">
                            <li>
                                <a href="${pageContext.request.contextPath}/UILoad/Admin3.action?category=${cate.category}">${cate.category}</a>
                            </li>
                        </c:forEach>


                    </ul>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/UILoad/exam.action">考试专区</a>
                </li>
                <li class="log">
                    <c:if test="${user==null}">
                        <a href="/UILogin/login.action">登 录</a>
                    </c:if>
                    <c:if test="${user!=null}">
                        <ul class="menu">
                            <li>
                                <a href="/UILogin/ToMyInfo.action">欢迎,${user.nickname}</a>
                                <ul class="menu-a">
                                    <li><a href="/LoginAndRegist/unsubscribe.action">退出</a></li>
                                </ul>
                            </li>
                        </ul>
                    </c:if>

                </li>
            </ul>
        </div>

    <!--
                    背景图片
    -->
    <div class="info"></div>

    <!--
                       轮播图
     -->

    <div class="carousel slide" id="carousel-339259">
        <ol class="carousel-indicators">
            <li class="active" data-slide-to="0" data-target="#carousel-339259">
            </li>
            <li data-slide-to="1" data-target="#carousel-339259">
            </li>
            <li data-slide-to="2" data-target="#carousel-339259">
            </li>
        </ol>
        <div class="carousel-inner">
            <div class="item active">
                <img alt="" src="img/img1.jpg" />

            </div>
            <div class="item">
                <img alt="" src="img/img2.jpg" />
                <div class="carousel-caption">
                    <h4>
                        焦点图二
                    </h4>
                    <p>
                        焦点图二的描述,焦点图二的描述,焦点图二的描述,焦点图二的描述,焦点图二的描述,焦点图二的描述,
                    </p>
                </div>
            </div>
            <div class="item">
                <img alt="" src="img/img3.jpg" />
                <div class="carousel-caption">
                    <h4>
                        焦点图三
                    </h4>
                    <p>
                        焦点图三的描述，焦点图三的描述，焦点图三的描述，焦点图三的描述，焦点图三的描述，
                    </p>
                </div>
            </div>
        </div>
        <a rel="nofollow" class="left carousel-control" href="#carousel-339259" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
        <a rel="nofollow" class="right carousel-control" href="#carousel-339259" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
    </div>

    <div class="about">
        <div>
            <img src="img/renai.jpg" width="90px" height="150px" align="center" title="仁爱工作室官方logo" />
            <font size="3" face="隶书" color=#000000>仁爱工作室</font>&trade;&copy;2018-08-20 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 感谢赞助商阿里提供云服务：
            <a href="http://www.aliyun.com" target="_blank">上云就上阿里云</a>
        </div>
        <div>
            <font id="font1">扫描二维码了解我们</font>
        </div>
        <div id="erwei">
            <img src="img/erweima.jpg" width="120px" height="120px" />
        </div>
    </div>

</div>

<script>
    $(function() {
        $(".menu>li").hover(function() {
            $(this).find('.menu-a').stop(true, false).slideDown('slow');
        }, function() {
            $(this).find('.menu-a').stop(true, false).slideUp('slow');
        });
    })
</script>

</body>
</html>
