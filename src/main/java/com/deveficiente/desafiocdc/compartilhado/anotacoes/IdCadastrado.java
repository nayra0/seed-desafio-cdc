package com.deveficiente.desafiocdc.compartilhado.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.deveficiente.desafiocdc.compartilhado.IdCadastradoConstraintValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = IdCadastradoConstraintValidator.class)
public @interface IdCadastrado {

    String message() default "{id.not.exist}";
	
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    Class<?> entidade();
    
}
