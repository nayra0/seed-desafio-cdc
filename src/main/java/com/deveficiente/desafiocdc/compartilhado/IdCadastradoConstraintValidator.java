package com.deveficiente.desafiocdc.compartilhado;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import com.deveficiente.desafiocdc.compartilhado.anotacoes.IdCadastrado;

// CI: 2
public class IdCadastradoConstraintValidator implements ConstraintValidator<IdCadastrado, Object> {

	private EntityManager manager;
	private IdCadastrado idCadastrado;
	
	public IdCadastradoConstraintValidator(EntityManager manager) {
		super();
		this.manager = manager;
	}

	// CI: 1
	@Override
	public void initialize(IdCadastrado constraintAnnotation) {
		this.idCadastrado = constraintAnnotation;
	}

	// CI: 1
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Assert.notNull(this.manager, "O entityManager não deve ser nulo");
		
		if(value == null) {
			return true;
		}
		
		Object registro = manager.find(this.idCadastrado.entidade(), value);
		return registro != null;
	}

}
