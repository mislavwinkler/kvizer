delete from quiz;
delete from question;
delete from answer;

insert into users(username, password, email)
values
    ('mislav', '$2a$12$XwLlBuU73fyu9L0pmcFuc.SJClgjCHQ7Ve8lVeNZt4RlHQBN.afku', 'mislav@email.com'), -- password = mislav123
    ('admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG', 'admin@email.com'), -- password = admin
    ('toni', '$2a$12$q/YPJt7yDcN.DKVxuwhu3.3hh0PhbdF1XepNHT8o5isxugxu70gwC', 'user@email.com'), -- password = toni123
    ('ivan', '$2a$12$xBjtWv4I15I8tON0lEV4Gu3edSi77RRlzlR/p36IZ2aNO5ec1BMjO', 'user@email.com'), -- password = ivan123
    ('marko', '$2a$12$XjOwmcjO..IU9X3ROVpkOOFinufv76McPcYQxnoCK1i1xXzlrNYEq', 'pero@email.com'); -- password = marko123


insert into quiz (code, name, maker_id, creation_date)
values ('123456', 'Prvi probni kviz', 2, CURRENT_DATE),
       ('222BBB', 'Drugi probni kviz', 1, CURRENT_DATE);

insert into question (position, question, answer, quiz_id)
values
        (1, 'Glavni grad Poljske je Varšava. Smjestio se u centralnom dijelu ove velike zemlje. Kroz njega protječe i jedna velika rijeka, a grad se ravnomjerno širi na obje obale iste. Kako nazivamo rijeku koja protječe kroz Varšavu?',
            'Visla', 1),
        (2, 'Kod nas se temperatura mjeri u celzijusima. Međutim, u nekim djelovima svijeta prihvaćena je skala koju je osmislio njemački fizičar Gabriel Fahrenheit. Vjerujem da se mnogi snalaze i na ovoj ljestvici, ali kod nas je mnogo poznatija po književnom djelu Raya Bradburya, po kojem je snimljen i istoimeni film. U imenu romana prva je riječ Fahrenheit, a potom ide broj, koji, navodno, označava temperaturu na kojoj papir počinje gorjeti. U Fahrenheitima, logično. Koji je to broj?',
         '451', 1),
        (1, 'Indijski orah ili indijski oraščić biljka je iz porodice Anacardium i, bez obzira na ime, ne potječe iz Indije. Njega su u Indiju donijeli Portugalci i danas je Indija uz Obalu Bjelokosti njegov najveći proizvođač. Iz koje današnje države potječe ova biljka ?',
            'Brazil', 2),
        (2, 'Na visini od 1078 metara, nedaleko od Mrkoplja, smjestilo se naselje koje se smatra najvišim stalno naseljenim mjestom u Hrvatskoj. Koje je ime ovog pitoresknog sela?',
         'Begovo razdolje', 2),
        (3, 'Najstarije kontinuirano naselje u Europi nalazi se u Hrvatskoj. O kojem se gradu radi ako znamo da je kontinuirano naseljen preko 8.300 godina ?',
               'Vinkovci', 2),
        (4, 'Kako u fizici nazivamo pojavu međusobnog privlačenja površina dvaju tijela načinjenih od različitih tvari, ili tijela i tekućine, zbog djelovanja elektromagnetskih sila među molekulama?',
           'Adhezija', 2),
        (5, 'Evo nas opet u Antici, točnije u Ateni. Tražimo ime velikog grčkog matematičara, koji je zadužio svjetsku znanost djelom objavljenim oko 300 gpk.. Riječ je o matematičkim spisima objavlenim u trinaest knjiga, po imenu Elementi. Do dana današnjeg, ove spise se smatra jednim od najboljih djela o matematici ikad. Kako se zvao autor Elemenata?',
            'Euklid', 2),
        (6, 'Legenda kaže da je predivni lokalitet imena Odisejeva špilja točno mjesto gdje se Odisej zaljubio u Kalipso. Smještena je na jednom našem otoku. Kojem?',
         'Mljet', 2),
        (7, 'Jedan od najpoznatijih pojmova iz nordijske mitologije je Valhalla. Ovo je velika rajska dvorana u kojoj stoluje vrhovni bog Odin, a u njoj borave ratnici poginuli u boju. Svako jutro izlaze iz nje, i bore se međusobno. Tako vježbaju za konačnu bitku između bogova i divova. Kako se zove ta konačna bitka na kraju svijeta?',
         'Ragnarok', 2),
        (8, 'Možda i najveći konceptualni umjetnik Hrvatske zvao se Vladimir, a životopisni nadimak mu je Trokut. Kako se prezivao?',
         'Dodig', 2),
        (9, 'Osoba za koju možemo reći da je renesansni čovjek u punom značenju riječi, bio je, naravno, Leonardo Da Vinci. Stvorio je čitav niz sjajnih slika, crteža, projekata i nacrta, iz kojih se može, barem malo, dokučiti o kakvoj je posebnoj osobi bilo riječ. Na jednom od njegovih crteža, prikazan je čovjek sa svim njegovim proporcijama, a temelji se na radu starorimskog arhitekta. Kako je ime ovog slavnog crteža?',
         'Vitruvijev čovjek', 2);

insert into authority (id, authority_name)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');

insert into user_authority (user_id, authority_id)
values
    (1, 2),
    (2, 1),
    (3, 2),
    (4, 2),
    (5, 2);

insert into answer (answer, question_id, user_id)
values  -- Prvi probni kviz - mislav
        ('Visla', 1, 1),
        ('352', 2, 1),
        -- Prvi probni kviz - toni
        ('Dunav', 1, 3),
        ('451', 2, 3),
        -- Drugi probni kviz - ivan
        ('Brazil', 3, 4),
        ('Mrkopalj', 4, 4),
        ('Vinkovci', 5, 4),
        ('Difuzija', 6, 4),
        ('Euklid', 7, 4),
        ('Korčula', 8, 4),
        ('Ragnarok', 9, 4),
        (null, 10, 4),
        ('Vitruvijev čovjek', 11, 4),
        -- Drugi probni kviz - marko
        ('Argentina', 3, 5),
        ('Begovo razdolje', 4, 5),
        ('Vinkovci', 5, 5),
        ('Adhezija', 6, 5),
        (null, 7, 5),
        ('Mljet', 8, 5),
        ('Ragnarok', 9, 5),
        ('Dodig', 10, 5),
        ('Vitruvijev čovjek', 11, 5),
        -- Drugi probni kviz - toni
        ('Brazil', 3, 3),
        (null, 4, 3),
        ('Vinkovci', 5, 3),
        ('Adhezija', 6, 3),
        ('Euklid', 7, 3),
        ('Murter', 8, 3),
        ('Ragnarok', 9, 3),
        (null, 10, 3),
        ('Vitruvijev čovjek', 11, 3);
