ALTER TABLE posts
DROP CONSTRAINT posts_car_id_fkey,
ADD CONSTRAINT posts_car_id_fkey
FOREIGN KEY (car_id)
REFERENCES cars(id);

ALTER TABLE posts ALTER COLUMN car_id DROP NOT NULL;

ALTER TABLE posts ALTER COLUMN user_id DROP NOT NULL;