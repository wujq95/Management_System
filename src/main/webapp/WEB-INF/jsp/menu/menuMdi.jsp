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
    <title>Menu Modify</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,role-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/font.css">
    <link rel="stylesheet" href="css/xadmin.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>
   <script type="text/javascript" src="artDialog/dist/dialog-plus.js"></script>
<link href="artDialog/css/ui-dialog.css" rel="stylesheet"
    type="text/css" />
    <title>Assign Permissions</title>
	<style type="text/css">
		#main{
			width: 500px;
		}
		.demo{width:450px; margin:20px auto}
		.select_side{float:left; width:200px}
		 select{width:200px; height:200px;border: 1px solid #404040;font-weight: bold}
		.select_opt{float:left; width:40px; height:15%; padding-top: 80px;padding-left: 10px;}
		.select_opt p{width:26px; height:26px; margin-top:6px; background:url(images/arr.gif) no-repeat; cursor:pointer; text-indent:-999em}
		.select_opt p#toright{background-position:2px 0}
		.select_opt p#toleft{background-position:2px -22px}
		.sub_btn{clear:both; height:42px; line-height:42px; padding-top:10px; text-align:center}
	</style>
<script type="text/javascript">
$(function(){
    var leftSel = $("#selectL");
	var rightSel = $("#selectR");
	$("#toright").bind("click",function(){		
		leftSel.find("option:selected").each(function(){
			$(this).remove().appendTo(rightSel);
		});
	});
	$("#toleft").bind("click",function(){		
		rightSel.find("option:selected").each(function(){
			$(this).remove().appendTo(leftSel);
		});
	});
	leftSel.dblclick(function(){
		$(this).find("option:selected").each(function(){
			$(this).remove().appendTo(rightSel);
		});
	});
	rightSel.dblclick(function(){
		$(this).find("option:selected").each(function(){
			$(this).remove().appendTo(leftSel);
		});
	});

});
</script>
</head>

<body>
	<form id="form01" action="menuMdiDo" method="post">
		<input type="hidden" name="role_id" value="${role_id }">
		<div id="main">
		  <h2 align="center">Assign Permissions</h2>
		  <div class="demo">
			 <div class="select_side">
			 <p align="center">Not Have Permissions</p>
			 <select id="selectL" name="selectL" multiple="multiple">
				 <c:forEach items="${noList }" var="menu">
			 		<option value="${menu.menu_id }">${menu.menu_name }</option>
			 	</c:forEach>
			 </select>
			 </div>
			 <div class="select_opt">
				<p id="toright" title="add">&gt;</p>
				<p id="toleft" title="remove">&lt;</p>
			 </div>
			 <div class="select_side">
			 <p align="center">Already Have Permissions</p>
			 <select id="selectR" name="selectR" multiple="multiple">
			 	<c:forEach items="${havList }" var="rlm">
			 		<option name="havs" value="${rlm.menu.menu_id }">${rlm.menu.menu_name }</option>
			 	</c:forEach>
			 </select>
			 </div>
			 <div class="sub_btn"><input type="button" onclick="subs()" id="sub" class="layui-btn" value="Assign" /></div>
		  </div>
	
		</div>
	</form>
	<script type="text/javascript">
		function subs() {
			var havs = $("option[name='havs']");
			for ( var i in havs) {
				havs[i].selected=true;
			}
			$("#form01").submit();
		}
	</script>
</body>
</html>
