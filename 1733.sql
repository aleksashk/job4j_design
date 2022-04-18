create table kuzov(
	id serial primary key,
	name varchar(50)
);

	insert into kuzov(name)
		values('kuzov_1');
	insert into kuzov(name)
		values('kuzov_2');
	insert into kuzov(name)
		values('kuzov_3');
	insert into kuzov(name)
		values('kuzov_4');
	insert into kuzov(name)
		values('kuzov_5');
	insert into kuzov(name)
		values('kuzov_6');
	insert into kuzov(name)
		values('kuzov_7');

create table dvigatel(
	id serial primary key,
	name varchar(50)
);

	insert into dvigatel(name)
		values('dvigatel_1');
	insert into dvigatel(name)
		values('dvigatel_2');
	insert into dvigatel(name)
		values('dvigatel_3');
	insert into dvigatel(name)
		values('dvigatel_4');
	insert into dvigatel(name)
		values('dvigatel_5');
	insert into dvigatel(name)
		values('dvigatel_6');
	insert into dvigatel(name)
		values('dvigatel_7');
	insert into dvigatel(name)
		values('dvigatel_8');

create table kp(
	id serial primary key,
	name varchar(50)
);

	insert into kp(name)
		values('kp_1');
	insert into kp(name)
		values('kp_2');
	insert into kp(name)
		values('kp_3');
	insert into kp(name)
		values('kp_4');
	insert into kp(name)
		values('kp_5');
	insert into kp(name)
		values('kp_6');
	insert into kp(name)
		values('kp_7');
	insert into kp(name)
		values('kp_8');


create table car(
	id serial primary key,
	kuzov_id int references kuzov(id),
	dvigatel_id int references dvigatel(id),
	kp_id int references kp(id)
);

	insert into car(kuzov_id, dvigatel_id, kp_id)
		values(1,1,2);
	insert into car(kuzov_id, dvigatel_id, kp_id)
		values(1,1,2);
	insert into car(kuzov_id, dvigatel_id, kp_id)
		values(1,3,8);
	insert into car(kuzov_id, dvigatel_id, kp_id)
		values(2,2,6);
	insert into car(kuzov_id, dvigatel_id, kp_id)
		values(5,3,7);
	insert into car(kuzov_id, dvigatel_id, kp_id)
		values(7,2,8);
	insert into car(kuzov_id, dvigatel_id, kp_id)
		values(3,3,5);

1

select * from car;

2

select kuzov.name from kuzov
	left join car on car.kuzov_id = kuzov.id
	where car.kuzov_id is null;

select dvigatel.name from dvigatel
	left join car on car.dvigatel_id = dvigatel.id
	where car.dvigatel_id is null;

select kp.name from kp
	left join car on car.kp_id = kp.id
	where car.kp_id is null;



