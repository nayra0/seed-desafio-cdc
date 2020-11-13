package com.deveficiente.desafiocdc.validacoes;

import java.util.HashMap;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Carga Intrínseca: 3 
 */
public class UniqueValidator<T> implements Validator {
	
	private HashMap<String, Function<T, String>> propriedadesUnicas;
	private EntityManager manager;
	private Class<?> clazz;

	/**
	 * Carga Intrínseca: 0 
	 */
	public UniqueValidator(Class<?> clazz, HashMap<String,Function<T,String>> propriedadesUnicas, EntityManager manager) {
		this.clazz = clazz;
		this.propriedadesUnicas = propriedadesUnicas;
		this.manager = manager;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	/**
	 * Carga Intrínseca: 3
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		Assert.notNull(this.manager, "O entityManager não pode ser nulo.");
		Assert.notNull(this.propriedadesUnicas, "O map propriedadesUnicas não deve ser nulo.");
		
		for (String propriedade : this.propriedadesUnicas.keySet()) {
			
			String valorCampo = this.propriedadesUnicas.get(propriedade).apply((T) target);
			
			String hql = String.format("select count(*) > 0 from %s where %s = '%s'"
					, this.clazz.getName(), propriedade, valorCampo);
			Query query = this.manager.createQuery(hql);
			
			boolean possuiEmailCadastrado = (boolean) query.getSingleResult();
			
			if(possuiEmailCadastrado) {
				errors.rejectValue(propriedade, null, String.format("Já existe um(a) registro cadastrado com o valor %s.", valorCampo));
			}
			
		}

	}

}
