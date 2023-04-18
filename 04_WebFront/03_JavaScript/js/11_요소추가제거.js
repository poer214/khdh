const addBtn = document.getElementById("add");
addBtn.addEventListener("click",()=>{
    // const element = document.createElement('div');
    // element.className = 'row';
    // element.innerHTML = '<input type="number" class="in">';
    // document.querySelector('.container').append(element);
    // const container = document.querySelector('.container');
    document.querySelector('.container').insertAdjacentHTML('beforeend', '<div class="row"><input type="number" class="in"> <span class="remove-row">&times;</span></div>');
    
    document.querySelectorAll(".remove-row")[document.querySelectorAll(".remove-row").length-1].addEventListener('click', e => {
        e.target.parentElement.remove();
    })
})

const calcBtn = document.getElementById("calc");
calcBtn.addEventListener("click",()=>{
    const numberList = document.getElementsByClassName("in");
    let result = 0;
    for(let i=0;i<numberList.length;i++)
        result += Number(numberList[i].value);
    alert(`결과는 ${result} 입니다.`);
})


// 요소의 클래스 목록 확인하기 : 요소.classList
// 요소에 class 추가 : 요소.classList.add("클래스명");
// 요소의 class 제거 : 요소.classList.remove("클래스명");
// 요소의 속성 정보 확인하기 : 요소.attributes
// 요소에 속성 추가 : 요소.setAttiribute("속성명","값");
// 요소의 속성 삭제 : 요소.removeAttiribute("속성명");

// 부모 요소의 마지막 자식으로 자식 요소를 추가 : 부모요소.append(자식요소);
// 부모 요소의 첫 번째 자식으로 자식 요소를 추가 : 부모요소.prepend(자식요소);
// 요소의 이전 형제로 요소를 추가 : 요소.before(요소)
// 요소의 다음 형제로 요소를 추가 : 요소.after(요소)


// 삭제 버튼 동작 테스트

// 클래스가 remove-row인 요소 중 첫 번째 요소