ALTER TABLE cars ADD COLUMN IF NOT EXISTS brand_id INT NOT NULL REFERENCES brands(id);
ALTER TABLE cars ADD COLUMN IF NOT EXISTS model_id INT NOT NULL REFERENCES models(id);
ALTER TABLE cars ADD COLUMN IF NOT EXISTS mileage INT NOT NULL;
ALTER TABLE cars ADD COLUMN IF NOT EXISTS body_id INT NOT NULL REFERENCES bodies(id);
ALTER TABLE cars ADD COLUMN IF NOT EXISTS colour_id INT NOT NULL REFERENCES colours(id);
ALTER TABLE cars ADD COLUMN IF NOT EXISTS year_id INT NOT NULL REFERENCES release_years(id);
ALTER TABLE cars ADD COLUMN IF NOT EXISTS engine_volume_id INT NOT NULL REFERENCES engines_volume(id);