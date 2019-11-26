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
<body style="background-image:url(/images/timg.jpg);background-repeat:no-repeat">
		
	
	<nav class="navbar navbar-default navbar-static-top">
			
			<%@include  file="common/top.jsp" %>
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
								<img height="300px"  width="700px"  src="/images/115748249.png" alt="First slide">
							</div>
							<div  class="item">
								<img height="300px" width="700px" src="/images/timg (1).jpg" alt="Second slide">
							</div>
							<div class="item">
								<img height="300px" width="700px" src="/images/662c8da2b64e3cf.jpeg" alt="Third slide">
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
						<hr width="88%" style="background-color:#D2691E;border:none;height:1px">
							 <hr align="left" style="width:100%">
							<div class="col-md-2" style="text-align:right"><img height="50px" 
							width="50px"  src="/pic/${l.picture}"  onerror="this.src='/images/default-cat.png'"
							class="img-rounded"></div>
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
						<div class="row" align="center">
						<hr width="88%" style="background-color:#D2691E;border:none;height:1px">
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
						<h3 class="panel-title">信息</h3>
					</div>
					<div class="panel-body">
						<h6>乔磊</h6><br>
						<h6>1707D</h6>
					</div>
				</div>
				
				
				
					<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">图片文章</h3>
					</div>
					<div class="panel-body">
						<c:forEach items="${imgArticles}" var="article" varStatus="index"> 
							<a href="javascript:showArticle(${article.id})">${index.index}. ${article.title}</a>
							<br/>
						</c:forEach>
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
<nav class="navbar navbar-default " style="background:#666">
 	<div class="container-fluid" style="text-align:center;height: 5px ">
 		<div class="row" style="margin-top:13px">
 	    	<c:forEach items="${linklist.list }" var="link">
 	    		<div class="col-md-1"><a  style="color: red"  href="${link.url}" class="fl"> ${link.name}</a></div>
 	    	</c:forEach>
 		</div>
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