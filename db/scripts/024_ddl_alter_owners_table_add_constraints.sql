ALTER TABLE owners ALTER COLUMN name SET NOT NULL;
ALTER TABLE owners ALTER COLUMN user_id SET NOT NULL;
ALTER TABLE owners ADD CONSTRAINT users_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);