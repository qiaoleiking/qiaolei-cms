<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script> 
<link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.css" rel="stylesheet"> 
<script type="text/javascript" src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.js"></script>
</head>
<style type="text/css">
	.menu li{
		font-size:26px;
		text-align:center;
	}
	.menu li:hover{
		background:gray;
	}
</style>
<body>
		
		<nav class="navbar navbar-default">
 
  	
  	<!-- logo -->
  	<div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img alt="Brand" src="/images/logo.png">
      </a>
      
      
      
    </div>
    
      <form class="navbar-form"  style="float:none;text-align:center;">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      
    <!-- 搜索框和右侧登录信息 -->
    <div class="collapse navbar-collapse" style="float:none;text-align:right;"  id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        
      </ul>
      
    
      
      <ul class="nav navbar-nav navbar-right" >
        <li><a href="#"><img width="40px" height="40px" src="/images/donghua.gif"/> </a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          		张三 <span class="caret"></span></a>
          <ul class="dropdown-menu ">
            <li><a href="#">个人中心</a></li>
            <li><a href="#">个人设置</a></li>
            <li><a href="#">修改头像</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">退出登录</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
    
 
</nav>

<div class="container-fluid" >
	<div class="container" style="minheight:200px" >
		<div class="row">
			<!-- 左侧菜单 -->
			<div class="col-md-2" style="minheight:200px;margin-top:20px" >
				
					<ul class="list-group menu">
						<li class="list-group-item active" >热门文章</li>
						<c:forEach items="${list}" var="channel" varStatus="index">
					    	<li class="list-group-item ${id==channel.id? "active":"" }" data="/indexchn?id=${channel.id}">${channel.name}</li>
					    </c:forEach>
					</ul>
			</div>
			
			<!-- 中间的内容 -->
			<div class="col-md-8" style="background:white;minheight:200px" >
				<div>
						<hr>
						
				</div>
				
				<div id="myCarousel" class="carousel slide" style="minheight:200px">
						<!-- 轮播（Carousel）指标 -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>   
						<!-- 轮播（Carousel）项目 -->
						<div class="carousel-inner">
							<div class="item active">
								<img height="300px" src="/images/donghua.gif" alt="First slide">
							</div>
							<div  class="item">
								<img height="300px" src="/images/avatar1.jpg" alt="Second slide">
							</div>
							<div class="item">
								<img height="300px" src="/images/bg05.jpg" alt="Third slide">
							</div>
						</div>
						<!-- 轮播（Carousel）导航 -->
						<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
							<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a>
						<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
					
					
					
					<nav class="navbar navbar-default" role="navigation">
						    <div class="container-fluid">
							    <div>
							        <ul class="nav navbar-nav">
							        	<li <c:if test="${categoryId==0}"> class="active" </c:if> ><a href="javascript:gotoCat(0)" >全部</a></li>
								        	<c:forEach items="${categoryList}" var="cat">
								            	<li <c:if test="${cat.id==categoryId}"> class="active" </c:if> ><a href="javascript:gotoCat(${cat.id})" >${cat.name}</a></li>
								            </c:forEach>
							        </ul>
							    </div>
						    </div>
					</nav>
					
					
					
					
					
					
					
					<!-- 放文章的列表 -->
					 <div >
					 	<c:forEach items="${artList.list}" var="l" >
						<div class=row >
							 <hr align="left" style="width:100%">
							<div class="col-md-4"><img height="50px" width="50px" src="/images/avatar1.jpg"></div>
							<div class="col-md-8">
							<a href="javascript:showArticle(${l.id})">${l.title }</a>	
							<br>
							频道:<a>${l.channel.name}</a> &nbsp;&nbsp;
							分类:<a>${l.category.name}</a>
							<br>
							${l.user.username} 发布于 &nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${l.created }" pattern="yyyy年MM月dd日"/>
							</div>
						</div>
						</c:forEach>
						<div class="row">
							<ul class="pagination">
								    <li><a href="/indexchn?pageNum=${artList.prePage}&id=${id}&categoryId=${categoryId}">&laquo;</a></li>
								    <c:forEach begin="${artList.pageNum-2 > 1 ? artList.pageNum-2:1}" end="${artList.pageNum+2 > artList.pages ? artList.pages:artList.pageNum+2}" varStatus="index">    		
								    	<c:if test="${artList.pageNum!=index.index}">
								    		<li><a href="/indexchn?pageNum=${index.index}&id=${id}&categoryId=${categoryId}">${index.index}</a></li>
								    	</c:if>
								    	<c:if test="${artList.pageNum==index.index}">
								    		<li><a href="/indexchn?pageNum=${index.index}&id=${id}&categoryId=${categoryId}"><strong> ${index.index} </strong> </a></li>
								    	</c:if>
								    	
								    </c:forEach>
								    <li><a href="/indexchn?pageNum=${artList.nextPage}&id=${id}&categoryId=${categoryId}">&raquo;</a></li>
								</ul>
						</div>
		</div>		
</div>
			<!-- 中间的内容结束 -->
			<div class="col-md-2" style="minheight:200px" >
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">面板标题</h3>
					</div>
					<div class="panel-body">
						这是一个基本的面板
					</div>
				</div>
				
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">最新文章</h3>
					</div>
					<div class="panel-body">
						<c:forEach items="${articellist}" var="article" varStatus="index">
							${index.index+1} . <a>${article.title}</a>
							<br/>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
			<!-- 底部 -->
			<nav class="navbar navbar-default">
			 	 <div class="container-fluid">
			 </div>
	</nav>

		<script type="text/javascript">
			
		
				$(function(){
					//alert("加载页面完成")
					$(".menu li").click(function(){
						
						var url = $(this).attr("data");
						location.href = url;
						
						
					})
				})

				function showArticle(id){
					var url = "/article/showdetail?id="+id
					window.open(url);
				}
		
				function gotoCat(id){
					location.href="/indexchn?id=${id}&categoryId="+id;
				}
				
				
				
		</script>
		
		
		
		
</body>
</html>