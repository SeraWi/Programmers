-- 트리거
-- 회원테이블에서 삭제되면 자동으로 탈뢰테이블에 insert 시키기

select * from project.member;
select * from project.deletemember;
drop trigger trg_deleteMember;

-- 탈퇴테이블 만들기
create table project.deleteMember(
	memberId char(10),
    memberName char(10),
    memberPhoto char(50),
    deleteDate date -- 삭제한 날짜
);

-- 트리거
delimiter //
CREATE trigger trg_deleteMember 
	after DELETE 
    ON project.member 
    FOR EACH ROW 
BEGIN
	INSERT INTO project.deletemember VALUES (OLD.memberId, OLD.memberName,OLD.memberPhoto, curdate());
END //
delimiter;







