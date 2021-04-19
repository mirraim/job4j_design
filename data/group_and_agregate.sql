create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices (name, price) values ('Honor 7A', 6150.00);
insert into devices (name, price) values ('Xiaomi Redmi 9C 2', 9500.00);
insert into devices (name, price) values ('Samsung Galaxy A32', 19990.00);
insert into devices (name, price) values ('Vertex Impress Luck', 3980.00);
insert into devices (name, price) values ('ZTE Blade L8', 4190.00);
insert into devices (name, price) values ('Xiaomi Redmi Note 9', 17190.00);
insert into devices (name, price) values ('Смартфон Nokia C1 Plus', 5679.00);
insert into devices (name, price) values ('Apple iPhone XR', 44099.00);

insert into people (name) values ('Alise');
insert into people (name) values ('Tom');
insert into people (name) values ('Sarah');
insert into people (name) values ('Jane');

insert into devices_people (device_id, people_id) values (1, 1);
insert into devices_people (device_id, people_id) values (4, 1);
insert into devices_people (device_id, people_id) values (3, 2);
insert into devices_people (device_id, people_id) values (2, 2);
insert into devices_people (device_id, people_id) values (6, 2);
insert into devices_people (device_id, people_id) values (5, 2);
insert into devices_people (device_id, people_id) values (5, 3);
insert into devices_people (device_id, people_id) values (7, 3);
insert into devices_people (device_id, people_id) values (8, 4);

select avg(devices.price) from devices;

select p.name as Имя, avg(d.price) as Средняя_стоимость_девайсов
from devices_people as dp
join devices as d on dp.device_id=d.id
join people as p on dp.people_id=p.id
group by p.name;

select p.name as Имя, avg(d.price) as Средняя_стоимость_девайсов
from devices_people as dp
join devices as d on dp.device_id=d.id
join people as p on dp.people_id=p.id
group by p.name
having avg(d.price)>5000;
