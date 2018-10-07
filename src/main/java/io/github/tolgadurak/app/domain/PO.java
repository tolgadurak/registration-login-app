package io.github.tolgadurak.app.domain;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
@MappedSuperclass
public abstract class PO {
	@Id
	@GeneratedValue
	protected UUID id;

	public UUID getId() {
		return id;
	}
}
