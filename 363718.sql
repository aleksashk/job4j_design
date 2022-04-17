insert into  devices(name, price)
	values('d1', 3.12);
insert into  devices(name, price)
	values('d2', 4.28);
insert into  devices(name, price)
	values('d3', 4.02);
insert into  devices(name, price)
	values('d4', 78.01);
insert into  devices(name, price)
	values('d5', 5.97);
insert into  devices(name, price)
	values('d6', 14.17);
insert into  devices(name, price)
	values('d7', 3.12);
insert into  devices(name, price)
	values('d10', 6.08);
insert into  devices(name, price)
	values('d8', 10.25);
insert into  devices(name, price)
	values('d9', 87.10);


insert into people(name)
	values('person1');
insert into people(name)
	values('person2');
insert into people(name)
	values('person3');
insert into people(name)
	values('person4');
insert into people(name)
	values('person5');
insert into people(name)
	values('person6');
insert into people(name)
	values('person7');
insert into people(name)
	values('person8');
insert into people(name)
	values('person9');





insert into devices_people(device_id, people_id)
	values(1, 1);
insert into devices_people(device_id, people_id)
	values(1, 3);
insert into devices_people(device_id, people_id)
	values(1, 8);
insert into devices_people(device_id, people_id)
	values(1, 4);
insert into devices_people(device_id, people_id)
	values(2, 3);
insert into devices_people(device_id, people_id)
	values(2, 6);
insert into devices_people(device_id, people_id)
	values(3, 1);
insert into devices_people(device_id, people_id)
	values(4, 6);
insert into devices_people(device_id, people_id)
	values(4, 2);
insert into devices_people(device_id, people_id)
	values(4, 8);
insert into devices_people(device_id, people_id)
	values(5, 1);
insert into devices_people(device_id, people_id)
	values(5, 4);
insert into devices_people(device_id, people_id)
	values(5, 7);
insert into devices_people(device_id, people_id)
	values(6, 3);
insert into devices_people(device_id, people_id)
	values(6, 5);
insert into devices_people(device_id, people_id)
	values(7, 1);
insert into devices_people(device_id, people_id)
	values(7, 5);
insert into devices_people(device_id, people_id)
	values(7, 9);
insert into devices_people(device_id, people_id)
	values(8, 5);
insert into devices_people(device_id, people_id)
	values(8, 9);
insert into devices_people(device_id, people_id)
	values(9, 3);


3	select avg(price) as average_price from devices;


4	select p.name as person, avg(d.price)
		from people as p
		join devices_people as dp
			on p.id=dp.people_id
		join devices as d
			on d.id=dp.device_id
		group by p.name;


5	select p.name as person, avg(d.price)
		from people as p
		join devices_people as dp
			on p.id=dp.people_id
		join devices as d
			on d.id=dp.device_id
		group by p.name
		having avg(d.price) > 5000
