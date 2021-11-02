-- 저장 프로시저 Stored Procedure
-- 일련의 작업 절차를 정리해서 저장한 것이다. 여러 sql문을 묶어서 미리 정의

select * from member where idx= 1;
select * from emp where deptno =20;

-- 프로시져 생성
delimiter //
create procedure myProc()
begin
	select * from member where idx= 1;
	select * from emp where deptno =20;
end//
delimiter ;

-- 프로시져 실행
call myProc();

-- 저장 프로시져 내용 확인
show create procedure myProc;

-- 프로시져 drop
drop procedure myProc;

-- 프로시저 생성 : 매개변수 받기
-- in 매개변수 
delimiter //
create procedure getMember(in userName varchar(20))
begin
	select * 
    from member
    where memberName = userName;
end//
delimiter ;

call getMember('cool');

-- out 매개변수
select * from emp;
select count(*) from emp where deptno = 20 group by deptno ;


-- 한부서에 몇명이 일하나
-- 매개변수 deptno
-- 출력 매개변수 : 총 사람 수 

delimiter //
create procedure getDeptMemCount(
	in param_deptno int,
    out total int
)
begin
	select count(deptno)
    from emp
    where deptno = param_deptno
    group by deptno;
end //
delimiter ;

call getDeptMemCount( 20, @total);
select @total;


drop procedure getDeptMemCount;
