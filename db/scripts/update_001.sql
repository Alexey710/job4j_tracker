create table items (
   id serial primary key not null,
   name varchar(2000)
);
insert into items(name) values ('item1');
insert into items(name) values ('item2');
insert into items(name) values ('item3');