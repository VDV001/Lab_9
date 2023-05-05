DROP TABLE IF EXISTS t_role;

USE spring;

create table t_role(
    id LONG NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

--CREATE TABLE t_role(
--  id LONG NOT NULL AUTO_INCREMENT,
--  name VARCHAR(255) DEFAULT NULL ,
--  PRIMARY KEY (id)
--);
