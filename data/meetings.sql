create table if not exists meetings
(
    id   serial primary key,
    name text
);

create table if not exists users
(
    id   serial primary key,
    name text
);

create table if not exists status
(
    id   serial primary key,
    name text
);

create table if not exists claims
(
    id   serial primary key,
    meeting_id integer references meetings(id),
    user_id integer references users(id),
    status_id integer references status(id)
);

insert into meetings (name) values ('daily');
insert into meetings (name) values ('weekly');
insert into meetings (name) values ('monthly');

insert into users (name) values ('user1');
insert into users (name) values ('user2');
insert into users (name) values ('user3');
insert into users (name) values ('user4');

insert into status (name) values ('confirmed');
insert into status (name) values ('not confirmed');
insert into status (name) values ('rejected');

insert into claims (meeting_id, user_id, status_id) values (1, 2, 1);
insert into claims (meeting_id, user_id, status_id) values (1, 3, 1);
insert into claims (meeting_id, user_id, status_id) values (1, 4, 3);
insert into claims (meeting_id, user_id, status_id) values (2, 1, 2);
insert into claims (meeting_id, user_id, status_id) values (2, 2, 2);
insert into claims (meeting_id, user_id, status_id) values (2, 4, 3);

-- запрос, который получит список всех заяков и количество подтвердивших участников
select m.name as meeting, count(c.user_id) as user_count
from meetings m
left join
    (
        select meeting_id, user_id
        from claims
        join users u on u.id = claims.user_id
        join status s on s.id = claims.status_id
        where s.name = 'confirmed'
        )
    as c on m.id = c.meeting_id
group by m.id
order by m.id;

--все совещания, где не было ни одной заявки на посещения
select m.name as meeting
from meetings m
left join
     (
         select meeting_id, count(claims.id) as claim
         from claims join meetings on claims.meeting_id = meetings.id
         group by meeting_id
     )
         as c on m.id = c.meeting_id
where c.claim is null
order by m.id;