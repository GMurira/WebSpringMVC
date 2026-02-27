-- Add 'IF NOT EXISTS' to prevent errors on restart
CREATE TABLE IF NOT EXISTS run
(
    id           INT PRIMARY KEY,
    title        varchar(255) NOT NULL,
    started_on   TIMESTAMP    NOT NULL,
    completed_on TIMESTAMP    NOT NULL,
    version      INT
    );