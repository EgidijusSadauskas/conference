CREATE TABLE demo (
	id IDENTITY PRIMARY KEY,
    data VARCHAR(100)
);

CREATE TABLE conference (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    location VARCHAR(100) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    startDate DATETIME NOT NULL,
    endDate DATETIME NOT NULL
    
);
 CREATE TABLE member{
 	id IDENTITY PRIMARY KEY,
 	fullName VARCHAR(40) NOT NULL,
 	emailAddress VARCHAR(60) NOT NULL,
 	town VARCHAR(60) NOT NULL,
 	country VARCHAR(30) NOT NULL,
 	username VARCHAR(20) NOT NULL,
 	password VARCHAR(80) NOT NULL
 };
-- -- Member who joins into conferences
-- CREATE TABLE memberConferences{
-- 	memberId;
-- 	conferenceId;
-- };
-- -- members who creates conferences
-- CREATE TABLE memberCreatedConferences{
-- 	memberId;
-- 	conferenceId; -- this one 
-- } 
CREATE INDEX startDate ON conference (startDate);
CREATE INDEX endDate ON conference (endDate);
