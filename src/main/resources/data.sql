delete from quiz;
delete from question;
delete from answer;

insert into quiz (code, name, maker_id, creation_date)
values ('123456', 'Prvi probni kviz', 2, CURRENT_DATE),
       ('222BBB', 'Drugi probni kviz', 1, CURRENT_DATE);

insert into question (position, question, answer, quiz_id)
values
       (1, 'Indijski orah ili indijski oraščić biljka je iz porodice Anacardium i, bez obzira na ime, ne potječe iz Indije. Njega su u Indiju donijeli Portugalci i danas je Indija uz Obalu Bjelokosti njegov najveći proizvođač. Iz koje današnje države potječe ova biljka ?',
        'Brazil', 2),
       (3, 'Najstarije kontinuirano naselje u Europi nalazi se u Hrvatskoj. O kojem se gradu radi ako znamo da je kontinuirano naseljen preko 8.300 godina ?',
           'Vinkovci', 2),
       (1, 'Glavni grad Poljske je Varšava. Smjestio se u centralnom dijelu ove velike zemlje. Kroz njega protječe i jedna velika rijeka, a grad se ravnomjerno širi na obje obale iste. Kako nazivamo rijeku koja protječe kroz Varšavu?',
            'Visla', 1),
       (2, 'Na visini od 1078 metara, nedaleko od Mrkoplja, smjestilo se naselje koje se smatra najvišim stalno naseljenim mjestom u Hrvatskoj. Koje je ime ovog pitoresknog sela?',
            'Begovo razdolje', 2),
       (4, 'Kako u fizici nazivamo pojavu međusobnog privlačenja površina dvaju tijela načinjenih od različitih tvari, ili tijela i tekućine, zbog djelovanja elektromagnetskih sila među molekulama?',
           'Adhezija', 2),
       (5, 'Evo nas opet u Antici, točnije u Ateni. Tražimo ime velikog grčkog matematičara, koji je zadužio svjetsku znanost djelom objavljenim oko 300 gpk.. Riječ je o matematičkim spisima objavlenim u trinaest knjiga, po imenu Elementi. Do dana današnjeg, ove spise se smatra jednim od najboljih djela o matematici ikad. Kako se zvao autor Elemenata?',
            'Euklid', 2),
       (2, 'Kod nas se temperatura mjeri u celzijusima. Međutim, u nekim djelovima svijeta prihvaćena je skala koju je osmislio njemački fizičar Gabriel Fahrenheit. Vjerujem da se mnogi snalaze i na ovoj ljestvici, ali kod nas je mnogo poznatija po književnom djelu Raya Bradburya, po kojem je snimljen i istoimeni film. U imenu romana prva je riječ Fahrenheit, a potom ide broj, koji, navodno, označava temperaturu na kojoj papir počinje gorjeti. U Fahrenheitima, logično. Koji je to broj?',
            '451', 1);


insert into users(username, password, email)
values
    ('user', '$2a$12$PWh2Tlwhmgc3V8HhnNFQke2cEVHw85ipZCX1.5aBgdJYG2i7OVNqy', 'user@email.com'), -- password = user
    ('admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG', 'admin@email.com'), -- password = admin
    ('toni', '$2a$12$q/YPJt7yDcN.DKVxuwhu3.3hh0PhbdF1XepNHT8o5isxugxu70gwC', 'user@email.com'), -- password = toni123
    ('ivan', '$2a$12$xBjtWv4I15I8tON0lEV4Gu3edSi77RRlzlR/p36IZ2aNO5ec1BMjO', 'user@email.com'), -- password = ivan123
    ('marko', '$2a$12$XjOwmcjO..IU9X3ROVpkOOFinufv76McPcYQxnoCK1i1xXzlrNYEq', 'pero@email.com'); -- password = marko123

insert into authority (id, authority_name)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');

insert into user_authority (user_id, authority_id)
values
    (1, 2),
    (2, 1),
    (3, 2);

insert into answer (answer, question_id, user_id)
values  ('Ovo je prvi odgovor ikad dan u ovoj aplikaciji, na treće pitanje', 2, 2),
        ('Drugi odgovor u ovoj aplikaciji, ali na prvo pitanje (drugog kviza)', 1, 2),
        ('Treći odgovor u ovoj aplikaciji, na 2. pitanje', 4, 2),
        ('Vinkovci', 2, 3),
        ('Brazil', 1, 3),
        ('Mrkopalj', 4, 3);