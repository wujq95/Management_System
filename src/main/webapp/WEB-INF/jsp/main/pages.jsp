<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<script type="text/javascript">
      	function jumpPage(pages) {
			$("#pages").val(pages);
			$("#pageForm").submit();
		}
      </script>
      <form id="pageForm" action="${url }" method="post">
     	 <input type="hidden" name="user_name"  value="${user.user_name }">
         <input type="hidden" name="user_account" value="${user.user_account }">
      	<div class="page">
      	当前第<font color="red">${pages }</font>页，共<font color="green">${sumPage }</font>页
      	</div>
      	 <input type="hidden" name="pages" id="pages">
	      <div class="page">
	        <div>
	          <a class="num" href="javascript:jumpPage(1);">首页</a>
	          <a class="num" href="javascript:jumpPage(${(pages-1>0)?(pages-1):1 });">上一页</a>
	          <a class="num" href="javascript:jumpPage(${(pages+1>sumPage)?sumPage:(pages+1) });">下一页</a>
	          <a class="num" href="javascript:jumpPage(${sumPage });">尾页</a>
	        </div>
	      </div>
      </form>