
-- 1. 업무가 SALESMAN, CLERK 인 사원들의 이름, 업무, 급여를 출력하시오 (in 이용)
SELECT ENAME, JOB, SAL 
FROM EMP
WHERE JOB IN ('SALESMAN', 'CLERK');
-- 2. 급여가 2000 이상 3000 이하인 사원의 이름, 급여를 출력하되, 급여를 기준으로 내림차순으로 정렬하세요 (between 이용)
SELECT ENAME, SAL
FROM EMP
WHERE SAL BETWEEN 2000 AND 3000
ORDER BY SAL DESC;
-- 3. 이름에 K 자가 들어가는 사원의 이름, 급여를 출력하되 입사일이 빠른 날짜 순으로 출력하세요
SELECT ENAME, SAL
FROM EMP
WHERE ENAME LIKE '%K%'
ORDER BY HIREDATE;
-- 4. 커미션 계약을 하지 않은 사원들의 이름, 급여, 커미션을 출력하되, 급여가 높은 순으로 출력하세요
SELECT ENAME, SAL, COMM
FROM EMP
WHERE COMM IS NULL
ORDER BY SAL DESC;
-- 5. 급여가 높은 상위 3명의 사원명, 급여를 출력하세요(limit)
SELECT ENAME, SAL
FROM EMP
ORDER BY SAL DESC
LIMIT 3;
-- 6. 급여가 낮은 순으로 정렬된 상태에서, 상위 2명은 제외시키고 3번째 부터 시작하여 5명의 이름, 급여, 부서번호를 출력하시오 (offset) 
SELECT ENAME, SAL, DEPTNO
FROM EMP
ORDER BY SAL
LIMIT 5 OFFSET 2;
-- 7. 급여가 1500 이상 2000 이하가 아닌 사원의 이름, 급여를 출력하되 급여를 기준으로 오름차순으로 정렬하세요 (not between)
SELECT ENAME, SAL
FROM EMP
WHERE SAL NOT BETWEEN 1500 AND 2000
ORDER BY SAL;
-- 8. 아래와 같이 사원들을 부서 번호를 기준으로 오름차순으로 정렬시키고, 그 정렬 내에서, 다시 급여가 높은 순으로 정렬이 되게 출력해 보세요
SELECT *
FROM EMP
ORDER BY DEPTNO , SAL DESC;
