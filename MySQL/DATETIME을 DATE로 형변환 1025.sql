-- ANIMAL_INS 테이블에 등록된 모든 레코드에 대해, 각 동물의 아이디와 이름, 들어온 날짜1를 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 아이디 순으로 조회해야 합니다.

-- sql
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%M-%D') AS 날짜
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- DATE_FORMAT(컬럼, 형식)
-- 2016-April-19th 식으로 출력


SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d') AS 날짜
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- Y: 2021 /y : 21
-- M: Apriel / m:04
-- D: 19th / d: 05

-- oracle
SELECT ANIMAL_ID
     , NAME
     , TO_CHAR(DATETIME, 'YYYY-MM-DD') AS 날짜
  FROM ANIMAL_INS
 ORDER BY 1