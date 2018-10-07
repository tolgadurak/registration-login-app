package io.github.tolgadurak.app.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SecurePasswordValidator.class)
@Documented
public @interface SecurePassword {
	String message() default "Password should be at least 7 characters including at least 1 number and 1 upper case letter";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
