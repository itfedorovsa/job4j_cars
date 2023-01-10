CREATE TABLE IF NOT EXISTS posts(
    id SERIAL PRIMARY KEY,
    description TEXT,
    created TIMESTAMP WITHOUT TIME ZONE,
    user_id INT NOT NULL REFERENCES users(id)
);