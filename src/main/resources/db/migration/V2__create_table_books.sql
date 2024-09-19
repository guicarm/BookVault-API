CREATE TABLE t_bv_books (
    id bigint auto_increment,
    title varchar(255),
    releaseYear INT,
    genre varchar(255),
    primary key (id)

);

INSERT INTO t_bv_books (title, releaseYear, genre) 
VALUES ('Dom Casmurro', 1899, 'Romance');

INSERT INTO t_bv_books (title, releaseYear, genre) 
VALUES ('Cem Anos de Solidão', 1967, 'Realismo Mágico');

INSERT INTO t_bv_books (title, releaseYear, genre) 
VALUES ('Vidas Secas', 1938, 'Ficção Social');

INSERT INTO t_bv_books (title, releaseYear, genre) 
VALUES ('Ensaio sobre a Cegueira', 1995, 'Ficção');

INSERT INTO t_bv_books (title, releaseYear, genre) 
VALUES ('Gabriela, Cravo e Canela', 1958, 'Romance');

INSERT INTO t_bv_books (title, releaseYear, genre) 
VALUES ('A Cidade e os Cachorros', 1963, 'Romance');

INSERT INTO t_bv_books (title, releaseYear, genre) 
VALUES ('A Hora da Estrela', 1977, 'Romance');

INSERT INTO t_bv_books (title, releaseYear, genre) 
VALUES ('O Livro do Desassossego', 1982, 'Prosa Poética');

INSERT INTO t_bv_books (title, releaseYear, genre) 
VALUES ('O Tempo e o Vento', 1949, 'Romance Histórico');

INSERT INTO t_bv_books (title, releaseYear, genre) 
VALUES ('Memórias Póstumas de Brás Cubas', 1881, 'Romance');
