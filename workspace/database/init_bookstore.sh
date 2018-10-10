#!/bin/sh

MYSQL_CMD="mysql -u guest -pguest bookstore"

# CREATE TABLES
$MYSQL_CMD -e "CREATE TABLE IF NOT EXISTS items (item_id INT PRIMARY KEY, item_name VARCHAR(255), price INT, picture VARCHAR(255), release_date DATE, prc_date DATE) ENGINE = InnoDB DEFAULT CHARSET = utf8;"
$MYSQL_CMD -e "CREATE TABLE IF NOT EXISTS stocks (item_id INT PRIMARY KEY, stock INT, prc_date DATE) ENGINE = InnoDB DEFAULT CHARSET = utf8;"
$MYSQL_CMD -e "CREATE TABLE IF NOT EXISTS order_headers (order_header_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, total_amount INT, customer_name VARCHAR(255), customer_address VARCHAR(255), order_date DATE, prc_date DATE) ENGINE = InnoDB DEFAULT CHARSET = utf8;"
$MYSQL_CMD -e "CREATE TABLE IF NOT EXISTS order_details (order_header_id INT, item_id INT, amount INT, prc_date DATE) ENGINE = InnoDB DEFAULT CHARSET = utf8;"
$MYSQL_CMD -e "CREATE TABLE IF NOT EXISTS cart_items (user_id VARCHAR(255), item_id INT, amount INT, prc_date DATE) ENGINE = InnoDB DEFAULT CHARSET = utf8;"

# CREATE SEQUENCE
$MYSQL_CMD -e "CREATE TABLE IF NOT EXISTS sequence (id INT NOT NULL);"

# DELETE RECORDS
$MYSQL_CMD -e "DELETE FROM cart_items;"
# $MYSQL_CMD -e "DELETE FROM items;"
$MYSQL_CMD -e "DELETE FROM order_details;"
$MYSQL_CMD -e "DELETE FROM order_headers;"
$MYSQL_CMD -e "DELETE FROM stocks;"

# RESET SEQUENCE
$MYSQL_CMD -e "DELETE FROM sequence;"
$MYSQL_CMD -e "INSERT INTO sequence VALUES (0);"

# INSERT DEMO DATA
# $MYSQL_CMD -e "INSERT INTO items (ITEM_ID,ITEM_NAME,PRICE,PICTURE,RELEASE_DATE,PRC_DATE) VALUES (1, 'パーフェクトJava', 3456, '/images/9784774139906.jpg',  '2009-09-24', curdate());"
# $MYSQL_CMD -e "INSERT INTO items (ITEM_ID,ITEM_NAME,PRICE,PICTURE,RELEASE_DATE,PRC_DATE) VALUES (2, 'パーフェクトPython', 3456, '/images/TH160_9784774155395.jpg',  '2013-03-05', curdate());"
$MYSQL_CMD -e "INSERT INTO stocks (ITEM_ID,STOCK,PRC_DATE) VALUES (1, 20, curdate());"
$MYSQL_CMD -e "INSERT INTO stocks (ITEM_ID,STOCK,PRC_DATE) VALUES (2, 8, curdate());"
