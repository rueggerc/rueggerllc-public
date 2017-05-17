use rueggerllc;

drop table if exists rueggerllc.customer_order;
create table customer_order
(id                  varchar(32) not null,
 name                varchar(40) not null,
 status              integer not null,
 primary key (id)
);

insert into customer_order (id, name, status) values ("4028818538924079013892407a690001", "Order1", 100);
insert into customer_order (id, name, status) values ("4028818538924079013892407a690002", "Order2", 200);
insert into customer_order (id, name, status) values ("4028818538924079013892407a690003", "Order3", 400);

 