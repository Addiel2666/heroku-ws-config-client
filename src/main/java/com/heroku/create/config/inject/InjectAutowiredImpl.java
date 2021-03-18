package com.heroku.create.config.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

import com.heroku.create.config.bean.BeanConfiguration;
import com.heroku.create.config.bean.BeanHerokuCredentialDatabaseMysql;
import com.heroku.create.config.bean.BeanHerokuPerson;
import com.heroku.create.config.component.DataComponent;
import com.heroku.create.config.component.HerokuCredentialDatabaseMysql;
import com.heroku.create.config.component.HerokuPersonDTO;
import com.netflix.discovery.EurekaClient;

public class InjectAutowiredImpl implements InjetAutowired {

	@Autowired
	@Lazy
	private EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	private String appName;

	@Autowired
	DataComponent dataComponent;
	@Autowired
	HerokuPersonDTO herokuPerson;
	@Autowired
	HerokuCredentialDatabaseMysql credentials;

	@Override
	public BeanConfiguration returnConfigInitial() {
		return new BeanConfiguration(dataComponent.getGreeting(), dataComponent.getCopyright());
	}

	@Override
	public BeanHerokuPerson returnHerokuPerson() {
		return new BeanHerokuPerson(herokuPerson.getToken());
	}
	
	 public String heroku() {
	        return String.format(
	          "Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	    }

	@Override
	public BeanHerokuCredentialDatabaseMysql returnCredentialsPerson() {
		return new BeanHerokuCredentialDatabaseMysql(credentials.getUrl(),credentials.getUser(),credentials.getPassword());
	}

}
