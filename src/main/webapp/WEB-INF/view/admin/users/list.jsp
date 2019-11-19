<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.1.js"></script> 
<link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.css" rel="stylesheet"> 
<script type="text/javascript" src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.js"></script>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">输入姓名</a>
    </div>
    <div>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search" name="mohu">
            </div>
            <input type="button" class="btn btn-default" value="查询" onclick="search()"/>
        </form>
    </div>
    </div>
</nav>

<div class="table-responsive">
  <table class="table">
    <caption>用户列表</caption>
    <thead>
      <tr >
        <th>用户id</th>
        <th>用户名称</th>
        <th>注册日期</th>
        <th>生日</th>
        <th>角色</th>
        <th>状态</th>
        <th>操作</th>
       </tr>
    </thead>
    <tbody>
   
    	<c:forEach items="${info.list}"  var="user">
    	
    		<c:if test="${user.locked==1}">
    			<tr class="active"> 
    		</c:if>
    		<c:if test="${user.locked!=1}">
    		 	<tr >
    		</c:if>
    		
	        <td>${user.id}</td>
	        <td>${user.username}</td>
	        
    		<td><fmt:formatDate pattern="YYYY年MM月dd号" value="${user.create_time}"></fmt:formatDate></td>
	        <td><fmt:formatDate pattern="YYYY年MM月dd日" value="${user.birthday}"/></td>
	        <td>
	        
	        <c:choose>
	        	<c:when test="${user.role==1}">
	        		管理员
	        	</c:when>
	        	<c:when test="${user.role==0}">
	        		注册用户
	        	</c:when>
	        	<c:otherwise>
	        		未知
	        	</c:otherwise>
	        </c:choose>
	        
	        </td>
	        <td>${user.locked==1?"禁用":"正常"}</td>
	        <td>
	        	<c:if test="${user.locked==1}">
	        		<input type="button" class="btn btn-success" onclick="updateStatus(${user.id},0)" value="解禁" />	
	        	</c:if>
	        	<c:if test="${user.locked!=1}">
	        		<input type="button" class="btn btn-info"  onclick="updateStatus(${user.id},1)" value="封禁"/>
	        	</c:if>
			</td>
	        <td></td>
	        <td></td>
	      </tr>
    		
      </c:forEach>
  </table>
</div>
		
		 		<!-- 分页 -->
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
				function updateStatus(userId,state){
					
					
					$.post(
						"/admin/transform",
						{userId:userId,state:state},
						function(data){
							if(data.result == 1){
								alert("恭喜,处理成功")
								$("#content").load("/admin/users");
							}else{
								alert(data.errorMsg)
							}
						}
					)
					
				}
				
				
				function goPage(pageNum){
				
				 	var url = "/admin/users?pageNum="+pageNum+"&mohu=${mohu}";
					$("#content").load(url); 
				}
				
				
				function search(){
					var mohu = $("[name=mohu]").val();
					$("#content").load("/admin/users?mohu="+mohu);
				}
				
				
				
				
		</script>	
</body>
</html>








