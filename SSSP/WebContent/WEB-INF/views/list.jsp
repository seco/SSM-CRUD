<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>所有的员工</h1>
	<c:if test="${page.content==null||page.numberOfElements==0 }">
		暂时还没有员工
	</c:if>
	<c:if test="${page!=null&&page.numberOfElements>0 }">
		<table cellpadding="10" cellspacing="2" border="1">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Age</td>
				<td>Email</td>
				<td>PhoneNumber</td>
				<td>Department</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<c:forEach items="${page.content }" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.name }</td>
					<td>${emp.age }</td>
					<td>${emp.email }</td>
					<td>${emp.phonenumber }</td>
					<td>${emp.department.departmentName }</td>
					<td><a href="<%=request.getContextPath()%>/delete/${emp.id}">删除</a></td>
					<td><a href="<%=request.getContextPath()%>/emp/${emp.id}">编辑</a></td>

				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
					共${page.totalElements }条记录 
					共${page.totalPages }页
					当前第${page.number+1 }页
					<a href="<%=request.getContextPath()%>/getemployees?pageNo=1">首页</a>
					<a href="<%=request.getContextPath()%>/getemployees?pageNo=${page.number+1-1}">上一页</a>
					<a href="<%=request.getContextPath()%>/getemployees?pageNo=${page.number+1+1}">下一页</a>
					<a href="<%=request.getContextPath()%>/getemployees?pageNo=${page.totalPages }">末页</a>
					
				</td>
				<td style="text-align: center" colspan="1">
				<a href="<%=request.getContextPath()%>/index">返回</a>
				</td>
			</tr>
		</table>
		<br>

	</c:if>

</body>
</html>