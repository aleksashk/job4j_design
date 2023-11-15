CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);


insert into customers(first_name, last_name, age, country) values
('Bob', 'Dilan', 56, 'USA'),
('Fred', 'Shnobel', 25, 'UK'),
('Ricke', 'Martin', 34, 'EU'),
('Tagir', 'Valeev', 59, 'BY'),
('Endy', 'Worhal', 50, 'RU'),
('Jenifer', 'Lopes', 12, 'UZ'),
('Serena', 'Williams', 45, 'UK'),
('Justin', 'Biber', 13, 'KZ'),
('Erick', 'Birds', 51, 'AE'),
('John', 'Doe', 53, 'FR'),
('Freddy', 'Merkuri', 63, 'IR'),
('Katrin', 'Shibra', 12, 'MK'),
('Jein', 'Doe', 24, 'AF'),
('Witney', 'Huston', 12, 'RU');

select * from customers where age = (select min(age) from customers);

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);


insert into orders(amount, customer_id) values
(50, 10),
(960, 12),
(850, 13),
(380, 4),
(60, 12),
(40, 5),
(30, 6),
(20, 7),
(4214, 5),
(785, 8),
(9885, 9),
(685, 11),
(345, 12),
(800, 10),
(70, 14),
(3, 13),
(600, 12),
(3000, 11),
(890, 10),
(750, 4),
(580, 5),
(500, 10);

select * from customers where id not in(
	select customer_id from orders
);