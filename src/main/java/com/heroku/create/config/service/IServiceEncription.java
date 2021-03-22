package com.heroku.create.config.service;

import com.heroku.create.config.dto.ObjectReturnCredentialsResponse;
import com.heroku.create.config.dto.ObjectReturnDecrypt;

public interface IServiceEncription {

	<T> ObjectReturnCredentialsResponse retornaServicioEncriptado(T servicio) throws Exception;
	<T> ObjectReturnCredentialsResponse retornaDecrypt(ObjectReturnDecrypt request) throws Exception;
}
