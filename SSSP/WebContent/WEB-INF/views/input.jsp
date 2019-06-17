<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#name").change(function(){
		var value=$(this).val();
		//如果存在_oldname,将不用发请求进行验证用户名可用,直接alert,用户名可用
		var _oldname=$('#_oldname').val();
	
		if(_oldname!=null&&_oldname!=""&&value==_oldname){
			alert("用户名可用");
			return;
		}
		var url="http://localhost:8989/SSSP/ajaxvaildata";
		var args={"name":value,"time":new Date()}
		$.get(url,args,function(data){
			if(data==1){
				alert("该用户名已被占用")
			}else if(data==0){
				alert("该用户名可以使用");
			}else{alert("服务器出现错误,或网络错误")}
			
		})
	})
})
</script>
<body>
	<c:if test="${employee.id==null }">
		<c:set  value="${pageContext.request.contextPath}/save" var="url"></c:set>
	</c:if>
	<c:if test="${employee.id!=null }">
		<c:set  value="${pageContext.request.contextPath}/update" var="url"></c:set>
	</c:if>
	
	<input type="hidden"  id="_oldname" value="${employee.name}">
	<form:form action="${url}" modelAttribute="employee">
	<input type="hidden" name="id" value="${employee.id}" >
		<br><br>
		姓名:<form:input path="name" id="name" />
		<br><br>
		年龄:<form:input path="age"/>
		<br><br>
		邮箱:<form:input path="email"/>
		<br><br>
		电话:<form:input path="phonenumber"/>
		<br><br>
		部门:<form:select path="department.departmentId" 
		items="${departments }" itemLabel="departmentName" 
		itemValue="departmentId"></form:select>
		<br><br>
		<form:button>Submit</form:button>
	</form:form>
</body>
</html>