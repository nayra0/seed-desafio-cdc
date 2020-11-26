package com.deveficiente.desafiocdc.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.function.Function;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.deveficiente.desafiocdc.autor.Autor;
import com.deveficiente.desafiocdc.categoria.Categoria;
import com.deveficiente.desafiocdc.compartilhado.UniqueProperties;
import com.deveficiente.desafiocdc.compartilhado.anotacoes.IdCadastrado;
import com.fasterxml.jackson.annotation.JsonProperty;

// CI: 3
public class NovoLivroForm implements UniqueProperties {

	@NotBlank
	@JsonProperty
	private String titulo;

	@NotBlank
	@Size(max = 500)
	@JsonProperty
	private String resumo;

	@Column(columnDefinition = "text")
	@JsonProperty
	private String sumario;

	@NotNull
	@DecimalMin(value = "20.0")
	@JsonProperty
	private BigDecimal preco;

	@NotNull
	@Min(value = 100)
	@JsonProperty
	private long quantidadePaginas;

	@NotBlank
	@JsonProperty
	private String isbn;

	@NotNull
	@Future
	@JsonProperty
	private LocalDate dataPublicacao;

	@IdCadastrado(entidade = Categoria.class)
	@NotNull
	@JsonProperty
	private Long idCategoria;

	@IdCadastrado(entidade = Autor.class)
	@NotNull
	@JsonProperty
	private Long idAutor;

	// CI: 3
	public Livro toModel(EntityManager manager) {
		Categoria categoria = manager.find(Categoria.class, this.idCategoria);
		Autor autor = manager.find(Autor.class, this.idAutor);

		return new Livro(titulo, resumo, sumario, preco, quantidadePaginas, isbn, dataPublicacao, categoria, autor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Function<NovoLivroForm, String>> obterPropriedadesUnicas() {
		HashMap<String, Function<NovoLivroForm, String>> propriedadesUnicas = new HashMap<>();
		propriedadesUnicas.put("titulo", NovoLivroForm::getTitulo);
		propriedadesUnicas.put("isbn", NovoLivroForm::getIsbn);
		return propriedadesUnicas;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

}
