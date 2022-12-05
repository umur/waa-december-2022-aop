insert into public.category (id, name)values (1,'cat');
insert into public.category (id, name)values (2,'pig');
insert into public.category (id, name)values (3,'dog');
insert into public.category (id, name)values (4,'bird');

insert into product (id, name, price, rating, id_category) values (1,'cat pot',50,0.02,1);
insert into product (id, name, price, rating, id_category) values (2,'dog pot',100,0.01,3);
insert into product (id, name, price, rating, id_category) values (3,'bird pot',150,0.03,4);

insert into public.address (id, city, street, zip)
values (1,'fairfield','R13 1000N 4th','52557');
insert into public.address (id, city, street, zip)
values (2,'fairfield','R14 1000N 4th','52557');
insert into public.address (id, city, street, zip)
values (3,'fairfield','R15 1000N 4th','52557');


insert into hw_user (id, email, first_name, last_name, password, address_id)
values (1,'675601125@qq.com','meijuan','long','111',1);
insert into hw_user (id, email, first_name, last_name, password, address_id)
values (2,'88888888@qq.com','hassan','raza','111',2);
insert into hw_user (id, email, first_name, last_name, password, address_id)
values (3,'99999999@qq.com','superman','raza','111',3);


insert into review (id, comment, product_id, user_id)
values (1,'the dog pot is good',2,2);
insert into review (id, comment, product_id, user_id)
values (2,'the cat pot is useful',1,1);
insert into review (id, comment, product_id, user_id)
values (3,'the bird pot is bad',3,3);

