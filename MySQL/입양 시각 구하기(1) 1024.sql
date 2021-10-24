
-- 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 09:00부터 19:59까지, BETWEEN 9 AND 20
-- 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. COUNT, GROUP BY
-- 이때 결과는 시간대 순으로 정렬해야 합니다. ORDER BY

SELECT HOUR(DATETIME), COUNT(DATETIME) AS COUNT
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) BETWEEN 9 AND 20
GROUP BY HOUR(DATETIME)
ORDER BY HOUR(DATETIME);