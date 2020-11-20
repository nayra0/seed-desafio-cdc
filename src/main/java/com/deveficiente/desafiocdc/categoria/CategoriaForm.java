package com.deveficiente.desafiocdc.categoria;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaForm {
	
	@NotNull
	private Long id;

	@JsonCreator
	public CategoriaForm(Long id) {
		super();
		this.id = id;
	}

	public Categoria toModel(EntityManager manager) {
		return manager.find(Categoria.class, this.id);
	}
	
}
