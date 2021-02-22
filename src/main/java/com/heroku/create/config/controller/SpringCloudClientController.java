package com.heroku.create.config.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.heroku.create.config.inject.InjectAutowiredImpl;

@RestController
public class SpringCloudClientController extends InjectAutowiredImpl{
	
	
    @GetMapping("/initial")
    public ResponseEntity<?> initial() {
    	return ResponseEntity.ok(returnConfigInitial());
    }
    
    @GetMapping("/herokuPesonApp")
    public ResponseEntity<?> herokuPerson() {
    	return ResponseEntity.ok(returnHerokuPerson());
    }
    
    @GetMapping("/heroku")
    public String heroku(){
    	return heroku();
    }
}
