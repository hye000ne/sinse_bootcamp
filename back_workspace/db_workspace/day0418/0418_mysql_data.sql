--------------------------------------------------------------
-- 부서 테이블 생성/레코드 넣기
--------------------------------------------------------------
create table dept(
deptno int primary key auto_increment
,dname varchar(14)
,loc varchar(13)
);
 
insert into dept(deptno,dname,loc) values(10,'ACCOUNTING','NEW YORK');
insert into dept(deptno,dname,loc) values(20,'RESEARCH','DALLAS');
insert into dept(deptno,dname,loc) values(30,'SALES','CHICAGO');
insert into dept(deptno,dname,loc) values(40,'OPERATIONS','BOSTON');
 
--------------------------------------------------------------
-- 사원 테이블 생성/레코드 넣기
--------------------------------------------------------------
 
create table emp(
empno int primary key auto_increment
,ename varchar(10)     
,job varchar(9)         
,mgr int
,hiredate timestamp
,sal int
,comm int
,deptno int
);
 
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7369,'SMITH','CLERK',7902,'80/12/17',800,20);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7499,'ALLEN','SALESMAN',7698,'81/02/20',1600,300,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7521,'WARD','SALESMAN',7698,'81/02/22',1250,500,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7566,'JONES','MANAGER',7839,'81/04/02',2975,20);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7654,'MARTIN','SALESMAN',7698,'81/09/28',1250,1400,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7698,'BLAKE','MANAGER',7839,'81/05/01',2850,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7782,'CLARK','MANAGER',7839,'81/06/09',2450,10);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7788,'SCOTT','ANALYST',7566,'87/04/19',3000,20);
insert into emp(empno,ename,job,hiredate,sal,deptno) values(7839,'KING','PRESIDENT','81/11/17',5000,10);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7844,'TURNER','SALESMAN',7698,'81/09/08',1500,0,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7876,'ADAMS','CLERK',7788,'87/05/23',1100,20);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7900,'JAMES','CLERK',7698,'81/12/03',950,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7902,'FORD','ANALYST',7566,'81/12/03',3000,20);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7934,'MILLER','CLERK',7782,'82/01/23',1300,10);
