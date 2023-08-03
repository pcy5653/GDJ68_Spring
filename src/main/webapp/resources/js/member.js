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
    }else{
        idtext.innerText="사용가능한 ID입니다.";
        idtext.className="s";
    }
});

// 강사님 -> ID
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

// --------------------------------------------------


// PW : 빈칸X, 6글자 이상 12글자 미만
pw.addEventListener("blur", function(){
    if(pw.value==""){
        pw.focus();
        pwtext.innerText="PW를 입력하세요."
    }else if(pw.value.length >= 6 && pw.value.length < 12){
        pwtext.innerText="올바른 PW입니다."
        pwtext.className="s";
    }else{
        pw.focus();
        pwtext.innerText="6글자 이상 12글자 미만입니다.";
        pwtext.className="f";
    }

    // pw 바뀔 시 pw2 일치하지 않음 출력
    pw.addEventListener("change", function(){
        if(pw.change==""){

        }
    })
})


// 강사님 PW
// pw.addEventListener("blur", function(){
//     const pwtext = document.getElementById(pw.id+"Result");
//     if(pw.value.length>5 && pw.value.length<12){
//         pwtext.innerText="올바른 PW입니다."
//         pwtext.className="s";
//     }else{
//         pwtext.innerText="6글자 이상 12이하의 PW를 입력하세요."
//         pwtext.className="f";
//     }
// })

// --------------------------------------------------


// PW2 : PW와 동일 , 글자를 1글자씩 입력할 때마다 검사.
pw2.addEventListener("keyup", function(){
    if(pw2.value == pw.value){
        pwtext2.innerText="일치합니다.";
    }else{
        pwtext2.innerText="일치하지 않습니다.";
    }
});



// 강사님 PW2


// --------------------------------------------------


// NAME : 빈칸X
n.addEventListener("blur", function(){
    if(n.value==""){
        n.focus();
        nametext.innerText="이름을 입력하세요."
    }else{
        nametext.innerText="";
    }
})


// Email : 빈칸X 
email.addEventListener("blur", function(){
    if(email.value==""){
        email.focus();
        emailtext.innerText="Email을 입력하세요. (ex> abc@naver.com)"
    }else{
        emailtext.innerText="";
    }
})


// Birth : 빈칸X, 회원가입 버튼을 클릭했을 때 검증.
btn.addEventListener("click", function(){
    if(birth.value==""){
        birth.focus();
        birthtext.innerText="생일을 입력하세요."
    }else{
        birthtext.innerText="";
        frm.submit();
    }

    
})