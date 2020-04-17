CREATE TABLE questions(
    id SERIAL PRIMARY KEY,
    question_text TEXT,
    event_id TEXT,
    question_type TEXT,
    created_by TEXT
    )INHERITS (resource);
