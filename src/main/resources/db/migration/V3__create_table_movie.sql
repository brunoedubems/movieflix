CREATE TABLE movie(
    id serial PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    release_date DATE,
    rating NUMERIC,
    created_at TIMESTAMP,
    updated_at TIMESTAMP

);