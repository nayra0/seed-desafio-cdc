package com.deveficiente.desafiocdc.livro;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 4
public class ListaLivroResponse {

	// CI: 1
	@JsonProperty
	private List<ItemListaLivroResponse> livros;
	
	// CI: 3
	public ListaLivroResponse(List<Livro> livros) {
		this.livros = livros.stream().map(ItemListaLivroResponse::new).collect(Collectors.toList());
	}

}
