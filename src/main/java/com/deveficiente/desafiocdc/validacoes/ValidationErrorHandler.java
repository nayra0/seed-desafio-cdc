package com.deveficiente.desafiocdc.validacoes;

import javax.validation.ValidationException;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// CI: 3
@RestControllerAdvice
public class ValidationErrorHandler {

	private MessageSource messageSource;

	public ValidationErrorHandler(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	// CI: 1
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ValidationErrorsResponse handleValidationError(MethodArgumentNotValidException exception) {
		return buildValidationErrors(exception.getBindingResult());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public ValidationErrorsResponse handleValidationError(BindException exception) {
		return buildValidationErrors(exception.getBindingResult());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ValidationException.class)
	public ValidationErrorsResponse handleValidationError(ValidationException exception) {
		ValidationErrorsResponse validationErrors = new ValidationErrorsResponse();
		String mensagemErroValidacao = messageSource.getMessage("validation.error", null, LocaleContextHolder.getLocale());
		validationErrors.addError(mensagemErroValidacao  + ". " + exception.getLocalizedMessage());

		return validationErrors;
	}

	// CI: 2
	private ValidationErrorsResponse buildValidationErrors(BindingResult bindingResult) {

		ValidationErrorsResponse validationErrors = new ValidationErrorsResponse();

		bindingResult.getGlobalErrors().forEach(error -> validationErrors.addError(getErrorMessage(error)));

		bindingResult.getFieldErrors().forEach(error -> {
			String message = getErrorMessage(error);
			validationErrors.addFieldError(error.getField(), message);

		});

		return validationErrors;
	}

	private String getErrorMessage(ObjectError error) {
		return messageSource.getMessage(error, LocaleContextHolder.getLocale());
	}

}
