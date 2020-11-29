package com.deveficiente.desafiocdc.pais;

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
@RequestMapping("paises")
public class PaisController {
	
	private EntityManager manager;
	private MessageSource messageSource;

	public PaisController(EntityManager manager, MessageSource messageSource) {
		this.manager = manager;
		this.messageSource = messageSource;
	}
	
	// CI: 3
	@InitBinder
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new UniqueValidator<NovoPaisForm>(Pais.class, this.manager, this.messageSource));
	}

	// CI: 1
	@Transactional
	@PostMapping
	public ResponseEntity<NovoPaisResponse> criar(@RequestBody @Valid NovoPaisForm form) {
		Pais pais = form.toModel();
		this.manager.persist(pais);
		
		return ResponseEntity.ok(new NovoPaisResponse(pais));
	}

}
