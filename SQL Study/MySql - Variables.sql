set @myval = 3;
set @myval2 =5;
set @myval3 = 4.25;
set @myval4 = '가수 이름은 =>';

select @myval ;
select @myval2 + @myval3;
select @myval4, ename from emp;

-- 1. 변수 선언
set @myval1 =3;
-- 2. 쿼리 준비
prepare myQuery
	from 'select  ename, job from emp limit ?';
-- 3. 쿼리 실행 시 ?에 선언 변수 넣기
execute myQuery using @myval1;



