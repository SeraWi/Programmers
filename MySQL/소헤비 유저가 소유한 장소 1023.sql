-- 이 서비스에서는 공간을 둘 이상 등록한 사람을 "헤비 유저"라고 부릅니다.  (2개 이상의 공간을 등록 == HOST_ID 가 두번이상)
-- 헤비 유저가 등록한 공간의 정보를 아이디 순으로 조회하는 SQL문을 작성해주세요.

SELECT *
FROM PLACES
WHERE HOST_ID  IN (
        SELECT HOST_ID
        FROM PLACES
        GROUP BY HOST_ID
        HAVING COUNT(HOST_ID) >1
);

