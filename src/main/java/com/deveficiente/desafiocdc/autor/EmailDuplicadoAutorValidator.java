package com.deveficiente.desafiocdc.autor;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Carga Intrínseca: 5
 * 
 */
@Component
public class EmailDuplicadoAutorValidator implements Validator {
	
	private AutorRepository autorRepository;

	/**
	 * Carga Intrínseca: 1
	 * 
	 * @param autorRepository
	 */
	public EmailDuplicadoAutorValidator(AutorRepository autorRepository) {
		super();
		this.autorRepository = autorRepository;
	}

	/**
	 * Carga Intrínseca: 1
	 * 
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoAutorForm.class.isAssignableFrom(clazz);
	}

	/**
	 * Carga Intrínseca: 3
	 * 
	 */
	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		NovoAutorForm novoAutorForm = (NovoAutorForm) target;
		Optional<Autor> possivelAutor = autorRepository.findByEmail(novoAutorForm.getEmail());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe um autor cadastrado com o e-mail: " + novoAutorForm.getEmail());
		}

	}

}
