package com.encryption;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveEncryptedMessage {
	public static void saveMessage(String encryptedUserMessageInChars, String encryptedUserMessageInBytes, String encodedKey){
	Path mySecretMessagepath= Paths.get("\\Users\\Public\\Documents\\secretmessage.txt");
	File mySecretMessageFile= mySecretMessagepath.toFile();
	
	try(PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(mySecretMessageFile,true)))){
		out.println("Message In Characters:\n"+encryptedUserMessageInChars);
		out.println("Message In Numbers:\n"+encryptedUserMessageInBytes);
		out.println("Your Key:\n"+encodedKey);
	}catch (IOException e) {
		e.printStackTrace();
	}
}}
