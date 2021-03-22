package com.heroku.create.config.encrypt;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptRC5 {



	
//	public static void main(String[] args) throws Exception {
//        String plainText = "Hello World!";
// 
//        // Generate public and private keys using RSA
//        Map<String, Object> keys = getRSAKeys();
//        PrivateKey privateKey = (PrivateKey) keys.get("private");
//        PublicKey publicKey = (PublicKey) keys.get("public");
// 
//        // First create an AES Key
//        String secretAESKeyString = EncriptAES.getSecretAESKeyAsString();
// 
//        // Encrypt our data with AES key
//        String encryptedText = EncriptAES.encryptTextUsingAES(plainText, secretAESKeyString);
// 
//        // Encrypt AES Key with RSA Private Key
//        String encryptedAESKeyString = EncriptAES.encryptAESKey(secretAESKeyString, privateKey);
// String f = "TX+CmEg+t7NP66KmJH4NFJIZ/sWTaEYF3FID7D5KjT8JXWHJQ+90Oate0S9ElP8P9WmWXja7j8Mt2b9qNSTmCNq2B9uOk7leqeBlfUyDRoaxDydoo7weRc6xWEGOXIV0iKsbzAo7AryYxZtAo+SZna6KlbjCOOeIU764NOHC6BhFUJ7NdX0xJVRluRXqggRVJOYxqMM/iiVwQiBFVQS7M8Qw5ifjJHDgXcFUjaF9SbXcHTQCp7utGW7m0YXr3YghtkW5a9sX3tTFqf3MTzuUksoswS13X4+e1Pvy2kkpLcrwiKlRF9qepNZ9lO4uYgEyA61DzGG0l81b8JDvB3FAbA==";
//        String decryptedAESKeyString = DecriptAES.decryptAESKey(f, publicKey);
// 
//        // Now decrypt data using the decrypted AES key!
//        String decryptedText = DecriptAES.decryptTextUsingAES(encryptedText, decryptedAESKeyString);
// 
//        System.out.println("input:" + plainText);
//        System.out.println("AES Key:" + secretAESKeyString);
//        System.out.println("decrypted:" + decryptedText);
// 
//    }
// 
// 
//    // Decrypt text using AES key
//  
// 
//    // Get RSA keys. Uses key size of 2048.
//    private static Map<String, Object> getRSAKeys() throws Exception {
//       KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
//        keyPairGenerator.initialize(2048);
//        KeyPair keyPair = keyPairGenerator.generateKeyPair();
//        PrivateKey privateKey = keyPair.getPrivate();
//        PublicKey publicKey = keyPair.getPublic();
// 
//        Map<String, Object> keys = new HashMap<String, Object>();
//        keys.put("private", privateKey);
//        keys.put("public", publicKey);
//        return keys;
//    }
// 
    
 

}
