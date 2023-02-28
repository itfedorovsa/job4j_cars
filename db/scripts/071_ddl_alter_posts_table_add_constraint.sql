ALTER TABLE posts
DROP CONSTRAINT posts_car_id_fkey,
ADD CONSTRAINT posts_car_id_fkey
FOREIGN KEY (car_id)
REFERENCES cars(id)
ON DELETE CASCADE;