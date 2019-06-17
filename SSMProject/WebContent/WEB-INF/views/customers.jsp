<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${customers==null }">
		没有员工信息
	</c:if>
	<c:if test="${customers!=null }">
		<h3>所有员工信息</h3>
		<table cellpadding="10" cellspacing="0" border=1>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>邮箱</td>
				<td>部门</td>
				<td>Delete</td>
				<td>Edit</td>
			</tr>
			<c:forEach items="${customers }" var="customer">
				<tr>
					<td>${customer.id }</td>
					<td>${customer.name }</td>
					<td>${customer.age }</td>
					<td>${customer.email }</td>
					<td>${customer.department.departmentName}</td>
					<td><a href="<%=request.getContextPath()%>/deletecustomer/${customer.id}">删除</a></td>
					
					<td><a href="">编辑</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>