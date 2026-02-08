CREATE TABLE run
(
    id           INT PRIMARY KEY,
    title        varchar(255) NOT NULL,
    started_on   TIMESTAMP    NOT NULL,
    completed_on TIMESTAMP    NOT NULL
);