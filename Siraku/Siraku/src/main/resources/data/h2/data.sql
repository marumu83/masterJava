DELETE FROM SEQUENCES;
DELETE FROM EMPLOYEE;
DELETE FROM DEPARTMENT;
DELETE FROM PEDIDOS;
DELETE FROM COMERCIALES;
DELETE FROM CLIENTES;
DELETE FROM PRODUCTOS;

INSERT INTO SEQUENCES(NOMBRE, VALOR) VALUES('PRODUCTOS_SEQ',500);
INSERT INTO SEQUENCES(NOMBRE, VALOR) VALUES('COMERCIALES_SEQ',500);

-- INSERTS DE DEPARTAMENTOS
INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,MGRNO,ADMR_DEPT) VALUES
('A00','SPIFFY COMPUTER SERVICE','000010','A00');
 INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,MGRNO,ADMR_DEPT) VALUES
('B01','PLANNING','000020','A00');
 INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,MGRNO,ADMR_DEPT) VALUES
('C01','INFORMATION CENTER','000030','A00');
 INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,MGRNO,ADMR_DEPT) VALUES
('D01','DEVELOPMENT CENTER',NULL,'A00');
 INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,MGRNO,ADMR_DEPT) VALUES
('D11','MANUFACTURING SYSTEMS','000060','D01');
 INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,MGRNO,ADMR_DEPT) VALUES
('D21','ADMINISTRATION SYSTEMS','000070','D01');
 INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,MGRNO,ADMR_DEPT) VALUES
('E01','SUPPORT SERVICES','000050','A00');
 INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,MGRNO,ADMR_DEPT) VALUES
('E11','OPERATIONS','000090','E01');
 INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,MGRNO,ADMR_DEPT) VALUES
('E21','SOFTWARE SUPPORT','000100','E01');
 INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,MGRNO,ADMR_DEPT) VALUES
('F22','BRANCH OFFICE F2',NULL,'E01');
 INSERT INTO DEPARTMENT(DEPT_NO,DEPT_NAME,MGRNO,ADMR_DEPT) VALUES
('G22','BRANCH OFFICE G2',NULL,'E01');

