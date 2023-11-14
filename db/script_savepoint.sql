begin;

insert into products (name, producer, count, price) VALUES ('product_10', 'producer_10', 101, 105);

select * from products;

savepoint second_savepoint;


insert into products (name, producer, count, price) VALUES ('product_20', 'producer_20', 201, 205);

select * from products;

savepoint third_savepoint;

insert into products (name, producer, count, price) VALUES ('product_30', 'producer_30', 301, 305);

select * from products;

savepoint fourth_savepoint;

rollback to second_savepoint;

select * from products;