package com.heroku.create.config.inject;

import com.heroku.create.config.bean.BeanConfiguration;
import com.heroku.create.config.bean.BeanHerokuCredentialDatabaseMysql;
import com.heroku.create.config.bean.BeanHerokuPerson;

public interface InjetAutowired {

	BeanConfiguration returnConfigInitial();
	BeanHerokuPerson returnHerokuPerson();
	BeanHerokuCredentialDatabaseMysql returnCredentialsPerson();
	String heroku();
}
