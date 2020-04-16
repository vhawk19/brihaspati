CREATE TABLE response(
    id SERIAL PRIMARY KEY,
    user_id TEXT,
    event_id TEXT,
    question INTEGER REFERENCES questions(id),
    answer INTEGER REFERENCES answers(id),
    descriptive_answer TEXT);