package com.deveficiente.desafiocdc.validacoes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

/**
 * Carga intrínseca: 1 
 */
public class ValidationErrorsResponse {

	private List<String> errors;
	private List<FieldErrorResponse> fieldErrors;
	
	public ValidationErrorsResponse() {
		this.errors = new ArrayList<>();
		this.fieldErrors = new ArrayList<>();
	}

	public boolean addError(String error) {
		Assert.notNull(this.errors, "Errors não deve ser nulo");
		return this.errors.add(error);
	}
	
	/**
	 * Carga intrínseca: 1 
	 */
	public boolean addFieldError(String field, String message) {
		Assert.notNull(this.errors, "FieldErrors não deve ser nulo");
		return this.fieldErrors.add(new FieldErrorResponse(field, message));
	}
	
	public List<String> getErrors() {
		return errors;
	}
	
	public List<FieldErrorResponse> getFieldErrors() {
		return fieldErrors;
	}

}
