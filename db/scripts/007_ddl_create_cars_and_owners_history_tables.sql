CREATE TABLE IF NOT EXISTS cars(
    id SERIAL PRIMARY KEY,
    name TEXT,
    vin VARCHAR NOT NULL UNIQUE,
    engine_id INT NOT NULL UNIQUE REFERENCES engines(id),
    owner_id INT NOT NULL REFERENCES owners(id)
);

CREATE TABLE IF NOT EXISTS owners_history(
    id SERIAL PRIMARY KEY,
    owner_id INT NOT NULL REFERENCES owners(id),
    car_id INT NOT NULL REFERENCES cars(id),
    start_at TEXT,
    end_at TEXT
);