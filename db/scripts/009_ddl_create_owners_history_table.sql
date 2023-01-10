CREATE TABLE IF NOT EXISTS owners_history(
    id SERIAL PRIMARY KEY,
    owner_id INT NOT NULL REFERENCES owners(id),
    car_id INT NOT NULL REFERENCES cars(id),
    start_at TEXT,
    end_at TEXT
);