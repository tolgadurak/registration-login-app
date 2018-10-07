package io.github.tolgadurak.app.service.impl;

import javax.transaction.Transactional;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.tolgadurak.app.domain.User;
import io.github.tolgadurak.app.dto.RegistrationDto;
import io.github.tolgadurak.app.exception.UserAlreadyExistsException;
import io.github.tolgadurak.app.repository.UserRepository;
import io.github.tolgadurak.app.service.HashService;
import io.github.tolgadurak.app.service.UserService;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private HashService hashService;
	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public User registerNewUser(RegistrationDto registrationDto) throws UserAlreadyExistsException {
		if (userRepository.findByEmail(registrationDto.getEmail()) != null) {
			throw new UserAlreadyExistsException("Email " + registrationDto.getEmail() + " exists");
		}
		if (userRepository.findByUsername(registrationDto.getUsername()) != null) {
			throw new UserAlreadyExistsException("Username " + registrationDto.getUsername() + " exists");
		}
		String passwordSalt = hashService.generateSalt();
		String passwordHash = hashService.hashPassword(registrationDto.getPassword(), passwordSalt);
		User user = new User();
		user.setUsername(registrationDto.getUsername());
		user.setEmail(registrationDto.getEmail());
		user.setPasswordSalt(passwordSalt);
		user.setPasswordHash(passwordHash);
		return userRepository.save(user);
	}

	@Transactional
	@Override
	public User getByEmail(String email) {
		Validate.notNull(email, "email cannot be null here");
		return userRepository.findByEmail(email);
	}

}
