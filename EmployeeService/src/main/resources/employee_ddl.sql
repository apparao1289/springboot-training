  CREATE TABLE EMPLOYEE 
   (	"EID" NUMBER NOT NULL ENABLE, 
	"ENAME" VARCHAR2(20 BYTE), 
	"DEPTNO" NUMBER NOT NULL ENABLE, 
	"JOB" VARCHAR2(20 BYTE), 
	"SAL" NUMBER, 
	"COMM" NUMBER, 
	"MGR" NUMBER, 
	"HIREDATE" DATE, 
	 CONSTRAINT "EMPLOYEE_PK" PRIMARY KEY ("EID"));