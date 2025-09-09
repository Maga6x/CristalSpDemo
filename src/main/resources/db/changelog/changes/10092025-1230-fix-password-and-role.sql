--liquibase formatted sql

--changeset alisher:fix-maga-password
-- изменяем пароль пользователя 'maga' на корректный bcrypt-хэш для "qwerty"
UPDATE users
SET password_hash = '$2a$10$jXH8/ecxGeRTHQx21OHwV.XcKm9b3HopSmNwqmdFWi6tBPXuMo46K'
WHERE username = 'maga';

--changeset alisher:fix-role
UPDATE roles SET name = 'ROLE_USER'  WHERE name = 'USER';
UPDATE roles SET name = 'ROLE_ADMIN' WHERE name = 'ADMIN';
