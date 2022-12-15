CREATE TABLE IF NOT EXISTS price_history(
   id SERIAL PRIMARY KEY,
   before INT NOT NULL,
   after INT NOT NULL,
   created TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
   auto_post_id INT REFERENCES auto_post(id)
);