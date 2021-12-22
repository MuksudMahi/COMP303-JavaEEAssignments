Create database assignment2;
use assignment2;

CREATE TABLE passengers(
    custid SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	email varchar(30) NOT NULL,
	pass varchar(30) NOT NULL,
    firstname varchar(30) NOT NULL,
    lastname varchar(30) NOT NULL,
    phonenumber varchar(12) NOT NULL,
    address varchar(30) NOT NULL,
    city varchar(30) NOT NULL,
    postalcode varchar(10) NOT NULL,
	country varchar(10) NOT NULL
);

create table flight(
flightcode int PRIMARY KEY AUTO_INCREMENT,
departure varchar(30),
arrival varchar(30),
departurecity varchar(30),
destination varchar(30),
airlinename varchar(30),
fare varchar(30),
price decimal(9,2)
);

create table reservation(
reservationid int PRIMARY KEY AUTO_INCREMENT,
custid SMALLINT,
flightcode int,
totalpassenger int,
amountpaid decimal(9,2),
reservationdate varchar(20),
FOREIGN KEY(custid) REFERENCES passengers(custid),
FOREIGN KEY(flightcode) REFERENCES flight(flightcode)
);
