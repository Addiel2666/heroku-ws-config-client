package com.heroku.create.config.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@ConfigurationProperties("heroku-person")
public class HerokuPersonDTO {

	
	private String token;
	
}
