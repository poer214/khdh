const btn = document.getElementById("createBtn");

// btn.addEventListener("click",() => {
//     let arr = [];
//     while(arr.length < 6) {
//         const random = Math.floor(Math.random() * 45+1);
//         if(arr.indexOf(random) == -1) arr.push(random);
//     }
//     arr.sort( (a,b) => a-b );
//     for(let i=0; i<arr.length ; i++) document.getElementById("container").children[i].innerText = arr[i];
// })

btn.addEventListener("click",() => {
    let arr = Array.from({length: 6}, () => Math.ceil(Math.random() * 45));
    arr.sort( (a,b) => a-b );
    document.querySelectorAll('#container>div').forEach((element, index) => {
        element.innerText = arr[index];
    });
})