-- INSERTS DE EMPLEADOS
INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000010','CHRISTINE','I','HAAS','A00','CLERK','3978', '1995-01-01','F',18,'1973-02-08',152750.0,4220.0,19185.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000020','MICHAEL','L','THOMPSON','B01','MANAGER','3476','2003-10-10','M',18,'1978-10-10',94250.0,3300.0,18502.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000030','SALLY','A','KWAN','C01','ANALYST','4738','2005-05-04','F',20,'1971-05-04',98250.0,3060.0,10144.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000050','JOHN','B','GEYER','E01','MANAGER','6789','1979-12-08','M',16,'1975-10-08',80175.0,3214.0,2292.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000060','IRVING','F','STERN','D11','DESIGNER','6423','2003-10-08','M',16,'1975-07-07',72250.0,2580.0,6092.0);  
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000070','EVA','D','PULASKI','D21','CLERK','7831','2005-11-09','F',16,'2003-06-05',96170.0,2893.0,17354.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000090','EILEEN','W','HENDERSON','E11','FIELDREP','5498', '2000-10-08','F',16,'1971-11-05',89750.0,2380.0,15432.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000100','THEODORE','Q','SPENSER','E21','FIELDREP','0972','1999-06-10','M',14,'1970-12-01',86150.0,2092.0,14740.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000110','VINCENZO','G','LUCCHESSI','A00','PRES','3490','1988-10-05','M',19,'1979-05-11',66500.0,3720.0,7606.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000120','SEAN',null,'O''CONNELL','A00','SALESREP','2167','1993-05-12','M',14,'1972-10-10',49250.0,2340.0,6334.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000130','DELORES','M','OUINTANA','C01','MANAGER','4578','2001-03-07','F',16,'1975-12-09',73800.0,1904.0,32.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000140','HEATHER','A','NICHOLLS','C01','MANAGER','1793','2006-12-12','F',18,'1976-10-01',68420.0,2274.0,3855.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000150','BRUCE',null,'ADAMSON','D11','MANAGER','4510','2002-10-02','M',16,'1977-10-05',55280.0,2022.0,7180.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000160','ELIZABETH','R','PIANKA','D11','DESIGNER','3782','2006-11-10','F',17,'1980-12-04',62250.0,1780.0,8851.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000170','MASATOSHI','J','YOSHIMURA','D11','DESIGNER','2890','1999-09-15','M',16,'1981-01-05',44680.0,1974.0,2416.0);

 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000180','MARILYN','S','SCOUTTEN','D11','DESIGNER','1682','2003-07-07','F',17,'1979-02-21',51340.0,1707.0,7348.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000190','JAMES','H','WALKER','D11','DESIGNER','2986','2004-07-26','M',16,'1982-06-25',50450.0,1636.0,2728.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000200','DAVID',null,'BROWN','D11','DESIGNER','4501','2002-03-03','M',16,'1971-05-29',57740.0,2217.0,6820.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000210','WILLIAM','T','JONES','D11','DESIGNER','0942','1998-04-11','M',17,'2003-02-23',68270.0,1462.0,1748.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000220','JENNIFER','K','LUTZ','D11','DESIGNER','0672','1998-08-29','F',18,'1978-03-19',49840.0,2387.0,9083.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000230','JAMES','J','JEFFERSON','D21','CLERK','2094','1996-11-21','M',14,'1980-05-30',42180.0,1774.0,5518.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000240','SALVATORE','M','MARINO','D21','CLERK','3780','2004-12-05','M',17,'2002-03-31',48760.0,2301.0,5899.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000250','DANIEL','S','SMITH','D21','CLERK','0961','1999-10-30','M',15,'1979-11-12',49180.0,1534.0,8130.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000260','SYBIL','P','JOHNSON','D21','MANAGER','8953','2005-09-11','F',16,'1976-10-05',47250.0,1380.0,8982.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000270','MARIA','L','PEREZ','D21','CLERK','9001','2006-09-30','F',15,'2003-05-26',37380.0,2190.0,1286.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000280','ETHEL','R','SCHNEIDER','E11','OPERATOR','8997','1997-03-24','F',17,'1976-03-28',36250.0,2100.0,5871.0);
 INSERT INTO EMPLOYEE (EMP_NO,FIRST_NAME,MIDINIT,LAST_NAME,WORK_DEPT,JOB,PHONE_NO,HIRE_DATE,SEX,ED_LEVEL,BIRTH_DATE,SALARY,BONUS,COMM) VALUES ('000290','JOHN','R','PARKER','E11','MANAGER','4502','2006-05-30','M',12,'1985-07-09',35340.0,1227.0,67.0);
 
 -- INSERTS DE PRODUCTOS
 INSERT INTO PRODUCTOS(COD_PRODUCTO,NOMBRE,PRECIO,FECHA_ALTA,FAMILIA,DESCATALOGADO) VALUES(1,'Mayonesa',4.5,'2025-3-12','CONSUMIBLE',0);
 INSERT INTO PRODUCTOS(COD_PRODUCTO,NOMBRE,PRECIO,FECHA_ALTA,FAMILIA,DESCATALOGADO) VALUES(2,'RTX-4060',743.99,'2020-9-11','HARDWARE',1);
 INSERT INTO PRODUCTOS(COD_PRODUCTO,NOMBRE,PRECIO,FECHA_ALTA,FAMILIA,DESCATALOGADO) VALUES(3,'Licencia windows 11',140.5,'2025-7-22','SOFTWARE',0);
 
 -- INSERTS DE CLIENTES
 INSERT INTO CLIENTES VALUES('12G','GameFreak','Antonio','Galar','Pérez','AV.SALAMANCA','Plasencia','10600','CACERES','ESPAÑA','123456789','231243543','awa@test.com');
 INSERT INTO CLIENTES VALUES('14L','Vodafone','Maria','Sanchez','Hinojal','AV.DE LA HISPANIDAD','Cáceres','10005','CACERES','ESPAÑA','987654321','653578123','hola@test.com');
 INSERT INTO CLIENTES VALUES('16C','Carrefour','Ana','Martin','Martinez','AV.COLON','Cáceres','10002','CACERES','ESPAÑA','827364912','953624786','si@test.com');
 
 -- INSERTS DE COMERCIALES
 INSERT INTO COMERCIALES(COD_COMERCIAL,NOMBRE,APELLIDO1,APELLIDO2) VALUES(1,'Pedro','Pérez','Pérez');
 INSERT INTO COMERCIALES(COD_COMERCIAL,NOMBRE,APELLIDO1,APELLIDO2) VALUES(2,'Mario','Gutierrez','Hinojosa');
 INSERT INTO COMERCIALES(COD_COMERCIAL,NOMBRE,APELLIDO1,APELLIDO2) VALUES(3,'Sofia','Martinez','Martinez');