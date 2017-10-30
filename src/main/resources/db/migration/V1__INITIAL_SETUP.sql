CREATE TABLE books(
  book_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
  book_name VARCHAR(255), 
  author_name VARCHAR(255), 
  user_id VARCHAR(255)
);

INSERT INTO books (book_name, author_name, user_id) VALUES 
  ('sample_book', 'sample_author', '1'),
  ('anothor_book', 'another_author', '2');
