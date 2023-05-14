// 좋아요 버튼이 클릭 되었을 때
const boardLike = document.getElementById("boardLike");

boardLike.addEventListener("click", e => {
    // 로그인 여부 검사
    if(loginMemberNo == ''){
        alert("로그인 후 이용해주세요");
        return;
    }

    let check;  // 기존에 좋아요 X(빈 하트) : 0
                //        좋아요 O(찬 하트) : 1

    // contains("클래스명") : 클래스가 있으면 true, 없으면 false
    
    
    if(e.target.classList.contains("fa-regular")) check = 0;// 좋아요 X(빈 하트) : 0
    else check = 1; // 좋아요 O(찬 하트) : 1

    // ajax로 서버로 제출 할 파라미터를 모아둔 JS 객체
    const data = {  "boardNo" : boardNo,
                    "memberNo" : loginMemberNo,
                    "check" : check };

    fetch("/board/like", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(data)
    })
    .then(resp => resp.text()) // 응답 객체를 필요한 형태로 파싱하여 리턴
    .then(cnt => { // 파싱된 데이터를 받아서 처리하는 코드 작성
        console.log("cnt : " + cnt);
        if(cnt == -1){ // INSERT, DELETE 실패 시
            console.log("좋아요 처리 실패");
            return;
        }
        
        // toggle() : 클래스가 있으면 없애고, 없으면 추가
        e.target.classList.toggle("fa-regular");
        e.target.classList.toggle("fa-solid");

        // 현재 게시글의 좋아요 수 갱신
        e.target.nextElementSibling.innerText = cnt;
    })
    .catch(err => { // 예외 발생 시 처리하는 부분
        console.log("예외 발생");
        console.log(err);
    });





});

document.getElementById("updateBtn").addEventListener("click", ()=>{
    location.href
        = location.pathname.replace("board","board2") // board2 / 게시판 코드 / 글번호
        + "/update" // /update
        + location.search; // 쿼리스트링 ?cp=페이지번호
});

// 게시글 삭제 버튼이 클릭 되었을 때

document.getElementById('deleteBtn').addEventListener("click", () => {

    if(confirm("정말 삭제하시겠습니까?")){
        location.href
        = location.pathname.replace("board","board2") // board2 / 게시판 코드 / 글번호
        + "/delete" // /delete
        + location.search; // 쿼리스트링 ?cp=페이지번호

        // /board2/1/2006/delete (GET)

        // 삭제 서비스 호출 성공 시 redirect:/board/{boardCode}
        // + RedirectAttributes 이용해서 "삭제 되었습니다" alert 출력

        // 삭제 서비스 호출 실패 시 redirect:/board/{boardCode}/{boardNo}
        // + RedirectAttributes 이용해서 "삭제 실패" alert 출력


    } else {
        alert("삭제 취소");
    }
})