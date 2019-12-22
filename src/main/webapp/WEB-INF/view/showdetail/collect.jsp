<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏夹</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script> 
<link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.css" rel="stylesheet"> 
<script type="text/javascript" src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.js"></script>
</head>
<body>	
		
		<table class="table">
  <caption>我的收藏夹</caption>
  <thead>
    <tr>
      <th>id</th>
      <th width="20%">标题</th>
      <th>发布日期</th>
<!--       <th>操作</th>
      <th>操作    <input type="button" value="添加" onclick="add()"> -->
      </tr>
  </thead>
  <tbody>
    <c:forEach items="${info.list}" var="article">
	    <tr class="active">
	       <td>${article.id}</td>
	       <td><a href="javascript:showArticle(${article.article_id})">${article.title}</a></td>
	       <td><fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd"/></td>
	    
	       <td><a href="${article.url }">${article.url }</a></td>
	       <td>${article.text }</td>
	      <td>
	      	<input type="button" onclick="delArticle(${article.id})" value="取消收藏	"  class="btn-danger"/>
	      </td></tr>s
   	</c:forEach>
  </tbody>
</table>
		
		<ul class="pagination">
    <li><a href="javascript:goPage(${info.prePage})">&laquo;</a></li>
    <c:forEach begin="${info.pageNum-2 > 1 ? info.pageNum-2:1}" end="${info.pageNum+2 > info.pages ? info.pages:info.pageNum+2}" varStatus="index">    		
    	<c:if test="${info.pageNum!=index.index}">
    		<li><a href="javascript:goPage(${index.index})">${index.index}</a></li>
    	</c:if>
    	<c:if test="${info.pageNum==index.index}">
    		<li><a href="javascript:void"><strong> ${index.index} </strong> </a></li>
    	</c:if>
    	
    </c:forEach>
    <li><a href="javascript:goPage(${info.nextPage})">&raquo;</a></li>
</ul>
		
		
		
		
		
		<script type="text/javascript">
		
		function goPage(pageNum){
			var url="/user/favorite?pageNum="+pageNum ;
			$("#content").load(url);
			}
		
		
		function showArticle(id){
			var url = "/article/showdetail?id="+id
			window.open(url);
		}
		
		function delArticle(id){
				
			$.post(
				"/user/deleteCollect",
				{id:id},
				function(data){
					if(data.result==1){
						alert("取消收藏成功")
						$("#content").load("/user/favorite?pageNum=${info.pageNum}")
					}else{
						alert(data.errorMsg)
					}
				}
			)
		}
		
		function add(){
			$("#content").load("/user/addCollect");
		}
		
		function showArticle(id){
			var url = "/article/showdetail?id="+id
			window.open(url);
		}
		
		</script>
</body>
</html>