

--> SYS 계정으로 접속
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

--> 각자 계정에 CREATE VIEW 권한 부여
GRANT CREATE VIEW TO KH_LDH;