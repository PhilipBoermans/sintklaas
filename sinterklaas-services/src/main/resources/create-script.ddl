SET DATABASE SQL SYNTAX ORA TRUE;
CREATE SCHEMA SINTERKLAAS;
SET INITIAL SCHEMA SINTERKLAAS;

CREATE SEQUENCE SINTERKLAAS."LETTER.SEQ";
CREATE SEQUENCE SINTERKLAAS."TEMPLATE.SEQ";

CREATE TABLE SINTERKLAAS."LETTER"
("ID"             DECIMAL,
 "NAME"     VARCHAR(255),
 "BODY"      CLOB
);

CREATE TABLE SINTERKLAAS."TEMPLATE"
("ID"       DECIMAL,
 "NAME"     VARCHAR(255),
 "PATH"     VARCHAR(255)
);

INSERT INTO SINTERKLAAS."LETTER"(ID, NAME, BODY) VALUES (1, 'Standaardbrief 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt');
INSERT INTO SINTERKLAAS."LETTER"(ID, NAME, BODY) VALUES (2, 'Standaardbrief 2', 'Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam,');