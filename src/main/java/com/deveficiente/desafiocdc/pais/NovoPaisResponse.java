package com.deveficiente.desafiocdc.pais;

import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 1
public class NovoPaisResponse {
	
	@JsonProperty
	private Long id;

	@JsonProperty
	private String nome;

	// CI: 1
	public NovoPaisResponse(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

}
