create table address(
	id serial primary key,
	street text not null,
	house_number text not null,
	flat_number text
);

insert into address (street, house_number, flat_number) values
('1-й Казанский переулок', 'д. 14', null),
('ул. Центральная', 'д. 40', 'кв. 74'),
('ул. Ленина', 'д. 7', 'кв. 130');

create table film(
	id serial primary key,
	title text not null
);

insert into film(title) values
    ('Пираты Карибского моря'),
    ('Матрица: Революция'),
    ('Человек, который изменил всё'),
    ('Император');

create table sex(
	id serial primary key,
	title text not null
);

insert into sex(title) values
    ('женский'),
    ('мужской');

create table owner(
	id serial primary key,
	fullname text not null
);

insert into owner(fullname) values
    ('Ольга Егорова'),
    ('Иванов Сергей');

create table film_info(
	id serial primary key,
	owner_id int not null,
	address_id int not null,
	film_id int not null,
	sex_id int not null,
	foreign key (owner_id) references owner(id),
	foreign key (address_id) references address(id),
	foreign key (film_id) references film(id),
	foreign key (sex_id) references sex(id)
);

insert into film_info(owner_id, address_id, film_id, sex_id) values
(1, 1, 1, 1),
(1, 1, 2, 1),
(2, 2, 3, 2),
(2, 2, 3, 2),
(2, 3, 2, 2);


select
    owner.fullname as "Полное имя",
    CONCAT(address.street, ' ', address.house_number, ' ', address.flat_number) as "Адрес",
    film.title as "Заказанные фильмы",
    sex.title as "Пол"
from
    film_info
left join
    owner on owner.id = film_info.owner_id
left join
    address on address.id = film_info.address_id
left join
    film on film.id = film_info.film_id
left join
    sex on sex.id = film_info.sex_id;