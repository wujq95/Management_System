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
    <title>*****</title>
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
                    <span class="x-red">*</span>头像
                </label>
                <div class="layui-input-inline">
                    <input type="file" id="photo" name="photo"
                           autocomplete="off" class="layui-input">
                </div>

            </div>
            <div class="layui-form-item">
                <label for="user_name" class="layui-form-label">
                    <span class="x-red">*</span>姓名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="user_name" value="${user.user_name }" name="user_name" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>

            </div>
            <div class="layui-form-item">
                <label for="user_account" class="layui-form-label">
                    <span class="x-red">*</span>账号
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="user_account" value="${user.user_account }" name="user_account" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>

            </div>

            <div class="layui-form-item">
                <label class="layui-form-label"><span class="x-red">*</span>角色</label>
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
                    修改
                </button>
            </div>
        </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
            var form = layui.form
                ,layer = layui.layer;

            //自定义验证规则
            form.verify({
                nikename: function(value){
                    if(value.length < 5){
                        return '昵称至少得5个字符啊';
                    }
                }
                ,pass: [/(.+){6,12}$/, '密码必须6到12位']
                ,repass: function(value){
                    if($('#L_pass').val()!=$('#L_repass').val()){
                        return '两次密码不一致';
                    }
                }
            });

            //监听提交
            form.on('submit(add)', function(data){
                console.log(data);
                form.submit();
                return false;
            });


        });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();</script>
    </body>