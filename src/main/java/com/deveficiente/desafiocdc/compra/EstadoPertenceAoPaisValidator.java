package com.deveficiente.desafiocdc.compra;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.deveficiente.desafiocdc.estado.Estado;
import com.deveficiente.desafiocdc.pais.Pais;

// CI: 5
@Component
public class EstadoPertenceAoPaisValidator implements Validator {

	private EntityManager manager;

	public EstadoPertenceAoPaisValidator() {
		super();
	}

	public EstadoPertenceAoPaisValidator(EntityManager manager) {
		super();
		this.manager = manager;
	}

	// CI: 1
	@Override
	public boolean supports(Class<?> clazz) {
		return NovaCompraForm.class.isAssignableFrom(clazz);
	}

	// CI: 4
	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		NovaCompraForm novaCompraForm = (NovaCompraForm) target;
		Pais pais = this.manager.find(Pais.class, novaCompraForm.getIdPais());
		Estado estado = this.manager.find(Estado.class, novaCompraForm.getIdEstado());
		
		if(!estado.pertenceAoPais(pais)) {
			errors.reject("idEstado", null, "O estado não pertence ao país informado");
		}

	}

}
