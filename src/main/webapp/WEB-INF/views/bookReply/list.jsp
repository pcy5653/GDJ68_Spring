<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<section class="container mt-5">
		<!-- Conttroller에서 각각의 (Notice, Qna) 페이지인지 보기 위해 키 이름인 board 사용 -->
		<h1 class="mb-4 text-center">상품 댓글</h1>
		
		<table class="table table-hover">
			<thead class="table-dark">
				<th>번호</th><th>작성자</th>내용<th></th><th>날짜</th>
			</thead>
			<tbody>
				<!-- Controller에서 속성명=items를 해서  -->
				<c:forEach items="${list}" var="dto" varStatus="i">
					<tr class="row-date">
						<td>${dto.replyNum}</td>						
						<td>${dto.id}</td>
						<td>${dto.replyContents}</td>
						<td>${dto.replyDate}</td>
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
		    	<li class="page-item" data-page-num="${i}"><a class="page-link move" href="#" data-num="${i}">${i}</a></li>
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
	</section>
