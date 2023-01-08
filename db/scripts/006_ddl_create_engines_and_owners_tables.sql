CREATE TABLE IF NOT EXISTS engines(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS owners(
    id SERIAL PRIMARY KEY,
    name TEXT,
    user_id INT
);
