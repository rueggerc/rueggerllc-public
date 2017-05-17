
drop table chris.pet_details;
drop table chris.pet;

create table chris.pet
(id 		varchar(32) not null primary key,
 name		varchar(40) not null
);

create table pet_details
(
	pet_id 		varchar(32) not null primary key,
	description	varchar(40),
	birth_date	date,
	species 	varchar(40) not null,
	age			bigint not null,
	weight 		double not null,
	color 		varchar(40) not null
);