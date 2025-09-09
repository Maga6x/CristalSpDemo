-- liquibase formatted sql

-- changeset alisher:1
INSERT INTO students(last_name, first_name, age)
VALUES ('Gabriloc', 'Nikita', 17),
       ('Hadidja','Jasmin', 18),
       ('Kaidyrbekova','Aisulu',19);

-- changeset alisher:2
INSERT INTO lessons(name)
VALUES ('Algebra'),
       ('History'),
       ('Fizra');