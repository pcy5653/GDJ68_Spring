// GetList btn
const list = document.getElementById("list");

list.addEventListener("click", function(){
    // Ajax
    let xhttp = new XMLHttpRequest();

    // open("method", "url")
    xhttp.open("GET", "./list?page=1");

    //send : POST파라미터 전송, 현재 responseText의 내용을 보여줌
    xhttp.send();

    xhttp.onreadystatechange=function(){
        // 4wayHandShaking == 4번 && 요청이 200번대(성공)
        if(this.readyState==4 && this.status==200){
            // 응답데이터가 담기는 곳 (responseText)
            console.log(this.responseText);
        }
    }
})