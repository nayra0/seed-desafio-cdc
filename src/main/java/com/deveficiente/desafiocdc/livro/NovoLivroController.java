package com.deveficiente.desafiocdc.livro;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deveficiente.desafiocdc.compartilhado.UniqueValidator;

// CI: 4
@RestController
@RequestMapping("/livros")
public class NovoLivroController {

	private EntityManager manager;
	private MessageSource messageSource;

	public NovoLivroController(EntityManager manager, MessageSource messageSource) {
		super();
		this.manager = manager;
		this.messageSource = messageSource;
	}

	// CI: 3
	@InitBinder
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new UniqueValidator<NovoLivroForm>(Livro.class, this.manager, this.messageSource));
	}

	// CI: 1
	@Transactional
	@PostMapping
	public ResponseEntity<NovoLivroResponse> cria(@RequestBody @Valid NovoLivroForm form) {
		Livro novoLivro = form.toModel(this.manager);
		this.manager.persist(novoLivro);
		return ResponseEntity.ok(new NovoLivroResponse(novoLivro));
	}

}
