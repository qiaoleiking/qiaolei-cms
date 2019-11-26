<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${articel.title }</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script> 
<link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.css" rel="stylesheet"> 
<script type="text/javascript" src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.js"></script>
</head>
<body>
			<div align="center">
					<br>
					<h2 style="color: red">${articel.title }</h2>
					<br>
					<h5 style="color: green">
						作者:${articel.user.username }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						频道:${articel.channel.name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						分类:${articel.category.name }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:collect(${articel.id })">收藏</a>
					</h5>
						<br>
					${articel.content }
			</div>
			
			<ul class="pager">
    			<li><a href="#">上一篇</a></li>
   				 <li><a href="#">下一篇</a></li>
			</ul>
			
			<script type="text/javascript">
			
					function collect(id){
						
						$.post(
							"/user/collect",	
							{id:id},
							function(Msg){
								if(Msg.result == 1){
									alert("收藏成功")
								}else{
									alert(msg.errorMsg)
								}
							},"json"
						)
					}
			
			</script>
			
</body>
</html>











