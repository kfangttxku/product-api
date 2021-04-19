USE salesman;

CREATE TABLE product (
   product_id INT NOT NULL AUTO_INCREMENT,
   product_name VARCHAR(30) NOT NULL,
   product_unit VARCHAR(30) NOT NULL,
   product_price VARCHAR(10) NOT NULL,
   PRIMARY KEY (product_id)
);