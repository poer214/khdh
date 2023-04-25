<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
    <section>
        <!-- 클릭 시 메인 페이지로 이동하는 로고 -->
        <a href=""></a>
        <img src="/resources/images/logo.png" alt="로고" id="homeLogo">
    </section>
    <section>
        <!-- 검색어 입력할 수 있는 화면 -->
        <article class="search-area">
            <!--
                action : 내부 input에 작성된 값을 제출할 경로/주소
                method : 어떤 방식으로 제출할 지 지정

                - GET : input 태그 값을 주소에 담아서 제출(주소에 보임)
                - POST : input태그 값을 주소에 담지 않고 제출(주소에 안보임)
                        -> HTTP Body에 담아서 제출
            -->
            <form action="#" method="GET">
                <fieldset> <!-- form태그 내 영역 구분 -->
                    <!--
                        input의 name 속성 = 제출 시 key 값
                        input에 입력된 내용 = 제출 시 value
                    -->
                    <input type="search" name="query" id="query" placeholder="검색어를 입력해주세요."
                    autocomplete="off">
                    <!-- 검색 버튼 -->
                    <!-- button type="submit" 이 기본값 -->
                    <button id="searchBtn" class="fa-solid fa-magnifying-glass"></button>
                </fieldset>
            </form>
        </article>
    </section>
    <section></section>
</header>
<nav>
    <ul>
        <li><a href="#">공지사항</a></li>
        <li><a href="#">자유 게시판</a></li>
        <li><a href="#">질문 게시판</a></li>
        <li><a href="#">FAQ</a></li>
        <li><a href="#">1:1 문의</a></li>
    </ul>
</nav>