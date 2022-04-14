create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna (name, avg_age, discovery_date)
	values('instance1fish', 235, date '1020-09-01');
insert into fauna (name, avg_age, discovery_date)
	values('instance2cat', 252, date '1000-09-01');
insert into fauna (name, avg_age, discovery_date)
	values('instance3fish', 425, date '20-01-01');
insert into fauna (name, avg_age, discovery_date)
	values('instance4dog', 265, date '5-09-01');
insert into fauna (name, avg_age, discovery_date)
	values('instance5rabbit', 75, date '21-09-01');
insert into fauna (name, avg_age, discovery_date)
	values('instance6fish', 15, date '1520-09-01');
insert into fauna (name, avg_age, discovery_date)
	values('instance7fish', 35, date '820-09-01');
insert into fauna (name, avg_age, discovery_date)
	values('instance8fish', 45, date '220-09-01');


select * from fauna 
	where name like '%fish%';

select * from fauna 
	where 10000 < avg_age 
		and 21000 < avg_age;

select * from fauna where current_date is null;

select * from fauna where discovery_date < date'1950-01-01';





