const createBtn = document.querySelector('#createBtn')
const lottoBoard = document.

createBtn.addEventListener("click",()=>{
    lottoBoard.innerHTML = '';

    for(let i=1;i<=45;i++){

        // 로또판에 들어갈 div 요소 생성
        const innerDiv = document.createElement("div");

        // 
        innerDiv.innerText = i;
        innerDiv.classList.add('number');

        innerDiv.addEvenetListener('click',e => {
            if(e.target.classList.contains('active')){
                e.target.classList.remove('active');
            } else {
                e.target.classList.add('active');
            }
            
        });

        lottoBoard.append(innerDiv);
    }
})