package com.deveficiente.desafiocdc.livro;

import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 1
public class ItemListaLivroResponse {
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String titulo;

	// CI: 1
	public ItemListaLivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

}
