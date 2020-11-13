package com.deveficiente.desafiocdc.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.deveficiente.desafiocdc.validacoes.UniqueConstraintValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueConstraintValidator.class)
public @interface Unique {

    String message() default "deve ser unico";
	
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    Class<?> entidade();
    
    String propriedade();
	
}
