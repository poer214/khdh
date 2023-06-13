// 미리보기 관련 요소 모두 얻어오기


// img 5개
const previews = document.getElementsByClassName("preview");

// file 5개
const inputImages = document.getElementsByClassName("input-image");

// x버튼 5개
const deleteImages = document.getElementsByClassName("delete-image");

// -> 위에 얻어온 요소들의 개수가 같음 == 인덱스가 일치함

for(let i=0 ; i<inputImages.length ; i++){
    // 파일이 선택되거나, 선택 후 취소 되었을 때
    inputImages[i].addEventListener('change', e => {
        
        const file = e.target.files[0]; // 선택된 파일의 데이터

        if(file != undefined){ // 파일이 선택되었을 때

            const reader = new FileReader(); // 파일을 읽는 객체

            reader.readAsDataURL(file);
            // 지정된 파일을 읽은 후 result 변수에 URL 형식으로 저장

            reader.onload = e => { // 파일을 다 읽은 후 수행
                previews[i].setAttribute("src",e.target.result);
            }


        } else { // 파일 선택 후 취소 되었을 때
                // -> 선택된 파일 없음 -> 미리보기 삭제
            previews[i].removeAttribute("src");
        }
    })

    // 미리보기 삭제 버튼(X버튼) 클릭 시
    deleteImages[i].addEventListener('click', () => {
        // 미리보기 이미지가 있을 경우
        if(previews[i].getAttribute("src") != ""){
            // preview의 src속성 지우기(미리보기 삭제)
            previews[i].removeAttribute("src");
            // inputImage Value 비우기(파일 경로 삭제)
            inputImages[i].value="";
        }
    })
}

// 게시글 등록 시 제목, 내용 작성 여부 검사
const boardWriteFrm = document.getElementById("boardWriteFrm")
const boardTitle = document.querySelector("[name='boardTitle']")
const boardContent = document.querySelector("[name='boardContent']")

boardWriteFrm.addEventListener("submit", e=>{
    if(boardTitle.value.trim().length == 0) {
        alert("제목을 입력해주세요.");
        boardTitle.value = "";
        boardTitle.focus();
        e.preventDefault(); // form 기본 이벤트 제거
    }
    if(boardContent.value.trim().length == 0){
        alert("내용을 입력해주세요.");
        boardContent.value = "";
        boardContent.focus();
        e.preventDefault(); // form 기본 이벤트 제거
    }
})