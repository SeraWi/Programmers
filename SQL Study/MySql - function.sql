-- mySql 사용자 정의함수
-- 사번을 넣으면 이름, 부서를 반환하는 함수

-- 1418 에러 해결하기
SET GLOBAL log_bin_trust_function_creators = 1;

select * from dept;
select * from emp;

-- CREATE FUNCTION 함수명(매개변수 자료형)
-- RETURNS 반환_자료형
-- BEGIN
-- 	   SQL 쿼리문1;
--     SQL 쿼리문2;
-- END;

-- 제곱을 처리하는 함수
DELIMITER //
CREATE function square(a int) returns double
begin
	return a * a;
end //
DELIMITER ;

-- 실행
select square(10);


-- 함수에서 변수 선언하기
-- 값대입은 into 명령어를 사용한다
-- declare 변수명 자료형;
delimiter //
create function test(a int) returns double
begin
	declare s double;
    select a * a into s;
    return s;
end
// 
delimiter ;

-- 실행
select test(4);

-- 함수 확인
show create function test;
-- 함수 삭제
drop function test;

select * from emp;


-- 이름 매개변수로 받아서 연봉 반환하는 함수

delimiter //
create function get_Tsal(NAME VARCHAR(10))returns int
begin
	declare tSal int;
    select sal * 12 into tSal
    from emp
    where ENAME = NAME
    LIMIT 1;
    return tSal;
    
end
//
delimiter ;
drop function get_Tsal;

-- 실행
select get_Tsal('WARD');

--


