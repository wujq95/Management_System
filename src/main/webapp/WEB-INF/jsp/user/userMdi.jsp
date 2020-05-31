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
    <title>User Modification</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/font.css">
    <link rel="stylesheet" href="css/xadmin.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>
  </head>
    <body>
    <div class="x-body">
        <form action="userMdiDo" method="post" enctype="multipart/form-data" class="layui-form">
            <input type="hidden" name="user_id" value="${user.user_id }">
            <div class="layui-form-item">
                <label for="user_account" class="layui-form-label">
                    <span class="x-red">*</span>Avatar
                </label>
                <div class="layui-input-inline">
                    <input type="file" id="photo" name="photo"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="user_name" class="layui-form-label">
                    <span class="x-red">*</span>Name
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="user_name" value="${user.user_name }" name="user_name" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="user_account" class="layui-form-label">
                    <span class="x-red">*</span>Account
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="user_account" value="${user.user_account }" name="user_account" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="user_account" class="layui-form-label">
                    <span class="x-red">*</span>Password
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="user_password" value="${user.user_password }" name="user_password" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>Role</label>
                <div class="layui-input-block">
                    <c:forEach items="${roleAllList }" var="role">
                        <input type="radio" ${user.fk_role_id eq role.role_id ?'checked="checked"' : '' } value="${role.role_id }" name="fk_role_id" lay-skin="primary" title="${role.role_name }" >

                    </c:forEach>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                </label>
                <button  class="layui-btn" lay-filter="add" lay-submit="">
                    Modify
                </button>
            </div>
        </form>
    </div>
    </body>