package com.deveficiente.desafiocdc.autor;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	private EntityManager manager;

	public AutorController(EntityManager manager) {
		super();
		this.manager = manager;
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	@Transactional
	public ResponseEntity cadastrarAutor(@RequestBody @Valid AutorForm autorForm) {
		Autor autor = autorForm.toModel();
		manager.persist(autor);
		return ResponseEntity.ok().build();
	}

}
