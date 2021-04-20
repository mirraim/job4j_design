drop table product;
drop table type;

-- type(id, name)

create table type(
	id serial primary key, 
	name text);

-- product(id, name, type_id, expired_date, price)

create table product(
	id serial primary key, 
	name text, 
	type_id integer, 
	expired_date date, 
	price float);
	
insert into type (name) values
('СЫР'),
('Хлеб'),
('Мясо');

insert into type (name) values
('МОЛОКО');


insert into product (name, type_id, expired_date, price) values
('гауда', 1, '01.05.2021', 200),
('костромской', 1, '01.09.2021', 200),
('эдам', 1, '01.11.2021', 250),
('бородинский', 2, '25.04.2021', 35),
('8 злаков', 2, '26.04.2021', 35),
('свинина', 3, '25.04.2021', 300),
('говядина', 3, '05.05.2021', 450),
('курица', 3, '02.05.2021', 200),
('индейка', 3, '30.04.2021', 350);

insert into product (name, type_id, expired_date, price) values
('молоко 2,5%, тетрапак', 4, '01.10.2021', 200);


-- получение всех продуктов с типом "СЫР"

SELECT p.name as Продукт FROM product as p
JOIN type as t on p.type_id=t.id
WHERE t.name = 'СЫР';

-- получение всех продуктов, у кого в имени есть слово "мороженное"

SELECT p.name as Продукт FROM product as p
WHERE p.name LIKE '%мороженное%';


-- выводит все продукты, срок годности которых заканчивается в следующем месяце.
-- Запрос должен быть универсальным, т.е. не зависеть от конкретного временного промежутка

SELECT p.name as Продукт FROM product as p
WHERE p.expired_date< (current_date + interval '1 month');

-- выводит самый дорогой продукт.

SELECT * FROM product
WHERE price = (SELECT max(price) FROM product);

-- выводит для каждого типа количество продуктов к нему принадлежащих. В виде имя_типа, количество

SELECT t.name as Тип, COUNT(*) as Количество FROM product as p
JOIN type as t on p.type_id=t.id
GROUP BY t.name;

-- получение всех продуктов с типом "СЫР" и "МОЛОКО"

SELECT p.name as Продукт FROM product as p
JOIN type as t on p.type_id=t.id
WHERE t.name = 'СЫР' OR t.name = 'МОЛОКО';

-- выводит тип продуктов, которых осталось меньше 10 штук. 
SELECT t.name as Тип, COUNT(p.name) as Количество FROM product as p
JOIN type as t on p.type_id=t.id
GROUP BY t.name
HAVING COUNT(p.name) < 10 ;

-- Вывести все продукты и их тип.

SELECT p.name as Продукт, t.name as Тип FROM product as p
JOIN type as t on p.type_id=t.id;