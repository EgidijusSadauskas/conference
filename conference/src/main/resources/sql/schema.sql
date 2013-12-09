CREATE TABLE demo (
	id IDENTITY PRIMARY KEY,
    data VARCHAR(100)
);

CREATE TABLE conferences(
    conferenceId IDENTITY PRIMARY KEY,
    conferenceName VARCHAR(255) NOT NULL,
    location VARCHAR(100) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    startDate DATETIME NOT NULL,
    endDate DATETIME NOT NULL,
    ownerId int NOT NULL   
);
 CREATE TABLE members(
 	id IDENTITY PRIMARY KEY,
 	fullName VARCHAR(40) NOT NULL,
 	emailAddress VARCHAR(60) NOT NULL,
 	town VARCHAR(60) NOT NULL,
 	country VARCHAR(30) NOT NULL,
 	userName VARCHAR(20) NOT NULL,
 	password VARCHAR(80) NOT NULL
 );
 
 CREATE TABLE conference_categories(
	conferenceId INTEGER NOT NULL,
	categoryId INTEGER NOT NULL,
 );
 
 CREATE TABLE categories(
 	categoryId IDENTITY PRIMARY KEY,
 	categoryName varchar(50) NOT NULL,
 );
 
 CREATE TABLE conference_attendees(
 	conferenceId INTEGER NOT NULL,
 	userId INTEGER NOT NULL
 );
 
 CREATE TABLE cities(
 	cityId IDENTITY PRIMARY KEY,
 	cityName VARCHAR(100) NOT NULL,
 	countryName VARCHAR(10) NOT NULL
 );
 
 

CREATE INDEX startDate ON conferences (startDate);
CREATE INDEX endDate ON conferences (endDate);
