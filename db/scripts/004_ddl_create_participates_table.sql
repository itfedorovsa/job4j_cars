CREATE TABLE IF NOT EXISTS participates (
   id SERIAL PRIMARY KEY,
   user_id INT NOT NULL REFERENCES users(id),
   post_id INT NOT NULL REFERENCES posts(id)
);