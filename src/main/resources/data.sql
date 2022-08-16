delete from quiz;
delete from question;

insert into quiz (id, code, name, maker_id, creation_date)
values (1, '123456', 'Prvi probni kviz', 2, CURRENT_DATE),
       (2, '222bbb', 'Drugi probni kviz', 1, CURRENT_DATE);

insert into question (id, position, question, answer)
values
       (1, 1, 'Koje je prvo pitanje drugog probnog kviza ?', 'Ovo je prvo pitanje drugog probnog kviza'),
       (2, 2, 'Je li ovo drugo pitanje drugog probnog kviza ?', 'Da'),
       (3, 1, 'Ima li prvi probni kviz ijedno pitanje ?', 'Sada ima');

insert into quiz_question (quiz_id, question_id)
values
    (2, 1),
    (2, 2),
    (1, 3);

insert into users(id, username, password)
values
    (1, 'user', '$2a$12$PWh2Tlwhmgc3V8HhnNFQke2cEVHw85ipZCX1.5aBgdJYG2i7OVNqy'), -- password = user
    (2, 'admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG'); -- password = admin

insert into authority (id, authority_name)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');

insert into user_authority (user_id, authority_id)
values
    (1, 2),
    (2, 1);