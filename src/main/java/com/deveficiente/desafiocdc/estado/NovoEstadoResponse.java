package com.deveficiente.desafiocdc.estado;

import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 1
public class NovoEstadoResponse {
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String nome;
	
	@JsonProperty
	private Long idPais; 

	// CI: 1
	public NovoEstadoResponse(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.idPais = estado.getPais().getId();
	}

}
