<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
    <%@ %> : 지시자 태그

    taglib : 태그 라이브러리 추가(JSTL, 커스텀태그)

    prefix : 접두사(앞에 붙이는 말, 단어)
            태그명 앞에 작성되는 단어 <c:if>

    uri(Uniform Resource Identifier, 통합 자원 식별자)
        -> 자원을 식별하는 고유 문자열 (ID)

    참고 url(Uniform Resource Locator)
        -> 자원의 위치를 나타내는 문자열 (경로)

    





--%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSTL(Jsp Standard Tag Library)</title>
</head>
<body>
    <a href="condition">JSTL을 이용한 조건문(if, choose, when, then)</a>
    <br>
    <a href="loop">JSTL을 이용한 반복문(forEach)</a>
    <br>
    <h3><a href="student/selectAll">workbook에서 학생 전체 조회하기</a></h3>


    <h1>JSTL(Jsp Standard Tag Library, JSP 표준 태그 라이브러리)</h1>

    <pre>
    JSP에서 자주 사용되거나 공통적으로 사용되는 JAVA 코드(if,for,변수선언,형변환)를
    
    스크립틀릿 대신 html 태그 형식을 태그화하여
    표준으로 제공하는 라이브러리(if, for 간단히 쓰고싶으면 이 라이브러리를 사용해라)
    </pre>

    <h3>JSTL 라이브러리 다운로드 및 등록방법</h3>

    <ol>
        <li>
            <a href="https://tomcat.apache.org/download-taglibs.cgi">JSTL 다운로드 페이지 이동</a>
            <br>
            Standard-1.2.5 -> JarFiles -> Impl, Spec, EL 다운로드 
        </li>
        <li>
            /webapp/WEB-INF/lib 폴더에 라이브러리 파일(.jar) 추가
        </li>

        <li>
            JSTL 라이브러리를 사용하고자 하는 JSP 파일 상단에

            taglib JSP 지시자 태그를 추가 (2번 줄에 작성된 내용)
        </li>
        
    </ol>
    
    <hr>

    <h1>1. 변수 선언 (c:set 태그)</h1>
    
    <pre>
    - 변수 선언(지정된 scope에 속성 세팅)위한 태그

    - c:set에 작성 가능한 속성
    1) var : 변수명(속성 key)

    2) value : 대입할 값

    3) scope : page, request, session, application (기본값 page)
    </pre>
    
    <%
        // 스크립틀릿으로 page scope에 속성 세팅하는 방법
        pageContext.setAttribute("num1",10);
    %>

    <%-- JSTL(c:set)으로 page scope에 속성 세팅하는 방법 --%>
    <c:set var="num2" scope="page" value="20"/>

    num1 : ${num1} <br>
    num2 : ${num2} <br>

    <%-- requestScope에 세팅 --%>
    <c:set var="num2" scope="request" value="30"/>
    <br>
    request num2 : ${requestScope.num2}

    <h1>2. 변수 제거(c:remove)</h1>

    <pre>
    - 변수 제거 : 내장 객체에 세팅된 속성을 제거
        ( removeAttribute("k"))

    - c:remove 속성
    1) var : 삭제할 변수명(속성 key)
    2) scope : 내장 객체 범위(기본값 : 모든 scope);
    </pre>
    <%
        pageContext.removeAttribute("num1");
    %>
    num1 제거 확인 : ${num1}

    <br>
    <%-- <c:remove var="num2" scope="request" /> --%>
    <c:remove var="num2" />
    request num2 제거 확인 : ${requestScope.num2}
    <br>
    page num2 제거 확인 : ${pageScope.num2}

    <hr>

    <h1>3. 변수 출력 (c:out)</h1>

    <pre>
    - 변수 출력 : \${key} EL 구문과 비슷함

    - 단, escapeXml="true" (기본값) 설정 시
        html태그가 해석 X
    - escapeXml="false" : html 태그 해석 O
    </pre>

    <c:set var="temp" scope="session" value="<h1>점심시간</h1>"/>
    html 태그 해석 X : <c:out value="${temp}"/>
    <br>
    html 태그 해석 O : <c:out value="${temp}" escapeXml="false"/>
    html 태그 해석 O : ${temp}
    
    
</body>
</html>