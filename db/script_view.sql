create table Address(
                        id serial primary key ,
                        city varchar(255) not null ,
                        postal_code varchar(20),
                        country varchar(255) not null
);
create table Customer(
                         id serial primary key,
                         fullname varchar(255) not null,
                         address_id int,
                         foreign key (address_id) references Address(id)
);

create table Delivery_Service(
                                 id serial primary key ,
                                 title varchar(255) not null,
                                 delivery_time int not null
);

create table Product (
                         id serial primary key,
                         title varchar(255) not null,
                         price decimal(10, 2) not null,
                         category varchar(255)
);

create table Order_data(
                           id serial primary key,
                           customer_id int,
                           order_date date not null,
                           delivery_service_id int,
                           total_amount decimal(10, 2),
                           foreign key (customer_id) references Customer(id),
                           foreign key (delivery_service_id) references Delivery_Service(id)
);

create table Order_Product (
                               order_id int,
                               product_id int,
                               quantity int NOT NULL,
                               foreign key (order_id) references Order_data(id),
                               foreign key (product_id) references Product(id),
                               primary key (order_id, product_id)
);

insert into Address (city, postal_code, country) values
                                                     ('New York', '10001', 'USA'),
                                                     ('Moscow', '101000', 'Russia'),
                                                     ('London', '123456', 'UK'),
                                                     ('Paris', '980654', 'France'),
                                                     ('Beijing', '111111', 'China'),
                                                     ('Tokyo', '23344556', 'Japan'),
                                                     ('Delhi', '341234', 'India'),
                                                     ('Sydney', '4566643', 'Australia'),
                                                     ('Toronto', '3453432', 'Canada'),
                                                     ('São Paulo', '4523453', 'Brazil'),
                                                     ('Madrid', '4546789', 'Spain'),
                                                     ('Rome', '5634532', 'Italy'),
                                                     ('Berlin', '3421123', 'Germany'),
                                                     ('Minsk', '6788545', 'Belaruc'),
                                                     ('Istanbul', '3455566', 'Turkey');

insert into Customer (fullname, address_id) values
                                                ('John Doe', 1),
                                                ('Ivan Ivanov', 2),
                                                ('Smon Simonov', 3),
                                                ('Vao Bao', 4),
                                                ('Chan Yamamoto', 5),
                                                ('Cris Patel', 6),
                                                ('Lucy Smith', 7),
                                                ('Michael Jackson', 8),
                                                ('Shalil Oneel', 9),
                                                ('Isabella Lopes', 10),
                                                ('Diego Maradonna', 11),
                                                ('Olivero Gonsales', 12),
                                                ('Mickey Rurg', 13),
                                                ('Patrinck Honney', 14),
                                                ('Shao Baon ', 15);

insert into Delivery_Service (title, delivery_time) values
                                                        ('FastEx', 24),
                                                        ('QuickRl', 48),
                                                        ('LogisticsMvm', 72),
                                                        ('ShipR', 36),
                                                        ('ExpressMov', 12),
                                                        ('GlobalEx', 96),
                                                        ('PostEx', 24),
                                                        ('SpeedyMv', 48),
                                                        ('TransportLog', 72),
                                                        ('FlyDel', 8),
                                                        ('HonnewMove', 24),
                                                        ('DirectDel', 16),
                                                        ('AquaEx', 120),
                                                        ('BelPost', 32),
                                                        ('PostOfRussia', 40);

insert into Product (title, price, category) values
                                                 ('Laptop', 1020.04, 'Electronics'),
                                                 ('Smartphone', 699.59, 'Electronics'),
                                                 ('Tablet', 399.54, 'Electronics'),
                                                 ('Camera', 299.27, 'Electronics'),
                                                 ('Headphones', 149.79, 'Electronics'),
                                                 ('Bicycle', 489.07, 'Sports'),
                                                 ('Tennis racket', 85.54, 'Sports'),
                                                 ('Football', 34.57, 'Sports'),
                                                 ('Backpack', 59.89, 'Travel'),
                                                 ('Suitcase', 119.67, 'Travel'),
                                                 ('Picture', 19.42, 'Books'),
                                                 ('TextBook', 79.35, 'Books'),
                                                 ('Chair', 149.28, 'Furniture'),
                                                 ('Desk', 249.95, 'Furniture'),
                                                 ('Lamp', 45.12, 'Furniture');

