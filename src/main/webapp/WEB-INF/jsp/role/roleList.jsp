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
    		    title: '添加角色',
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
    		    title: '修改角色',
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
    		    title: '删除角色',
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
                title: '分配权限',
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
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
        <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
            <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
        <div class="layui-row">
            <form class="layui-form layui-col-md12 x-so" action="roleList" method="post">
                <!-- <input class="layui-input" placeholder="开始日" name="start" id="start">
                <input class="layui-input" placeholder="截止日" name="end" id="end"> -->
                <input type="text" name="role_name"  placeholder="请输入角色名" autocomplete="off" class="layui-input" value="${role.role_name }">
                <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
            </form>
        </div>
        <xblock>
            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
            <button class="layui-btn" onclick="roleAdd()"><i class="layui-icon"></i>添加</button>
            <span class="x-right" style="line-height:40px">共有数据：${count }条</span>
        </xblock>
        <table class="layui-table">
            <thead>
            <tr>
                <th>
                    <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
                </th>
                <td>角色名</td>
                <th>操作</th>
            </thead>
            <tbody>
            <c:forEach items="${roleList }" var="role">
                <tr>
                    <td>
                        <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
                    </td>
                    <td>${role.role_name }</td>
                    <td class="td-manage">
                        <button class="layui-btn" onclick="menuMdi(${role.role_id})">分配权限</button>
                        <a title="编辑"  onclick="roleMdi(${role.role_id})" href="javascript:;">
                            <i class="layui-icon">&#xe642;</i>
                        </a>
                        <a title="删除" onclick="roleDel(${role.role_id})" href="javascript:;">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <jsp:include page="../main/pages.jsp"></jsp:include>

    </div>
    <script>
        layui.use('laydate', function(){
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: '#start' //指定元素
            });

            //执行一个laydate实例
            laydate.render({
                elem: '#end' //指定元素
            });
        });

        /*用户-停用*/
        function member_stop(obj,id){
            layer.confirm('确认要停用吗？',function(index){

                if($(obj).attr('title')=='启用'){

                    //发异步把用户状态进行更改
                    $(obj).attr('title','停用')
                    $(obj).find('i').html('&#xe62f;');

                    $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                    layer.msg('已停用!',{icon: 5,time:1000});

                }else{
                    $(obj).attr('title','启用')
                    $(obj).find('i').html('&#xe601;');

                    $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                    layer.msg('已启用!',{icon: 5,time:1000});
                }

            });
        }

        /*用户-删除*/
        function member_del(obj,id){
            layer.confirm('确认要删除吗？',function(index){
                //发异步删除数据
                $(obj).parents("tr").remove();
                layer.msg('已删除!',{icon:1,time:1000});
            });
        }



        function delAll (argument) {

            var data = tableCheck.getData();

            layer.confirm('确认要删除吗？'+data,function(index){
                //捉到所有被选中的，发异步进行删除
                layer.msg('删除成功', {icon: 1});
                $(".layui-form-checked").not('.header').parents('tr').remove();
            });
        }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();</script>
    </body>

</html>