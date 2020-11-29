package com.deveficiente.desafiocdc.compartilhado.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.deveficiente.desafiocdc.compartilhado.DocumentoValidator;

// CI: 1
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = DocumentoValidator.class)
public @interface CpfOuCnpjValido {

	String message() default "{documento.not.valid}";
	
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}


