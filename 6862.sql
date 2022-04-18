
1	
create table departments(
	id serial primary key,
	name varchar(50)
);

create table employees(
	id serial primary key,
	name varchar(50),
	department_id int references departments(id)
);

insert into departments(name)
	values('d1');
insert into departments(name)
	values('d2');
insert into departments(name)
	values('d3');
insert into departments(name)
	values('d4');
insert into departments(name)
	values('d5');
insert into departments(name)
insert into departments(name)
	values('d432');
insert into departments(name)
	values('d1165');
insert into departments(name)
	values('d25');
insert into departments(name)
	values('d01');


insert into employees(name, department_id)
	values('e1', 1);
insert into employees(name, department_id)
	values('e2', 2);
insert into employees(name)
	values('e3');
insert into employees(name, department_id)
	values('e4', 3);
insert into employees(name, department_id)
	values('e5', 1);
insert into employees(name, department_id)
	values('e6', 4);
insert into employees(name)
	values('e7');
insert into employees(name, department_id)
	values('e8', 5);
insert into employees(name, department_id)
	values('e9', 4);
insert into employees(name, department_id)
	values('e10', 2);
insert into employees(name)
	values('e11');
insert into employees(name, department_id)
	values('e12', 6);
insert into employees(name)
	values('e13');
insert into employees(name, department_id)
	values('e14', 2);
insert into employees(name, department_id)
	values('e15', 5);
insert into employees(name)
	values('e16');

2
select * from employees e
	left join departments d on e.department_id = d.id;

select * from employees e
	right join departments d on d.id = e.department_id;

select * from employees e
	full join departments d on d.id = e.department_id;

select * from employees e
	cross join departments d;

3
select d.name from departments d
	left join employees e on d.id = e.department_id
	where e.department_id is null;

4
select * from departments d
	left join employees e on d.id = e.department_id;

select * from departments d
	right join employees e on e.department_id=d.id;

5
select * from teens as person_1 
	cross join teens as person_2 
	where person_1.gender != person_2.gender;
