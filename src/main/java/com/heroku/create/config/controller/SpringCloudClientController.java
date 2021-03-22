package com.heroku.create.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.heroku.create.config.dto.ObjectReturnCredentialsResponse;
import com.heroku.create.config.dto.ObjectReturnDecrypt;
import com.heroku.create.config.inject.InjectAutowiredImpl;
import com.heroku.create.config.service.IEncriptionService;
import com.heroku.create.config.service.IServiceEncription;

@RestController
public class SpringCloudClientController extends InjectAutowiredImpl{
	
	@Autowired
	IEncriptionService service;
	@Autowired
	IServiceEncription serviceEncription;
	
    @GetMapping("/initial")
    public ResponseEntity<?> initial() {
    	return ResponseEntity.ok(returnConfigInitial());
    }
    
    @GetMapping("/herokuPesonApp")
    public ResponseEntity<?> herokuPerson() {
    	return ResponseEntity.ok(returnHerokuPerson());
    }
    
    @GetMapping("/herokuPersonMysql")
    public ResponseEntity<?> herokuCredentialsPerson() throws Exception {
    	ObjectReturnCredentialsResponse response = serviceEncription.retornaServicioEncriptado(returnCredentialsPerson());
    	return ResponseEntity.ok(response);
    }
    
    @PostMapping("/decrypt")
    public ResponseEntity<?> decrypt(@RequestBody ObjectReturnDecrypt request) throws Exception{
    	return ResponseEntity.ok(serviceEncription.retornaDecrypt(request));
    }
    
    @GetMapping("/heroku")
    public String heroku(){
    	return heroku();
    }
}
