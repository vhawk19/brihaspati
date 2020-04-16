CREATE TABLE descriptive_answer(
    id SERIAL PRIMARY KEY,
    answer TEXT,
    question_id INTEGER REFERENCES questions(id))