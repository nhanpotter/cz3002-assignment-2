# Group 32 CZ3002 assignment 2

## Installation

- Install Maven (<https://maven.apache.org/install.html>)
- Install Apache Tomcat (<https://www3.ntu.edu.sg/home/ehchua/programming/howto/Tomcat_HowTo.html>)
- Install MySQL (<https://dev.mysql.com/doc/mysql-installation-excerpt/8.0/en/>) 
  and run MySQL server. 

## User Manual

1. Navigate to project root
2. Run these database scripts in the command prompt
- Set up database by creating a user with all privileges and create database 
  named `authentication`. The credentials of the user is:
  - username: `testing` ('testing'@'localhost')
  - password: `password`
    ```shell
    sudo mysql < db_scripts/setup.sql
    ```
- Create table `account` and populate some accounts with username and password.
  You can check (or add more accounts) in the file `db_scripts/populate.sql`.
    ```shell
    sudo mysql < db_scripts/populate.sql
    ```
3. Run tests to make sure everything is correct. If a test fails, maybe you 
haven't started your MySQL server yet.
    ```shell
    mvn test
    ```
4. Start the server
```shell
mvn jetty:run
```
5. Open link <http://localhost:8080/> in your browser to test the app.
