package com.deveficiente.desafiocdc.autor;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;

public class AutorForm {

	@NotNull
	private Long id;

	@JsonCreator
	public AutorForm(@NotNull Long id) {
		super();
		this.id = id;
	}

	public Autor toModel(EntityManager manager) {
		return manager.find(Autor.class, this.id);
	}
	
}
