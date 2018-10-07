package io.github.tolgadurak.app.domain;

import javax.persistence.Entity;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
@Entity
public class User extends PO {
	private String username;
	private String email;
	private String passwordHash;
	private String passwordSalt;

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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	@Override
	public String toString() {
		return new StringBuilder("id: ").append(id).append(", ").append("userName: ").append(username).append(", ")
				.append("email: ").append(email).toString();
	}
}
