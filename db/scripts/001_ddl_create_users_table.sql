CREATE TABLE IF NOT EXISTS users(
    id SERIAL PRIMARY KEY,
    login TEXT,
    password TEXT
);