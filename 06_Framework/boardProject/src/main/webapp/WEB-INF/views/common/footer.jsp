<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<footer>
    <p>Copyright &copy; KH Information Educational Institute A-Class</p>
    <article>
        <a href="#">프로젝트 소개</a>
        <span>|</span>
        <a href="#">이용 약관</a>
        <span>|</span>
        <a href="#">개인정보처리방침</a>
        <span>|</span>
        <a href="#">고객센터</a>
    </article>
</footer>
<%-- session message가 존재할 경우--%>
<%-- not empty : 비어있지 않을 경우 true --%>
<c:if test="${not empty sessionScope.message}">
    <script>
        alert('${message}');
    </script>
    <%-- 
        session에 message를 추가하면
        브라우저 종료 또는 만료 전까지 계속 메시지가 출력된다.
        -> 1회 출력 후 session에서 message 삭제
    --%>
    <c:remove var="message" scope="session" />
</c:if>