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
    <title>Role Information</title>
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
    <script type="text/javascript">
    	function roleAdd() {
    		var d = top.dialog({
    		    title: 'Add Role',
    		    width:600,
    		    url: 'roleAdd',
    		    onclose:function(){
    		    	window.location.reload();
    		    }
    		});
    		d.showModal();
		}
    	function roleMdi(role_id) {
    		var d = top.dialog({
    		    title: 'Modify Role',
    		    width:600,
    		    url: 'roleMdi?role_id='+role_id,
    		    onclose:function(){
    		    	window.location.reload();
    		    }
    		});
    		d.showModal();
		}
    	function roleDel(role_id) {
    		var d = top.dialog({
    		    title: 'Delete Role',
    		    width:600,
    		    url: 'roleDel?role_id='+role_id,
    		    onclose:function(){
    		    	window.location.reload();
    		    }
    		});
    		d.showModal();
		}
        function menuMdi(role_id) {
            var d = top.dialog({
                title: 'Assign Permissions',
                width:600,
                url: 'menuMdi?role_id='+role_id,
                onclose:function(){
                    window.location.reload();
                }
            });
            d.showModal();
        }
    </script>
  </head>

    <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">Home</a>
        <a>
          <cite>Navigation</cite></a>
      </span>
        <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="Refresh">
            <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
        <div class="x-body">
            <div class="layui-row">
                <form class="layui-form layui-col-md12 x-so" action="roleList" method="post">
                    <input type="text" name="role_name"  placeholder="Please enter the name" autocomplete="off" class="layui-input" value="${role.role_name }">
                    <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                </form>
            </div>
            <xblock>
                <button class="layui-btn" onclick="roleAdd()"><i class="layui-icon"></i>Add</button>
                <span class="x-right" style="line-height:40px">Totally Number: ${count }</span>
            </xblock>
            <table class="layui-table">
                <thead>
                <tr>
                    <th>
                        <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
                    </th>
                    <td>Role Name</td>
                    <th>Operation</th>
                </thead>
                <tbody>
                <c:forEach items="${roleList }" var="role">
                    <tr>
                        <td>
                            <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
                        </td>
                        <td>${role.role_name }</td>
                        <td class="td-manage">
                            <button class="layui-btn" onclick="menuMdi(${role.role_id})">Assign Permissions</button>
                            <a title="Modify"  onclick="roleMdi(${role.role_id})" href="javascript:;">
                                <i class="layui-icon">&#xe642;</i>
                            </a>
                            <a title="Delete" onclick="roleDel(${role.role_id})" href="javascript:;">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <jsp:include page="../main/pages.jsp"></jsp:include>
        </div>
    </body>

</html>