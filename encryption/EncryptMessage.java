package com.encryption;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptMessage {

	public static byte[] EncryptMe(String userMessage, Key myKey) {
		byte[] encryptedUserMessage = null;

		try {

			Cipher userCipher = Cipher.getInstance("AES");

			userCipher.init(Cipher.ENCRYPT_MODE, myKey);

			encryptedUserMessage = userCipher.doFinal(userMessage.getBytes());

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}

		return encryptedUserMessage;

	}

}
