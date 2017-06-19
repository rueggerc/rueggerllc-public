create table chris.exception_queue (
  id            		bigint generated always as identity,
  item_number      		varchar (40) not null
);

insert into chris.exception_queue
(item_number)
values
('Item1');