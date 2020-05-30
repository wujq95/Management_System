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
    <title>User Information</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
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
        <script type="text/javascript">
            function userAdd() {
                var d = top.dialog({
                    title: 'Add Staff',
                    width:600,
                    url: 'userAdd',
                    onclose:function(){
                        window.location.reload();
                    }
                });
                d.showModal();
            }
            function userMdi(user_id) {
                var d = top.dialog({
                    title: 'Modify Staff',
                    width:600,
                    url: 'userMdi?user_id='+user_id,
                    onclose:function(){
                        window.location.reload();
                    }
                });
                d.showModal();
            }
            function userDel(user_id) {
                var d = top.dialog({
                    title: 'Delete Staff',
                    width:600,
                    url: 'userDel?user_id='+user_id,
                    onclose:function(){
                        window.location.reload();
                    }
                });
                d.showModal();
            }
            function delAll() {
                var data = tableCheck.getData();
                if(data==""){
                    layer.msg('You should select at lease one item');
                    return;
                }
                layer.confirm('Confirm Deletion？',{title:'Confirm',btn: ['Confirm', 'Cancel']},function () {
                    var ids = "";
                    if(data.length>0){
                        for(var i=0;i<data.length;i++){
                            ids = ids + data[i]+",";
                        }
                    }
                    $.ajax({
                        type:"POST",
                        url:"userDelAll",
                        data:{"ids":ids},
                        success:function () {
                            window.location.reload();
                        }
                    })
                    $(".layui-form-checked").not('.header').parents('tr').remove();
                })

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
                <form class="layui-form layui-col-md12 x-so" action="userList" method="post">
                    <input type="text" name="user_name"  placeholder="Please enter the name" autocomplete="off" class="layui-input" value="${user.user_name }">
                    <input type="text" name="user_account"  placeholder="Please enter the account" autocomplete="off" class="layui-input" value="${user.user_account }">
                    <button class="layui-btn"  lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i></button>
                </form>
            </div>
            <xblock>
                <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>Batch Deletion</button>
                <button class="layui-btn" onclick="userAdd()"><i class="layui-icon"></i>Add</button>
                <span class="x-right" style="line-height:40px">Totally Number: ${count }</span>
            </xblock>
            <table class="layui-table">
                <thead>
                <tr>
                    <th>
                        <div class="layui-unselect header layui-form-checkbox" lay-skin="primary" id="demo"><i class="layui-icon">&#xe605;</i></div>
                    </th>
                    <td>Portrait</td>
                    <td>Name</td>
                    <td>Account</td>
                    <td>Role</td>
                    <td>Status</td>
                    <th>Operation</th>
                </thead>
                <tbody>
                <c:forEach items="${userList }" var="user">
                    <tr>
                        <td>
                            <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${user.user_id}'><i class="layui-icon">&#xe605;</i></div>
                        </td>
                        <td><img width="50px" src="upload/${user.user_img }" /></td>
                        <td>${user.user_name }</td>
                        <td>${user.user_account }</td>
                        <td>${user.role.role_name }</td>
                        <td>${user.user_status eq 1 ? 'In service' : 'Resignation' }</td>
                        <td class="td-manage">
                            <a title="Modify"  onclick="userMdi(${user.user_id})" href="javascript:;">
                                <i class="layui-icon">&#xe642;</i>
                            </a>
                            <a title="Delete" onclick="userDel(${user.user_id})" href="javascript:;">
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