<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form modelAttribute="collect" id="form">
	名称： <form:input path="text"/><form:errors path="text"/>
	地址： <form:input path="url"/><form:errors path="url"/>
	<input type="button" value="提交" onclick="submit()">
</form:form>



<script>
	function submit(){
		//$("#form").submit();
		$.post('/user/addCollect',$("#form").serialize(),
				function(html){
					$("#content").html(html);
				}
			);
	}
</script>