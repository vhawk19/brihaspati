CREATE TABLE questions(
    question_id SERIAL UNIQUE NOT NULL,
    question_text TEXT NOT NULL,
    event_id TEXT NOT NULL,
    question_type TEXT NOT NULL,
    created_by TEXT NOT NULL,
    PRIMARY KEY (question_text, event_id)
    )INHERITS (resource);
