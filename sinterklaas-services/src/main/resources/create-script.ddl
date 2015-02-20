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

INSERT INTO SINTERKLAAS."TEMPLATE"(ID, NAME, PATH) VALUES (1, 'SinterklaasTemplate 1', 'images/Sinterklaas1.jpg');
INSERT INTO SINTERKLAAS."TEMPLATE"(ID, NAME, PATH) VALUES (2, 'SinterklaasTemplate 2', 'images/Sinterklaas2.jpg');
INSERT INTO SINTERKLAAS."TEMPLATE"(ID, NAME, PATH) VALUES (3, 'SinterklaasTemplate 3', 'images/Sinterklaas3.jpg');
INSERT INTO SINTERKLAAS."TEMPLATE"(ID, NAME, PATH) VALUES (4, 'SinterklaasTemplate 4', 'images/Sinterklaas4.jpg');
INSERT INTO SINTERKLAAS."TEMPLATE"(ID, NAME, PATH) VALUES (5, 'SinterklaasTemplate 5', 'images/Sinterklaas5.jpg');
INSERT INTO SINTERKLAAS."TEMPLATE"(ID, NAME, PATH) VALUES (6, 'SinterklaasTemplate 6', 'images/Sinterklaas6.jpg');

