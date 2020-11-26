INSERT INTO categoria (nome) VALUES ('categoria1');
INSERT INTO autor (nome, email, descricao) VALUES ('autor1', 'autor1@email.com', 'descrição');
INSERT INTO livro (titulo, quantidade_paginas, isbn, resumo, preco, data_publicacao, sumario,
	id_categoria, id_autor) 
	VALUES ('livro1', 101, '1', 'resumo1', 120.0, {ts '2012-09-17 18:47:52.69'}, 'sumario1', 1, 1);