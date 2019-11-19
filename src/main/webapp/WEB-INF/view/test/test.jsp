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
<title>CMS</title>
</head>
<body>

	<nav class="navbar navbar-default" role="navigation"> 
    <div class="container-fluid" > 
        <div class="navbar-header"> 
            <a class="navbar-brand" href="#">Cms</a> 
        </div> 
        
        <form role="form" id="a">
			  <div class="form-group">
			    <input type="text" class="form-control" id="name" placeholder="请输入名称" style="width: 300px;margin-left:500px;margin-top: 20px" >
			  </div>
			  <button type="submit" class="btn btn-default" style="float: right">提交</button>
		</form>
        
        
        <ul class="nav navbar-nav navbar-right"> 
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li> 
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li> 
        </ul> 
    </div> 
</nav>
</body>	
</html>




