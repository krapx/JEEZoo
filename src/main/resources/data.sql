INSERT INTO players (id, username, password, mail, role, creation_at, updated_at)
VALUES (900L, 'player', 'pouetpouet', 'admin@gmail.com', 'USER', '2022-07-18', '2022-07-18');

INSERT INTO zoos (id, name, zoo_status, created_at, updated_at, player_id)
VALUES (1000L, 'zoo1', 'IN_PROGRESS', '2022-07-18', '2022-07-18', 900L);

INSERT INTO player_animals (id, damage, name, image, creation_at, updated_at, player_id, zoo_id)
VALUES (1100L, 2L, 'tortank', 'https://i.skyrock.net/2477/43222477/pics/2938629059_1_3.jpg',
        '2022-07-18', '2022-07-18', 900L, 1000L);

INSERT INTO spaces (id, name, status, zoo_id, defeated_count)
VALUES (1200L, 'water', 'IN_PROGRESS', 1000L, 0),
       (1201L, 'water', 'COMPLETED', 1000L, 0);

INSERT INTO animals (id, name, type, status, length_max, weight_max, arrival_date, image_link, space_id)
VALUES (1300L, 'toto', 'bonobo', 'Alive', 1L, 1L, '2022-07-18',
        'https://images.lanouvellerepublique.fr/image/upload/t_1020w/6252ba676b2332302d8b4770.jpg',
        1200L),
       (1301L, 'titi', 'bonobo', 'Dead', 1L, 1L, '2022-07-18',
        'https://images.lanouvellerepublique.fr/image/upload/t_1020w/6252ba676b2332302d8b4770.jpg',
        1200L);
