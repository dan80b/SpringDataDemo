CREATE TABLE customer (
  customer_id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  address varchar(50) DEFAULT NULL,
  name varchar(30) DEFAULT NULL,
  phone varchar(15) DEFAULT NULL
);

CREATE TABLE product (
  product_id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  description varchar(200) DEFAULT NULL,
  name varchar(30) DEFAULT NULL,
  price double DEFAULT NULL
);

CREATE TABLE sales_order (
  order_id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  date date DEFAULT NULL,
  total double DEFAULT NULL,
  customer_id int(11) DEFAULT NULL
);

CREATE TABLE line_item (
  line_item_id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  price double DEFAULT NULL,
  quantity int(11) DEFAULT NULL,
  total double DEFAULT NULL,
  order_id int(11) DEFAULT NULL,
  product_id int(11) DEFAULT NULL
);
