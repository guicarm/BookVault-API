CREATE TABLE t_bv_users (
    id bigint auto_increment,
    username varchar(255),
    password varchar(255),
    email varchar(255),
    primary key (id)

);

INSERT INTO t_bv_users (username, password, email) 
VALUES ('ganx', 'darksouls', 'ganx@gmail.com');

INSERT INTO t_bv_users (username, password, email) 
VALUES ('mathabes', 'esponja', 'mathabes@hotmail.com');

INSERT INTO t_bv_users (username, password, email) 
VALUES ('godoi', 'barretao', 'godoi@outlook.com');
