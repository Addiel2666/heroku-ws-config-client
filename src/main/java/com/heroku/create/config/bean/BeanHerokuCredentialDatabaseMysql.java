package com.heroku.create.config.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeanHerokuCredentialDatabaseMysql {

	private String url;
	private String user;
	private String password;
	
}
