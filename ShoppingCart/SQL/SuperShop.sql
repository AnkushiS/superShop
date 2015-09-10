--------------------------------------------------------
--  File created - Thursday-September-03-2015   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CART
--------------------------------------------------------

  CREATE TABLE "TESTDB"."CART" 
   (	"ORDER_ID" NUMBER, 
	"CHECK_ID" NUMBER, 
	"PROD_ID" NUMBER, 
	"TOTALPRICE" NUMBER, 
	"QUANTITY" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PAY
--------------------------------------------------------

  CREATE TABLE "TESTDB"."PAY" 
   (	"PAY_ID" NUMBER, 
	"USER_ID" NUMBER, 
	"PAY_AMOUNT" NUMBER, 
	"FULL_NAME" VARCHAR2(50 BYTE), 
	"CARDNAME" VARCHAR2(20 BYTE), 
	"SHIPADR1" VARCHAR2(50 BYTE), 
	"SHIPADR2" VARCHAR2(50 BYTE), 
	"SHIPCODE" VARCHAR2(10 BYTE), 
	"BILLADR1" VARCHAR2(50 BYTE), 
	"BILLADR2" VARCHAR2(50 BYTE), 
	"BILLCODE" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRODUCTS
--------------------------------------------------------

  CREATE TABLE "TESTDB"."PRODUCTS" 
   (	"PROD_ID" NUMBER, 
	"PROD_NAME" VARCHAR2(50 BYTE), 
	"PRICE" NUMBER(8,2), 
	"PROD_PIC" VARCHAR2(1000 BYTE), 
	"DESCRIPTION" VARCHAR2(500 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "TESTDB"."USERS" 
   (	"USER_ID" NUMBER, 
	"USER_NAME" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"USER_MOTTO" VARCHAR2(100 BYTE), 
	"JOINDATE" DATE, 
	"ORDER_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into TESTDB.CART
SET DEFINE OFF;
Insert into TESTDB.CART (ORDER_ID,CHECK_ID,PROD_ID,TOTALPRICE,QUANTITY) values (53,88,2,150,3);
Insert into TESTDB.CART (ORDER_ID,CHECK_ID,PROD_ID,TOTALPRICE,QUANTITY) values (54,61,2,350,7);
REM INSERTING into TESTDB.PAY
SET DEFINE OFF;
Insert into TESTDB.PAY (PAY_ID,USER_ID,PAY_AMOUNT,FULL_NAME,CARDNAME,SHIPADR1,SHIPADR2,SHIPCODE,BILLADR1,BILLADR2,BILLCODE) values (2,61,371,'new user','123456852','ship #1','MD','0000','bill1','DC','0001');
REM INSERTING into TESTDB.PRODUCTS
SET DEFINE OFF;
Insert into TESTDB.PRODUCTS (PROD_ID,PROD_NAME,PRICE,PROD_PIC,DESCRIPTION) values (2,'Rihanna Riri Eau De Parfum, 3.4 oz',50,'https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcRMGZiBZbELZupqxjgTRHkCkvbM2yGM-25aQStBMGCayOXDUOFOdy-MzqKccZToYY4-YVq3lw&usqp=CAY','RiRi by Rihanna is a flirty, floral melody of feminine, mischievous and playfully sensual notes. Inspired by Rihanna''s passion to always reveal her true self, RiRi by Rihanna captures a fresh, vibrant essence with a playful twist that lets your vivacious spirit shine through.');
Insert into TESTDB.PRODUCTS (PROD_ID,PROD_NAME,PRICE,PROD_PIC,DESCRIPTION) values (3,'Cologne by Paco Rabanne',48,'https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcS0DZQrRh1nmSXCzkfgPh5qBDiJnDHjWwb_rkZQUu7dCIcsLHs1A6wFbrRe6sdCKIvNK507Z6M&usqp=CAY','Defying limits, the audacious 1 Million fragrance evokes every masculine fantasy and desire, while exuding a self-assured, intelligent spirit. This fragrance is for the confident man, one who is not afraid to show who he really is. Its bottle, shaped like a gold bar, gives it an almost mystical power, captivating all who gaze upon it with envious eyes');
Insert into TESTDB.PRODUCTS (PROD_ID,PROD_NAME,PRICE,PROD_PIC,DESCRIPTION) values (21,'Christian Dior Miss Dior',54,'https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcRR856XZCsBkmpzjBbS_QO2lbhX8zT7g343WqpNIbxASe1C4souFW2fPnPBdejOkqR_UxId_8E&usqp=CAY','A floral fragrance that combines the Dior''s couture spirit with the fresh sophistication of a modern scent. Miss Dior Blooming Bouquet is a romantic floral, a total declaration of femininity, glamour and joie de vivre. It opens with a fresh and fruity explosion of Italian mandarin essence.');
REM INSERTING into TESTDB.USERS
SET DEFINE OFF;
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE,ORDER_ID) values (81,'new','123','???',to_date('02-SEP-15','DD-MON-RR'),null);
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE,ORDER_ID) values (42,'bull_horn','789','Hello Bull horn ',to_date('28-AUG-15','DD-MON-RR'),null);
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE,ORDER_ID) values (85,null,null,null,to_date('02-SEP-15','DD-MON-RR'),0);
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE,ORDER_ID) values (43,'set_register','123','Here you go ',to_date('28-AUG-15','DD-MON-RR'),null);
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE,ORDER_ID) values (87,null,null,null,to_date('03-SEP-15','DD-MON-RR'),0);
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE,ORDER_ID) values (88,'olu','olu',null,to_date('03-SEP-15','DD-MON-RR'),0);
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE,ORDER_ID) values (44,'col_new','147','when will this work',to_date('28-AUG-15','DD-MON-RR'),null);
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE,ORDER_ID) values (61,'new_user','123','shop?',to_date('01-SEP-15','DD-MON-RR'),null);
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE,ORDER_ID) values (48,'rathor','pwd','Sunny is the best',to_date('28-AUG-15','DD-MON-RR'),null);
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE,ORDER_ID) values (59,'pure_leaf','123','???',to_date('28-AUG-15','DD-MON-RR'),null);
Insert into TESTDB.USERS (USER_ID,USER_NAME,PASSWORD,USER_MOTTO,JOINDATE,ORDER_ID) values (86,null,null,null,to_date('02-SEP-15','DD-MON-RR'),0);
--------------------------------------------------------
--  DDL for Index SYS_C007576
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTDB"."SYS_C007576" ON "TESTDB"."CART" ("ORDER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007589
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTDB"."SYS_C007589" ON "TESTDB"."PAY" ("PAY_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007550
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTDB"."SYS_C007550" ON "TESTDB"."PRODUCTS" ("PROD_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007483
--------------------------------------------------------

  CREATE UNIQUE INDEX "TESTDB"."SYS_C007483" ON "TESTDB"."USERS" ("USER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table CART
--------------------------------------------------------

  ALTER TABLE "TESTDB"."CART" ADD PRIMARY KEY ("ORDER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PAY
--------------------------------------------------------

  ALTER TABLE "TESTDB"."PAY" ADD PRIMARY KEY ("PAY_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUCTS
--------------------------------------------------------

  ALTER TABLE "TESTDB"."PRODUCTS" ADD PRIMARY KEY ("PROD_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "TESTDB"."USERS" ADD PRIMARY KEY ("USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  DDL for Trigger cartrig
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTDB"."cartrig" 
BEFORE INSERT ON CART
FOR EACH ROW
DECLARE
  new_id number;
BEGIN
  SELECT cart_seq.nextval
    INTO new_id
    FROM dual;
  :new.order_id := new_id;
END;
/
ALTER TRIGGER "TESTDB"."cartrig" ENABLE;
--------------------------------------------------------
--  DDL for Trigger pay_trig
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTDB"."pay_trig" 
BEFORE INSERT ON Pay
FOR EACH ROW
DECLARE
  new_id number;
BEGIN
  SELECT pay_seq.nextval
    INTO new_id
    FROM dual;
  :new.Pay_id := new_id;
END;
/
ALTER TRIGGER "TESTDB"."pay_trig" ENABLE;
--------------------------------------------------------
--  DDL for Trigger prod_trig
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTDB"."prod_trig" 
BEFORE INSERT ON products
FOR EACH ROW
DECLARE
  new_id number;
BEGIN
  SELECT prod_seq.nextval
    INTO new_id
    FROM dual;
  :new.prod_id := new_id;
END;
/
ALTER TRIGGER "TESTDB"."prod_trig" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USR_SEQ_TRIG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TESTDB"."USR_SEQ_TRIG" 
BEFORE INSERT ON users
for each row
declare
ab_id number;
begin 
  select usr_seq.nextval
  into ab_id
  from dual;
  :new.user_id :=ab_id;
end;
/
ALTER TRIGGER "TESTDB"."USR_SEQ_TRIG" ENABLE;
