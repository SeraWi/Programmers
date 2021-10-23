-- 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 
-- 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 시간대 순으로 정렬해야 합니다.

-- 사용자 변수 @
SET @TIME=-1;

SELECT @TIME:=@TIME+1 AS HOUR,
        (
        SELECT COUNT(DATETIME)
        FROM ANIMAL_OUTS
        WHERE @TIME =HOUR(DATETIME)
        ) AS COUNT
FROM ANIMAL_OUTS
WHERE @TIME<23
ORDER BY @TIME;

-- 입양을 간 동물 중, 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회하는 SQL문을 작성해주세요. (상위2개 뽑기)
-- 이때 결과는 보호 기간이 긴 순으로 조회해야 합니다.
-- 상위 2개 봅기 ->LIMIT

SELECT INS.ANIMAL_ID, INS.NAME
FROM ANIMAL_INS INS, ANIMAL_OUTS OUTS
WHERE INS.ANIMAL_ID = OUTS.ANIMAL_ID
ORDER BY OUTS.DATETIME-INS.DATETIME DESC
LIMIT 2;