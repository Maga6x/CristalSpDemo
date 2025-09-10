-- liquibase formatted sql

-- changeset alisher:1
INSERT INTO roles (name, description)
VALUES('ROLE_USER', 'обычный пользователь'),
      ('ROLE_ADMIN', 'администратор')
ON CONFLICT (name) DO NOTHING;

-- changeset alisher:2
INSERT INTO users (username, password_hash, full_name, age, gender)
VALUES('maga',   '$2a$10$jXH8/ecxGeRTHQx21OHwV.XcKm9b3HopSmNwqmdFWi6tBPXuMo46K', 'maga',   19, 'male'),
      ('darhan', '$2a$10$jXH8/ecxGeRTHQx21OHwV.XcKm9b3HopSmNwqmdFWi6tBPXuMo46K', 'darhan', 20, 'male')
ON CONFLICT (username) DO NOTHING;


-- changeset alisher:3
INSERT INTO user_roles(user_id, role_id)
VALUES (1,1),
       (2,2);

-- changeset alisher:4
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u JOIN roles r ON r.name = 'ROLE_USER'
WHERE u.username = 'maga'
ON CONFLICT DO NOTHING;

-- changeset alisher:5
INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u JOIN roles r ON r.name = 'ROLE_ADMIN'
WHERE u.username = 'darhan'
ON CONFLICT DO NOTHING;

-- changeset alisher:6
UPDATE databasechangelog
SET md5sum = NULL
WHERE filename = 'db/changelog/changes/10092025-1230-insert-table.sql'
  AND author   = 'alisher'
  AND id IN ('3','4');

