CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company (id, name) values (1, 'company 1');
insert into company (id, name) values (2, 'company 2');
insert into company (id, name) values (3, 'company 3');
insert into company (id, name) values (4, 'company 4');
insert into company (id, name) values (5, 'company 5');
insert into company (id, name) values (6, 'company 6');
insert into company (id, name) values (7, 'company 7');

insert into person (id, name, company_id) values (1, 'John', 2);
insert into person (id, name, company_id) values (2, 'Tom', 1);
insert into person (id, name, company_id) values (3, 'Jane', 5);
insert into person (id, name, company_id) values (4, 'Sam', 3);
insert into person (id, name, company_id) values (5, 'Sarah', 5);

-- В одном запросе получить: имена всех person, которые не состоят в компании с id = 5; название компании для каждого человека.

SELECT p.name as Person, c.name as Company
FROM person as p
JOIN company as c ON p.company_id=c.id
WHERE c.id<>5;

-- Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании.
SELECT c.name as Company, count(p.name) as Quantity
FROM person as p
JOIN company as c ON p.company_id=c.id
group by c.name
HAVING count(p.name) =(
select max(q)from (select c.name as c_name, count(p.id) as q
from company as c
join person as p ON p.company_id=c.id
group by c.id) as p_c); 
