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
    <title>Goods Add</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,good-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/font.css">
    <link rel="stylesheet" href="css/xadmin.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>
  
  </head>

    <body>
    <div class="x-body">
        <form action="goodAddDo" method="post" enctype="multipart/form-data" class="layui-form">
            <div class="layui-form-item">
                <label for="good_name" class="layui-form-label">
                    <span class="x-red">*</span>Name
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="good_name" name="good_name" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>

            </div>
            <div class="layui-form-item">
                <label for="good_price" class="layui-form-label">
                    <span class="x-red">*</span>Price
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="good_price" name="good_price" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>

            </div>
            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>Type</label>
                <div class="layui-input-block">
                    <c:forEach items="${typeAllList }" var="type">
                        <input type="radio" value="${type.type_id }" name="fk_type_id" lay-skin="primary" title="${type.type_name }" checked="checked">
                    </c:forEach>
                </div>
            </div>

            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                </label>
                <button  class="layui-btn" lay-filter="add" lay-submit="">
                    Add
                </button>
            </div>
        </form>
    </div>

    </body>