delete from quiz;
delete from question;

insert into quiz (code, name, maker_id, creation_date)
values ('123456', 'Prvi probni kviz', 2, CURRENT_DATE),
       ('222BBB', 'Drugi probni kviz', 1, CURRENT_DATE);

insert into question (position, question, answer)
values
       (1, 'Koje je prvo pitanje drugog probnog kviza ?', 'Ovo je prvo pitanje drugog probnog kviza'),
       (3, 'Je li ovo treće pitanje drugog probnog kviza ?', 'Nije na pravom mjestu u bazi, ali valjda će frontend to riješiti'),
       (1, 'Ima li prvi probni kviz ijedno pitanje ?', 'Sada ima'),
       (2, 'Je li ovo drugo pitanje drugog probnog kviza ?', 'Da');

insert into quiz_question (quiz_id, question_id)
values
    (2, 1),
    (2, 2),
    (1, 3),
    (2, 4);

insert into users(username, password, email)
values
    ('user', '$2a$12$PWh2Tlwhmgc3V8HhnNFQke2cEVHw85ipZCX1.5aBgdJYG2i7OVNqy', 'user@email.com'), -- password = user
    ('admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG', 'admin@email.com'); -- password = admin

insert into authority (id, authority_name)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');

insert into user_authority (user_id, authority_id)
values
    (1, 2),
    (2, 1);