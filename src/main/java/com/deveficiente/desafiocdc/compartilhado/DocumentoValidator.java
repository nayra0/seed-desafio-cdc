package com.deveficiente.desafiocdc.compartilhado;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import com.deveficiente.desafiocdc.compartilhado.anotacoes.CpfOuCnpjValido;

// CI: 1
public class DocumentoValidator implements ConstraintValidator<CpfOuCnpjValido, CharSequence> {

	private CPFValidator cpfValidator = new CPFValidator();;
	private CNPJValidator cnpjValidator = new CNPJValidator();;

	@Override
	public void initialize(CpfOuCnpjValido constraintAnnotation) {
		this.cpfValidator.initialize(null);
		this.cnpjValidator.initialize(null);
	}

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		return cpfValidator.isValid(value, context) || cnpjValidator.isValid(value, context);
	}

}
