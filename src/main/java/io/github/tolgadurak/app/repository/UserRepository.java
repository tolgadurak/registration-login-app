package io.github.tolgadurak.app.repository;

import org.springframework.data.repository.CrudRepository;

import io.github.tolgadurak.app.domain.User;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);

	User findByUsername(String username);
}
