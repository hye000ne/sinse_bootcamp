 -- 사원 테이블 복사하기
 create table emp2 as select * from emp;
 -- 부서 테이블 복사하기
 create table dept2 as select * from dept;

 -- 1. [insert] 부서테이블에 부서번호:50/부서이름:secret/위치:seoul 데이터 넣기
 insert into dept2(deptno, dname, loc) values (50,'secret','seoul');
 -- 2. [delete] 사원테이블에 급여가 800인 사람 삭제
 delete from emp2 where sal = 800;
 -- 3. [delete] 10번 부서 사원들 삭제
 delete from emp2 where deptno = 10;
 -- 4. [update] 사원번호 7788인 사원의 업무를 '분석'으로 수정
 update emp2 set job = '분석' where empno='7788';
 -- 5. dept2에서 30번 부서명을 '세일즈'로 수정
 update dept2 set dname='세일즈' where deptno=30;
 -- 6. emp2에서 이름이 'WARD'인 사원의 급여를 3500으로 수정
 update emp2 set sal=3500 where ename='WARD';
 -- 7. emp2에서 사원번호가 7839인 사원의 이름을 회장으로, 급여는 9000으로 커미션으로 5000으로 수정
 update emp2 set ename='회장' and sal=9000 and comm=5000 where empno=7839;
 -- 8. emp2에서 급여가 1000보다 적은 사원 삭제
 delete from emp2 where sal < 1000;
