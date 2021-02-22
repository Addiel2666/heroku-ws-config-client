package com.heroku.create.config.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BeanConfiguration {

	private String greeting;
	private String copyright;
	public BeanConfiguration(String greeting, String copyright) {
		super();
		this.greeting = greeting;
		this.copyright = copyright;
	}
	
	
	
}
