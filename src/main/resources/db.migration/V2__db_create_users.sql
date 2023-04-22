INSERT INTO user (activate_code, archive, email, password, phone_number, role, user_name)
    VALUES (null, false, '2.12nps@mail.ru', '$2a$12$jQuD.4QW5pm0qssdjD9vfeZxIbA01ZZoXPVLKNbIzk9uaO7mF.liq', '89086431055', 'ADMIN', 'alex');

INSERT INTO user (activate_code, archive, email, password, phone_number, role, user_name)
    VALUES (null, false, '2.12nps@gmail.com', '$2a$12$jQuD.4QW5pm0qssdjD9vfeZxIbA01ZZoXPVLKNbIzk9uaO7mF.liq', '89041256288', 'MANAGER', 'user');

INSERT INTO user (activate_code, archive, email, password, phone_number, role, user_name)
    VALUES (null, false, '2.12nps@gmail.ru', '$2a$12$jQuD.4QW5pm0qssdjD9vfeZxIbA01ZZoXPVLKNbIzk9uaO7mF.liq', '89016668881', 'WORKER', 'user1');

INSERT INTO admin (admin_name, user_id) VALUES ('Иван', 1);

INSERT INTO manager (manager_name, admin_id, user_id) VALUES ('Юлия', 1, 2);

INSERT INTO worker (worker_name, manager_id, user_id) VALUES ('Люба', 1, 3);