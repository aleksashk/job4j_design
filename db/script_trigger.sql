create table products (
                          id serial primary key,
                          name varchar(50),
                          producer varchar(50),
                          count integer default 0,
                          price integer
);

create or replace function discount()
    returns trigger as
$$
BEGIN
    update products
    set price = price - price * 0.2
    where count <= 5 AND id = new.id;
    return NEW;
END;
$$
    LANGUAGE 'plpgsql';


create trigger discount_trigger
    after insert
    on products
    for each row
execute procedure discount();

insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);

create or replace function tax()
    returns trigger as
$$
BEGIN
    update products
    set price = price - price * 0.2
    where id = (select id from inserted) and count <= 5;
    return new;
END;
$$
    LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
execute procedure tax();


-- task 1.

create or replace function calculate_tax()
    returns trigger as
$$
BEGIN
    update products
    set price = price + price * 0.2;
    return null;
END;
$$
    LANGUAGE 'plpgsql';

create trigger add_tax_trigger
    after insert on products
    for each statement
execute function calculate_tax();

insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 10, 100);

select * from products;

-- task 2.

create or replace function calculate_tax_before()
    returns trigger as
$$
BEGIN
    NEW.price = NEW.price + NEW.price * 0.2;
    return new;
END;
$$
    LANGUAGE 'plpgsql';

create trigger add_tax_trigger_before
    before insert on products
    for each row
execute function calculate_tax_before();

insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 5, 25);
insert into products (name, producer, count, price) VALUES ('product_5', 'producer_5', 10, 50);

select * from products;

-- task 3.

create table history_of_price (
                                  id serial primary key,
                                  name varchar(50),
                                  price integer,
                                  date timestamp
);

create or replace function add_history_of_product()
    returns trigger as
$$
BEGIN
    insert into history_of_price(name, price, date)
    values(NEW.name, NEW.price, now());
    return new;
END;
$$
    LANGUAGE 'plpgsql';

create trigger insert_log
    after insert on products
    for each row
    execute function add_history_of_product();

insert into products (name, producer, count, price) VALUES ('product_6', 'producer_6', 12, 10);
insert into products (name, producer, count, price) VALUES ('product_7', 'producer_7', 8, 120);

select * from products;
select * from history_of_price;
