package com.deveficiente.desafiocdc.compartilhado;

import java.util.HashMap;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

// CI: 4

// CI: 1
public class UniqueValidator<T extends UniqueProperties> implements Validator {

	private static final String UNIQUE_VALIDATION_CODE = "validation.unique";
	private EntityManager manager;
	private Class<?> clazz;
	private MessageSource messageSource;

	public UniqueValidator(Class<?> clazz, EntityManager manager, MessageSource messageSource) {
		this.clazz = clazz;
		this.manager = manager;
		this.messageSource = messageSource;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	// CI: 3
	@SuppressWarnings("unchecked")
	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		Assert.notNull(this.clazz, "clazz não pode ser nulo.");
		Assert.notNull(this.manager, "manager não pode ser nulo.");
		Assert.notNull(this.messageSource, "messageSource não pode ser nulo.");

		T objetoParaValidar = (T) target;
		HashMap<String, Function<T, String>> propriedadesUnicas = objetoParaValidar.obterPropriedadesUnicas();

		for (String propriedade : propriedadesUnicas.keySet()) {

			String valorCampo = propriedadesUnicas.get(propriedade).apply(objetoParaValidar);
			if (possuiValorCadastrado(propriedade, valorCampo)) {
				String[] errorArgs = new String[] { valorCampo, getNomeCampo(propriedade) };
				errors.rejectValue(propriedade, UNIQUE_VALIDATION_CODE, errorArgs, null);
			}
		}
	}

	private boolean possuiValorCadastrado(String propriedade, String valorCampo) {
		Assert.notNull(propriedade, "propriedade não pode ser nulo");
		Assert.notNull(valorCampo, "valorCampo não pode ser nulo");

		String hql = String.format("select count(*) > 0 from %s where %s = '%s'", this.clazz.getName(), propriedade,
				valorCampo);
		Query query = this.manager.createQuery(hql);

		return (boolean) query.getSingleResult();
	}

	private String getNomeCampo(String propriedade) {
		Assert.notNull(propriedade, "propriedade não pode ser nulo");
		return this.messageSource.getMessage(propriedade, null, LocaleContextHolder.getLocale());
	}

}
