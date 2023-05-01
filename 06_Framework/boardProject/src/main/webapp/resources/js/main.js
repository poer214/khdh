
const loginFrm = document.getElementById("loginFrm");

const memberEmail = document.querySelector("#loginFrm input[name='memberEmail']");
const memberPw = document.querySelector("#loginFrm input[name='memberPw']");

// 로그인 시도를 할 때
loginFrm.addEventListener("submit",e =>{
    // alert("로그인");

    // form태그 기본 이벤트 제거
    // e.preventDefault(); // 제출 막기

    // 아이디가 입력되지 않은 경우
    if(memberEmail.value.trim().length == 0){
        alert("이메일을 입력해주세요.");
        memberEmail.value = ""; // 잘못 입력된 값(공백) 제거
        memberEmail.focus(); // 이메일 input태그에 초점을 맞춤
        e.preventDefault(); // 제출 막기
        return;
    }
    
    // 비밀번호가 입력되지 않은 경우
    if(memberPw.value.trim().length == 0){
        alert("비밀번호를 입력해주세요.");
        memberPw.value = ""; // 잘못 입력된 값(공백) 제거
        memberPw.focus(); // Pw input태그에 초점을 맞춤
        e.preventDefault(); // 제출 막기
        return;
    }
})