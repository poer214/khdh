--1. 학생이름과 주소지를 표시하시오. 
--단, 출력 헤더는 "학생 이름", "주소지"로 하고, 정렬은 이름으로 오름차순 표시하도록 한다.
SELECT STUDENT_NAME "학생 이름", STUDENT_ADDRESS "주소지"
FROM TB_STUDENT TS
ORDER BY 1;


--2. 휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오
SELECT STUDENT_NAME , STUDENT_SSN
FROM TB_STUDENT TS 
WHERE ABSENCE_YN = 'Y'
ORDER BY TO_DATE(SUBSTR(STUDENT_SSN,1,6)) DESC;

--3. 주소지가 강원도나 경기도인 학생들 중 1900년대 학번을 가진 학생들의
--이름과 학번, 주소를 이름의 오름차순으로 화면에 출력하시오.
--단, 출력헤더에는 "학생이름", "학번", "거주지 주소"가 출력되도록 한다.
SELECT STUDENT_NAME "학생이름", STUDENT_NO "학번", STUDENT_ADDRESS "거주지 주소"
FROM TB_STUDENT
WHERE NOT STUDENT_NO LIKE 'A%'
AND STUDENT_ADDRESS LIKE '%강원도%'
OR STUDENT_ADDRESS LIKE '%경기도%'
ORDER BY 1;

--4. 현재 법학과 교수 중 가장 나이가 많은 사람부터 이름을 확인할 수 있는 SQL 문장을 작성하시오.
--(법학과의 '학과 코드'는 학과 테이블을 조회해서 찾아 내도록 하자)  JOIN으로 풀어도 됩니다!
SELECT PROFESSOR_NAME , PROFESSOR_SSN 
FROM TB_PROFESSOR TP 
NATURAL JOIN TB_DEPARTMENT TD 
WHERE TD.DEPARTMENT_NAME = '법학과'
ORDER BY TO_DATE(SUBSTR(PROFESSOR_SSN,1,6));

--5. 2004년 2학기에 'C3118100' 과목을 수강한 학생들의 학점을 조회하려고 한다. 학점이 높은 학생부터
--표시하고,
--학점이 같으면 학번이 낮은 학생부터 표시하는 구문을 작성해 보시오.
--(워크북 결과와 동일하게 소수점 둘째 자리까지 0으로 표현하기 위해서 TO_CHAR(NUMBER, 'FM9.00') 포맷 사용)
SELECT STUDENT_NO , TO_CHAR(POINT, 'FM9.00') 학점
FROM TB_GRADE TG 
WHERE TERM_NO = '200402' AND CLASS_NO='C3118100'
ORDER BY 2 DESC, 1;

--6. 학생 번호, 학생 이름, 학과 이름을 학생 이름으로 오름차순 정렬하여 출력하는 SQL문을 작성하시오.
SELECT STUDENT_NO , STUDENT_NAME , DEPARTMENT_NAME
FROM TB_STUDENT TS 
NATURAL JOIN TB_DEPARTMENT TD
ORDER BY 2;

--7. 춘 기술대학교의 과목 이름과 과목의 학과 이름을 출력하는 SQL문장을 작성하시오.
SELECT CLASS_NAME, DEPARTMENT_NAME
FROM TB_CLASS
NATURAL JOIN TB_DEPARTMENT TD;


--8. 과목별 교수 이름을 찾으려고 한다. 과목 이름과 교수 이름을 출력하는 SQL문을 작성하시오.
--(기존 워크북 PDF에 나타난 조회 결과는 DB 버전이 낮아 현재와 조회 방식이 다름.
--결과 행의 수만 동일하게 조회하자)

SELECT CLASS_NAME , PROFESSOR_NAME 
FROM TB_PROFESSOR TP 
JOIN TB_CLASS_PROFESSOR TCP USING(PROFESSOR_NO)
JOIN TB_CLASS TC2 USING(CLASS_NO);

