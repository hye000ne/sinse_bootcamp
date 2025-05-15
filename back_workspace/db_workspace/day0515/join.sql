--oracle
select *
from emp e inner join dept d
on e.deptno = d.deptno;

-- inner join
select d.deptno, count(empno)
from emp e inner join dept d
on e.deptno = d.deptno
group by d.deptno;

-- outer join
select d.deptno, count(empno)
from emp e right outer join dept d
on e.deptno = d.deptno
group by d.deptno;

select * 
from emp e left outer join dept d
on e.deptno = d.deptno
;

-- 조인은 부모자식간 데이터 조합이지만 union은 전혀 관련성이 없는 데이터를 조합
-- union
select ename, sal from emp
union
select dname, deptno from dept
;
