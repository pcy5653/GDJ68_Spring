const frm = document.getElementById("frm");
const id = document.getElementById("id");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const n = document.getElementById("name");
const email = document.getElementById("email");
const birth = document.getElementById("birth");
const btn = document.getElementById("btn");

const idtext = document.getElementById("idText");
const pwtext = document.getElementById("pwText");
const pwtext2 = document.getElementById("pwText2");
const nametext = document.getElementById("nameText");
const emailtext = document.getElementById("emailText");
const birthtext = document.getElementById("birthText");




// ID : 빈칸X, 10글자 초과X
id.addEventListener("blur", function(){
    if(id.value=="" || id.value.length > 10){
        id.focus();
        idtext.innerText="10글자 이하의 ID를 입력하세요";
        idtext.className="f";
        checkResults[0] = false; 
    }else{
        idtext.innerText="사용가능한 ID입니다.";
        idtext.className="s";
        checkResults[0] = true; 
    }
});


// PW : 빈칸X, 6글자 이상 12글자 미만
pw.addEventListener("blur", function(){
    if(pw.value.length >= 6 && pw.value.length < 12){
        pwtext.innerText="올바른 PW입니다."
        pwtext.className="s";
        checkResults[1] = true; 
    }else{
        pw.focus();
        pwtext.innerText="6글자 이상 12글자 미만입니다.";
        pwtext.className="f";
        checkResults[1] = false; 
    }
})

pw.addEventListener("change", function(){
    pw2.value="";   // pw와 값이 다를 때, pw2의 값을 빈칸
    checkResults[2]=false;  // true -> false 변경
    pwtext2.innerText="일치하지 않습니다."
    pwtext2.className="f";
})


// PW2 : PW와 동일 , 글자를 1글자씩 입력할 때마다 검사.
pw2.addEventListener("keyup", function(){
    if(pw2.value==pw.value){
        pwtext2.innerText="일치합니다.";
        pwtext2.className="s";
        checkResults[2] = true; 
    }else{
        pwtext2.innerText="일치하지 않습니다.";
        pwtext2.className="f";
        checkResults[2] = false; 
    }
})


// NAME : 빈칸X
n.addEventListener("blur", function(){
    let check = emptyCheck(n);
    nametext.innerText="이름을 작성하세요.";
    nametext.className="f";
    checkResults[3] = false; 

    if(!check){     // check=false면 공백채움
        nametext.innerText="가능합니다.";
        nametext.className="s"; 
        checkResults[3] = true; 
    }
})


// Email : 빈칸X 
email.addEventListener("blur", function(){
    if(email.value==""){
        email.focus();
        emailtext.innerText="Email을 입력하세요. (ex> abc@naver.com)"
        checkResults[4] = false; 
    }else{
        emailtext.innerText="";
        checkResults[4] = true; 
    }
})


// Birth : 빈칸X, 회원가입 버튼을 클릭했을 때 검증.
birth.addEventListener("change", function(){
    let check = emptyCheck(birth);
    birthtext.innerText="Email을 작성하세요.";
    birthtext.className="f";
    checkResults[5] = false; 

    if(!check){     // check=false면 공백채움
        birthtext.innerText="사용가능한 이메일 입니다.";
        birthtext.className="s"; 
        checkResults[5] = true; 
    }
})

btn.addEventListener("click", function(){
    let c = checkResults.includes(false);
    if(!c){
        // form 전송
        console.log("form 전송")
        frm.submit();
    }else{
        alert("필수 항목을 작성하세요.");
    }
})



// ------------------------<강사님 ver>----------------------------------
// >> 비어있는지 체크하는 함수
// -> value == null 이면 ||(or) 연산자로 true 값을 주니 뒤에 조건식은 계산하지 않고 바로 true값 갖는다.
// -> 
function emptyCheck(element){
    if(element.value == null || element.value.length == 0){
        return true;
    }else{
        return false;
    }
}


// 방법1. idcheck 결과
// 각각의 성공의 여부에 따라 false / true 작성
// idCheckResult = false; / idCheckResult = true;
let idCheckResult = false;
let pwCheckResult = false;
let pw2CheckResult = false;
let nameCheckResult = false;
let emailCheckResult = false;

// 인덱스마다 id, pw, pw2, name, email 확인
let checkResults=[false, false, false, false, false, false];


//// ID
// id.addEventListener("blur", function(){
//     const idtext = document.getElementById(id.id+"Result");
//     if(id.value == "" || id.value.length > 10){
//         idtext.innerText="ID는 비어있으면 안되고 10글자 미만이어야 합니다."
//         idtext.className="f";
//     }else{
//         idtext.innerText=" ";
//         idtext.className="s";
//     }
// })


//// PW
// pw.addEventListener("blur", function(){
//     const pwtext = document.getElementById(pw.id+"Result");  -> pw.id+"Result" = 문자열 출력 (pwtext에 id명Result로 출력하기 위함)
//     if(pw.value.length>5 && pw.value.length<12){
//         pwtext.innerText="올바른 PW입니다."
//         pwtext.className="s";
//     }else{
//         pwtext.innerText="6글자 이상 12이하의 PW를 입력하세요."
//         pwtext.className="f";
//     }
// })




//// PW2
// pw2.addEventListener("keyup", function(){
//     if(pw2.value==pw.value){
//         pwtext2.innerText="비밀번호가 같다";
//         pwtext2.className="s";
//     }else{
//         pwtext2.innerText="비밀번호가 다르다";
//         pwtext2.className="f";
//     }
// })



//// name
// n.addEventListener("blur", function(){
//     let check = emptyCheck(n);
//     nametext.innerText="이름을 작성하세요.";
//     nametext.className="f";
//     checkResults[3] = false; 

//     if(!check){     // check=false면 공백채움
//         nametext.innerText="가능합니다.";
//         nametext.className="s"; 
//         checkResults[3] = false; 
//     }
// })


//// email
// email.addEventListener("blur", function(){
//     let check = emptyCheck(email);
//     emailtext.innerText="Email을 작성하세요.";
//     emailtext.className="f";

//     if(!check){     // check=false면 공백채움
//         emailtext.innerText="사용가능한 이메일 입니다.";
//         emailtext.className="s"; 
//     }
// })

//// birth


