package com.encryption;

import java.security.Key;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Scanner;

import javax.crypto.spec.SecretKeySpec;

import com.decryption.DecryptMessage;

public class MyMessage {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		byte[] encryptedUserMessage = null;
		boolean restartApp = true;
		String encryptedUserMessageInBytes = null;
		String encryptedUserMessageInChars = null;
		String decryptedUserMessageInChars = null;
		byte[] friendsDecryptedMessage = null;
		String friendsMessageToPrint = null;
		String friendsKeyinput = null;
		byte[] encryptedFriendsMessage = null;
		Key myKey = SecretKeyGenerator.myKeyGen();
		Key friendsKey = null;

		do {
			System.out.println(
					"What would you like to do?\n1: Encrypt Message\n2: Decrypt your encrypted message\n3: Decrypt friends message\n4: Exit");
			String userChoice = sc.nextLine();
			switch (userChoice) {
			case "1":
				System.out.println("Please Enter The Message You Would Like To Keep Secret:");

				String userMessage = sc.nextLine();

				encryptedUserMessage = EncryptMessage.EncryptMe(userMessage, myKey);

				encryptedUserMessageInBytes = Arrays.toString(encryptedUserMessage);
				encryptedUserMessageInChars = new String(encryptedUserMessage);

				System.out.println("Your message in Characters is:\n" + encryptedUserMessageInChars);
				System.out.println();
				System.out.println("Your message in Numbers is:\n" + encryptedUserMessageInBytes);
				System.out.println();
				String encodedKey = Base64.getEncoder().encodeToString(myKey.getEncoded());
				System.out.println("Your key is:\n" + encodedKey);
				SaveEncryptedMessage.saveMessage(encryptedUserMessageInChars,encryptedUserMessageInBytes,encodedKey);

				System.out.println();
				System.out.println(
						"Your message and key is saved in your documents folder.\nSend it to a friend so they can read your message!\n");

				break;

			case "2":
				byte[] decryptedUserMessage = DecryptMessage.DecryptMe(encryptedUserMessage, myKey);
				decryptedUserMessageInChars = new String(decryptedUserMessage);
				System.out.println("Your Decoded message is:\n" + decryptedUserMessageInChars);
				break;
			case "3":
				System.out.println("Enter your friends message. Either the numbers with the \"[]\" or the charaters.");
				System.out.println("Pro Tips: The numbers are easier to type in, and its better to copy and paste:");
				encryptedFriendsMessage = sc.nextLine().getBytes();
				System.out.println("Input friends key:");
				friendsKeyinput = sc.nextLine();
				byte[] decodedFriendsKey = Base64.getDecoder().decode(friendsKeyinput);
				friendsKey = new SecretKeySpec(decodedFriendsKey, 0, decodedFriendsKey.length, "AES");

				friendsDecryptedMessage = DecryptMessage.DecryptMe(encryptedFriendsMessage, friendsKey);
				friendsMessageToPrint = new String(friendsDecryptedMessage);

				System.out.println("Your friend said:\n" + friendsMessageToPrint);

				break;

			case "4":
				System.out.println("Bye for now!");
				restartApp = false;
				break;

			default:
				System.out.println("Please Enter A Valid Number:");
				userChoice = null;

				break;
			}
		} while (restartApp);
		sc.close();
	}

}
