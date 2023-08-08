<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1 class="my-4">My Page</h1>
	
	<div>
	
		<p>
			<!-- ${member.memberFileDTO.fileName} = member는 Controller의 getLogin에서 불러오는 속성명 -->
			<img alt="" src="../resources/upload/member/${member.memberFileDTO.fileName}">
		</p>
		<p>
			${member.id} : ${sessionScope.member.name}
		</p>
		<p>
			${member.email}
		</p>
		<p>
			${member.birth}
		</p>
	</div>

	<a class="btn btn-primary" href="./memberUpdate">회원수정</a>
	
	<div id="productList">

	</div>


</section>

<script>
	const productList = document.getElementById("productList");
	getList(1);
	

	// mypage > 상품가입목록 하단의 page를 누르면 해당 page의 내용 출력.
	productList.addEventListener("click", function(event){
	// li > a 태그 class명 : move
	if(event.target.classList.contains("move")){	
		let page = event.target.getAttribute("data-num");
		console.log("before");
		getList(page);
	}
})

// Ajax
// pager 번호 넘기기
function getList(page){
	fetch("../bookAccount/list?page="+page,{
		method : "get"
	})
	.then((response)=>{return response.text()})
	.then((r)=>{
		console.log("ajax 실행");
		productList.innerHTML=r;
		console.log("after");
		})
		;
	}

</script>

</body>
</html>