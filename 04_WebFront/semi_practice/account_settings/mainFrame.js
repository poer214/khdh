// 로고 클릭시 메인페이지
document.getElementById("logoimg").addEventListener("click", () => {
  window.location.href = '/vote/mainFrame.html';
});


// 프레임 불러오기
document.getElementById("startPetitions").addEventListener("click",function () {
    document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="startPetitions/start_a_petition.html"></iframe>';
});

document.getElementById("myPetitions").addEventListener("click",function () {
  document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="/vote/myPetitions/myPetitions/login_mypettitions.html"></iframe>';
});

document.getElementById("browse").addEventListener("click",function () {
  document.getElementById("mf").innerHTML = '<iframe id="iframe" onload="iframeLoaded()" frameborder = "0" src="browse/browser.html"></iframe>';
});

// 프레임 크기 변동
function iframeLoaded() {
  let frame = document.getElementById('iframe');
  let mheight = document.getElementById('mf');
  let height = frame.contentWindow.document.body.scrollHeight;
  let width = frame.contentWindow.document.body.scrollWidth;

  mheight.height = height + "px";
  mheight.width = width + "px";

  frame.height = height + 100 + "px";
  frame.width = width + 100 + "px"
}