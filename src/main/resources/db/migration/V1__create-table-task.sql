CREATE TABLE task (
    id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description TEXT,
    status VARCHAR(10) NOT NULL
);