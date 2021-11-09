-- admin123 ( koen )
-- teacher123 ( melissa, piet )
-- student123 ( ...rest )

INSERT INTO users(username, password, enabled)
VALUES ('koen', '$2a$10$X8iI32YbVcYZUn7Yt43lN.r5RLxIdsifR.Ghtmm1NDhzS3vOGPYPC', TRUE),
       ('melissa', '$2a$10$324r9w/3Nkw.Yp1hMe..pOyAJ7JJM5jpJQRpuLhpa1VzEfnTftL2e', TRUE),
       ('piet', '$2a$10$324r9w/3Nkw.Yp1hMe..pOyAJ7JJM5jpJQRpuLhpa1VzEfnTftL2e', TRUE),
       ('sara', '$2a$10$EiCejec55zP5j8VpokgGMuZ8RGIxP97z2bFRhzaFWRVmBqVZNf4kK', TRUE),
       ('willem', '$2a$10$EiCejec55zP5j8VpokgGMuZ8RGIxP97z2bFRhzaFWRVmBqVZNf4kK', TRUE),
       ('bas', '$2a$10$EiCejec55zP5j8VpokgGMuZ8RGIxP97z2bFRhzaFWRVmBqVZNf4kK', TRUE),
       ('klaas', '$2a$10$EiCejec55zP5j8VpokgGMuZ8RGIxP97z2bFRhzaFWRVmBqVZNf4kK', TRUE),
       ('noor', '$2a$10$EiCejec55zP5j8VpokgGMuZ8RGIxP97z2bFRhzaFWRVmBqVZNf4kK', TRUE),
       ('lisa', '$2a$10$EiCejec55zP5j8VpokgGMuZ8RGIxP97z2bFRhzaFWRVmBqVZNf4kK', TRUE),
       ('robert', '$2a$10$EiCejec55zP5j8VpokgGMuZ8RGIxP97z2bFRhzaFWRVmBqVZNf4kK', TRUE),
       ('anouk', '$2a$10$EiCejec55zP5j8VpokgGMuZ8RGIxP97z2bFRhzaFWRVmBqVZNf4kK', TRUE),
       ('jamie', '$2a$10$EiCejec55zP5j8VpokgGMuZ8RGIxP97z2bFRhzaFWRVmBqVZNf4kK', TRUE),
       ('peter', '$2a$10$EiCejec55zP5j8VpokgGMuZ8RGIxP97z2bFRhzaFWRVmBqVZNf4kK', TRUE),
       ('kelly', '$2a$10$EiCejec55zP5j8VpokgGMuZ8RGIxP97z2bFRhzaFWRVmBqVZNf4kK', TRUE);


INSERT INTO authorities (username, authority)
VALUES ('koen', 'ROLE_STUDENT'),
       ('koen', 'ROLE_TEACHER'),
       ('koen', 'ROLE_ADMIN'),
       ('melissa', 'ROLE_STUDENT'),
       ('melissa', 'ROLE_TEACHER'),
       ('piet', 'ROLE_STUDENT'),
       ('piet', 'ROLE_TEACHER'),
       ('sara', 'ROLE_STUDENT'),
       ('willem', 'ROLE_STUDENT'),
       ('bas', 'ROLE_STUDENT'),
       ('klaas', 'ROLE_STUDENT'),
       ('noor', 'ROLE_STUDENT'),
       ('lisa', 'ROLE_STUDENT'),
       ('robert', 'ROLE_STUDENT'),
       ('anouk', 'ROLE_STUDENT'),
       ('jamie', 'ROLE_STUDENT'),
       ('peter', 'ROLE_STUDENT'),
       ('kelly', 'ROLE_STUDENT');