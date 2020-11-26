package com.deveficiente.desafiocdc.autor;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 1
public class NovoAutorResponse {

	@JsonProperty
	private Long id;

	@JsonProperty
	private String nome;

	@JsonProperty
	private String email;

	@JsonProperty
	private String descricao;

	@JsonProperty
	private LocalDateTime dataCriacao;

	// CI: 1
	public NovoAutorResponse(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
		this.dataCriacao = autor.getDataCriacao();
	}

}