--9. 8번의 결과 중 '인문 사회' 계열에 속한 과목의 교수 이름을 찾으려고 한다.
--이에 해당하는 과목 이름과 교수 이름을 출력하는 SQL문을 작성하시오.
SELECT CLASS_NAME , PROFESSOR_NAME 
FROM TB_PROFESSOR TP 
JOIN TB_CLASS_PROFESSOR TCP USING(PROFESSOR_NO)
JOIN TB_CLASS TC2 USING(CLASS_NO)
JOIN TB_DEPARTMENT TD ON(TD.DEPARTMENT_NO=TP.DEPARTMENT_NO)
WHERE CATEGORY = '인문사회';

--10. '음악학과' 학생들의 평점을 구하려고 한다. 음악학과 학생들의 "학번", "학생 이름", "전체 평점"을 출력하는
--SQL 문장을 작성하시오.
--(단, 평점은 소수점 1자리까지만 반올림하여 표시한다.)

SELECT STUDENT_NO 학번, STUDENT_NAME "학생 이름", ROUND(AVG(POINT),1) "전체 평점"
FROM TB_STUDENT TS 
JOIN TB_GRADE TG USING (STUDENT_NO)
JOIN TB_DEPARTMENT TD USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '음악학과'
GROUP BY STUDENT_NO, STUDENT_NAME
ORDER BY 학번;

--11. 학번이 A313047인 학생이 학교에 나오고 있지 않다. 지도 교수에게 내용을 전달하기 위한 학과 이름, 학생
--이름과 지도 교수 이름이 필요하다. 이때 사용할 SQL문을 작성하시오.
--단, 출력헤더는 “학과이름”, “학생이름”, “지도교수이름” 으로 출력되도록 한다.
--SELECT DEPARTMENT_NAME "학과이름", STUDENT_NAME "학생이름", PROFESSOR_NAME "지도교수이름"
SELECT DEPARTMENT_NAME "학과이름", STUDENT_NAME "학생이름", PROFESSOR_NAME "지도교수이름"
FROM TB_STUDENT TS 
JOIN TB_DEPARTMENT TD USING(DEPARTMENT_NO)
JOIN TB_PROFESSOR TP2 ON (COACH_PROFESSOR_NO=PROFESSOR_NO)
WHERE STUDENT_NO = 'A313047';

--12. 2007년도에 '인간관계론' 과목을 수강한 학생을 찾아
--학생이름과 수강학기를 표시하는 SQL 문장을 작성하시오.
SELECT STUDENT_NAME , TERM_NO 
FROM TB_STUDENT TS 
JOIN TB_GRADE TG USING(STUDENT_NO)
JOIN TB_CLASS TC USING(CLASS_NO)
WHERE CLASS_NAME='인간관계론' AND TG.TERM_NO LIKE '2007%';

--13. 예체능 계열 과목 중 과목 담당교수를 한 명도 배정받지 못한 과목을 찾아
--그 과목 이름과 학과 이름을 출력하는 SQL 문장을 작성하시오.
--(기존 워크북 PDF에 나타난 조회 결과는 DB 버전이 낮아 현재와 조회 방식이 다름.
--결과 행의 수만 동일하게 조회하자)
SELECT CLASS_NAME, DEPARTMENT_NAME 
FROM TB_DEPARTMENT TD 
JOIN TB_CLASS TC USING(DEPARTMENT_NO)
LEFT JOIN TB_CLASS_PROFESSOR TCP USING(CLASS_NO)
WHERE PROFESSOR_NO IS NULL AND CATEGORY ='예체능';

