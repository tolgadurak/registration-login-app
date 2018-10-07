package io.github.tolgadurak.app.exception;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1753706084422429880L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
