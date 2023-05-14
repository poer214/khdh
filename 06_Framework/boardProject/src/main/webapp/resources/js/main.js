
const loginFrm = document.getElementById("loginFrm");

const memberEmail = document.querySelector("#loginFrm input[name='memberEmail']");
const memberPw = document.querySelector("#loginFrm input[name='memberPw']");

// 비로그인상태일 떄
if(loginFrm!=null)
    // 로그인 시도를 할 때
    loginFrm.addEventListener("submit", e => {
        // alert("로그인");

        // form태그 기본 이벤트 제거
        // e.preventDefault(); // 제출 막기

        // 아이디가 입력되지 않은 경우
        if (memberEmail.value.trim().length == 0) {
            alert("이메일을 입력해주세요.");
            memberEmail.value = ""; // 잘못 입력된 값(공백) 제거
            memberEmail.focus(); // 이메일 input태그에 초점을 맞춤
            e.preventDefault(); // 제출 막기
            return;
        }

        // 비밀번호가 입력되지 않은 경우
        if (memberPw.value.trim().length == 0) {
            alert("비밀번호를 입력해주세요.");
            memberPw.value = ""; // 잘못 입력된 값(공백) 제거
            memberPw.focus(); // Pw input태그에 초점을 맞춤
            e.preventDefault(); // 제출 막기
            return;
        }
    })


// 비동기로 이메일이 일치하는 회원의 닉네임 조회
function selectNickname(email) {
    fetch("/selectNickname?email="+email)
        // 지정된 주소로 GET방식 비동기 요청(ajax)
        // 전달하고자 하는 파라미터를 주소 뒤 쿼리스트링으로 추가
        .then(response => response.text()) // 요청에 대한 응답 객체(response)를 필요한 형태로 파싱
        .then(nickname => { console.log(nickname) }) // 첫 번째 then에서 파싱한 데이터를 이용한 동작 작성
        .catch (e => { console.log(e) }) // 예외 발생 시 처리할 내용을 작성
}

const inputNickname = document.getElementById("inputNickname");
const btn1 = document.getElementById("btn1");
const result1 = document.getElementById("result1");

 // GET 방식 요청(파라미터를 쿼리스트링으로 추가)

btn1.addEventListener('click',()=>{
    fetch("/selectMemberTel?nickname="+inputNickname.value)
    .then(resp => resp.text())
    // resp : 응답 객체
    // resp.text() : 응답 객체 내용을 문자열로 변환하여 반환
    
    .then(tel => {/* 비동기 요청 후 수행할 코드 */result1.innerText = tel }) // 조회 결과를 result1에 출력
    .catch(err => {console.log(err)});
})


// fetch() API를 이용한 POST 방식 요청

// 이메일을 입력 받아 일치하는 회원의 정보를 모두 조회

// 입력받은 주소가 포함된 회원을 모두 조회


const inputEmail = document.getElementById("inputEmail")
const btn2 = document.getElementById("btn2")
const result2 = document.getElementById("result2")

btn2.addEventListener('click', ()=>{
    
    // POST 방식 비동기 요청

    // JSON.stringify() : JS객체 -> JSON
    // JSON.parse()     : JSON -> JS객체

    fetch("/selectMember", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify({email:inputEmail.value})
    })
    .then(resp => resp.json()) // 응답 객체를 매개변수로 얻어와 파싱
    .then(member =>{
        console.log(member);
        result2.innerHTML = '';
        const li1 = document.createElement("li");
        li1.innerText = `회원번호 : ${member.memberNo}`;
        const li2 = document.createElement("li");
        li2.innerText = `이메일 : ${member.memberEmail}`;
        const li3 = document.createElement("li");
        li3.innerText = `닉네임 : ${member.memberNickname}`;
        const li4 = document.createElement("li");
        li4.innerText = `전화번호 : ${member.memberTel}`;
        const li5 = document.createElement("li");
        li5.innerText = `주소 : ${member.memberAddress}`;
        const li6 = document.createElement("li");
        li6.innerText = `가입일 : ${member.enrollDate}`;
        result2.append(li1, li2, li3, li4, li5, li6);
    }) // 파싱한 데이터를 이용해서 비동기 처리 후 동작
    .catch(err => {
        console.log(err);

        result2.innerText = "일치하는 회원이 없습니다.";
    });
});

// 이메일이 일부라도 일치하는 모든 회원 조회
const input = document.getElementById("input");
const btn3 = document.getElementById("btn3");
const result3 = document.getElementById("result3");

btn3.addEventListener("click", ()=> {
    fetch(`/selectMemberList?input=${input}`)
    .then(resp => resp.json())
    .then(memberList => {
        console.log(memberList);
        
        result3.innerText = memberList===0?"조회 결과가 없습니다.":"";
        if(memberList===0) return;
        // 향상된 for문으로 memberList 순차 접근
        for(let member of memberList){

            // tr, td 만들어서 result3에 추가
            const tr = document.createElement("tr");
            tr.innerHTML = `
                <td>${member.memberNo}</td>
                <td>${member.memberEmail}</td>
                <td>${member.memberNickname}</td>
            `;
            result3.append(tr);
        }
    })
    .catch(err => {
        console.log(err);
    });
})
// btn3.addEventListener("click", ()=> {
//     fetch("/selectMemberList", {
//         method : "POST",
//         headers : {"Content-Type" : "application/text"}, // text -> 문자열 하나를 파라미터로 전달
//         body : input.value // 보내질 문자열 하나
//     })
//     .then(resp => resp.json())
//     .then(memberList => {
//         console.log(memberList);
        
//         result3.innerText = memberList===0?"조회 결과가 없습니다.":"";
//         if(memberList===0) return;
//         // 향상된 for문으로 memberList 순차 접근
//         for(let member of memberList){

//             // tr, td 만들어서 result3에 추가
//             const tr = document.createElement("tr");
//             tr.innerHTML = `
//                 <td>${member.memberNo}</td>
//                 <td>${member.memberEmail}</td>
//                 <td>${member.memberNickname}</td>
//             `;
//             result3.append(tr);
//         }
//     })
//     .catch(err => {
//         console.log(err);
//     });
// })