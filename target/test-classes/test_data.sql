insert into users(username, password)
values  ('user1', 'pass1'),
        ('user2', 'pass1');

insert into todos(description, target_date, user_id)
select 'desc1', '2021-08-05', (select id from users where username = 'user1') union
select 'desc2', '2021-08-06', (select id from users where username = 'user1') union
select 'desc3', '2021-08-07', (select id from users where username = 'user1');

insert into todos(description, target_date, user_id)
select 'desc4', '2021-09-05', (select id from users where username = 'user2') union
select 'desc5', '2021-09-06', (select id from users where username = 'user2') union
select 'desc6', '2021-09-07', (select id from users where username = 'user2');
