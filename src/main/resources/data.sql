-- admin123 (koen)
-- teacher123 (melissa)
-- student123 (lynn)

INSERT INTO users(username, password, email, is_student, enabled, plus_minus, divide, multiply)
VALUES ('koen', '$2a$10$j4hF9GhP.53ttXOlxkt0sOpmI1I8sGUOwFEVcoz1oX.r8DPvW1qHe', 'koenm@chiefcount.nl', FALSE, TRUE, 3,
        3, 3),
       ('melissa', '$2a$10$XJg2lvDRyTMN93ku1DlHwuErx3kFfhAfrhNTCHkAJy6Q5w2Vi.HyO', 'melissa@chiefcount.nl', FALSE, TRUE,
        3, 3, 3),
       ('lynn', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'lynn@chiefcount.nl', TRUE, TRUE, 2, 1,
        2),
       ('jason', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'jason@chiefcount.nl', TRUE, TRUE, 3,
        1, 2),
       ('jamie', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'jamie@chiefcount.nl', TRUE, TRUE, 2,
        2, 2),
       ('mathias', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'mathias@chiefcount.nl', TRUE, TRUE,
        1, 1, 2),
       ('julia', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'julia@chiefcount.nl', TRUE, TRUE, 2,
        1, 2),
       ('ivy-mae', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'ivy-mae@chiefcount.nl', TRUE, TRUE,
        1, 3, 1),
       ('marley', '$2a$10$dUe5ex8s5UP37uFqVgoexecYF81G45aaDIQKEGLBinzaX75B/edI6', 'marley@chiefcount.nl', TRUE, TRUE,
        1, 2, 2);

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