insert into Order_data (customer_id, order_date, delivery_service_id, total_amount) values
                                                                                        (1, '2023-12-01', 1, 1020.04),
                                                                                        (2, '2023-08-02', 2, 699.59),
                                                                                        (3, '2023-02-03', 3, 399.54),
                                                                                        (4, '2023-11-04', 4, 299.27),
                                                                                        (5, '2023-01-05', 5, 149.79),
                                                                                        (6, '2023-02-06', 6, 489.07),
                                                                                        (7, '2023-03-07', 7, 85.54),
                                                                                        (8, '2023-04-08', 8, 34.57),
                                                                                        (9, '2023-05-05', 9, 59.89),
                                                                                        (10, '2023-06-04', 10, 119.67),
                                                                                        (11, '2023-07-11', 1, 19.42),
                                                                                        (12, '2023-08-12', 2, 79.35),
                                                                                        (13, '2023-09-13', 3, 149.28),
                                                                                        (14, '2023-10-14', 4, 249.95),
                                                                                        (15, '2023-11-15', 5, 45.12);

insert into Order_Product (order_id, product_id, quantity) values
                                                               (1, 1, 1),
                                                               (2, 2, 1),
                                                               (3, 3, 2),
                                                               (4, 4, 1),
                                                               (5, 5, 3),
                                                               (6, 6, 1),
                                                               (7, 7, 2),
                                                               (8, 8, 1),
                                                               (9, 9, 2),
                                                               (10, 10, 1),
                                                               (11, 11, 3),
                                                               (12, 12, 2),
                                                               (13, 13, 1),
                                                               (14, 14, 1),
                                                               (15, 15, 2);

select
    c.fullname as customer_name,
    a.city,
    a.postal_code,
    a.country,
    ds.title as delivery_service,
    o.order_date,
    ARRAY_AGG(p.title) as product_titles,
    ARRAY_AGG(op.quantity) as product_quantities,
    sum(p.price * op.quantity) as order_total,
    avg(p.price) as average_product_price,
    count(p.*) as total_products_ordered,
    sum(case when p.category = 'Electronics' then p.price * op.quantity else 0 end) as electronics_total,
    sum(case when p.category = 'Sports' then p.price * op.quantity else 0 end) as sports_total,
    sum(case when p.category = 'Travel' then p.price * op.quantity else 0 end) as travel_total
from
    Customer c
        inner join Address a on c.address_id = a.id
        inner join Order_data o on c.id = o.customer_id
        inner join Delivery_Service ds on o.delivery_service_id = ds.id
        inner join Order_Product op on o.id = op.order_id
        inner join Product p on op.product_id = p.id
group by
    c.fullname,
    a.city,
    a.postal_code,
    a.country,
    ds.title,
    o.order_date
order by
    o.order_date desc,
    order_total desc
LIMIT 10;

create view CustomerOrderSummary as select
    c.fullname as customer_name,
    a.city,
    a.postal_code,
    a.country,
    ds.title as delivery_service,
    o.order_date,
    ARRAY_AGG(p.title) as product_titles,
    ARRAY_AGG(op.quantity) as product_quantities,
    sum(p.price * op.quantity) as order_total,
    avg(p.price) as average_product_price,
    count(p.*) as total_products_ordered,
    sum(case when p.category = 'Electronics' then p.price * op.quantity else 0 end) as electronics_total,
    sum(case when p.category = 'Sports' then p.price * op.quantity else 0 end) as sports_total,
    sum(case when p.category = 'Travel' then p.price * op.quantity else 0 end) as travel_total
from
    Customer c
        inner join Address a on c.address_id = a.id
        inner join Order_data o on c.id = o.customer_id
        inner join Delivery_Service ds on o.delivery_service_id = ds.id
        inner join Order_Product op on o.id = op.order_id
        inner join Product p on op.product_id = p.id
group by
    c.fullname,
    a.city,
    a.postal_code,
    a.country,
    ds.title,
    o.order_date
order by
    o.order_date desc,
    order_total desc
LIMIT 10;

select * from CustomerOrderSummary;