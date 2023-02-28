ALTER TABLE participants
DROP CONSTRAINT participants_user_id_fkey,
ADD CONSTRAINT participants_user_id_fkey
FOREIGN KEY (user_id)
REFERENCES users(id);

ALTER TABLE participants
DROP CONSTRAINT participates_post_id_fkey,
ADD CONSTRAINT participants_post_id_fkey
FOREIGN KEY (post_id)
REFERENCES posts(id);