sales_db2=*# delete from products where id > 3;
DELETE 5
sales_db2=*# commit;
COMMIT
sales_db2=# begin transaction;
BEGIN
sales_db2=*# select * from products;
 id |   name    |  producer  | count | price
----+-----------+------------+-------+-------
  1 | product_1 | producer_1 |     3 |    50
  2 | product_2 | producer_2 |    15 |    32
  3 | product_3 | producer_3 |     8 |   115
(3 rows)


sales_db2=*# insert into products (name, count, price) VALUES ('product_4', 11, 64);
INSERT 0 1
sales_db2=*# delete from products where price = 115;
DELETE 1
sales_db2=*# update products set price = 75 where name = 'product_1';
UPDATE 1
sales_db2=*# commit;
COMMIT
sales_db2=# show transaction isolation level;
 transaction_isolation
-----------------------
 read committed
(1 row)


sales_db2=# drop table products;
DROP TABLE
sales_db2=# create table products (
sales_db2(#     id serial primary key,
sales_db2(#     name varchar(50),
sales_db2(#     producer varchar(50),
sales_db2(#     count integer default 0,
sales_db2(#     price integer
sales_db2(# );
CREATE TABLE
sales_db2=# insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
INSERT 0 1
sales_db2=# insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 15, 32);
INSERT 0 1
sales_db2=# insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);
INSERT 0 1
sales_db2=# begint transaction isolation level repeatable read;
ОШИБКА:  ошибка синтаксиса (примерное положение: "begint")
LINE 1: begint transaction isolation level repeatable read;
        ^
sales_db2=# begin transaction isolation level repeatable read;
BEGIN
sales_db2=*# select * from products;
 id |   name    |  producer  | count | price
----+-----------+------------+-------+-------
  1 | product_1 | producer_1 |     3 |    50
  2 | product_2 | producer_2 |    15 |    32
  3 | product_3 | producer_3 |     8 |   115
(3 rows)


sales_db2=*# insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 11, 64);
INSERT 0 1
sales_db2=*# delete from products where price = 115;
DELETE 1
sales_db2=*# update products set price = 75 where name = 'product_1';
UPDATE 1
sales_db2=*# commit;
COMMIT
sales_db2=# drop table products;
DROP TABLE
sales_db2=# select * from products;
ОШИБКА:  отношение "products" не существует
LINE 1: select * from products;
                      ^
sales_db2=# create table products (
sales_db2(# sales_db2(#     id serial primary key,
sales_db2(# sales_db2(#     name varchar(50),
sales_db2(# sales_db2(#     producer varchar(50),
sales_db2(# sales_db2(#     count integer default 0,
sales_db2(# sales_db2(#     price integer
sales_db2(# sales_db2(# );
sales_db2(#
sales_db2(# );
sales_db2(# select * from products;
sales_db2(# \q

c:\Program Files\PostgreSQL\16\bin>psql -U postgres -d sales_db2
Password for user postgres:
psql (16.1)
Type "help" for help.

sales_db2=# create table products (
sales_db2(#     id serial primary key,
sales_db2(#     name varchar(50),
sales_db2(#     producer varchar(50),
sales_db2(#     count integer default 0,
sales_db2(#     price integer
sales_db2(# );
CREATE TABLE
sales_db2=# insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
INSERT 0 1
sales_db2=# insert into products (name, producer, count, price) VALUES ('product_2', 'producer_2', 15, 32);
INSERT 0 1
sales_db2=# insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);
INSERT 0 1
sales_db2=# select * from products;
 id |   name    |  producer  | count | price
----+-----------+------------+-------+-------
  1 | product_1 | producer_1 |     3 |    50
  2 | product_2 | producer_2 |    15 |    32
  3 | product_3 | producer_3 |     8 |   115
(3 rows)


sales_db2=# begin transaction isolation level serializable
sales_db2-# begin transaction isolation level serializable;
ОШИБКА:  ошибка синтаксиса (примерное положение: "begin")
LINE 2: begin transaction isolation level serializable;
        ^
sales_db2=# begin transaction isolation level serializable;
BEGIN
sales_db2=*# select sum(count) from products;
 sum
-----
  26
(1 row)


sales_db2=*# update products set count = 26 where name = 'product_1';
UPDATE 1
sales_db2=*# commit;
ОШИБКА:  не удалось сериализовать доступ из-за зависимостей чтения/записи между транзакциями
DETAIL:  Reason code: Canceled on identification as a pivot, during commit attempt.
HINT:  Транзакция может завершиться успешно при следующей попытке.
sales_db2=#  select * from products;
 id |   name    |  producer  | count | price
----+-----------+------------+-------+-------
  1 | product_1 | producer_1 |     3 |    50
  3 | product_3 | producer_3 |     8 |   115
  2 | product_2 | producer_2 |    26 |    32
(3 rows)


sales_db2=# create table customer(id serial primary key, name varchar(100), email varchar(100), age int, city varchar(100));
ОШИБКА:  отношение "customer" уже существует
sales_db2=# create table vip_customer(id serial primary key, name varchar(100), email varchar(100), age int, city varchar(100));
CREATE TABLE
sales_db2=# insert into vip_customer values('Adam Boui', 'boui@gmail.com', 32, 'Minsk');
ОШИБКА:  неверный синтаксис для типа integer: "Adam Boui"
LINE 1: insert into vip_customer values('Adam Boui', 'boui@gmail.com...
                                        ^
sales_db2=# insert into vip_customer values(1,'Adam Boui', 'boui@gmail.com', 32, 'Minsk');
INSERT 0 1
sales_db2=# insert into vip_customer values(2,'Richard Gir', 'gir@gmail.com', 56, 'Vitebsk');
INSERT 0 1
sales_db2=# insert into vip_customer values(3,'Jorge Cluni', 'clunca@gmail.com', 47, 'Chausi');
INSERT 0 1
sales_db2=# select * from vip_customer;
 id |    name     |      email       | age |  city
----+-------------+------------------+-----+---------
  1 | Adam Boui   | boui@gmail.com   |  32 | Minsk
  2 | Richard Gir | gir@gmail.com    |  56 | Vitebsk
  3 | Jorge Cluni | clunca@gmail.com |  47 | Chausi
(3 rows)


sales_db2=# set transaction isolation level read uncommitted;
ПРЕДУПРЕЖДЕНИЕ:  SET TRANSACTION может выполняться только внутри блоков транзакций
SET
sales_db2=# begin;
BEGIN
sales_db2=*# set transaction isolation level read uncommitted;
SET
sales_db2=*# update vip_customer set age = 12 where id = 1;
UPDATE 1
sales_db2=*# commit;
COMMIT
sales_db2=# set transaction isolation level serializable;
ПРЕДУПРЕЖДЕНИЕ:  SET TRANSACTION может выполняться только внутри блоков транзакций
SET
sales_db2=# begin;
BEGIN
sales_db2=*# set transaction isolation level serializable;
SET
sales_db2=*# select * from vip_customer where id = 2;
 id |    name     |     email     | age |  city
----+-------------+---------------+-----+---------
  2 | Richard Gir | gir@gmail.com |  56 | Vitebsk
(1 row)


sales_db2=*# select * from vip_customer where id = 2;
 id |    name     |     email     | age |  city
----+-------------+---------------+-----+---------
  2 | Richard Gir | gir@gmail.com |  56 | Vitebsk
(1 row)


sales_db2=!# commit;
ROLLBACK
sales_db2=# begin;
BEGIN
sales_db2=*# set transaction isolation level serializable;
SET
sales_db2=*# select * from vip_customer where id = 2;
 id |     name      |     email     | age |  city
----+---------------+---------------+-----+---------
  2 | Oleg Gazmanof | gir@gmail.com |  56 | Vitebsk
(1 row)


sales_db2=*#