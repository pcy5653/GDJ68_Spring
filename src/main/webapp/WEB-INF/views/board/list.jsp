<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Notice List</title>
	<c:import url="../temp/bootStrap.jsp"></c:import>
	
	<style>
	*{text-align:center;}
	.container {position:relative;} 
	.btn{
		border:var(--bs-btn-border-width) solid #9fb1df;
		background-color:#9fb1df;
		position:absolute; right:0; bottom=0;
	}
	.btn-danger{
		--bs-btn-hover-border-color: #2497fa;
		--bs-btn-hover-bg:#2497fa; 
		transition: all 0.5s cubic-bezier(0.28, -0.32, 0.58, 1.19);
		}
	</style>
</head>
<body>
	
	<c:import url="../temp/header.jsp"></c:import>
	<section class="container mt-5">
		<h1 class="mb-4 text-center">Notice List</h1>
	
		
		<table class="table table-hover">
			<thead class="table-dark">
				<th>No</th><th>Title</th><th>작성자</th><th>날짜</th><th>HIT</th>
			</thead>
			<tbody>
				<!-- Controller에서 속성명=items를 해서  -->
				<c:forEach items="${list}" var="dto" varStatus="i">
				<tr class="row-date">
					<td>${dto.noticeNum}</td>
					<td><a class="link-underline link-underline-opacity-0 text-black" href="./detail?noticeNum=${dto.noticeNum}">${dto.noticeTitle}</a></td>
					<td>${dto.noticeName}</td>
					<td>${dto.noticeDate}</td>
					<td>${dto.noticeHit}</td>
				</tr>			
				</c:forEach>
		
			</tbody>
		
		</table>
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  	<c:if test="${pager.pre}">
			    <li class="page-item">
			      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
		    </c:if>
		    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    	<li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${param.kind}&search=${param.search}">${i}</a></li>
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
		
		<div class="input-group mb-3">
			<form action="./list" method="get" >
				  <!-- parameter(name,value) -->
				  <select name="kind" class="form-select" aria-label="Default select example">
					  <option value="name">작성자</option>
					  <option value="title">Title</option>
					  <option value="contents">Contents</option>
				 </select>
				 <!-- parameter -->
				  <input type="text" name="search" class="form-control" aria-label="Amount (to the nearest dollar)">
				  <div class="col-auto">
				    <button type="submit" class="btn btn-primary">검색</button>
				  </div>
			</form>
		</div>
		
		<a class="btn btn-danger" href="./add">게시물 등록</a>
	
	</section>
	
<%-- 	
	<c:forEach begin="1" end="10" step="2" var="num">
		<h1>${num}</h1>
	</c:forEach>
	 --%>

</body>
</html>