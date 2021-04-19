USE salesman;

CREATE TABLE product (
   product_id INT NOT NULL AUTO_INCREMENT,
   product_name VARCHAR(30) NOT NULL,
   product_price double NOT NULL,
   product_stock INT NOT NULL,
   PRIMARY KEY (product_id)
);
