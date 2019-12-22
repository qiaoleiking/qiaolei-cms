<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script> 
<link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.css" rel="stylesheet"> 
<script type="text/javascript" src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.js"></script>
<title>CMS 管理系统</title>
</head> 
<body>
	
		
		
		<div class="row">
			<div class="col-md-2">
				<div style="margin-left:20px ">
					<ul class="nav nav-pills nav-stacked">
					  <li class="active"><a href="javascript:showFuction('/admin/articles')">文章列表</a></li>
					  <li><a href="javascript:showFuction('/user/hello')">测试</a></li>
					  <li><a href="javascript:showFuction('/link/list')">1</a></li>
					  <li>投票管理
					  	<ul class="nav nav-pills nav-stacked">
					  		<li><a href="#">投票列表</a></li>
					  		<li><a href="#">新建投票</a></li>
					  		<li><a href="/index">回到主页</a></li>
					  	</ul>
					  </li>
					  <li class="divider"></li>
					  <li><a href="javascript:showFuction('/admin/users')">用户管理</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-10"  style=" min-height:500px; border-left: solid">
				<div id="content"></div>
			</div>
		</div>


	<nav class="navbar navbar-inverse navbar-fixed-bottom" 
		role="navigation">
			<div align="center"> <font color="blue" size="5"> ----八维大数据学院1707D--- </font> </div>
	</nav>
			

	
	<script type="text/javascript">
		
			// url 响应到后台的  url:@RequestMapping("users")注解中
			function showFuction(url){
				
				$("#content").load(url)
			}
	
	
	</script>
</body>
</html>