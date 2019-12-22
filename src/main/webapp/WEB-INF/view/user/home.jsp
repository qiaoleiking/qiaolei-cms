<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script> 
<link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.css" rel="stylesheet"> 
<script type="text/javascript" src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.js"></script>
</head>
<body>
		<nav class="navbar navbar-default">
			<%@include  file="../common/top.jsp" %>
		</nav>
	
		<div class="container">
			<div class="row">
				<div class="col-md-3" >
					<ul class="list-group homemenu">
					 <li class="list-group-item list-group-item-success" data="/user/myarticles">我的文章</li>
					 <li class="list-group-item list-group-item-info" data="/user/postArticle">发布文章</li>
					 <li class="list-group-item list-group-item-info" data="/user/postImg">发布图片</li>
					 <li class="list-group-item list-group-item-info" data="/user/favorite">收藏夹功能</li>
					 <li class="list-group-item list-group-item-info">我的评论</li>
					 <li class="list-group-item list-group-item-info">个人设置</li>				
					</ul>
					<button type="button" class="btn btn-primary" style="margin-left: 50px" onclick="hd()"
   			 	data-toggle="button"> 回到主页
					</button>
				</div>
				
				<div class="col-md-9" id="content">
					<div id="kindEditor" style="display: none">
						   <!-- 引入kindEditor的样式 -->
						  <jsp:include page="/kindeditor/jsp/demo.jsp"></jsp:include>
		              </div>
				</div>
		</div>
	</div>	
		
	


		<script type="text/javascript">
		
				$(".homemenu li").click(function(){
					var url  = $(this).attr("data");
					
					$("#content").load(url);
				})
				
				var url = $(".homemenu li:eq(0)").attr("data");
				$("#content").load(url);
				
				function hd(){
					location = "/index"
				}
	
		</script>	
</body>
</html>