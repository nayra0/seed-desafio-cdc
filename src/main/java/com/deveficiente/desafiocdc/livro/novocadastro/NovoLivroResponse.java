package com.deveficiente.desafiocdc.livro.novocadastro;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.deveficiente.desafiocdc.livro.Livro;
import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 1
public class NovoLivroResponse {

	@JsonProperty
	private Long id;

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
	private Long idCategoria;

	@JsonProperty
	private Long idAutor;

	// CI: 1
	public NovoLivroResponse(Livro novoLivro) {
		this.id = novoLivro.getId();
		this.titulo = novoLivro.getTitulo();
		this.resumo = novoLivro.getResumo();
		this.preco = novoLivro.getPreco();
		this.quantidadePaginas = novoLivro.getQuantidadePaginas();
		this.isbn = novoLivro.getIsbn();
		this.dataPublicacao = novoLivro.getDataPublicacao();
		this.idCategoria = novoLivro.getCategoria().getId();
		this.idAutor = novoLivro.getAutor().getId();
	}

}
