CREATE TABLE response(
    response_id SERIAL UNIQUE NOT NULL,
    user_id TEXT NOT NULL,
    event_id TEXT NOT NULL,
    question_id INTEGER REFERENCES questions(question_id) NOT NULL,
    answer_id INTEGER REFERENCES answers(answer_id) NOT NULL,
    PRIMARY KEY (question_id, user_id),
    descriptive_answer TEXT);