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


insert into tb_section (title, description, position, img_uri, resource_id, prerequisite_id) values ('Capitulo 1',  'Neste capitulo vai ser dado o start', 1, 'https://cdn.pixabay.com/photo/2020/05/31/09/40/online-course-5242018_1280.jpg', 1, null);
insert into tb_section (title, description, position, img_uri, resource_id, prerequisite_id) values ('Capitulo 2',  'Neste capitulo vamos continuar', 1, 'https://cdn.pixabay.com/photo/2020/05/31/09/40/online-course-5242018_1280.jpg', 1, 1);
insert into tb_section (title, description, position, img_uri, resource_id, prerequisite_id) values ('Capitulo 3',  'Neste capitulo vamos finalizar', 1, 'https://cdn.pixabay.com/photo/2020/05/31/09/40/online-course-5242018_1280.jpg', 1, 2);


insert into tb_enrollment(enrollment_moment, refund_moment, avaliable, only_update, user_id, offer_id) values (TIMESTAMP WITH TIME ZONE '2020-06-20T08:00:00Z', null, true, false, 1, 1);
insert into tb_enrollment(enrollment_moment, refund_moment, avaliable, only_update, user_id, offer_id) values (TIMESTAMP WITH TIME ZONE '2020-06-20T10:00:00Z', null, true, false, 2, 1);

insert into tb_lesson (title, position, section_id) values ('Aula 1 do capitulo 1', 1, 1);
insert into tb_content (id, text_content, video_uri) values (1, 'Material de apoio: abc', 'https://youtu.be/-gUHKJzeK9g');

insert into tb_lesson (title, position, section_id) values ('Aula 2 do capitulo 1', 2, 1);
insert into tb_content (id, text_content, video_uri) values (2, '', 'https://youtu.be/-gUHKJzeK9g');

insert into tb_lesson (title, position, section_id) values ('Aula 3 do capitulo 1', 3, 1);
insert into tb_content (id, text_content, video_uri) values (3, '', 'https://youtu.be/-gUHKJzeK9g');

insert into tb_lesson (title, position, section_id) values ('Task do capitulo 1', 4, 1);
insert into tb_task (id, description, quest_count, approval_count, weight, due_date) values (4, 'Fazer bolo de Ovo', 5, 4, 1.0, TIMESTAMP WITH TIME ZONE '2020-06-25T08:00:00Z');

insert into tb_lessons_done (lesson_id, user_id, offer_id) values (1, 1, 1);
insert into tb_lessons_done (lesson_id, user_id, offer_id) values (2, 1, 1);


INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Primeiro feedback de tarefa: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-10T13:00:00Z', true, '/offers/1/resources/1/sections/1', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Segundo feedback: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-12T13:00:00Z', true, '/offers/1/resources/1/sections/1', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Terceiro feedback: favor revisar', TIMESTAMP WITH TIME ZONE '2020-12-14T13:00:00Z', false, '/offers/1/resources/1/sections/1', 1);

INSERT INTO tb_deliver (uri, moment, status, feedback, correct_Count, lesson_id, user_id, offer_id) VALUES ('https://github.com/devsuperior/bds-dslearn', TIMESTAMP WITH TIME ZONE '2020-12-10T10:00:00Z', 0, null, null, 4, 1, 1);

INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 1', 'Corpo do tópico 1', TIMESTAMP WITH TIME ZONE '2020-12-12T13:00:00Z', 1, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 2', 'Corpo do tópico 2', TIMESTAMP WITH TIME ZONE '2020-12-13T13:00:00Z', 2, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 3', 'Corpo do tópico 3', TIMESTAMP WITH TIME ZONE '2020-12-14T13:00:00Z', 2, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 4', 'Corpo do tópico 4', TIMESTAMP WITH TIME ZONE '2020-12-15T13:00:00Z', 1, 1, 2);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 5', 'Corpo do tópico 5', TIMESTAMP WITH TIME ZONE '2020-12-16T13:00:00Z', 1, 1, 2);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 6', 'Corpo do tópico 6', TIMESTAMP WITH TIME ZONE '2020-12-17T13:00:00Z', 2, 1, 3);

INSERT INTO tb_topic_likes (topic_id, user_id) VALUES (1, 2);
INSERT INTO tb_topic_likes (topic_id, user_id) VALUES (2, 1);

INSERT INTO tb_reply (body, moment, topic_id, author_id) VALUES ('Tente reiniciar o computador', TIMESTAMP WITH TIME ZONE '2020-12-15T13:00:00Z', 1, 2);
INSERT INTO tb_reply (body, moment, topic_id, author_id) VALUES ('Deu certo, valeu!', TIMESTAMP WITH TIME ZONE '2020-12-20T13:00:00Z', 1, 1);

INSERT INTO tb_reply_likes (reply_id, user_id) VALUES (1, 1);



