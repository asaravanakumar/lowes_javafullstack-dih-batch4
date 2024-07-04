CREATE TABLE dihtraining.order (
  id INT NOT NULL AUTO_INCREMENT,
  description TEXT NULL,
  category VARCHAR(25) NULL,
  quantity INT NULL,
  price DOUBLE NULL,
  PRIMARY KEY (id));


INSERT INTO dihtraining.order (description, category, quantity, price) VALUES ('Lenovo Thinkpad Laptop', 'Laptop', '10', '75000');
INSERT INTO dihtraining.order (description, category, quantity, price) VALUES ('Samsung Galaxy M50', 'SmartPhone', '10', '25000');
INSERT INTO dihtraining.order (description, category, quantity, price) VALUES ('Samsung Galaxy S24', 'SmartPhone', '2', '75000');
INSERT INTO dihtraining.order (description, category, quantity, price) VALUES ('HP Pavilion', 'Laptop', '5', '70000');
INSERT INTO dihtraining.order (description, category, quantity, price) VALUES ('Sony Bravia', 'SmartTv', '10', '90000');
INSERT INTO dihtraining.order (description, category, quantity, price) VALUES ('LG OLED', 'SmartTv', '3', '95000');
INSERT INTO dihtraining.order (description, category, quantity, price) VALUES ('MacBook Pro', 'Laptop', '3', '175000');
INSERT INTO dihtraining.order (description, category, quantity, price) VALUES ('OnePlus Nord', 'SmartPhone', '7', '30000');


UPDATE dihtraining.order SET quantity=15, category='Phones' WHERE id=2;

DELETE FROM dihtraining.order WHERE id=2;

SELECT * FROM dihtraining.order;

DROP TABLE dihtraining.order;

DROP SCHEMA dihtraining;