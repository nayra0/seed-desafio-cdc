package com.deveficiente.desafiocdc.livro;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 4
public class ItemLivroResponse {

	// CI: 1
	@JsonProperty
	private List<LivroDaListaResponse> livros;
	
	// CI: 3
	public ItemLivroResponse(List<Livro> livros) {
		this.livros = livros.stream().map(LivroDaListaResponse::new).collect(Collectors.toList());
	}

}
