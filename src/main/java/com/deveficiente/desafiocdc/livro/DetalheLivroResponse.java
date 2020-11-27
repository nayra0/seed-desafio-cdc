package com.deveficiente.desafiocdc.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 2
public class DetalheLivroResponse {

	@JsonProperty
	private String titulo;

	@JsonProperty
	private String resumo;

	@JsonProperty
	private BigDecimal preco;

	@JsonProperty
	private long quantidadePaginas;

	@JsonProperty
	private String isbn;

	@JsonProperty
	private LocalDate dataPublicacao;

	@JsonProperty
	private DetalheAutorResponse autor;

	// CI: 2
	public DetalheLivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.preco = livro.getPreco();
		this.quantidadePaginas = livro.getQuantidadePaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.autor = new DetalheAutorResponse(livro.getAutor());
	}

}
