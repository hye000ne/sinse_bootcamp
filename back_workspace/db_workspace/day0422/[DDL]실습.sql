-- 1.아래의 조건으로 테이블을 생성하세요
--  table명 : member/ id컬럼 : 한글, 영문 20자 수용 크기 /
--  pwd컬럼 : 암호화 해시값용 64자 수용 크기 / email 컬럼: 영문 25자 수용 크기
CREATE TABLE MEMBER(
    ID VARCHAR(20), PWD VARCHAR(64), EMAIL VARCHAR(25)
);
-- 2. 아래의 조건으로 member 테이블 구조 변경하기
--  (1) name 컬럼 추가 : 한글,영문 등 문자 20자 수용
--  (2) 테이블명 변경 : 기존 테이블명을 membership 으로 
--  (3) 컬럼명 변경: 기존 pwd pass로
--  (4) 컬럼의 크기 변경: 기존 email컬럼의 크기를 35로
ALTER TABLE MEMBER ADD COLUMN NAME VARCHAR(20);
-- ALTER TABLE MEMBER RENAME MEMBERSHIP;
RENAME TABLE MEMEBER TO MEMBERSHIP;
ALTER TABLE MEMBERSHIP CHANGE COLUMN PWD PASS VARCHAR(64);
ALTER TABLE MEMBERSHIP MODIFY COLUMN EMAIL VARCHAR(35);

-- 3. 테이블 제거하기
DROP TABLE MEMBERSHIP;