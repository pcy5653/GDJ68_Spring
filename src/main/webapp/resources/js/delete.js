// 1. bankBook > detail.jsp 삭제 버튼 실행

// del(element) : 태그+속성+contents 를 가져왔기 때문에 속성 data-delete-num(bookNum)을 가져와 해당 내용을 삭제한다.
let del = document.getElementById('del')

let bookNum;

// 1. 함수 사용
function setBookNum(num){
    bookNum = num;
}

del.addEventListener("click", function (){
    let result = window.confirm("삭제하시겠습니까?");
    if(result){
        // location을 통해 URL 주소를 변경한다.
        // jsp안에서만 ${}=EL이 적용되기 때문에 js에서는 EL 사용X
        // location.href="./delete?bookNum=${dto.bookNum}"; = X

        console.log(del.id);
        console.log(del.getAttribute("data-delete-num"));
        bookNum = del.getAttribute("data-delete-num");
        let parameterName = del.getAttribute("data-delete-name");
        location.href="./delete?"+parameterName+"="+bookNum;
    }
});