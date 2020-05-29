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
    <title>Good Delete</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/xadmin.css">
    <script type="text/javascript" src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="artDialog/dist/dialog-plus.js"></script>
<link href="artDialog/css/ui-dialog.css" rel="stylesheet"
    type="text/css" />
    <script>
    function closes() {
        var dialog = top.dialog.get(window);//获取当前模态窗口
        dialog.close();
        dialog.remove();
        return false;
    }
</script>
  </head>

    <body>
    <form action="goodDelDo" method="post">
        <input type="hidden" name="good_id" value="${good_id }">
        <br/><br/><br/><br/>
        <div align="center">
            <div style="font-size: 40px">Confirm Delete？</div>
        </div>
        <br/><br/><br/><br/>
        <div align="center">
            <button class="layui-btn layui-btn-danger" type="submit">Confirm</button>
            <button class="layui-btn layui-btn-primay" onclick="closes()" type="button">Cancel</button>
        </div>
        <br/><br/>
    </form>
    </body>

</html>