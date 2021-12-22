Create database assignment4;
use assignment4;

CREATE TABLE customer(
    custid SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	firstname varchar(30) NOT NULL,
	lastname varchar(30) NOT NULL,
    address varchar(30) NOT NULL,
    city varchar(30) NOT NULL,
	phone varchar(30) NOT NULL,
	email varchar(30) NOT NULL,
	age SMALLINT NOT NULL,
	password varchar(30) NOT NULL
);

CREATE TABLE card(
	id SMALLINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	cardno varchar(30) NOT NULL,
	pin int NOT NULL,
	custid SMALLINT NOT NULL,
	cardtype varchar(30) NOT NULL,
	price decimal(9,2) NOT NULL,
    status varchar(30) NOT NULL,
    renewal varchar(30) NOT NULL,
    cycle date not null,
    foreign key(custid) references customer(custid)
);

create table sequence(
	id smallint primary key not null,
    seq varchar(17)
    );
    
INSERT INTO `assignment4`.`sequence` (`id`, `seq`) VALUES ('1', '10000000000000000');
