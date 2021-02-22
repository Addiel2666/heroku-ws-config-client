package com.heroku.create.config.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Component
@NoArgsConstructor
@ConfigurationProperties("text")
public class DataComponent {

    private String greeting;
    private String copyright;
	
}
