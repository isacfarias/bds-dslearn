INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 3);


INSERT INTO tb_course (name, img_uri, img_gray_uri) VALUES ('Bootcamp HTML', 'https://cdn.pixabay.com/photo/2020/05/31/09/40/online-course-5242018_1280.jpg', 'https://static.thenounproject.com/png/2036003-200.png');

INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) values ('1.0', TIMESTAMP WITH TIME ZONE '2020-06-20T00:00:00Z', TIMESTAMP WITH TIME ZONE '2021-06-30T00:00:00Z', 1);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) values ('2.0', TIMESTAMP WITH TIME ZONE '2020-07-20T00:00:00Z', TIMESTAMP WITH TIME ZONE '2021-07-30T00:00:00Z', 1);

insert into tb_resource(title, description, position, img_uri, type, external_link, offer_id) values ('Trilha HTML', 'Trilha principal do curso', 1, 'https://cdn.pixabay.com/photo/2020/05/31/09/40/online-course-5242018_1280.jpg', 1, null, 1);
insert into tb_resource(title, description, position, img_uri, type, external_link, offer_id) values ('Forum', 'Tire suas duvidas', 1, 'https://cdn.pixabay.com/photo/2020/05/31/09/40/online-course-5242018_1280.jpg', 2, null, 1);
insert into tb_resource(title, description, position, img_uri, type, external_link, offer_id) values ('Lives', 'Lives exclusivas', 1, 'https://cdn.pixabay.com/photo/2020/05/31/09/40/online-course-5242018_1280.jpg', 0, null, 1);
