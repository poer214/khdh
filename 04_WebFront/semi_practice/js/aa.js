function sha256(input) {
    const hashed = CryptoJS.SHA256(input);
    return hashed.toString(CryptoJS.enc.Hex);
}
const input = document.getElementById('input');
document.querySelector('button').addEventListener('click',()=>{
    input.value = sha256(input.value);
    frm.submit();
});