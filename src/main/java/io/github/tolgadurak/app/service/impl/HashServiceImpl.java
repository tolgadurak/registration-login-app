package io.github.tolgadurak.app.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import io.github.tolgadurak.app.service.HashService;

/**
 * 
 * @author Tolga Durak <tolgadurak.dev@gmail.com>
 *
 */
@Service
public class HashServiceImpl implements HashService {

	private static final int ITERATION_COUNT = 1000;
	private static final int KEY_LENGTH = 256;

	@Override
	public String hashPassword(String password, String saltText) {
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), saltText.getBytes(), ITERATION_COUNT, KEY_LENGTH);
			SecretKey key = skf.generateSecret(spec);
			return Hex.encodeHexString(key.getEncoded());
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String generateSalt() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] bytes = new byte[32];
		secureRandom.nextBytes(bytes);
		return Base64.encodeBase64String(bytes);
	}
}
