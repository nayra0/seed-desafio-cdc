package com.deveficiente.desafiocdc.livro;

import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 1
public class LivroDaListaResponse {
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String titulo;

	// CI: 1
	public LivroDaListaResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

}
