DROP TABLE people IF EXISTS;
DROP TABLE company IF EXISTS ;

CREATE TABLE people  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);

CREATE TABLE company  (
    company_id	BIGINT  IDENTITY NOT NULL PRIMARY KEY,
    company_name	 VARCHAR(50) NOT NULL ,
    province	VARCHAR(20),
    establish_date VARCHAR(20),
    company_type	VARCHAR (100),
    company_address	VARCHAR (100),
    legal_person VARCHAR(20)
);