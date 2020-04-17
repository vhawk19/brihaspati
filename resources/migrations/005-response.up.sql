CREATE TABLE response(
    id SERIAL PRIMARY KEY,
    user_id TEXT,
    event_id TEXT,
    question_id INTEGER REFERENCES questions(id),
    answer_id INTEGER REFERENCES answers(id),
    descriptive_answer TEXT);