create table car_body (
	id serial primary key,
	name varchar(30)
);

create table engine (
	id serial primary key,
	name varchar(30)
);

create table transmission (
	id serial primary key,
	name varchar(30)
);

create table car (
	id serial primary key,
	name varchar(30),
	body_id integer references car_body(id),
	engine_id integer references engine(id),
	transmission_id integer references transmission(id)
);

insert into car_body(name) values ('Седан');
insert into car_body(name) values ('Хэчбэк');
insert into car_body(name) values ('Кроссовер');
insert into car_body(name) values ('Пикап');
insert into car_body(name) values ('Кабриолет');
insert into car_body(name) values ('Лифтбэк');
insert into car_body(name) values ('Лимузин');

insert into engine (name) values ('1,7 л');
insert into engine (name) values ('2 л');
insert into engine (name) values ('3,5 л');
insert into engine (name) values ('5,2 л');
insert into engine (name) values ('2,8 л');

insert into transmission (name) values ('Ручная');
insert into transmission (name) values ('Автомат');
insert into transmission (name) values ('Вариатор');
insert into transmission (name) values ('Робот');

insert into car (name, body_id, engine_id, transmission_id) values ('City model 1', 1, 1, 4);
insert into car (name, body_id, engine_id, transmission_id) values ('City model 2', 2, 1, 2);
insert into car (name, body_id, engine_id, transmission_id) values ('City model 3', 1, 2, 1);
insert into car (name, body_id, engine_id, transmission_id) values ('Travel model 1', 3, 2, 2);
insert into car (name, body_id, engine_id, transmission_id) values ('Travel model 2', 3, 4, 1);
insert into car (name, body_id, engine_id, transmission_id) values ('Travel model 3', 6, 2, 2);
insert into car (name, body_id, engine_id, transmission_id) values ('Country model', 4, 3, 1);
insert into car (name, body_id, engine_id, transmission_id) values ('Drive model', 5, 4, 1);

-- Вывести список всех машин и все привязанные к ним детали.

select c.name as Модель, b.name as Кузов, e.name as Двигатель, t.name as Коробка_передач from car as c
join car_body as b on c.body_id=b.id
join engine as e on c.engine_id=e.id
join transmission as t on c.transmission_id=t.id;

--Вывести отдельно детали (1 деталь - 1 запрос), которые не используются в машине, кузова, двигатели, коробки передач.

select b.name as Кузов 
from car as c
right join car_body as b on c.body_id=b.id
where c.name is null;

select e.name as Двигатель 
from car
right join engine as e on car.engine_id=e.id
where car.name is null;

select t.name as Коробка_передач 
from car as c
right join transmission as t on c.transmission_id=t.id
where c.name is null;
