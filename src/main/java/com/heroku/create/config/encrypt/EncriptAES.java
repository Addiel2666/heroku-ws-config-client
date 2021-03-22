package com.heroku.create.config.encrypt;

import java.security.PrivateKey;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncriptAES {
	
	 public static String getSecretAESKeyAsString() throws Exception {
	        KeyGenerator generator = KeyGenerator.getInstance("AES");
	        generator.init(128); // The AES key size in number of bits
	        SecretKey secKey = generator.generateKey();
	        String encodedKey = Base64.getEncoder().encodeToString(secKey.getEncoded());
	        return encodedKey;
	    }
	 
	   public static String encryptTextUsingAES(String plainText, String aesKeyString) throws Exception {
	        byte[] decodedKey = Base64.getDecoder().decode(aesKeyString);
	        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
	 
	        // AES defaults to AES/ECB/PKCS5Padding in Java 7
	        Cipher aesCipher = Cipher.getInstance("AES");
	        aesCipher.init(Cipher.ENCRYPT_MODE, originalKey);
	        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
	        return Base64.getEncoder().encodeToString(byteCipherText);
	    }
	 
	   public static String encryptAESKey(String plainAESKey, PrivateKey privateKey) throws Exception {
	        Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(plainAESKey.getBytes()));
	    }

}
