CREATE TABLE answers(
        id SERIAL PRIMARY KEY,
        question_id INTEGER REFERENCES questions(id), 
        event_id TEXT,
        created_by TEXT,
        is_correct BOOLEAN,
        answer TEXT
        )INHERITS (resource);