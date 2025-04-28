-- 1. 모든 사원의 정보
select * from emp;
-- 2. 사원 이름과 급여
select ename, sal from emp;
-- 3. 부서 번호가 10인 사원의 이름과 급여
select ename, sal from emp where deptno=10;
-- 4. 급여가 3000 이상인 사원의 이름과 급여
select ename, sal from emp where sal >= 3000;
-- 5. 직무가 MANAGE인 사원의 이름과 입사일
select ename, hiredate from emp where job like 'MANAGER';
-- 6. 급여가 1000이상이고 3000이하인 사원의 이름과 급여
select ename, sal from emp where sal>=1000 and sal <= 3000;
-- 7. 급여가 2000보다 작거나 커미션이 500이상인 사원
select * from emp where sal<2000 or comm >= 500;
-- 8. 이름이 A로 시작하는 사원의 모든 정보
select * from emp where ename like 'A%';
-- 9. 커미션이 null이 아닌 사원의 이름과 커미션
select ename, comm from emp where comm is not null;
-- 10. 직무가 SALESMAN인 사원의 모든 정보
select * from emp where job ='SALESMAN';
-- 11. 모든 부서의 정보
select * from dept;
-- 12. 사원의 급여 10% 더한 값을 출력
select ename, (sal*1.1) as sal from emp;
-- 13. 모든 사원의 입사일 기준 오름차순
select * from emp order by hiredate;
-- 14. 모든 사원의 급여를 기준으로 높은순
select * from emp order by sal desc;