CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    author_name VARCHAR(100) NOT NULL
);

CREATE TABLE genres (
    genre_id SERIAL PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL
);

CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    language VARCHAR(50),
    publication_date DATE,
    num_pages INT,
    -- Foreign key reference to authors table
    author_id INT REFERENCES authors(author_id),
    -- Foreign key reference to genres table
    genre_id INT REFERENCES genres(genre_id)
);