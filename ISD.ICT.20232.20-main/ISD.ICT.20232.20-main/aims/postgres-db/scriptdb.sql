CREATE TABLE customer (
  user_id integer PRIMARY KEY,
  name varchar(255),
  password varchar(255),
  DoB date,
  email varchar(255)
);

CREATE TABLE cart (
  user_id integer PRIMARY KEY,
  created_date timestamp,
  total_price real
);

CREATE TABLE product (
  product_id integer PRIMARY KEY,
  name varchar(255),
  description text,
  type integer,
  price real,
  available integer
);

CREATE TABLE cart_product (
  cart_id integer,
  product_id integer,
  PRIMARY KEY (cart_id, product_id)
);

CREATE TABLE orders (
  order_id integer PRIMARY KEY,
  total_price real,
  created_date date,
  shipping_fee real,
  payment_id integer,
  user_id integer,
  delivery_id integer
);

CREATE TABLE order_product (
  order_id integer,
  product_id integer,
  PRIMARY KEY (order_id, product_id)
);

CREATE TABLE delivery_info (
  delivery_id integer PRIMARY KEY,
  address text,
  delivery_time timestamp,
  phone_number varchar(255),
  instructions text,
  type bool,
  receiver_name varchar(255),
  province varchar(255),
  user_id integer
);

CREATE TABLE payment_transaction (
  id integer PRIMARY KEY,
  status varchar(255),
  created_time timestamp,
  content text,
  customer_id integer
);


ALTER TABLE cart ADD FOREIGN KEY (user_id) REFERENCES customer (user_id);

ALTER TABLE orders ADD FOREIGN KEY (user_id) REFERENCES customer (user_id);

ALTER TABLE delivery_info ADD FOREIGN KEY (user_id) REFERENCES customer (user_id);

ALTER TABLE payment_transaction ADD FOREIGN KEY (customer_id) REFERENCES customer (user_id);

ALTER TABLE orders ADD FOREIGN KEY (delivery_id) REFERENCES delivery_info (delivery_id);

ALTER TABLE orders ADD FOREIGN KEY (payment_id) REFERENCES payment_transaction (id);

ALTER TABLE cart_product ADD FOREIGN KEY (cart_id) REFERENCES  cart (user_id);

ALTER TABLE cart_product ADD FOREIGN KEY (product_id) REFERENCES product(product_id);

ALTER TABLE order_product ADD FOREIGN KEY (order_id) REFERENCES  orders (order_id);

ALTER TABLE order_product ADD FOREIGN KEY  (product_id) REFERENCES product (product_id);