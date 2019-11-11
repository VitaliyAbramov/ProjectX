CREATE DATABASE hacker_db;

CREATE TABLE test_user (
    user_id SERIAL PRIMARY KEY,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    birthday VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    country VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    login VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL
);

CREATE TABLE Answer (
    answer_id SERIAL PRIMARY KEY,
    answer TEXT NOT NULL
);

CREATE TABLE Module (
    module_id SERIAL PRIMARY KEY,
    module VARCHAR(200) NOT NULL
);

CREATE TABLE CodingTask (
    codingTask_id SERIAL PRIMARY KEY,
    module_id INTEGER NOT NULL REFERENCES Module(module_id),
    question TEXT NOT NULL,
    difficulty VARCHAR(20) NOT NULL
);

CREATE TABLE AnswerOnTask (
    answerOnTask_id SERIAL PRIMARY KEY,
    codingTask_id INTEGER NOT NULL REFERENCES CodingTask(codingTask_id),
    answer_id INTEGER NOT NULL REFERENCES Answer(answer_id)
)










