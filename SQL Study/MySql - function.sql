-- mySql 사용자 정의함수
-- 사번을 넣으면 이름, 부서를 반환하는 함수

select * from dept;
select * from emp;

select *
from dept, emp
where dept.deptno = emp.deptno;


