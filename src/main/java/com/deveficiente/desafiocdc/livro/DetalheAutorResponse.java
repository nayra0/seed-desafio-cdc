package com.deveficiente.desafiocdc.livro;

import com.deveficiente.desafiocdc.autor.Autor;
import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 1
public class DetalheAutorResponse {

	@JsonProperty
	private String nome;

	@JsonProperty
	private String descricao;

	// CI: 1
	public DetalheAutorResponse(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

}