--14. 춘 기술대학교 서반아어학과 학생들의 지도교수를 게시하고자 한다. 
--학생이름과 지도교수 이름을 찾고 만일 지도 교수가 없는 학생일 경우
--"지도교수 미지정"으로 표시하도록 하는 SQL 문을 작성하시오.
--단 출력헤더는 "학생이름", "지도교수"로 표시하며 고학번 학생이 먼저 표시되도록 한다.
SELECT STUDENT_NAME "학생이름",NVL(TP.PROFESSOR_NAME ,'지도교수 미지정') "지도교수" 
FROM TB_STUDENT TS 
LEFT JOIN TB_PROFESSOR TP ON(TS.COACH_PROFESSOR_NO = TP.PROFESSOR_NO)
JOIN TB_DEPARTMENT TD ON(TS.DEPARTMENT_NO = TD.DEPARTMENT_NO)
WHERE TD.DEPARTMENT_NAME ='서반아어학과'
ORDER BY TS.STUDENT_NO ;

--15. 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 그 학생의 학번, 이름, 학과, 이름, 평점을 출력하는
--SQL문을 작성하시오.
SELECT STUDENT_NO 학번,STUDENT_NAME 이름, DEPARTMENT_NO "학과 이름", AVG(POINT) 평점
FROM TB_STUDENT TS
JOIN TB_GRADE TG USING(STUDENT_NO)
JOIN TB_DEPARTMENT TD USING(DEPARTMENT_NO)
WHERE TS.ABSENCE_YN = 'N'
GROUP BY STUDENT_NO, STUDENT_NAME, DEPARTMENT_NO 
HAVING AVG(POINT) >= 4
ORDER BY 학번;

--16. 환경조경학과 전공과목들의 과목 별 평점을 파악할 수 있는 SQL 문을 작성하시오.
SELECT CLASS_NO, CLASS_NAME, AVG(POINT)
FROM TB_DEPARTMENT TD 
JOIN TB_CLASS TC USING(DEPARTMENT_NO)
JOIN TB_GRADE TG USING(CLASS_NO)
WHERE DEPARTMENT_NAME = '환경조경학과' AND CLASS_TYPE LIKE '전공%'
GROUP BY CLASS_NO, CLASS_NAME
ORDER BY 1;

--17. 춘 기술대학교에 다니고 있는 최경희 학생과 같은 과 학생들의 이름과 주소를 출력하는 SQL 문을
--작성하시오.
SELECT STUDENT_NAME , STUDENT_ADDRESS 
FROM TB_STUDENT TS 
WHERE DEPARTMENT_NO  = (SELECT DEPARTMENT_NO 
FROM TB_STUDENT TS2 WHERE STUDENT_NAME ='최경희');

--18. 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번을 표시하는 SQL문을 작성하시오
WITH 국어왕 AS (SELECT STUDENT_NO , STUDENT_NAME
FROM TB_STUDENT TS 
JOIN TB_GRADE TG USING(STUDENT_NO)
JOIN TB_DEPARTMENT TD USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME='국어국문학과'
GROUP BY STUDENT_NO , STUDENT_NAME
ORDER BY AVG(POINT) DESC)
SELECT *
FROM 국어왕
WHERE ROWNUM=1;

--19. 춘 기술대학교의 "환경조경학과"가 속한 같은 계열 학과들의 학과 별 전공과목 평점을 파악하기 위한
--적절한 SQL문을 찾아내시오.
--단, 출력헤더는 "계열 학과명", "전공평점"으로 표시되도록 하고, 평점은 소수점 한자리까지만 반올림하여
--표시되도록 한다.
SELECT DEPARTMENT_NAME "계열 학과명", ROUND(AVG(POINT),1) "전공평점" 
FROM TB_DEPARTMENT TD
JOIN TB_CLASS TC USING (DEPARTMENT_NO)
JOIN TB_GRADE TG USING (CLASS_NO)
WHERE CATEGORY  =
(SELECT CATEGORY FROM TB_DEPARTMENT TD2 WHERE DEPARTMENT_NAME='환경조경학과')
AND CLASS_TYPE LIKE '전공%'
GROUP BY DEPARTMENT_NAME
ORDER BY 1;