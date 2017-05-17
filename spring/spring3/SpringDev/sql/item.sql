use rueggerllc;

drop table if exists rueggerllc.item;
create table item
(id                  varchar(32) not null,
 order_id            varchar(32) not null,
 name                varchar(40) not null,
 serial_number       varchar(40) not null,
 primary key (id),
 key order_id (order_id)
)
 