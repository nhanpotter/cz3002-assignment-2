USE authentication;
CREATE TABLE IF NOT EXISTS account (
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (username)
);

INSERT INTO account (username, password)
VALUES ROW('nhan', 'awesome'),
       ROW('user1', 'password1'),
       ROW('user2', 'password2'),
       ROW('user3', 'password3'),
       ROW('user4', 'password4'),
       ROW('user5', 'password5'),
       ROW('user6', 'password6'),
       ROW('user7', 'password7'),
       ROW('user8', 'password8')
;


