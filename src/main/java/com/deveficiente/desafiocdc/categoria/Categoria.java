package com.deveficiente.desafiocdc.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.util.Assert;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Deprecated
	public Categoria() {
		super();
	}

	public Categoria(@NotBlank String nome) {
		super();
		
		Assert.notNull(nome, "nome não pode ser nulo");
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
