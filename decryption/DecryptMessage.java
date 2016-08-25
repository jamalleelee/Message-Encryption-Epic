package com.decryption;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DecryptMessage {

	public static byte[] DecryptMe(byte[] encryptedUserMessage, Key myKey) {
		byte[] decryptedUserMessage = null;
		try {
			Cipher userCipher = Cipher.getInstance("AES");
			userCipher.init(Cipher.DECRYPT_MODE, myKey);
			decryptedUserMessage = userCipher.doFinal(encryptedUserMessage);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}

		return decryptedUserMessage;
	}

}
