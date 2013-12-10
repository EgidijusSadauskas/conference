

INSERT INTO demo (id, data) VALUES (1, 'Hello, world!');
INSERT INTO demo (id, data) VALUES (2, 'Hello, world again!');
INSERT INTO demo (id, data) VALUES (3, 'Hello, world for the third time!');

DELETE FROM conferences WHERE conferenceId between 1 and 8;
DELETE FROM conference_categories where conferenceId between 1 and 8;
DELETE FROM cities WHERE cityId between 1 and 7;


INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (1, 'NFQ Akademijos atidarymas. Įvadas į šiuolaikinio programuotojo darbą','lietuva','neblogas bus atidarymas. Turesim galimybe praktiškai pamatyti teoriją ir teoriškai pamatyti praktiką. Atliekamas šio elemento dydžio patikrinimas' ,'2013-09-30 17:00:00', '2013-09-30 18:00:00',1);
INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (2, 'Projekto valdymas ir Agile','lietuva','neblogas bus atidarymas', '2013-10-02 17:00:00', '2013-10-02 18:00:00',1);
INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (3, 'J2EE programavimui naudojami įrankiai','lietuva','neblogas bus atidarymas', '2013-10-07 17:00:00', '2013-10-07 18:00:00',1);
INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (4, 'Web puslapių vartotojo sąsajos kūrimas (1-a dalis)','lietuva','neblogas bus atidarymas', '2013-10-09 17:00:00', '2013-10-09 18:00:00',1);
INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (5, 'Raketos sumontavimas iš produktų esančių jūsų namo rūsyje2','lietuva','Skrisim', '2013-10-08 17:00:00', '2013-10-09 19:00:00',1);
INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (6, 'Raketos sumontavimas iš produktų esančių jūsų namo rūsyje3','lietuva','Skrisim', '2013-10-08 17:00:00', '2013-10-09 19:00:00',1);
INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (7, 'Raketos sumontavimas iš produktų esančių jūsų namo rūsyje4','lietuva','Skrisim', '2013-10-08 17:00:00', '2013-10-09 19:00:00',1);
INSERT INTO conferences (conferenceId, conferenceName,location ,description, startDate, endDate,ownerId) VALUES (8, 'Raketos sumontavimas iš produktų esančių jūsų namo rūsyje5','lietuva','Skrisim', '2013-10-08 17:00:00', '2013-10-09 19:00:00',1);
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
INSERT INTO conference_categories(conferenceId,categoryId) VALUES (6,5);
INSERT INTO conference_categories(conferenceId,categoryId) VALUES (7,5);
INSERT INTO conference_categories(conferenceId,categoryId) VALUES (8,5);


INSERT INTO cities(cityId,cityName,countryName) VALUES (1,'afganistanas1','AF');
INSERT INTO cities(cityId,cityName,countryName) VALUES (2,'afganistanas2','AF');
INSERT INTO cities(cityId,cityName,countryName) VALUES (3,'afganistanas3','AF');
INSERT INTO cities(cityId,cityName,countryName) VALUES (4,'afganistanas4','AF');
INSERT INTO cities(cityId,cityName,countryName) VALUES (5,'kaunas','LT');
INSERT INTO cities(cityId,cityName,countryName) VALUES (6,'vilnius','LT');
INSERT INTO cities(cityId,cityName,countryName) VALUES (7,'vilnius','LT');



COMMIT;
