package com.deveficiente.desafiocdc.pais;

import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 1
public class NovoPaisResponse {

	@JsonProperty
	private String nome;

	// CI: 1
	public NovoPaisResponse(Pais pais) {
		this.nome = pais.getNome();
	}

}
