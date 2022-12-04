-- insert into users values(1, 'user1@gmail.com', 'test-first1', 'test-last1', 'test-pass', 4);
-- insert into users values(2, 'user2@gmail.com', 'test-first2', 'test-last2', 'test-pass', 2);
-- insert into users values(3, 'user3@gmail.com', 'test-first3', 'test-last3', 'test-pass', 1);
-- insert into users values(4, 'user4@gmail.com', 'test-first4', 'test-last4', 'test-pass', 3);

-- insert  into address values (1, '1000 N 4th Street', 57552, 'Fairfield', 3);
-- insert  into address values (2, '2000 E 9th Street', 57551, 'Burlington', 2);
-- insert  into address values (3, '4000 N 7th Street', 57559, 'Mount Pleasent', 4);
-- insert  into address values (4, '3000 W 5th Street', 57556, 'Iowa City', 1);

insert into users values(1, 'user1@gmail.com', 'test-first1', 'test-last1', 'test-pass');
insert into users values(2, 'user2@gmail.com', 'test-first2', 'test-last2', 'test-pass');
insert into users values(3, 'user3@gmail.com', 'test-first3', 'test-last3', 'test-pass');
insert into users values(4, 'user4@gmail.com', 'test-first4', 'test-last4', 'test-pass');

insert  into address values (1, 'Fairfield', '1000 N 4th Street', 57552, 3);
insert  into address values (2, 'Burlington', '2000 E 9th Street', 57551, 2);
insert  into address values (3, 'Mount Pleasent', '4000 N 7th Street', 57559, 4);
insert  into address values (4, 'Iowa City', '3000 W 5th Street', 57556, 1);

insert into category values(1, 'Laptop');
insert into category values(2, 'Phone');
insert into category values(3, 'Tablet');
insert into category values(4, 'Smart Watch');

insert into product values(1, 'Apple Macbook Air M1', 899, 4.7, 1);
insert into product values(2, 'Dell Latitude e5470', 499, 4.1, 1);
insert into product values(3, 'Google Chromebook', 299, 3.2, 1);
insert into product values(4, 'Lenovo Legion', 799, 4.5, 1);

insert into review values(1, 'Very good product.', 1, 2);
insert into review values(2, 'Very satisfied with the product.', 1, 4);
insert into review values(3, 'Not satisfied with the product.', 3, 1);
insert into review values(4, 'Very bad product.', 3, 1);