document.getElementById('createBtn').addEventListener('click',()=>{
    const lottoBoard = document.querySelector('#lottoBoard');
    if(lottoBoard.children.length>1){
        alert('이미 생성되어있습니다.');
        return;
    }
    for(let i=0; i<45;i++){
        const el = document.createElement('span');
        el.classList.add('number');
        el.innerText = i+1;
        lottoBoard.append(el);
        el.addEventListener('click',()=>{
            if(el.classList.contains('active') || document.querySelectorAll('#lottoBoard>.active').length<6)
                el.classList.toggle('active');
            else
                alert('6개 초과 선택 불가');
        })
    }
})

document.getElementById('autoBtn').addEventListener('click',()=>{
    const lottoBoard = document.querySelector('#lottoBoard');
    if(lottoBoard.children.length<1) {
        alert('로또판을 먼저 생성해주세요.');
        return;
    }
    spanList = document.querySelectorAll('#lottoBoard>span');
    spanList.forEach(span=>{
        if(span.classList.contains('active'))
            span.classList.remove('active');
    })
    let arr = [];
    while(arr.length < 6) {
        const random = Math.floor(Math.random() * 45+1);
        if(arr.indexOf(random) == -1) arr.push(random);
    }
    arr.sort( (a,b) => a-b );
    const item = document.createElement('div');
    item.classList.add('item');
    for(let i=0;i<arr.length;i++){
        const sel = spanList[arr[i]-1];
        sel.classList.add('active');
        const span = document.createElement('span');
        span.innerText = arr[i]-1;
        span.classList.add('number');
        span.classList.add('active');
        item.append(span);
    }

    const history = document.querySelector('#history');
    history.append(item);
})

/* - document.createElement("태그명") -> 요소 생성
- 부모요소.append(자식요소) -> 부모의 마지막 자식 요소로 추가

<<<크기, 색상, 내용 지정해서 등록하기>>>
- 요소.setAttribute("속성명", "값)
   -> 요소에 속성명=값 추가

- 요소.getAttribute("속성명")
   -> 요소가 가지고있는 속성의 값 반환   
   
<<<로또판 생성하기>>>
- 요소.classList.contains("클래스명")
   -> 요소에 class 값 중 "클래스명"이 일치하는 요소가 있으면 true
      없으면 false */