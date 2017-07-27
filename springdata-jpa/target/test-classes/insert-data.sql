insert into customer (name, address, phone) values ('Kendrick Carran', '123 6th St. Melbourne, FL 32904', '202-555-0140');
insert into customer (name, address, phone) values ('Pio Givi', '4 Goldfield Rd. Honolulu, HI 96815', '202-555-0194');

insert into product (name, description, price) values ('ASUS R510VX-DM151D', 'ASUS R510VX-DM151D, Intel® Core™ i7-6700HQ 2.60GHz, Skylake™, 15.6", Full HD, 8GB, 1TB, DVD-RW, nVIDIA GeForce GTX 950M 4GB, Free DOS, Glossy Black', 3349.99);
insert into product (name, description, price) values ('ASUS ROG GL552V', 'ASUS ROG GL552V, Intel® Core™ i7-6700HQ 2.60GHz, Skylake™, 15.6", Full HD, 8GB, 1TB, nVIDIA GeForce GTX 960M 4GB, Free DOS', 3997.71);
insert into product (name, description, price) values ('Dell Inspiron 7559', 'Dell Inspiron 7559, Intel® Core™ i7-6700HQ, 2.60GHz, Skylake™, 15.6", Full HD, 8GB, 1TB + 8GB SSHD, nVidia GeForce GTX 960M 4GB, Ubuntu Linux 14.04 SP1, Black', 3799.99);
insert into product (name, description, price) values ('HP 250 G5', 'HP 250 G5, Intel® Celeron® N3060 1.60 GHz, 15.6", 4GB, 1TB, DVD-RW, Intel® HD Grapichs 400, Free DOS, Black', 1249.99);
insert into product (name, description, price) values ('Apple MacBook Air 13', 'Apple MacBook Air 13, Intel® Dual Core™ i5 1.60GHz, 13.3", 8GB, 128GB SSD, Intel® HD Graphics 6000, OS X El Capitan, RO KB', 4434.42);
insert into product (name, description, price) values ('Lenovo IdeaPad 100-15IBD', 'Lenovo IdeaPad 100-15IBD, Intel® Core™ i3-5005U 2.00 GHz, Broadwell™, 15.6", 4GB, 128GB SSD, DVD-RW, nVidia GeForce 920MX 2GB, Free DOS, Black', 1599.99);
insert into product (name, description, price) values ('Toshiba Tecra Z50-A-181', 'Toshiba Tecra Z50-A-181, Intel® Core™ i7-4600U 2.10GHz, Haswell™, 15.6", Full HD, 8GB, SSD 256GB, Intel® HD Graphics, Microsoft Windows 7 Professional + Upgrade Windows 8 Pro licenta, Steel Grey', 4799.98);

insert into sales_order (customer_id, date, total) values (1, curdate(), 4599.98);
insert into sales_order (customer_id, date, total) values (2, curdate(), 5597.7);
insert into sales_order (customer_id, date, total) values (1, curdate(), 4434.42);

insert into line_item (order_id, product_id, price, quantity, total) values (1, 1, 3349.99, 1, 3349.99);
insert into line_item (order_id, product_id, price, quantity, total) values (1, 4, 1249.99, 1, 1249.99);
insert into line_item (order_id, product_id, price, quantity, total) values (2, 2, 3997.71, 1, 3997.71);
insert into line_item (order_id, product_id, price, quantity, total) values (2, 6, 1599.99, 1, 1599.99);
insert into line_item (order_id, product_id, price, quantity, total) values (3, 5, 4434.42, 1, 4434.42);