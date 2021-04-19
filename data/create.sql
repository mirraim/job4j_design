create table roles (
	id serial primary key,
	rolename varchar(30)
);

create table users (
	id serial primary key,
	username varchar(30),
	role_id integer references roles(id)
);

create table rules (
	id serial primary key,
	rule text
);

create table roles_rules (
	id serial primary key,
	role_id integer references roles(id),
	rule_id integer references rules(id)
);

create table category (
	id serial primary key,
	category varchar(50)
);

create table states (
	id serial primary key,
	state varchar(50)
);

create table items (
	id serial primary key,
	item text,
	user_id integer references users(id),
	category_id integer references category(id),
	state_id integer references states(id)
);

create table comments (
	id serial primary key,
	comment text,
	item_id integer references items(id)
);

create table attachs (
	id serial primary key,
	attachment text,
	item_id integer references items(id)
);

