
create new schema authorization chris;

drop sequence hibernate_sequence restrict;
create sequence hibernate_sequence
as bigint
start with 1000
increment by 1;
