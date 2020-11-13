package com.deveficiente.desafiocdc.validacoes;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import com.deveficiente.desafiocdc.anotacoes.Unique;

/**
 * Carga Intrínseca: 2 
 *
 */
public class UniqueConstraintValidator implements ConstraintValidator<Unique, Object> {

	private EntityManager manager;
	private Unique unique;
	
	public UniqueConstraintValidator(EntityManager manager) {
		super();
		this.manager = manager;
	}

	/**
	 * Carga Intrínseca: 1
	 */
	@Override
	public void initialize(Unique constraintAnnotation) {
		this.unique = constraintAnnotation;
	}

	/**
	 * Carga Intrínseca: 1
	 * 
	 */
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		Assert.notNull(this.manager, "O entityManager não deve ser nulo");
		
		if (value == null)
            return true;
		
		String jpql = String.format("select count(*) = 0 from %s where %s = '%s'",
				this.unique.entidade().getName(), this.unique.propriedade(), value);
		Query query = this.manager.createQuery(jpql);
		
		return (boolean) query.getSingleResult();
	}

}
