package com.heroku.create.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.heroku.create.config.dto.ObjectReturnCredentialsResponse;
import com.heroku.create.config.dto.ObjectReturnDecrypt;

@Service
public class ServiceEncriptionImpl implements IServiceEncription{

	@Autowired 
	IEncriptionService serviceEncription;

	@Override
	public <T> ObjectReturnCredentialsResponse retornaServicioEncriptado(T servicio) throws Exception {
		String gson = new Gson().toJson(servicio);
		return serviceEncription.encriptar(gson);
	}

	@Override
	public <T> ObjectReturnCredentialsResponse retornaDecrypt(ObjectReturnDecrypt request) throws Exception {
		return serviceEncription.desencriptar(request.getClaveResponse());
	}
	
}
