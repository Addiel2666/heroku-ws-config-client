package com.heroku.create.config.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.stereotype.Service;

import com.heroku.create.config.dto.ObjectReturnCredentialsResponse;

@Service
public interface IEncriptionService{

	ObjectReturnCredentialsResponse returnEncriptionService(String cadenaService) throws Exception;
	ObjectReturnCredentialsResponse returnDecryptService(String cadenaService) throws Exception;
	ObjectReturnCredentialsResponse encriptar(String datos) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException;
	ObjectReturnCredentialsResponse desencriptar(String datosEncriptados) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException;
}
