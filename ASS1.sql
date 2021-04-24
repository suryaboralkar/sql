SELECT * FROM mobile.mobile_data;
DESC mobile.mobile_data;
INSERT INTO mobile.mobile_data VALUES(1,'oneplus','oneplus 6',40000);
INSERT INTO mobile.mobile_data VALUES(2,'REDMI','NOTE PRO',18000);
INSERT INTO mobile.mobile_data VALUES(3,'IPHONE','12 PRO',98000);
INSERT INTO mobile.mobile_data VALUES(4,'OPPO','POCO X2',25000);
ALTER TABLE mobile.mobile_data ADD M_IMEI BIGINT;
UPDATE  mobile.mobile_data SET M_IMEI=878765433 WHERE M_ID=1;
UPDATE  mobile.mobile_data SET M_IMEI=878764435 WHERE M_ID=2;
UPDATE  mobile.mobile_data SET M_IMEI=8787665437 WHERE M_ID=3;
UPDATE  mobile.mobile_data SET M_IMEI=878785438 WHERE M_ID=4;
SELECT*FROM mobile.mobile_data WHERE M_NAME IN('12 PRO','ONEPLUS 6');

SELECT*FROM mobile.mobile_data where M_PRICE BETWEEN 15000 AND 25000;
DELETE FROM mobile.mobile_data WHERE M_PRICE=18000 ;
SELECT  MIN(M_PRICE) FROM mobile.mobile_data;
SELECT  MAX(M_PRICE) FROM mobile.mobile_data;
SELECT  avg(M_PRICE) FROM mobile.mobile_data;
SELECT  count(M_PRICE) FROM mobile.mobile_data;
truncate mobile.mobile_data ;
DROP TABLE mobile.mobile_data;
DROP database mobile;


