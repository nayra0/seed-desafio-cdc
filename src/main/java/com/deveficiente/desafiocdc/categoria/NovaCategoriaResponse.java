package com.deveficiente.desafiocdc.categoria;

import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 1
public class NovaCategoriaResponse {
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String nome;
	
	// CI: 1
	public NovaCategoriaResponse(Categoria novaCategoria) {
		this.id = novaCategoria.getId();
		this.nome = novaCategoria.getNome();
	}

}
