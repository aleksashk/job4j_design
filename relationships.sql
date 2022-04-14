many-to-one one-to-many

create table fuel(
	id serial primary key,
	fuel_name varchar(25),
	octane_rating varchar(10)
);

create table cars(
	id serial primary key,
	type_of_fuel int references fuel(id) 
);


insert into fuel(fuel_name, octane_rating) 
	values('Регуляр', 'АИ-92');
insert into fuel(fuel_name, octane_rating) 
	values('Премиум', 'АИ-95');
insert into fuel(fuel_name, octane_rating) 
	values('Супер', 'АИ-95+');
insert into fuel(fuel_name, octane_rating) 
	values('Экстра', 'АИ-98');
insert into fuel(fuel_name, octane_rating) 
	values('Экто', 'АИ-100');
insert into cars(type_of_fuel) 
	values(3);
insert into cars(type_of_fuel) 
	values(1);
insert into cars(type_of_fuel) 
	values(2);
insert into cars(type_of_fuel) 
	values(5);
insert into cars(type_of_fuel) 
	values(5);
insert into cars(type_of_fuel) 
	values(5);
insert into cars(type_of_fuel) 
	values(3);
insert into cars(type_of_fuel) 
	values(2);
insert into cars(type_of_fuel) 
	values(5);

many-to-many

create table animals(
     id serial primary key,
     name varchar(255)
 );
 
 create table food(
     id serial primary key,
     name varchar(255)
 );
 
 create table animals_food(
     id serial primary key,
     animal_id int references animals(id),
     food_id int references food(id)
 );

insert into animals(name) 
	values('Лось');
insert into animals(name) 
	values('Белка');
insert into animals(name) 
	values('Лиса');
insert into animals(name) 
	values('Слон');
insert into food(name) 
	values('Грибы');
insert into food(name) 
	values('Трава');
insert into food(name) 
	values('Ветки');
insert into food(name) 
	values('Ягоды');
insert into food(name) 
	values('Рыба');
insert into food(name) 
	values('Орехи');
insert into animals_food(animal_id, food_id) 
	values(1, 1);
insert into animals_food(animal_id, food_id) 
	values(1, 2);
insert into animals_food(animal_id, food_id) 
	values(1, 3);
insert into animals_food(animal_id, food_id) 
	values(1, 4);
insert into animals_food(animal_id, food_id) 
	values(1, 6);
insert into animals_food(animal_id, food_id) 
	values(2, 1);
insert into animals_food(animal_id, food_id) 
	values(2, 4);
insert into animals_food(animal_id, food_id) 
	values(2, 6);
insert into animals_food(animal_id, food_id) 
	values(3, 2);
insert into animals_food(animal_id, food_id) 
	values(3, 5);
insert into animals_food(animal_id, food_id) 
	values(4, 1);
insert into animals_food(animal_id, food_id) 
	values(4, 2);
insert into animals_food(animal_id, food_id) 
	values(4, 3);




one-to-one


create table registration_number(
    id serial primary key,
    number varchar(50) unique
);

create table car(
    id serial primary key,
    mark varchar(50),
    model varchar(50),
    number_id int references registration_number(id) unique
);

insert into registration_number(number) 
	values('54-02 JK78');
insert into registration_number(number) 
	values('54-03 JK78');
insert into registration_number(number) 
	values('54-12 JK78');
insert into registration_number(number) 
	values('54-22 JK78');

insert into car(mark, model,number_id) 
	values('skoda', 'rapid', 2);
insert into car(mark, model,number_id) 
	values('skoda', 'rapid', 4);
insert into car(mark, model,number_id) 
	values('skoda', 'rapid', 1);
insert into car(mark, model,number_id) 
	values('skoda', 'rapid', 3);

























