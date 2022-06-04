
insert into role(role_title)
	values('Князь');
insert into role(role_title)
	values('Воин');
insert into role(role_title)
	values('Халоп');
insert into role(role_title)
	values('Лекарь');
insert into role(role_title)
	values('Повар');
insert into role(role_title)
	values('Рабочий');




insert into rules(rule_drscription)
	values('готовить');
insert into rules(rule_drscription)
	values('атаковать');
insert into rules(rule_drscription)
	values('строить');
insert into rules(rule_drscription)
	values('лечить');
insert into rules(rule_drscription)
	values('говорить');
insert into rules(rule_drscription)
	values('идти');
insert into rules(rule_drscription)
	values('есть');
insert into rules(rule_drscription)
	values('спать');
insert into rules(rule_drscription)
	values('думать');



insert into role_rules(role_id, rule_id)
	values(1,1);
insert into role_rules(role_id, rule_id)
	values(1,2);
insert into role_rules(role_id, rule_id)
	values(1,5);
insert into role_rules(role_id, rule_id)
	values(1,6);
insert into role_rules(role_id, rule_id)
	values(1,7);
insert into role_rules(role_id, rule_id)
	values(1,8);
insert into role_rules(role_id, rule_id)
	values(1,9);
insert into role_rules(role_id, rule_id)
	values(2,2);
insert into role_rules(role_id, rule_id)
	values(2,8);
insert into role_rules(role_id, rule_id)
	values(3,3);
insert into role_rules(role_id, rule_id)
	values(4,8);
insert into role_rules(role_id, rule_id)
	values(4,1);
insert into role_rules(role_id, rule_id)
	values(5,1);
insert into role_rules(role_id, rule_id)
	values(5,7);
insert into role_rules(role_id, rule_id)
	values(6,3);


insert into users(first_name, last_name, role_id)
	values('Gans','Sholce',4);
insert into users(first_name, last_name, role_id)
	values('Saymon','Klaim',2);
insert into users(first_name, last_name, role_id)
	values('Mischael','Holms',1);
insert into users(first_name, last_name, role_id)
	values('Paul','Duda',3);
insert into users(first_name, last_name, role_id)
	values('Mary','Piece',5);
insert into users(first_name, last_name, role_id)
	values('Fridrich','Bucha',6);
insert into users(first_name, last_name, role_id)
	values('Richard','Gir',3);
	


insert into category(category)
	values('32');
insert into category(category)
	values('08');
insert into category(category)
	values('1');
insert into category(category)
	values('-9');
insert into category(category)
	values('17');
insert into category(category)
	values('8804');



insert into state(state)
	values('011');
insert into state(state)
	values('022');
insert into state(state)
	values('033');
insert into state(state)
	values('044');
insert into state(state)
	values('055');
insert into state(state)
	values('066');
insert into state(state)
	values('077');


insert into item(id_user, id_category, id_state)
	values(1,1,3);
insert into item(id_user, id_category, id_state)
	values(1,3,1);
insert into item(id_user, id_category, id_state)
	values(2,1,4);
insert into item(id_user, id_category, id_state)
	values(2,2,2);
insert into item(id_user, id_category, id_state)
	values(3,1,1);
insert into item(id_user, id_category, id_state)
	values(7,6,3);


insert into comments(comment, id_item)
	values('comment1', 1);
insert into comments(comment, id_item)
	values('comment2', 2);
insert into comments(comment, id_item)
	values('comment3', 1);
insert into comments(comment, id_item)
	values('comment4', 6);
insert into comments(comment, id_item)
	values('comment5', 3);
insert into comments(comment, id_item)
	values('comment6', 1);


insert into attachs(attachs, id_item)
	values('attachs1', 1);
insert into attachs(attachs, id_item)
	values('attachs2', 1);
insert into attachs(attachs, id_item)
	values('attachs3', 4);
insert into attachs(attachs, id_item)
	values('attachs4', 2);
insert into attachs(attachs, id_item)
	values('attachs5', 6);
insert into attachs(attachs, id_item)
	values('attachs6', 2);
insert into attachs(attachs, id_item)
	values('attachs7', 5);
insert into attachs(attachs, id_item)
	values('attachs8', 2);
insert into attachs(attachs, id_item)
	values('attachs9', 1);
