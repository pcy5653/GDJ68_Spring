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
	<h1>Detail Page</h1>
	
	<%-- ${} --%>
	<!-- Getter 이름 : 메서드에서 get을 제외하고 첫번째글자를 소문자로 바꾼것 -->
	<!-- DB & GETTER 이름 동일 -->
	<h1>${requestScope.dto.bookName}</h1>
	
	<div>
		${dto.bookContents}
	</div>
	
	<h1>${dto.bookRate} </h1>
	
	<c:choose>
		<c:when test="${dto.bookSale eq 1}">
			<h1>판매중</h1>
		</c:when>
		<c:otherwise>
			<h1>판매종료</h1>
		</c:otherwise>
	</c:choose>
	
	
	<c:forEach items="${dto.fileDTOs}" var="f">
		<img alt="" src="/resources/upload/bankbook/${f.fileName}">
	</c:forEach>
	
	<!-- 
	<a href="./update?bookNum=${dto.bookNum}">수정</a>
	<a href="./delete?bookNum=${dto.bookNum}">삭제</a> 
	-->



	<button id="update">수정</button>
	<!-- 2. 속성 사용 : data-**** 이라는 속성명을 통해 bookNum을 받아와 JS에서 id명.getAttributes로 불러와 삭제 -->
	<button id="del" data-delete-name="bookNum" data-delete-num="${dto.bookNum}">삭제</button>
	<a class="btn btn-primary" href="../bookAccount/add?bookNum=${dto.bookNum}">상품가입</a>
	<button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#accountModal">상품가입</button>

	<!-- modal : btn의 target의 이름(#이름)과 modal의 id 동일
		1. 상품가입 btn을 누르면 modal이 실행
		-->
	<div class="modal fade" id="accountModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		  <div class="modal-content">
			<div class="modal-header">
			  <h1 class="modal-title fs-5" id="exampleModalLabel">비밀번호를 입력하세요.</h1>
			  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<div class="mb-3">
					<input type="password" name="accountPassword" class="form-control" id="pw" placeholder="출금 비밀번호 4자리를 입력하세요">
				</div>
			</div>
			<div class="modal-footer">
			  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="close">Close</button>
			  <button type="button" class="btn btn-primary" id="add" data-add-num="${dto.bookNum}">상품가입</button>
			</div>
		  </div>
		</div>
	  </div>
	
<%-- 	
	<c:if test="${dto.bookSale eq 1}">
		<h1>판매중</h1>
	</c:if>
	<c:if test="${dto.bookSale eq 0}">
		<h1>판매종료</h1>
	</c:if>
--%>
	
	<!-- 현재 detail.jsp 위치 : /bankbook/detail.jsp 
		 실제 경로 root 기준   : /bankbook/detail.jsp
		 detail.jsp 기준	  : ..(bankbook 폴더 나가고)/resorce/js/delete.js		=> script 주소
		-->
	<script src="../resources/js/delete.js"></script>

	<!-- <script>
		// 1. 함수 사용 : js에서는 ${dto.bookNum}이 넘어가지 못하니 함수에 담아 보내준다.
		setBookNum(${dto.bookNum});
	</script> -->

	<!-- 함수 사용 : js에서는 ${dto.bookNum}이 넘어가지 못하니 함수에 담아 보내준다. -->
	<script type="text/javascript">	
		const add = document.getElementById("add");

		add.addEventListener("click", function(){
			// data-add-num : bookNum			
			let bookNum = add.getAttribute("data-add-num");
			// pw.value : password
			let pw = document.getElementById("pw").value;

			// ajax1() 변수 실행
			// ajax1(bookNum, pw);
			 ajax2(bookNum, pw);
		});


		function ajax2(bookNum, pw){
			fetch("../bookAccount/add",{
				method : "post",
				body : "bookNum="+bookNum+"&"+"accountPassword="+pw ,
				headers : {
					"Content-type":"application/x-www-form-urlencoded"
				}
			})
			.then((response)=>{
				return response.text();		// 0 or 1
			})
			.then((r)=>{	// response의 결과값을 r에 담는다.
				if(r>0){
					alert("가입 완료");
				}else{
					alert("가입 실패");
				}

				location.href="../";
			})
			;

		}

		function ajax1(bookNum, pw){
			// 1. Ajax 객체 선언
			let xhttp = new XMLHttpRequest();

			// 2. 요청정보 : open("method", "url") -> POST로 DB에 전달.
			xhttp.open("post","../bookAccount/add");

			// 3. 요청 header 정보
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

			// 4. 요청 발생(POST일 경우 파라미터 작성) Key=Value&Key2=Value2....
			xhttp.send("bookNum="+bookNum+"&"+"accountPassword="+pw);

			// 5. 응답 처리
			xhttp.onreadystatechange=function(){
				if(this.readyState==4 && this.status==200){
					// ajaxResult의 Text 내용이 r에 담김. (1 or 0)
					let r = this.responseText.trim();
					console.log(r);
					if(r>0){
						alert("가입 성공");
					}else{
						alert("가입 실패");
					}
					// aler창 뜨고 Modal 창 강제종료
					document.getElementById("close").click();
					
					// index page 이용
					location.href="../";
				}
			}
		}
	</script>
</body>
</html>