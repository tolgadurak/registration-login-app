package io.github.tolgadurak.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
public class SecurePasswordValidator implements ConstraintValidator<SecurePassword, String> {
	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		return StringUtils.isNotBlank(password) && password.length() >= 7
				&& !StringUtils.equals(password, password.toLowerCase()) && password.matches(".*\\d+.*");
	}

}
