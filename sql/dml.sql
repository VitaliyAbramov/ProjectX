INSERT INTO test_user (firstname, lastname, birthday, email, phone, country, city, login, password) VALUES
('John','Spilberg','1996-05-05','john.spilberg@gmail.com','380998789023','USA','New-York','john_log','john_pwd'),
('Mark','Walberg','1976-12-02','mark.walberg@gmail.com','380667892367','USA','Los-Angeles','mark_log','mark_pwd'),
('Jummy','Kimmel','1989-11-22','jummy.kimmel@gmail.com','380998789023','USA','San-Francisco','jummy_log','jummy_pwd'),
('Tony','Robynson','1985-09-01','tony.robynson@gmail.com','380998789023','Ukraine','Kharkiv','tony_log','tony_pwd'),
('Brayan','Treisy','1979-08-15','brayan.treisy@gmail.com','380998789023','Ukraine','Kyiv','brayan_log','brayan_pwd'),
('Dawyen','Johnson','1973-12-14','dawyen.johnson@gmail.com','380998789023','Ukraine','Poltava','dawyen_log','dawyen_pwd');

INSERT INTO Answer (answer) VALUES
('34 as a++ get us the same value in this line.'),
('String, Character, Integer'),
('11 methods'),
('56');

INSERT INTO Module (module) VALUES
('Data types'),
('Collections'),
('Strings'),
('Exceptions'),
('Concurrency'),
('IO Streams');

INSERT INTO CodingTask (module_id, question, difficulty) VALUES
('1', 'Which data types can be passed in switch statement?', 'MEDIUM'),
('2', 'How much methods exists in the Object class?', 'EASY'),
('3', 'a = a++; What is the value of "a" in this line?', 'EASY'),
('4', 'x = 57; x = --x++; What is the value of x?','HARD');
