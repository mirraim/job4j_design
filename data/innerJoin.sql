create table products (
	id serial primary key,
	product varchar(50)
);

create table producers (
	id serial primary key,
	producer text
);

create table price (
	id serial primary key,
	product_id integer references products(id),
	producer_id integer references producers(id),
	price integer
);

insert into products (product) values ('bicycle');
insert into products (product) values ('hoverboard');
insert into products (product) values ('scooter');
insert into products (product) values ('skateboard');
insert into products (product) values ('roller skate');

insert into producers (producer) values ('Stels');
insert into producers (producer) values ('GT');
insert into producers (producer) values ('RGX');

insert into price (product_id, producer_id, price) values (1, 1, 25000);
insert into price (product_id, producer_id, price) values (2, 2, 7500);
insert into price (product_id, producer_id, price) values (3, 2, 18000);
insert into price (product_id, producer_id, price) values (3, 1, 14000);
insert into price (product_id, producer_id, price) values (4, 3, 2000);
insert into price (product_id, producer_id, price) values (5, 3, 2500);
insert into price (product_id, producer_id, price) values (3, 3, 2500);


select pt.product as Товар, pdr.producer as Производитель 
from price as pc
join products as pt on pc.product_id=pt.id
join producers as pdr on pc.producer_id=pdr.id;

select pt.product as Товар, pc.price as Цена 
from price as pc
join products as pt on pc.product_id=pt.id
where pc.price>10000;

select pt.product as Товар, pdr.producer as Производитель, pc.price as Цена 
from price as pc
join products as pt on pc.product_id=pt.id
join producers as pdr on pc.producer_id=pdr.id
where pt.product='scooter';