CREATE TABLE answers(
        answer_id SERIAL UNIQUE NOT NULL,
        question_id INTEGER REFERENCES questions(question_id) NOT NULL, 
        event_id TEXT NOT NULL,
        created_by TEXT NOT NULL,
        is_correct BOOLEAN NOT NULL,
        answer TEXT NOT NULL,
        PRIMARY KEY (question_id,answer_id)
        )INHERITS (resource);