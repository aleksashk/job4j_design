create table workers(
	id serial primary key,
	first_name varchar(50),
	last_name varchar(50),
	married bool,
	department text,
	serial_id varchar(15)
);

select * from workers;

insert into workers(first_name, last_name, married, department, serial_id) 
	values('Frank','Sinatra', false, 'delivery deratrment', '01240112');

select * from workers;

update workers 
	set first_name = 'Lenoks' 
	where id = 1;
update workers 	
	set last_name = 'Luis' 
	where id = 1;

select * from workers;

delete from workers;

select * from workers;
