package com.deveficiente.desafiocdc.estado;

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

@RestController
@RequestMapping("estados")
public class EstadoController {
	
	private MessageSource messageSource;
	private EntityManager manager;

	public EstadoController(EntityManager manager, MessageSource messageSource) {
		super();
		this.manager = manager;
		this.messageSource = messageSource;
	}
	
	@InitBinder
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new UniqueValidator<NovoEstadoForm>(Estado.class, this.manager, this.messageSource));
	}

	@Transactional
	@PostMapping
	public ResponseEntity<NovoEstadoResponse> cria(@RequestBody @Valid NovoEstadoForm form){
		Estado estado = form.toModel(this.manager);
		this.manager.persist(estado);
		return ResponseEntity.ok(new NovoEstadoResponse(estado));
	}

}
