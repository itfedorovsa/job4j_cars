ALTER TABLE prices_history ADD COLUMN IF NOT EXISTS post_id INT NOT NULL REFERENCES posts(id);