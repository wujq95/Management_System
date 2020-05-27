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
      	Currently<font color="red">${pages }</font>Page，Totally<font color="green">${sumPage }</font>Pages
      	</div>
      	 <input type="hidden" name="pages" id="pages">
	      <div class="page">
	        <div>
	          <a class="num" href="javascript:jumpPage(1);">First Page</a>
	          <a class="num" href="javascript:jumpPage(${(pages-1>0)?(pages-1):1 });">Previous Page</a>
	          <a class="num" href="javascript:jumpPage(${(pages+1>sumPage)?sumPage:(pages+1) });">Next Page</a>
	          <a class="num" href="javascript:jumpPage(${sumPage });">Last Page</a>
	        </div>
	      </div>
      </form>