
INSERT INTO demo (id, data) VALUES (1, 'Hello, world!');
INSERT INTO demo (id, data) VALUES (2, 'Hello, world again!');
INSERT INTO demo (id, data) VALUES (3, 'Hello, world for the third time!');

INSERT INTO conference (id, name,category,location ,description, startDate, endDate) VALUES (1, 'NFQ Akademijos atidarymas. Įvadas į šiuolaikinio programuotojo darbą','Programming','lietuva','neblogas bus atidarymas' ,'2013-09-30 17:00:00', '2013-09-30 18:00:00');
INSERT INTO conference (id, name,category,location ,description, startDate, endDate) VALUES (2, 'Projekto valdymas ir Agile','Programming','lietuva','neblogas bus atidarymas', '2013-10-02 17:00:00', '2013-10-02 18:00:00');
INSERT INTO conference (id, name,category,location ,description, startDate, endDate) VALUES (3, 'J2EE programavimui naudojami įrankiai','Programming','lietuva','neblogas bus atidarymas', '2013-10-07 17:00:00', '2013-10-07 18:00:00');
INSERT INTO conference (id, name,category,location ,description, startDate, endDate) VALUES (4, 'Web puslapių vartotojo sąsajos kūrimas (1-a dalis)','Programming','lietuva','neblogas bus atidarymas', '2013-10-09 17:00:00', '2013-10-09 18:00:00');

COMMIT;