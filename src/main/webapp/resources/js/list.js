const kind = document.getElementsByClassName("kind");
const ki = document.getElementById('k');
const move = document.getElementsByClassName('move');
const page= document.getElementById('page');
const frm = document.getElementById('frm');



// let data = '';

// // 1. 함수를 사용
// function setData(d){
//     data=d;
//     for(k of kind){
//         if(k.value==data){
//              k.selected=true;
//              break;
//         }
//      }
// }

// 2. element의 속성에 변수 담아 사용
let data = ki.getAttribute("data-kind");
for(k of kind){
    if(k.value==data){
        k.selected=true;
        break;
    }
}


for(m of move){
    m.addEventListener("click", function(){
        // page 번호를 select의 value에 대입
        page.value = this.getAttribute("data-num")
        frm.submit();
    });
}


