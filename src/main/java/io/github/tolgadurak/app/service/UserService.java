package io.github.tolgadurak.app.service;

import io.github.tolgadurak.app.domain.User;
import io.github.tolgadurak.app.dto.RegistrationDto;
import io.github.tolgadurak.app.exception.UserAlreadyExistsException;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
public interface UserService {
	User registerNewUser(RegistrationDto registrationDto) throws UserAlreadyExistsException;

	User getByEmail(String email);
}
