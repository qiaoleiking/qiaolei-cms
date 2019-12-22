<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误提示</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.validate.js"></script>  
<link    rel="stylesheet"    href="<%=request.getContextPath() %>/css/index3.css"   type="text/css">
</head>
<body>
	<div class="alert alert-danger" role="alert">
  				${errorInfo}
    </div>
</body>
</html>