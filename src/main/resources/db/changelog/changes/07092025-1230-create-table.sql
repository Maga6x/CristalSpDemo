--liquibase formatted sql

--changeset alisher:1
CREATE TABLE IF NOT EXISTS students (
    id BIGSERIAL PRIMARY KEY,
    last_name VARCHAR(100),
    first_name VARCHAR(100),
    age INT
);

--changeset alisher:2
CREATE TABLE IF NOT EXISTS lessons (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200)
);

--changeset alisher:3
CREATE TABLE IF NOT EXISTS student_lessons (
    student_id BIGINT NOT NULL,
    lesson_id BIGINT NOT NULL,
    PRIMARY KEY (student_id, lesson_id),
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    FOREIGN KEY (lesson_id) REFERENCES lessons(id) ON DELETE CASCADE
);
