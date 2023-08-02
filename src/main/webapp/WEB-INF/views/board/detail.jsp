<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>

<style>
	.container{width: 920px; height:100hv; margin: 0 auto !important;}
	h1{text-align:center; margin: 2rem 0 !important;}
	table{width: 920px !important; margin: 0 auto !important;}
	a{
		color: rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1));
    	text-decoration: underline;
	}
	.btn{
		border:var(--bs-btn-border-width) solid #9fb1df;
		background-color:#9fb1df;
		
	}
	.btn-danger{
		--bs-btn-hover-border-color: #2497fa;
		--bs-btn-hover-bg:#2497fa; 
		--bs-btn-hover-color:black !important;
		color: white; 
		transition: all 0.5s cubic-bezier(0.28, -0.32, 0.58, 1.19);
		}
</style>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
	<section class="container">
		<h1>${board} Detail Page</h1>
	<!-- Getter 이름 : 메서드에서 get을 제외하고 첫번째글자를 소문자로 바꾼것 -->
	<!-- DB & GETTER 이름 동일 -->
	
	<table class="table table-hover">
			<thead class="table-dark">
				<th>SUBJECT</th><th>작성자</th><th>날짜</th><th>HIT</th>
			</thead>
			<tbody>
				<!-- Controller에서 속성명=items를 해서  -->
				<tr class="row-date">
					<td>${dto.subject}</td>
					<td>${dto.name}</td>
					<td>${dto.createDate}</td>
					<td>${dto.hit}</td>
				</tr>			
				<tr><td colspan=4>${dto.contents}</td></tr>
			</tbody>
		</table>
		

		<!-- Controller에서 작성한 키 이름과 동일하게 적기 -->
		<c:forEach items="${dto.fileDTOs}" var="f">
			<img alt="" src="../resources/upload/${board}/${f.fileName}">
		</c:forEach>
		
		
		
		<a href="./update?num=${dto.num}" class="btn btn-danger">수정</a>
		<a href="./delete?num=${dto.num}" class="btn btn-danger">삭제</a>
		
		<!-- parameterName = data-delete-name 속성에 넣기 -->
		<button id="del"  class="btn btn-danger" data-delete-name="num" data-delete-num="${dto.num}">삭제</button>

		<form action="">
			<!--  -->
			<c:if test="${board ne 'notice'}">
				<a href="./reply?num=${dto.num}" class="btn btn-danger">답글달기</a>
			</c:if>
		</form>


		<script src="../resources/js/delete.js"></script>
	</section>
	
	
</body>
</html>