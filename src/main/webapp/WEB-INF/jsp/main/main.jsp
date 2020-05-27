<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("path", path);
    pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>Welcome Screen</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/font.css">
    <link rel="stylesheet" href="css/xadmin.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>
    <script type="text/javascript" src="artDialog/dist/dialog-plus.js"></script>
    <link href="artDialog/css/ui-dialog.css" rel="stylesheet"
          type="text/css" />
</head>
<body>
<!-- top start -->
<div class="container">
    <div class="logo"><a href="main">Management System</a></div>
    <div class="left_open">
        <i title="Expand the left column" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">${sessionScope.user.user_name}</a>
            <dl class="layui-nav-child">
                <dd><a onclick="x_admin_show('Personal Information','userInfor',600,300)">Personal Information</a></dd>
                <dd><a href="logout">Logout</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a href="main">Front Page</a></li>
    </ul>

</div>
<!-- top end -->
<!-- mid start -->
<!-- left menu start -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <c:forEach items="${sessionScope.fatherList }" var="menu">
                <li>
                    <a href="javascript:;">
                        <cite>${menu.menu_name }</cite>
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    <ul class="sub-menu">
                        <c:forEach items="${sessionScope.sonList }" var="rlm">
                            <c:if test="${menu.menu_id eq rlm.menu.father_menu }">
                                <li>
                                    <a _href="${rlm.menu.menu_url }">
                                        <i class="iconfont">&#xe6a7;</i>
                                        <cite>${rlm.menu.menu_name }</cite>
                                    </a>
                                </li >
                            </c:if>
                        </c:forEach>
                    </ul>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<!-- left menu end -->
<!-- right end start -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li>My Page</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- right body end -->
<!-- mid end -->
</body>
</html>