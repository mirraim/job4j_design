insert into roles (rolename) values 
('admin'),
('user'),
('reader');

insert into users (username, role_id) values
('admin', 1),
('Mary', 2),
('Max', 2),
('Anna', 3);

insert into rules (rule) values
('read'),
('create new item'),
('delete item'),
('change state'),
('change item');

insert into roles_rules (role_id, rule_id) values
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (2, 1), (2, 2), (2, 4), (2, 5), (3, 1);

insert into category (category) values
('bug'),
('consultation'),
('revision');

insert into states (state) values
('new'),
('in process'),
('rejected'),
('completed');

insert into items (item, user_id, category_id, state_id) values
('help me', 2, 2, 3),
('post is not working', 2, 1, 4),
('add button to UI', 3, 3, 2);

insert into comments (comment, item_id) values 
('i need more information about your problem', 1);

insert into attachs (attachment, item_id) values
('screen of problem', 2);

select item, username, category, states.state, comment, attachment from items
join users on users.id=items.user_id
join category on category.id=items.category_id
join states on states.id=items.state_id
left join comments on items.id=comments.item_id
left join attachs on items.id=attachs.item_id;




