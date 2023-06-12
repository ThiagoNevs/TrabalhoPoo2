# TrabalhoPoo2
Trabalho/ Prova  

CREATE DATABASE creche;

USE creche;

CREATE TABLE parentes  (
nome_parentes VARCHAR(60),
cpf_parentes VARCHAR(30),
parentesco_parentes VARCHAR(25),
mensalidade_parentes FLOAT(20),
desconto_parentes INT(15)
);

CREATE TABLE crianca (
nome_crianca VARCHAR(60),
cpf_crianca VARCHAR(30),
sangue_crianca VARCHAR(25),
altura_crianca FLOAT(20),
serie_crianca INT(15)
);

CREATE TABLE login (
nome_login VARCHAR(50),
senha_login VARCHAR(50)
);

