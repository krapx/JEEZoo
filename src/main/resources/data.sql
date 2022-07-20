INSERT INTO users (id, username, password, mail, role, creation_at, updated_at)
VALUES (999L, 'user', 'pouetpouet', 'admin@gmail.com', 'PLAYER', '2022-07-18', '2022-07-18');

INSERT INTO zoos (id, name, zoo_status, user_id)
VALUES (1000L, 'zoo1', 'IN_PROGRESS', 999L);
