ALTER TABLE users ADD COLUMN IF NOT EXISTS name VARCHAR NOT NULL;
ALTER TABLE users ADD COLUMN IF NOT EXISTS timezone VARCHAR NOT NULL DEFAULT 'UTC';