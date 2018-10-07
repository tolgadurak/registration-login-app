package io.github.tolgadurak.app.dto;

import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;

import io.github.tolgadurak.app.validation.PasswordMatches;
import io.github.tolgadurak.app.validation.SecurePassword;
import io.github.tolgadurak.app.validation.ValidEmail;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
@PasswordMatches
public class RegistrationDto {

	@Size(min = 3, message = "Username should be at least 3 characters")
	private String username;
	@ValidEmail
	private String email;
	@SecurePassword
	private String password;
	private String passwordRetype;

	public RegistrationDto() {
	}

	public RegistrationDto(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRetype() {
		return passwordRetype;
	}

	public void setPasswordRetype(String passwordRetype) {
		this.passwordRetype = passwordRetype;
	}

	public boolean passwordMatches() {
		return StringUtils.isNotEmpty(password) && StringUtils.isNotEmpty(passwordRetype)
				&& StringUtils.equals(password, passwordRetype);
	}

}
