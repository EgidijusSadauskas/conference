TRUNCATE SCHEMA public AND COMMIT;

INSERT INTO demo (id, data) VALUES (1, 'Hello, world!');
INSERT INTO demo (id, data) VALUES (2, 'Hello, world again!');
INSERT INTO demo (id, data) VALUES (3, 'Hello, world for the third time!');

INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (1, 'NFQ Akademijos atidarymas. Įvadas į šiuolaikinio programuotojo darbą','lietuva','neblogas bus atidarymas. Turesim galimybe praktiškai pamatyti teoriją ir teoriškai pamatyti praktiką. Atliekamas šio elemento dydžio patikrinimas' ,'2013-09-30 17:00:00', '2013-09-30 18:00:00',1);
INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (2, 'Projekto valdymas ir Agile','lietuva','neblogas bus atidarymas', '2013-10-02 17:00:00', '2013-10-02 18:00:00',1);
INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (3, 'J2EE programavimui naudojami įrankiai','lietuva','neblogas bus atidarymas', '2013-10-07 17:00:00', '2013-10-07 18:00:00',1);
INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (4, 'Web puslapių vartotojo sąsajos kūrimas (1-a dalis)','lietuva','neblogas bus atidarymas', '2013-10-09 17:00:00', '2013-10-09 18:00:00',1);
INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (5, 'Raketos sumontavimas iš produktų esančių jūsų namo rūsyje','lietuva','Skrisim', '2013-10-08 17:00:00', '2013-10-09 19:00:00',1);


INSERT INTO categories (categoryId,categoryName) VALUES (1,'Programming');
INSERT INTO categories (categoryId,categoryName) VALUES (2,'Rocket science');
INSERT INTO categories (categoryId,categoryName) VALUES (3,'Technical engineering');
INSERT INTO categories (categoryId,categoryName) VALUES (4,'Lecture');
INSERT INTO categories (categoryId,categoryName) VALUES (5,'Testing');

INSERT INTO conference_categories(conferenceId,categoryId) VALUES (1,1);
INSERT INTO conference_categories(conferenceId,categoryId) VALUES (2,3);
INSERT INTO conference_categories(conferenceId,categoryId) VALUES (3,2);
INSERT INTO conference_categories(conferenceId,categoryId) VALUES (4,1);
INSERT INTO conference_categories(conferenceId,categoryId) VALUES (5,5);

INSERT INTO conference_attendees(conferenceId,userId) VALUES(4,1);
INSERT INTO conference_attendees(conferenceId,userId) VALUES(5,1);
INSERT INTO conference_attendees(conferenceId,userId) VALUES(2,1);
INSERT INTO conference_attendees(conferenceId,userId) VALUES(4,7);
INSERT INTO conference_attendees(conferenceId,userId) VALUES(5,7);
INSERT INTO conference_attendees(conferenceId,userId) VALUES(1,7);
INSERT INTO conference_attendees(conferenceId,userId) VALUES(1,8);

INSERT INTO conferences VALUES(7,'pirmojikonferencija','ls','pirmoji legit sukurta','2013-12-08 00:00:00.000000','2013-12-18 00:00:00.000000',8);
INSERT INTO members VALUES(8,'egidijus1','ramzzvi@gmail.com','kaunas','LS','rockas','1e6efed8a8e02519be6822a7851bb71d');
INSERT INTO conference_categories VALUES (7,2);
INSERT INTO MEMBERS VALUES(13,'omgazauras','ramzzvi@gmail.com','kaunas','LS','aaaaaaaaaa','e09c80c42fda55f9d992e59ca6b3307d');
COMMIT;
