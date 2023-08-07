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
		<!-- Conttroller에서 각각의 (Notice, Qna) 페이지인지 보기 위해 키 이름인 board 사용 => ${board}-->
		<h1 class="mb-4 text-center">Account List</h1>
	
		
		<table class="table table-hover">
			<thead class="table-dark">
				<th>No</th><th>상품번호</th><th>가입일</th>
			</thead>
			<tbody>
				<!-- Controller에서 속성명=items를 해서  -->
				<c:forEach items="${list}" var="dto" varStatus="i">
					<tr class="row-date">
						<td>${dto.accountNum}</td>		
						<td><a class="link-underline link-underline-opacity-0 text-black" href="./detail?accountNum=${dto.accountNum}">
							${dto.bookNum}
							</a>
						</td>
						<td>${dto.accountDate}</td>
					</tr>			
				</c:forEach>
		
			</tbody>
		
		</table>
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  	<c:if test="${pager.pre}">
			    <li class="page-item">
			      <a class="page-link move" href="#" data-num="${pager.startNum-1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
		    </c:if>
		    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    	<li class="page-item "><a class="page-link move" href="#" data-num="${i}">${i}</a></li>
		    </c:forEach>
		    <c:if test="${pager.next}">
			    <li class="page-item">
			      <a class="page-link move" href="#" data-num="${pager.lastNum+1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		    </c:if>
		  </ul>
		</nav>
		
		
		<a class="btn btn-danger" href="./add">상품 추가 등록</a>

	</section>
	

	<!-- 
		1. 함수호출
	<script>
		// 홑,쌍따옴표로 묶어야 JS에서 문자열로 받아들인다.
		setData('${param.kind}');
	</script>
	 -->

<%-- 	
	<c:forEach begin="1" end="10" step="2" var="num">
		<h1>${num}</h1>
	</c:forEach>
	 --%>

</body>
</html>