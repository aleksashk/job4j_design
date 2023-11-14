sales_db2=# begin transaction;
BEGIN
sales_db2=*# select * from products;
 id |   name    |  producer  | count | price
----+-----------+------------+-------+-------
  1 | product_1 | producer_1 |     3 |    50
  2 | product_2 | producer_2 |    15 |    32
  3 | product_3 | producer_3 |     8 |   115
(3 rows)


sales_db2=*# select * from products;
 id |   name    |  producer  | count | price
----+-----------+------------+-------+-------
  1 | product_1 | producer_1 |     3 |    50
  2 | product_2 | producer_2 |    15 |    32
  3 | product_3 | producer_3 |     8 |   115
(3 rows)


sales_db2=*# select * from products;
 id |   name    |  producer  | count | price
----+-----------+------------+-------+-------
  2 | product_2 | producer_2 |    15 |    32
  9 | product_4 |            |    11 |    64
  1 | product_1 | producer_1 |     3 |    75
(3 rows)


sales_db2=*# commit;
COMMIT
sales_db2=# select * from products;
ОШИБКА:  отношение "products" не существует
LINE 1: select * from products;
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


sales_db2=*# update products set price = 75 where name = 'product_1';
ОШИБКА:  не удалось сериализовать доступ из-за параллельного изменения
sales_db2=!# update products set price = 75 where name = 'product_1';
ОШИБКА:  текущая транзакция прервана, команды до конца блока транзакции игнорируются
sales_db2=!# select * from products;
ОШИБКА:  текущая транзакция прервана, команды до конца блока транзакции игнорируются
sales_db2=!# commit;
ROLLBACK
sales_db2=# begin transaction isolation level repeatable read;
BEGIN
sales_db2=*# update products set price = 75 where name = 'product_1';
UPDATE 1
sales_db2=*# rollback;
ROLLBACK
sales_db2=# begin transaction isolation level serializable;
BEGIN
sales_db2=*# select sum(count) from products;
 sum
-----
  26
(1 row)


sales_db2=*# update products set count = 26 where name = 'product_2';
UPDATE 1
sales_db2=*# commit;
COMMIT
sales_db2=# set transaction isolation level read uncommitted;
ПРЕДУПРЕЖДЕНИЕ:  SET TRANSACTION может выполняться только внутри блоков транзакций
SET
sales_db2=# begin;
BEGIN
sales_db2=*# set transaction isolation level read uncommitted;
SET
sales_db2=*# select * from vip_customer where id = 1;
 id |   name    |     email      | age | city
----+-----------+----------------+-----+-------
  1 | Adam Boui | boui@gmail.com |  32 | Minsk
(1 row)


sales_db2=*# select * from vip_customer where id = 1;
 id |   name    |     email      | age | city
----+-----------+----------------+-----+-------
  1 | Adam Boui | boui@gmail.com |  12 | Minsk
(1 row)


sales_db2=*# commit;
COMMIT
sales_db2=# begin;
BEGIN
sales_db2=*# set transaction isolation level serializable;
SET
sales_db2=*# update vip_customer set name = 'Oleg Gazmanof' where id = 2;
UPDATE 1
sales_db2=*# select * from vip_customer where id = 2;
 id |     name      |     email     | age |  city
----+---------------+---------------+-----+---------
  2 | Oleg Gazmanof | gir@gmail.com |  56 | Vitebsk
(1 row)


sales_db2=*# commit;\
COMMIT
invalid command \
Try \? for help.
sales_db2=# commit;
ПРЕДУПРЕЖДЕНИЕ:  нет незавершённой транзакции
COMMIT
sales_db2=# begin;
BEGIN
sales_db2=*# set transaction isolation level serializable;
SET
sales_db2=*# update vip_customer set name 'Mickey Rurck' where id = 2;
ОШИБКА:  ошибка синтаксиса (примерное положение: "'Mickey Rurck'")
LINE 1: update vip_customer set name 'Mickey Rurck' where id = 2;
                                     ^
sales_db2=!# update vip_customer set name='Mickey Rurck' where id = 2;
ОШИБКА:  текущая транзакция прервана, команды до конца блока транзакции игнорируются
sales_db2=!#