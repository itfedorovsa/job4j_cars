CREATE TABLE IF NOT EXISTS price_history(
   id SERIAL PRIMARY KEY,
   before INT NOT NULL,
   after INT NOT NULL,
   created TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
   post_id INT REFERENCES posts(id)
);