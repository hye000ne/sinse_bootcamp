-- 1.소속 된 총 사원 수가 5명 이상인 부서의 부서번호, 소속 사원수를 출력하세요
SELECT D.DEPTNO AS 부서번호, COUNT(EMPNO) AS 소속사원수
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY D.DEPTNO
HAVING COUNT(EMPNO) >=5
;
-- 2.SMITH가 소속된 부서의 총 사원수를 출력하세요
SELECT COUNT(*)
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND E.DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SMITH');
-- 3.SMITH 가 소속된 부서의 총 사원 수보다, 소속 사원 수가 더 많은 부서의 부서번호, 부서명, 부서위치를 출력하세요

-- 4.FORD 보다 입사일이 늦은 사원의 사원번호, 사원명, 입사일, 부서번호, 부서명, 부서위치를 출력하되, 입사일이 빠른 순서대로 정렬하세요
SELECT EMPNO, ENAME, HIREDATE, E.DEPTNO, DNAME, LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
AND HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME='FORD')
ORDER BY HIREDATE;

-- 5.부서별 소속 사원수를 출력하되, 소속 사원수가 없는 경우는 0으로 처리하세요
SELECT DNAME, COUNT(*)
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY DNAME;
-- 6.부서번호, 부서명, 위치, 소속 사원번호, 소속 사원명을 출력하되, 사원이 소속되지 않은 부서까지도 포함하세요( 이 경우 사원정보는 null 로출력)