package com.deveficiente.desafiocdc.autor;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.desafiocdc.validacoes.UniqueValidator;

/**
 * Carga Intrínseca: 3
 * 
 */
@RestController
@RequestMapping("/autores")
public class AutorController {
	
	private EntityManager manager;
	
	/**
	 *  Carga Intrínseca: 0
	 *  
	 */
	public AutorController(EntityManager manager) {
		super();
		this.manager = manager;
	}
	
	/**
	 * Carga Intrínseca: 3
	 * 
	 */
	@InitBinder
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new UniqueValidator<NovoAutorForm>(Autor.class,
				NovoAutorForm.obterPropriedadesUnicas(), this.manager));
	}
	
	/**
	 * 
	 * Carga Intrínseca: 0
	 * 
	 * @param novoAutorForm
	 * @return dados do objeto criado
	 */
	@PostMapping
	@Transactional
	public String cria(@RequestBody @Valid NovoAutorForm novoAutorForm) {
		Autor autor = novoAutorForm.toModel();
		manager.persist(autor);
		return autor.toString();
	}
	
}
