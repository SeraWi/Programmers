-- 트리거 : 테이블에 대한 이벤트에 반응해 자동으로 실행되는 작업을 의미한다.
-- 행트리거: 변경전 ->old, 변경 후 의 행 : new
-- 문장트리거 :insert, update, delete문에 대해 한번만 실행된다
-- before, after : 트리거가 실행되는 시기를 지정
-- instead of : 트리거를 원래 문장 대신 수행
-- when : 트리거를 시작하는 조건식을 지정
-- 회원테이블에서 삭제되면 자동으로 탈뢰테이블에 insert 시키기

select * from project.member;
select * from project.deletemember;
drop trigger trg_member;

-- 트리거 보기
show triggers;

-- 탈퇴테이블 만들기
create table project.deleteMember(
	memberId char(10),
    memberName char(10),
    memberPhoto char(50),
    deleteDate date -- 삭제한 날짜
);


-- 트리거 생성
DELIMITER // 
CREATE TRIGGER trg_member 
AFTER DELETE
ON project.member 
FOR EACH ROW
BEGIN 
	insert into project.deleteMember
    values(old.memberId,old.memberName,old.memberPhoto,curdate());
END // 
DELIMITER ;
-- delimiter 한칸 띄우고 ; -->안띄우면 syntax에러

-- member 테이블에서 삭제하면 -> deleteMember table 에 insert 된다. 
delete from project.member where idx = 92;






