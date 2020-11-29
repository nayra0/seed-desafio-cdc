package com.deveficiente.desafiocdc.compra;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// CI: 2
@RestController
@RequestMapping("/pagamento")
public class NovaCompraController {

	private EntityManager manager;

	public NovaCompraController(EntityManager manager) {
		super();
		this.manager = manager;
	}
	
	// CI: 1
	@InitBinder
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new EstadoPertenceAoPaisValidator(this.manager));
	}

	// CI: 1
	@PostMapping
	public void pagar(@RequestBody @Valid NovaCompraForm form) {
	}

}
