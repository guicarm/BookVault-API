ALTER TABLE t_bv_books
ADD COLUMN author_id BIGINT;

ALTER TABLE t_bv_books
ADD CONSTRAINT fk_author
FOREIGN KEY (author_id) REFERENCES t_bv_authors(id);

-- Atualiza a tabela de livros associando autores específicos aos livros
UPDATE t_bv_books SET author_id = (SELECT id FROM t_bv_authors WHERE name = 'Machado de Assis') WHERE title = 'Dom Casmurro';
UPDATE t_bv_books SET author_id = (SELECT id FROM t_bv_authors WHERE name = 'Gabriel García Márquez') WHERE title = 'Cem Anos de Solidão';
UPDATE t_bv_books SET author_id = (SELECT id FROM t_bv_authors WHERE name = 'Graciliano Ramos') WHERE title = 'Vidas Secas';
UPDATE t_bv_books SET author_id = (SELECT id FROM t_bv_authors WHERE name = 'José Saramago') WHERE title = 'Ensaio sobre a Cegueira';
UPDATE t_bv_books SET author_id = (SELECT id FROM t_bv_authors WHERE name = 'Jorge Amado') WHERE title = 'Gabriela, Cravo e Canela';
UPDATE t_bv_books SET author_id = (SELECT id FROM t_bv_authors WHERE name = 'Mario Vargas Llosa') WHERE title = 'A Cidade e os Cachorros';
UPDATE t_bv_books SET author_id = (SELECT id FROM t_bv_authors WHERE name = 'Clarice Lispector') WHERE title = 'A Hora da Estrela';
UPDATE t_bv_books SET author_id = (SELECT id FROM t_bv_authors WHERE name = 'Fernando Pessoa') WHERE title = 'O Livro do Desassossego';
UPDATE t_bv_books SET author_id = (SELECT id FROM t_bv_authors WHERE name = 'Érico Veríssimo') WHERE title = 'O Tempo e o Vento';
UPDATE t_bv_books SET author_id = (SELECT id FROM t_bv_authors WHERE name = 'Machado de Assis') WHERE title = 'Memórias Póstumas de Brás Cubas';
