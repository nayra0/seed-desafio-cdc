package com.deveficiente.desafiocdc.livro;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 4
public class ListaDeLivrosResponse {

	// CI: 1
	@JsonProperty
	private List<LivroDaListaResponse> livros;
	
	// CI: 3
	public ListaDeLivrosResponse(List<Livro> livros) {
		this.livros = livros.stream().map(LivroDaListaResponse::new).collect(Collectors.toList());
	}

}
