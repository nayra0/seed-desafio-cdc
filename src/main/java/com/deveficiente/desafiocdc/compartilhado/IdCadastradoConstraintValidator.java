package com.deveficiente.desafiocdc.compartilhado;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import com.deveficiente.desafiocdc.compartilhado.anotacoes.IdCadastrado;

// CI: 1
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

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Assert.notNull(this.manager, "O entityManager não deve ser nulo");
		
		Object registro = manager.find(this.idCadastrado.entidade(), value);
		return registro != null;
	}

}
