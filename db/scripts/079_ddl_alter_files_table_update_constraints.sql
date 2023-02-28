ALTER TABLE files
DROP CONSTRAINT files_post_id_fkey,
ADD CONSTRAINT files_post_id_fkey
  FOREIGN KEY (post_id)
  REFERENCES posts(id);

ALTER TABLE files ALTER COLUMN post_id DROP NOT NULL;