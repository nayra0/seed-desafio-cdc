package com.deveficiente.desafiocdc.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
//	@NotNull
	@OneToOne
	private Categoria categoria;
	
//	@NotNull
	@OneToOne
	private Autor autor;

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
			@NotNull @DecimalMin("20.0") BigDecimal preco, @NotNull @Min(100) long quantidadePaginas,
			@NotBlank String isbn, @NotNull @Future LocalDate dataPublicacao, Categoria categoria, Autor autor) {
		
		Assert.notNull(titulo, "titulo não pode ser nulo");
		Assert.notNull(resumo, "resumo não pode ser nulo");
		Assert.notNull(preco, "preco não pode ser nulo");
		Assert.notNull(isbn, "isbn não pode ser nulo");
//		Assert.notNull(dataPublicacao, "dataPublicacao não pode ser nulo");
		
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.quantidadePaginas = quantidadePaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", preco=" + preco
				+ ", quantidadePaginas=" + quantidadePaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", categoria=" + categoria + ", autor=" + autor + "]";
	}
	
}
