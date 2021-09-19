CREATE DATABASE wildlife;
\c wildlife;
CREATE TABLE endangered(id SERIAL PRIMARY KEY,name VARCHAR,health VARCHAR,age VARCHAR,location VARCHAR);
CREATE DATABASE wildlife_test WITH TEMPLATE wildlife;
