create table registration_numbers(
    id serial primary key,
    value_reg_number varchar(20)
);


create table cars(
    id serial primary key,
    mark varchar(25),
    model varchar(25),
    vin_number varchar(20),
    registration_number int references registration_numbers(id)
);



insert into registration_numbers(value_reg_number) values ('4578AS36');
insert into registration_numbers(value_reg_number) values ('9856BN785');
insert into registration_numbers(value_reg_number) values ('0214BB39');
insert into registration_numbers(value_reg_number) values ('5412FV25');
insert into registration_numbers(value_reg_number) values ('9457VV36');
insert into registration_numbers(value_reg_number) values ('0123JK85');
insert into registration_numbers(value_reg_number) values ('9852PO21');

insert into cars(mark, model, vin_number, registration_number) 
	values ('Lexus', 'RX300', '01245783GTR', 1);
insert into cars(mark, model, vin_number, registration_number) 
	values ('Skoda', 'Octavia', '23568995ZXV', 2);
insert into cars(mark, model, vin_number, registration_number) 
	values ('Lexus', 'RX350', '05647783VBD', 3);
insert into cars(mark, model, vin_number, registration_number) 
	values ('Skoda', 'Octavia', '56897421NMD', 4);
insert into cars(mark) 
	values ('Skoda');
insert into cars(mark) 
	values ('BMV');
insert into cars(mark) 
	values ('FIAT');
insert into cars(mark) 
	values ('HUMMER');

select c.mark as mark, 
	c.model as model, 
	c.vin_number as vin, 
	number.value_reg_number as r_number
from cars as c 
join registration_numbers as number 
on c.registration_number = number.id;

select c.mark as carMark, 
	number.value_reg_number as registration_number
from cars as c 
join registration_numbers as number 
on c.registration_number = number.id;

select c.vin_number as vin, 
	number.value_reg_number as car_registration_number
from cars as c 
join registration_numbers as number 
on c.registration_number = number.id;



