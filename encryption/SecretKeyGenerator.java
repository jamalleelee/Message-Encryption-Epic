package com.encryption;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;

public class SecretKeyGenerator {
	public static Key myKeyGen() {

		Key myKey = null;
		try {

			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(128);
			myKey = keyGen.generateKey();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return myKey;
	}

}
