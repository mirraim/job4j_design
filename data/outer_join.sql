-- Даны две сущности, представленные в таблицах departments и emploees. Отношение one-to-many. В таблицах только поле name.

-- Создать таблицы и заполнить их начальными данными

create table departments (
	id serial primary key,
	name varchar (50)
);

create table emploees (
    id serial primary key,
	name text,
	department_id integer references departments(id)
);

insert into departments (name) values ('sales');
insert into departments (name) values ('manufacture');
insert into departments (name) values ('stuff department');
insert into departments (name) values ('maintenance department');

insert into emploees (name, department_id) values ('Jim Kein', 1);
insert into emploees (name, department_id) values ('Bob Uilson', 1);
insert into emploees (name, department_id) values ('Terry Boot', 2);
insert into emploees (name, department_id) values ('Tom Jones', 2);
insert into emploees (name, department_id) values ('Kurt Jackson', 2);
insert into emploees (name, department_id) values ('Sam Newman', 2);
insert into emploees (name, department_id) values ('Sarah Parker', 3);
insert into emploees (name, department_id) values ('John Norman', null);
insert into emploees (name, department_id) values ('Ann Grove', null);

-- Выполнить запросы с left, rigth, full, cross соединениями

select e.name as Employee, d.name as Department from emploees as e
left join departments d on d.id = e.department_id;

select e.name as Employee, d.name as Department from emploees as e
right join departments d on d.id = e.department_id;

select e.name as Employee, d.name as Department from emploees as e
cross join departments d;

--Используя left join найти департаменты, у которых нет работников

select d.name as Department, e.name as Employee from departments as d
left join emploees as e on d.id=e.department_id
where e.name is null;

--Используя left и right join написать запросы, которые давали бы одинаковый результат.
select e.name as Employee, d.name as Department from emploees as e
left join departments d on d.id = e.department_id;

select e.name as Employee, d.name as Department from departments as d
right join emploees as e on d.id=e.department_id;

-- Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары
create table teens (
	id serial primary key,
	name text,
	gender varchar(10)
);

insert into teens (name, gender) values ('Jane', 'female');
insert into teens (name, gender) values ('Tom', 'male');
insert into teens (name, gender) values ('Sarah', 'female');
insert into teens (name, gender) values ('Sam', 'male');
insert into teens (name, gender) values ('John','male');

select t1.name, t2.name from teens as t1
cross join teens as t2
where t1.gender<> t2.gender;