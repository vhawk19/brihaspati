CREATE TABLE answers(id SERIAL PRIMARY KEY,question_id INTEGER REFERENCES questions(id), is_correct BOOLEAN,answer TEXT,option_no INTEGER);