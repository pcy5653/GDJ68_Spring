<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student List</title>
	<c:import url="../temp/bootStrap.jsp"></c:import>

</head>
<body>
	
	<c:import url="../temp/header.jsp"></c:import>
	<section class="container mt-5">
		<h1 class="mb-4 text-center">Student List</h1>
	
		
		<table class="table table-dark table-hover">
			<thead>
				<th>학생이름</th><th>평균</th>
			</thead>
			<tbody>
				<!-- Controller에서 속성명=items를 해서  -->
				<c:forEach items="${list}" var="dto" varStatus="i">
				<tr>
					<td><a class="link-underline link-underline-opacity-0 text-white" href="./detail?studNum=${dto.studNum}">${dto.studName}</a></td>
					<td>${dto.avg}</td>
				</tr>			
				</c:forEach>
		
			</tbody>
		
		</table>
		
		<a class="btn btn-danger" href="./add">학생등록</a>
	
	</section>
	
<%-- 	
	<c:forEach begin="1" end="10" step="2" var="num">
		<h1>${num}</h1>
	</c:forEach>
	 --%>

</body>
</html>