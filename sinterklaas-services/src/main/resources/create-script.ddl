SET DATABASE SQL SYNTAX ORA TRUE;
CREATE SCHEMA SINTERKLAAS;
SET INITIAL SCHEMA SINTERKLAAS;

CREATE SEQUENCE SINTERKLAAS."TEMPLATE.SEQ";

CREATE TABLE SINTERKLAAS."TEMPLATE"
("ID"             DECIMAL,
 "NAME"     VARCHAR(255),
 "BODY"      CLOB
);

INSERT INTO SINTERKLAAS."TEMPLATE"(ID, NAME, BODY) VALUES (1, 'TEMPLATE 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt');
INSERT INTO SINTERKLAAS."TEMPLATE"(ID, NAME, BODY) VALUES (2, 'TEMPLATE 2', 'Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam,');