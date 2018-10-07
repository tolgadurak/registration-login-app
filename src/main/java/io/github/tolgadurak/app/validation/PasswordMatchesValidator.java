package io.github.tolgadurak.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.tolgadurak.app.dto.RegistrationDto;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	private static final Logger logger = LogManager.getLogger(PasswordMatchesValidator.class);

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		RegistrationDto registrationDto = null;
		if (object instanceof RegistrationDto) {
			registrationDto = (RegistrationDto) object;
			return registrationDto.passwordMatches();
		} else {
			logger.warn("Object is not instance of RegistrationDto. Skipping validation..");
			return true;
		}
	}

}
