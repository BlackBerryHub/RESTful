CREATE TABLE IF NOT EXISTS user(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
second_name VARCHAR(100) NOT NULL,
payment INTEGER NOT NULL
);