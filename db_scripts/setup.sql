CREATE USER IF NOT EXISTS 'testing'@'localhost' IDENTIFIED BY 'password';
GRANT ALL ON *.* TO 'testing'@'localhost';
CREATE DATABASE IF NOT EXISTS authentication;
