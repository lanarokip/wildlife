SET MODE postgreSQL;

CREATE DATABASE wildlife;
\c wildlife;
CREATE TABLE if NOT EXISTS endangered(id SERIAL PRIMARY KEY,name VARCHAR,health VARCHAR,age VARCHAR,location VARCHAR,ranger VARCHAR);
CREATE DATABASE wildlife_test WITH TEMPLATE wildlife;
