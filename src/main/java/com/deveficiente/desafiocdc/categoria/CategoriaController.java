package com.deveficiente.desafiocdc.categoria;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.desafiocdc.compartilhado.UniqueValidator;

/**
 * Carga Intrínseca: 3
 * 
 */
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private EntityManager manager;
	private MessageSource messageSource;

	public CategoriaController(EntityManager manager, MessageSource messageSource) {
		super();
		this.manager = manager;
		this.messageSource = messageSource;
	}

	/**
	 * Carga Intrínseca: 3
	 * 
	 */
	@InitBinder
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(
				new UniqueValidator<NovaCategoriaForm>(Categoria.class, this.manager, this.messageSource));
	}

	@PostMapping
	@Transactional
	public String cria(@RequestBody @Valid NovaCategoriaForm form) {
		Categoria novaCategoria = form.toModel();
		this.manager.persist(novaCategoria);
		return novaCategoria.toString();
	}

}
