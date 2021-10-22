-- 이름이 없는 동물의 아이디
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL
ORDER BY ANIMAL_ID;

-- NULL을 조회하기
-- '컬럼 이름 ' IS NULL
-- NULL이 아닌 행 조회하기
-- '컬럼 이름' IS NOT NULL
-- 컬럼이름 = NULL 으로 조회하면 안된다!(주의!!)

-- 이름이 있는 동물의 아이디
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
ORDER BY ANIMAL_ID ASC;

-- 양 게시판에 동물 정보를 게시하려 합니다. 
-- 동물의 생물 종, 이름, 성별 및 중성화 여부를 아이디 순으로 조회하는 SQL문을 작성해주세요.  --> 아이디 순 정렬
-- 이때 프로그래밍을 모르는 사람들은 NULL이라는 기호를 모르기 때문에, 이름이 없는 동물의 이름은 "No name"으로 표시해 주세요.

SELECT ANIMAL_TYPE, NVL(NAME,'No name') AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

-- NULL 을 치환하는 함수 NVL(컬럼이름, 바꿀 내용)


-- 천재지변으로 인해 일부 데이터가 유실되었습니다. 
-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.

SELECT OUTS.ANIMAL_ID, OUTS.NAME
FROM ANIMAL_OUTS OUTS LEFT OUTER JOIN ANIMAL_INS INS 
ON OUTS.ANIMAL_ID = INS.ANIMAL_ID
WHERE INS.ANIMAL_ID IS NULL
ORDER BY OUTS.ANIMAL_ID;


-- 관리자의 실수로 일부 동물의 입양일이 잘못 입력되었습니다. 
-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요.
--  이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.

SELECT i.animal_id, i.name
from animal_ins i, animal_outs o
where i.animal_id = o.animal_id 
and i.datetime > o.datetime
order by i.datetime;

SELECT INS.ANIMAL_ID, INS.NAME
FROM ANIMAL_INS INS INNER JOIN ANIMAL_OUTS OUTS
ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE INS.DATETIME > OUTS.DATETIME
ORDER BY INS.DATETIME;


-- 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 보호 시작일 순으로 조회해야 합니다.

select *
from (select name, datetime
     from animal_ins
     where animal_id not in (select animal_id from animal_outs)
     order by datetime asc)
where rownum<4;


select *
from (select ins.name, ins.datetime
	from animal_ins ins left join animal_outs outs
	on  ins.animal_id = outs.animal_id
	where outs.animal_id is null 
	order by ins.datetime) 
where rownum <4;