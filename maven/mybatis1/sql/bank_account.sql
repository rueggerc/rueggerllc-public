drop table chris.bank_account;
create table chris.bank_account
(id                  integer not null primary key,
 name                varchar(40) not null,
 address             varchar(40) not null,
 state               varchar(40) not null,
 zip                 varchar (40) not null,
 create_date         timestamp  not null,
 status              integer not null
);

insert into bank_account
(id, name, address, state, zip, create_date, status)
values
(42, 'Account1', '100 Main Street', 'Virginia', '20171', '2013-06-12 12:35:21', 322);