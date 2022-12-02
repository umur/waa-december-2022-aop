INSERT INTO category (name) VALUES
                                ('Laptop'),('Phone');

INSERT INTO product (name, price, rating, id_category) VALUES
                                                           ('Macbook', 1000, 4, 1),('Acer', 700, 5, 1),
                                                           ('Pixel', 500, 5, 2),('Samsung', 300, 6, 2);

INSERT INTO address (street, zip, city) VALUES
                                            ('1000 N. 4th St.', 52557, 'FairField'),
                                            ('1001 N. 5th St.', 52885, 'Sigourney');

INSERT INTO users (email, password, first_name, last_name, id_address) VALUES
                                                                           ('ujjwal@gmail.com', 'password', 'Ujjwal', 'Humagain', 1),
                                                                           ('prajjwol@gmail.com', 'pass1234', 'Prajjwol', 'Humagain', 2);

INSERT INTO review (comment, id_product, id_user) VALUES
                                                      ('Great Product', 1, 2),
                                                      ('Nice One', 1, 1),
                                                      ('Bad Product',2,2);