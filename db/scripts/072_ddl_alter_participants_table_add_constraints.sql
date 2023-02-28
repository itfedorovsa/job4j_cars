ALTER TABLE participants
DROP CONSTRAINT participates_user_id_fkey,
ADD CONSTRAINT participants_user_id_fkey
FOREIGN KEY (user_id)
REFERENCES users(id)
ON DELETE CASCADE;

ALTER TABLE participants
DROP CONSTRAINT participates_post_id_fkey,
ADD CONSTRAINT participates_post_id_fkey
FOREIGN KEY (post_id)
REFERENCES posts(id)
ON DELETE CASCADE;