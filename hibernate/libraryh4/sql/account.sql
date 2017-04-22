
drop table chris.account;
create table account
(
	id 			bigint not null primary key,
	name		varchar(40) not null,
	address		varchar(40) not null,
	state		varchar(40) not null,
	zip			varchar(40) not null,
	create_date	date
);