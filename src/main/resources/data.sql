insert into category(id, name, deleted) values (1, 'Clothes', false);
insert into category(id, name, deleted) values (2, 'Electronics', false);

insert into product(id, name, price, rating, category_id, deleted) values (1, 't-shirt', 20, 5, 1, false);
insert into product(id, name, price, rating, category_id, deleted) values (2, 'shoes', 30, 3, 1, false);
insert into product(id, name, price, rating, category_id, deleted) values (3, 'Monitor', 120, 4, 2, false);
insert into product(id, name, price, rating, category_id, deleted) values (4, 'Keyboard', 40, 5, 2, false);

insert into address(id, street, zip, city, deleted) values (1, '1000', 52557, 'Fairfield', false);
insert into address(id, street, zip, city, deleted) values (2, '3000', 52558, 'Iowa city', false);

insert into users(id, email, password, firstname, lastName, address_id, deleted) values (1, 'a@a', 'a', 'a', 'x', 1, false);
insert into users(id, email, password, firstname, lastName, address_id, deleted) values (2, 'b@b', 'b', 'b', 'y', 2, false);

insert into review(id, comment, product_id, user_id) values (1, 'comby11', 1, 1);
insert into review(id, comment, product_id, user_id) values (2, 'comby12', 1, 2);
insert into review(id, comment, product_id, user_id) values (3, 'comby21', 2, 1);
insert into review(id, comment, product_id, user_id) values (4, 'comby32', 3, 2);
insert into review(id, comment, product_id, user_id) values (5, 'comby42', 4, 2);



