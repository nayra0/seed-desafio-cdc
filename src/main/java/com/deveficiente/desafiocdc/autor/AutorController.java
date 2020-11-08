package com.deveficiente.desafiocdc.autor;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Carga Intrínseca: 2
 * 
 * @author nayra
 *
 */
@RestController
@RequestMapping("/autores")
public class AutorController {
	
	private EntityManager manager;

	public AutorController(EntityManager manager) {
		super();
		this.manager = manager;
	}

	/**
	 * 
	 *  Carga Intrínseca: 2
	 * 
	 * @param autorForm
	 * @return dados do objeto criado
	 */
	@PostMapping
	@Transactional
	public String cria(@RequestBody @Valid AutorForm autorForm) {
		Autor autor = autorForm.toModel();
		manager.persist(autor);
		return autor.toString();
	}

}
