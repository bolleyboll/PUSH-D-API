DROP DATABASE IF EXISTS pushd;
CREATE DATABASE pushd; 
use pushd;

CREATE TABLE admins(adminID INT UNIQUE, username VARCHAR(20) PRIMARY KEY, password VARCHAR(100), name VARCHAR(50) NOT NULL, email VARCHAR(100) UNIQUE NOT NULL);

CREATE TABLE specialists(specID INT UNIQUE, username VARCHAR(20) PRIMARY KEY, password VARCHAR(100), name VARCHAR(50) NOT NULL, email VARCHAR(100) UNIQUE NOT NULL);

CREATE TABLE doctors(doctorID INT UNIQUE, username VARCHAR(20) PRIMARY KEY, password VARCHAR(100), name VARCHAR(50) NOT NULL, email VARCHAR(100) UNIQUE NOT NULL, specID VARCHAR(20), FOREIGN KEY(specID) REFERENCES specialists(username));

CREATE TABLE patients(patientID INT UNIQUE, username VARCHAR(20) PRIMARY KEY, password VARCHAR(100), name VARCHAR(50) NOT NULL, email VARCHAR(100) UNIQUE NOT NULL, doctorID VARCHAR(20), FOREIGN KEY(doctorID) REFERENCES doctors(username));

INSERT INTO admins VALUES(1, 'bolleyboll', 'password', 'Aman Gupta', 'aman.iv0012@gmail.com');

INSERT INTO specialists VALUES(1, 'vishalg', 'password', 'Vishal Govil', 'Vishal.Govil@iiitb.ac.in');

INSERT INTO doctors VALUES(1, 'nikhilm', 'password', 'Nikhil Mittal', 'Nikhil.Mittal@iiitb.ac.in', 'vishalg');
INSERT INTO doctors VALUES(2, 'shubhamn', 'password', 'Shubham Nigam', 'Shubham.Nigam@iiitb.ac.in', 'vishalg');

INSERT INTO patients VALUES(1, 'kunals', 'password', 'Kunal Sharma', 'Kunal.Sharma@iiitb.ac.in', 'nikhilm');
INSERT INTO patients VALUES(2, 'suchil', 'password', 'Suchi Laad', 'suchi.laad@iiitb.ac.in', 'nikhilm');
INSERT INTO patients VALUES(3, 'random', 'password', 'RCB', 'rcb@gmail.com', 'shubhamn');