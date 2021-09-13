CREATE DATABASE trabalho_lab;

CREATE TABLE aluno(
	id integer auto_increment PRIMARY KEY,
	matricula integer,
    curso varchar (255),
    nome varchar (255),
    telefone varchar (20),
    sexo varchar(9),
    idade integer
);

CREATE TABLE funcionario(
	id integer auto_increment PRIMARY KEY,
    nome varchar (255),
    telefone varchar (20),
    sexo varchar(9),
    idade integer,
    usuario varchar(255) UNIQUE,
    senha varchar(255) 
);

CREATE TABLE professor(
	id integer auto_increment PRIMARY KEY,
    identificacao integer,
    nome varchar (255),
    telefone varchar (20),
    sexo varchar(9),
    idade integer
);

CREATE TABLE livro(
	id integer auto_increment PRIMARY KEY,
    codigo integer,
    titulo varchar (255),
    autor varchar (255),
    genero varchar (255),
    isEmprestado boolean
);

CREATE TABLE emprestado_aluno(
	id integer auto_increment PRIMARY KEY,
	aluno integer,
    devolucao date,
	FOREIGN KEY (aluno) REFERENCES aluno (id)
);

CREATE TABLE emprestado_professor(
	id integer auto_increment PRIMARY KEY,
	professor integer,
    devolucao date,
	FOREIGN KEY (professor) REFERENCES professor (id)
);

SELECT * FROM funcionario;
