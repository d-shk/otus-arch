DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id        SERIAL
        CONSTRAINT pk_users PRIMARY KEY,
    user_name       VARCHAR(200),
    first_name      VARCHAR(200),
    last_name       VARCHAR(200),
    email           VARCHAR(200),
    phone           VARCHAR(200)
    );

