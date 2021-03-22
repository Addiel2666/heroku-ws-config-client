package com.heroku.create.config.encrypt;

import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DecriptAES {

	   public static String decryptAESKey(String encryptedAESKey, PublicKey publicKey) throws Exception {
	        Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.DECRYPT_MODE, publicKey);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedAESKey)));
	    }
	   
	   public static String decryptTextUsingAES(String encryptedText, String aesKeyString) throws Exception {
		   
	        byte[] decodedKey = Base64.getDecoder().decode(aesKeyString);
	        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
	 
	        // AES defaults to AES/ECB/PKCS5Padding in Java 7
	        Cipher aesCipher = Cipher.getInstance("AES");
	        aesCipher.init(Cipher.DECRYPT_MODE, originalKey);
	        byte[] bytePlainText = aesCipher.doFinal(Base64.getDecoder().decode(encryptedText));
	        return new String(bytePlainText);
	    }
	
}
