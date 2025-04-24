-- 집계함수
-- 사원 수를 출력하세요
SELECT COUNT(*) FROM EMP;

-- 부서의 수를 출력하세요
SELECT COUNT(*) FROM DEPT;

-- 사원의 급여의 합
SELECT SUM(SAL) FROM EMP; 

-- 사원의 커미션의 합
SELECT SUM(COMM) FROM EMP;

-- 사원의 급여의 평균
SELECT AVG(SAL) FROM EMP;

-- 최대급여 출력
SELECT MAX(SAL) FROM EMP;

-- 최소급여 출력
SELECT MIN(SAL) FROM EMP;

-- 별칭(AS) -> 출력만
SELECT AVG(SAL) AS 급여합 FROM EMP;

-- GROUP BY : 종류별로 묶기
-- GROUP BY에 명시된 컬럼 만이 SELECT 문에 올 수 있음
-- 그룹화는 WHERE절 못씀, 끝에 HAVING 사용
SELECT DEPTNO, COUNT(DEPTNO) FROM EMP GROUP BY DEPTNO;

-- 서브쿼리
-- 20번 부서의 평균 급여보다 높은 급여를 받는 사원의 이름, 급여를 출력하세요
SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP);

-- 커미션의 합보다 많은 급여를 받는 사원의 이름, 급여를 출력하세요
SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT SUM(COMM) FROM EMP);
