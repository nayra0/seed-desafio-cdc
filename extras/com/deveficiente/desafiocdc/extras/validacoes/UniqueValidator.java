package com.deveficiente.desafiocdc.extras.validacoes;

import java.util.HashMap;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Carga Intrínseca: 3
 */
public class UniqueValidator<T> implements Validator {

	private static final String UNIQUE_VALIDATION_CODE = "validation.unique";
	private HashMap<String, Function<T, String>> propriedadesUnicas;
	private EntityManager manager;
	private Class<?> clazz;
	private MessageSource messageSource;

	public UniqueValidator(Class<?> clazz, HashMap<String, Function<T, String>> propriedadesUnicas,
			EntityManager manager, MessageSource messageSource) {
		this.clazz = clazz;
		this.propriedadesUnicas = propriedadesUnicas;
		this.manager = manager;
		this.messageSource = messageSource;
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
		if (errors.hasErrors()) {
			return;
		}

		Assert.notNull(this.clazz, "clazz não pode ser nulo.");
		Assert.notNull(this.propriedadesUnicas, "O map propriedadesUnicas não deve ser nulo.");
		Assert.notNull(this.manager, "manager não pode ser nulo.");
		Assert.notNull(this.messageSource, "messageSource não pode ser nulo.");

		for (String propriedade : this.propriedadesUnicas.keySet()) {

			String valorCampo = this.propriedadesUnicas.get(propriedade).apply((T) target);
			if (possuiValorCadastrado(propriedade, valorCampo)) {
				String[] errorArgs = new String[] { valorCampo, getNomeCampo(propriedade) };
				errors.rejectValue(propriedade, UNIQUE_VALIDATION_CODE, errorArgs, null);
			}
		}
	}

	private boolean possuiValorCadastrado(String propriedade, String valorCampo) {
		String hql = String.format("select count(*) > 0 from %s where %s = '%s'", this.clazz.getName(), propriedade,
				valorCampo);
		Query query = this.manager.createQuery(hql);

		return (boolean) query.getSingleResult();
	}

	private String getNomeCampo(String propriedade) {
		return this.messageSource.getMessage(propriedade, null, LocaleContextHolder.getLocale());
	}

}
