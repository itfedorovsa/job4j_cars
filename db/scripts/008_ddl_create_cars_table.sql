CREATE TABLE IF NOT EXISTS cars(
    id SERIAL PRIMARY KEY,
    name TEXT,
    vin VARCHAR NOT NULL UNIQUE,
    engine_id INT NOT NULL UNIQUE REFERENCES engines(id),
    owner_id INT NOT NULL REFERENCES owners(id)
);