
	create table role(
		id serial primary key,
		role_title varchar(50)
	);
	
	create table rules(
		id serial primary key,
		rule_drscription varchar(250)
	);
	
	
	create table users(
		id serial primary key,
		first_name varchar(50),
		last_name varchar(50),
		role_id int references role(id)
	);


	create table role_rules(
		id serial primary key,
		role_id int references role(id),
		rule_id int references rules(id)
	);

	create table category(
		id serial primary key,
		category varchar(255)
	);
	
	create table state(
		id serial primary key,
		state varchar(255)
	);

	create table item(
		id serial primary key,
		id_user int references users(id),
		id_category int references category(id),
		id_state int references state(id)
	);


	create table comments(
		id serial primary key,
		comment text,
		id_item int references item(id)
	);


	create table attachs(
		id serial primary key,
		attachs varchar(255),
		id_item int references item(id)
	);