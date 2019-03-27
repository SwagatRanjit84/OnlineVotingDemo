/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Rashmi Tiwarii
 * Created: Jun 2, 2016
 */
-- drop database ovp;
-- create database ovp;
use voting;
-- DROP TABLE IF EXISTS commisner;
CREATE TABLE commisner (
    userId INT NOT NULL AUTO_INCREMENT, 
    userName VARCHAR(30) NOT NULL,
    password VARCHAR(1000), 
    PRIMARY KEY (userId));

-- DROP TABLE IF EXISTS POST;
CREATE TABLE post (
    post VARCHAR(50) NOT NULL,
    PRIMARY KEY (post)
);


-- DROP TABLE IF EXISTS image;
CREATE TABLE image (id INT NOT NULL AUTO_INCREMENT, 
    photo mediumblob NOT NULL,
    PRIMARY KEY (ID));

-- DROP TABLE IF EXISTS campaign;
CREATE TABLE campaign (id INT NOT NULL AUTO_INCREMENT, 
    TITLE VARCHAR(30) NOT NULL,
    STARTDATE DATE NOT NULL, 
    ENDDATE DATE NOT NULL, 
    STARTTIME TIME ,
    ENDTIME TIME,
    PRIMARY KEY (ID));
    
-- DROP TABLE IF EXISTS candidate;
CREATE TABLE candidate (
    id INT NOT NULL AUTO_INCREMENT, 
    NAME VARCHAR(30) NOT NULL, 
    AGENDA VARCHAR(1000)  NULL, 
    POST VARCHAR(50) NOT NULL,
    PARTY VARCHAR(50) NOT NULL,
    DISTRICT VARCHAR(50) NOT NULL,
    VOTE INT NOT NULL, 
    SUMMARY VARCHAR(40)  ,
    campaign_id INT NOT NULL,
    photo_id int,
    v_id int,
    PRIMARY KEY (id),
    FOREIGN KEY (campaign_id) REFERENCES campaign(id),
    FOREIGN KEY (photo_id) REFERENCES image(id));
FOREIGN KEY (v_id) REFERENCES tblvoter(id);
    
-- DROP TABLE IF EXISTS party;
CREATE TABLE party (
    id INT NOT NULL AUTO_INCREMENT, 
    NAME VARCHAR(30) NOT NULL,
    EstablishedDate VARCHAR(30),  
    NoOfMembers INT NOT NULL, 
    description VARCHAR(40) NOT NULL,
    photo_id int,
    PRIMARY KEY (ID),
    FOREIGN KEY (photo_id) REFERENCES image(id)
    );

-- DROP TABLE IF EXISTS voter;
-- CREATE TABLE voter (
--     id INT NOT NULL AUTO_INCREMENT, 
--     FIRSTNAME VARCHAR(30) NOT NULL,
--     LASTNAME VARCHAR(30) NOT NULL,
--     DISTRICT VARCHAR(30) NOT NULL,
--     BirthDate VARCHAR(30) NOT NULL,  
--     CITIZENSHIP VARCHAR(40) NOT NULL, 
--     VoterId VARCHAR(40) NOT NULL,
--     Email VARCHAR(40) NOT NULL,
--     voted boolean NOT NULL,
--     PRIMARY KEY (ID)
--     );
-- 

use voting;
insert into commisner(username,password) values('admin','admin');
