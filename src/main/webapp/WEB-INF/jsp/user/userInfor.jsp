<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("path", path);
    pageContext.setAttribute("basePath", basePath);
%>
<html>
<head>
    <title>User Information</title>
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/font.css">
    <link rel="stylesheet" href="css/xadmin.css">
    <script type="text/javascript" src="js/jquery.min.js"  charset="UTF-8"></script>
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>
    <script type="text/javascript" src="artDialog/dist/dialog-plus.js"></script>
    <link href="artDialog/css/ui-dialog.css" rel="stylesheet"
          type="text/css" />
</head>
<body>
    <table class="layui-table" align="center">
        <tr align="center">
            <td>Avatar</td>
            <td><img width="50px" src="upload/${user.user_img }" /></td>
        </tr>
        <tr align="center">
            <td>Name</td>
            <td>${user.user_name}</td>
        </tr>
        <tr align="center">
            <td>Account</td>
            <td>${user.user_account}</td>
        </tr>
        <tr align="center">
            <td>Role</td>
            <td>${user.role.role_name }</td>
        </tr>
        <tr align="center">
            <td>Status</td>
            <td>${user.user_status eq 1 ? 'In service' : 'Resignation' }</td>
        </tr>
    </table>
</body>
</html>
