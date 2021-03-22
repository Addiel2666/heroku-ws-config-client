package com.heroku.create.config.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import com.heroku.create.config.dto.ObjectReturnCredentialsResponse;
import com.heroku.create.config.encrypt.DecriptAES;
import com.heroku.create.config.encrypt.EncriptAES;

@Service
public class EncriptionServiceImpl implements IEncriptionService {
	
	final String claveEncriptacion = "MedicPlus";

	public ObjectReturnCredentialsResponse returnEncriptionService(String cadenaService) throws Exception {
		Map<String, Object> keys = getRSAKeys();
		PrivateKey privateKey = (PrivateKey) keys.get("private");
		// PublicKey publicKey = (PublicKey) keys.get("public");
		String secretAESKeyString = EncriptAES.getSecretAESKeyAsString();
		String encryptedAESKeyString = EncriptAES.encryptTextUsingAES(secretAESKeyString, secretAESKeyString);
		ObjectReturnCredentialsResponse response = new ObjectReturnCredentialsResponse(encryptedAESKeyString);
		return response;
	}

	private static Map<String, Object> getRSAKeys() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();

		Map<String, Object> keys = new HashMap<String, Object>();
		keys.put("private", privateKey);
		keys.put("public", publicKey);
		return keys;
	}

	@Override
	public ObjectReturnCredentialsResponse returnDecryptService(String cadenaService) throws Exception {
		Map<String, Object> keys = getRSAKeys();
		PublicKey publicKey = (PublicKey) keys.get("public");
		String secretAESKeyString = EncriptAES.getSecretAESKeyAsString();
		String decryptedAESKeyString = DecriptAES.decryptTextUsingAES(cadenaService, secretAESKeyString);
		ObjectReturnCredentialsResponse response = new ObjectReturnCredentialsResponse(decryptedAESKeyString);
		return response;
	}

	private SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncriptacion = clave.getBytes("UTF-8");
        
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        
        claveEncriptacion = sha.digest(claveEncriptacion);
        claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);
        
        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");

        return secretKey;
    }
	
	public ObjectReturnCredentialsResponse encriptar(String datos) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = this.crearClave(claveEncriptacion);
        
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");        
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] datosEncriptar = datos.getBytes("UTF-8");
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);
        ObjectReturnCredentialsResponse response = new ObjectReturnCredentialsResponse(encriptado);
		return response;
    }

	public ObjectReturnCredentialsResponse desencriptar(String datosEncriptados) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
	        SecretKeySpec secretKey = this.crearClave(claveEncriptacion);

	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);
	        
	        byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
	        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
	        String datos = new String(datosDesencriptados);
	        
	        ObjectReturnCredentialsResponse response = new ObjectReturnCredentialsResponse(datos);
			return response;
	        
	    }

	
}
