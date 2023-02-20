ALTER TABLE prices_history
DROP CONSTRAINT prices_history_post_id_fkey,
ADD CONSTRAINT prices_history_post_id_fkey
  FOREIGN KEY (post_id)
  REFERENCES posts(id)
  ON DELETE CASCADE;

