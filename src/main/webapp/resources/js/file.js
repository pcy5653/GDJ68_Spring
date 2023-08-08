{/* <div class="mb-3">
	<label for="pic" class="form-label">사진첨부1</label>
	<input type="file" name="photos" class="form-control" id="pic">
</div> */}

const filelist = document.getElementById("fileList");
const fbtn = document.getElementById("add");
const delets = document.getElementsByClassName("delets");


if(delets != null){
    count=delets.length;
    //alert(count);
}

// >> board > update.jsp 중에 span class="delets" (X)를 누를시 파일 삭제
for(del of delets){
    del.addEventListener("click",function(){
        let num = this.getAttribute("data-delete-num");
        let check = confirm("삭제시 복구 불가합니다. 정말로 삭제하시겠습니까?");    // true | false

        if(check){
            // 현재위치 (Notice or QNA) 
            fetch("./fileDelete?fileNum="+num, {
                method : "get"
            })
            .then((result)=>{return result.text()})
            .then((r)=>{
                if(r.trim()=='1'){
                    this.previousSibling.previousSibling.remove();  // this의 형제, class="alert alert-info"
                    this.remove();                                  // 본인 자신 (span)
                    count--;                                        // 삭제하고 전체 count 감소
                }
            })      
            
        }
    });
}

let count = 0;
let idx = 0;


// 1. fileBtn 누를 시 file input 생성 (5개까지만 생성)
fbtn.addEventListener("click", function(){
    if(count < 5){
        let d = document.createElement("div");
        let f = document.createAttribute("class");
        f.value ="input-group mb-3";
        d.setAttributeNode(f);
        f = document.createAttribute("id");
        f.value="file"+idx;
        d.setAttributeNode(f);

        //input
        let e = document.createElement("input");
        let t = document.createAttribute("type");
        t.value = "file";
        e.setAttributeNode(t);

        t = document.createAttribute("name");
        t.value = "photos";
        e.setAttributeNode(t);

        t = document.createAttribute("class");
        t.value = "form-control";
        e.setAttributeNode(t);

        t = document.createAttribute("id");
        t.value = "pic";
        e.setAttributeNode(t);

        d.appendChild(e);


        // 2. 파일 옆에 삭제하는 X 생성.
        // <span> X </span>를  만듦.
        let s = document.createElement("span");
        let a = document.createTextNode("X");
        s.appendChild(a);

        t = document.createAttribute("class");
        t.value="df";
        s.setAttributeNode(t);
        t = document.createAttribute("data-id");
        t.value="file"+idx;
        s.setAttributeNode(t);
        
        d.appendChild(s);


        filelist.appendChild(d);

        count++;
    }else{
        alert("파일은 최대 5개입니다.");
    }

    idx++;
    
})


// 3. 파일 옆에 X를 눌렀을 때, file이 삭제되도록 실행.
// span은 처음에 없고 btn을 눌렀을 때 생성되는 것이기 때문에 event를 위임해서 실행.
// -> 3_1. 부모인 fileList에게 event 실행.
// -> 3_2. 여러개의 class 명을 지녔으니, classList로 선언한다.
filelist.addEventListener("click", function(event){
    console.log(event.target);      // event의 영역 확인 = div#fileList
    let c1 = event.target.classList;
    if(event.target.classList.contains("df")){
        let deleteId = event.target.getAttribute("data-id");
        document.getElementById(deleteId).remove();     
        count--;    // 파일 삭제 시, count 수를 차감.
    }
});


