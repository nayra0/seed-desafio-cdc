package com.deveficiente.desafiocdc.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.deveficiente.desafiocdc.autor.Autor;
import com.deveficiente.desafiocdc.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String titulo;

	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@Column(columnDefinition = "text")
	@JsonProperty
	private String sumario;

	@NotNull
	@DecimalMin("20.0")
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private long quantidadePaginas;

	@NotBlank
	private String isbn;

	@NotNull
	@Future
	private LocalDate dataPublicacao;

	@NotNull
	@OneToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@NotNull
	@OneToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;
	
	@Deprecated
	public Livro() {
		super();
	}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @DecimalMin("20.0") BigDecimal preco, @NotNull @Min(100) long quantidadePaginas,
			@NotBlank String isbn, @NotNull @Future LocalDate dataPublicacao, Categoria categoria, Autor autor) {

		Assert.notNull(titulo, "titulo não pode ser nulo");
		Assert.notNull(resumo, "resumo não pode ser nulo");
		Assert.notNull(preco, "preco não pode ser nulo");
		Assert.notNull(isbn, "isbn não pode ser nulo");
		Assert.notNull(dataPublicacao, "dataPublicacao não pode ser nulo");

		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.quantidadePaginas = quantidadePaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public long getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public void setQuantidadePaginas(long quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
