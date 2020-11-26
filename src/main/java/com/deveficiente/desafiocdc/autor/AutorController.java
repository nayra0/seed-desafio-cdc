package com.deveficiente.desafiocdc.autor;

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
@RequestMapping("/autores")
public class AutorController {

	private EntityManager manager;
	private MessageSource messageSource;

	public AutorController(EntityManager manager, MessageSource messageSource) {
		super();
		this.manager = manager;
		this.messageSource = messageSource;
	}

	// CI: 3
	@InitBinder
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new UniqueValidator<NovoAutorForm>(Autor.class, this.manager, this.messageSource));
	}

	// 1
	@PostMapping
	@Transactional
	public ResponseEntity<NovoAutorResponse> cria(@RequestBody @Valid NovoAutorForm form) {
		Autor novoAutor = form.toModel();
		manager.persist(novoAutor);
		return ResponseEntity.ok(new NovoAutorResponse(novoAutor));
	}

}
