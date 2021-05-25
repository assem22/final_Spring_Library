CREATE TABLE if not exists users(
    user_id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL
);

CREATE TABLE if not exists books(
    book_id serial PRIMARY KEY,
    user_id BIGINT,
    book_genre VARCHAR(255) NOT NULL,
    book_name VARCHAR(255) NOT NULL,
    description VARCHAR(1000) NULL
);

CREATE TABLE if not exists role(
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE if not exists user_relation(
    user_id BIGINT,
    parent_id BIGINT
);

CREATE TABLE if not exists user_roles(
    user_id BIGINT,
    role_id BIGINT
);
