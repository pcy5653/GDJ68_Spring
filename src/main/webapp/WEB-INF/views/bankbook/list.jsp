<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<c:import url="../temp/bootStrap.jsp"></c:import>

</head>
<body>
	
	<c:import url="../temp/header.jsp"></c:import>
	<section class="container mt-5">
		<h1 class="mb-4 text-center">BankBook List</h1>
	
		
		<table class="table table-dark table-hover">
			<thead>
				<th>상품명</th><th>이자율</th>
			</thead>
			<tbody>
				<!-- Controller에서 속성명=items를 해서  -->
				<c:forEach items="${list}" var="d" varStatus="i">
				<tr>
					<td><a class="link-underline link-underline-opacity-0 text-white" href="./detail?bookNum=${d.bookNum}">${d.bookName}</a></td>
					<td>${d.bookRate} ${i.index}   </td>
				</tr>			
				</c:forEach>
		
			</tbody>
		
		</table>
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  	<!-- 화살표를 통해 이전, 이후 버튼을 true|false를 통해 보여지고 없애기 -->
		  	<c:if test="${pager.pre}">
			    <li class="page-item">
			      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
		    </c:if>
		    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    	<li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
		    </c:forEach>
		    <c:if test="${pager.next}">
			    <li class="page-item">
			      <a class="page-link" href="./list?page=${pager.lastNum+1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		    </c:if>
		  </ul>
		</nav>
		
		
<%-- 		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  	<!-- 화살표를 통해 이전, 이후 버튼을 true|false를 통해 보여지고 없애기 -->
			  <li class="page-item ${pager.pre?'':'disabled'}">
			      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			  </li>
			  <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    	<li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
		      </c:forEach>
		      <c:if test="${pager.next}">
			    <li class="page-item">
			      <a class="page-link" href="./list?page=${pager.lastNum+1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		    </c:if>
		  </ul>
		</nav> 
		--%>
		
		<a class="btn btn-danger" href="./add">상품등록</a>
	
	</section>
	
<%-- 	
	<c:forEach begin="1" end="10" step="2" var="num">
		<h1>${num}</h1>
	</c:forEach>
	 --%>

</body>
</html>