INSERT INTO category (id, name) VALUES (1, 'cat');
INSERT INTO category (id, name) VALUES (2, 'dog');

INSERT INTO product (id, name, price, category_id, create_dt, is_deleted) VALUES (3, 'cat dry food', 10, 1, CURRENT_DATE, false);
INSERT INTO product (id, name, price, category_id, create_dt, is_deleted) VALUES (1, 'cat nip', 10, 1, CURRENT_DATE, false);
INSERT INTO product (id, name, price, category_id, create_dt, is_deleted) VALUES (2, 'bone shaped toy', 20, 2, CURRENT_DATE, false);

INSERT INTO users (id, email, password, first_name, last_name, is_deleted) VALUES (1, 'test@local.host', 'password', 'firstName', 'lastname', false);
INSERT INTO users (id, email, password, first_name, last_name, is_deleted) VALUES (3, 'test3@local.host', 'password', 'firstNameee', 'lastnameee', false);
INSERT INTO users (id, email, password, first_name, last_name, is_deleted) VALUES (2, 'test2@local.host', 'password', 'firstNamee', 'lastnamee', false);

INSERT INTO address (id, street, zip, city, user_id, create_dt) VALUES (1, 'somestr', 123456, 'fairfield', 1, CURRENT_DATE);
INSERT INTO address (id, street, zip, city, user_id, create_dt) VALUES (2, 'somestr', 123457, 'fairfield', 2, CURRENT_DATE);
INSERT INTO address (id, street, zip, city, user_id, create_dt) VALUES (3, 'somestr', 123458, 'fairfield', 3, CURRENT_DATE);


INSERT INTO review (id, comment, product_id, user_id, create_dt) VALUES (3, 'sucks', 1, 1, CURRENT_DATE);
INSERT INTO review (id, comment, product_id, user_id, create_dt) VALUES (1, 'good enough', 2, 1, CURRENT_DATE);
INSERT INTO review (id, comment, product_id, user_id, create_dt) VALUES (2, 'not good', 3, 2, CURRENT_DATE);
