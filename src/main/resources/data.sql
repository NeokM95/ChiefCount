-- admin123 (koen)
-- teacher123 (melissa)
-- student123 (lynn)

INSERT INTO users(username, password, email, enabled, plus_minus, divide, multiply)
VALUES ('koen', '$2a$10$j4hF9GhP.53ttXOlxkt0sOpmI1I8sGUOwFEVcoz1oX.r8DPvW1qHe', 'koenm@chiefcount.nl', TRUE, 1, 1, 1),
       ('melissa', '$2a$10$F1/GNlpfmt3lEky8OgSOq.ytC8OWGrfEMTSi9e10aGrBU4JDEnS7W', 'melissa@chiefcount.nl', TRUE, 1, 1, 1),
       ('lynn', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'lynn@chiefcount.nl', TRUE , 1, 1, 1),
       ('jason', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'lynn@chiefcount.nl', TRUE , 1, 1, 1),
       ('jamie', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'lynn@chiefcount.nl', TRUE , 1, 1, 1),
       ('mathias', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'lynn@chiefcount.nl', TRUE , 1, 1, 1),
       ('julia', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'lynn@chiefcount.nl', TRUE , 1, 1, 1),
       ('ivy-mae', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'lynn@chiefcount.nl', TRUE , 1, 1, 1),
       ('marley', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'lynn@chiefcount.nl', TRUE , 1, 1, 1);

INSERT INTO authorities (username, authority)
VALUES ('koen', 'ROLE_ADMIN'),
       ('melissa', 'ROLE_TEACHER'),
       ('lynn', 'ROLE_STUDENT'),
       ('jason', 'ROLE_STUDENT'),
       ('jamie', 'ROLE_STUDENT'),
       ('mathias', 'ROLE_STUDENT'),
       ('julia', 'ROLE_STUDENT'),
       ('ivy-mae', 'ROLE_STUDENT'),
       ('marley', 'ROLE_STUDENT');
