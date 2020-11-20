package com.deveficiente.desafiocdc.livro;

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

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	private EntityManager manager;
	private MessageSource messageSource;

	public LivroController(EntityManager manager, MessageSource messageSource) {
		super();
		this.manager = manager;
		this.messageSource = messageSource;
	}
	
	@InitBinder
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new UniqueValidator<>(Livro.class, this.manager, this.messageSource));
	}

	@Transactional
	@PostMapping
	public String cria(@RequestBody @Valid NovoLivroForm form) {
		Livro novoLivro  = form.toModel(this.manager);
		this.manager.persist(novoLivro);
		return novoLivro.toString();
	}

}
