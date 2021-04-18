create table product(
	id serial primary key,
	name varchar(50),
	price integer,
	producer text,
	discounted boolean
);
insert into product (name, price, producer, discounted) values ('bicycle', 12000, 'Forward', false);

select * from product;

update product set price = 10000;

delete from product;