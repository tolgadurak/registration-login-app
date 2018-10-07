package io.github.tolgadurak.app.service;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
public interface HashService {
	String hashPassword(String password, String saltText);

	String generateSalt();
}
