create table type(
	id serial primary key,
	name varchar(50)
);

create table product(
	id serial primary key,
	name varchar(50),
	type_id int references type(id),
	expired_date date,
	price float
);

insert into type(name)
	values('СЫР');
insert into type(name)
	values('МОЛОКО');
insert into type(name)
	values('ХЛЕБ');
insert into type(name)
	values('МЯСО');


insert into product(name, type_id, expired_date, price)
	values('сыр1', 1,date'2016-05-12', 7.89);
insert into product(name, type_id, expired_date, price)
	values('сыр2', 1,date'2017-02-01', 127.04);
insert into product(name, type_id, expired_date, price)
	values('сыр3', 1,date'2014-12-22', 0.15);
insert into product(name, type_id, expired_date, price)
	values('молоко', 2,date'2016-04-01', 1.07);
insert into product(name, type_id, expired_date, price)
	values('молоко2', 2,date'2011-06-12', 1.21);
insert into product(name, type_id, expired_date, price)
	values('сушки', 3,date'2019-04-10', 2.05);
insert into product(name, type_id, expired_date, price)
	values('тушенка', 4,date'2015-01-08', 23.04);
insert into product(name, type_id, expired_date, price)
	values('колбаса', 4,date'2017-05-11', 14.04);
insert into product(name, type_id,expired_date, price)
	values('мороженое мясо ежа', 4,date'2022-08-23',123.23);
insert into product(name, type_id,expired_date, price)
	values('мороженое булка французская',3,date'2022-09-30',1203.23);
insert into product(name, type_id,expired_date, price)
	values('мороженое кумыс', 2,date'2023-01-03',12223.50);
insert into product(name, type_id,expired_date, price)
	values('мороженое сыр ВРОДЕ', 1,date'2024-01-15',23.235);
insert into product(name, type_id,expired_date, price)
	values('слабомороженое нечто', 2,date'2028-09-05',569.47);

1	select product.name from product
		join type on product.type_id = type.id
		where type.name = 'СЫР';


	select * from product
		join type on product.type_id = type.id
		where type.name = 'СЫР';

2	select * from product
		where product.name like('%мороженое%')

3	select * from product
		where expired_date < current_date 

4 	select * from product
		join type on product.type_id = type.id
		order by product.price desc
		limit 1
	
5	select type.name as productType, count(type.name) 
		rom product 
		join type 
		on product.type_id = type.id
		group by type.name;

6	select product.name as product, type.name as type from product 
		join type 
		on product.type_id = type.id
		where type.name = 'СЫР' or type.name ='МОЛОКО'

7	select type.name as type, count(type.name) from type
		join product on type.id = product.type_id
		group by type.name

8 	select product.name as product, type.name as type from product
		join type on product.type_id = type.id

