use rueggerllc;
drop table account;
create table account
(
	id 			bigint auto_increment not null primary key,
	name		varchar(40) not null,
	address		varchar(40) not null,
	state		varchar(40) not null,
	zip			varchar(40) not null,
	create_date	date
);

insert into account
(id, name, address, state, zip, create_date)
values
(4000, "My Savings", "100 Main Street", "NJ", "07642", CURDATE());

insert into account
(id, name, address, state, zip, create_date)
values
(5000, "My Checking", "80 Ralph Ave", "VA", "20171", STR_TO_DATE('05-19-2017', '%m-%d-%Y'));


