package com.rubicon.watermanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rubicon.watermanagment.security.AppProperties;


@SpringBootApplication
public class WaterManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaterManagmentApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean 
	public SpringApplicationContext springApplicationContext()
	{
		return new SpringApplicationContext();
	}
	
	@Bean(name="AppProperties")
	public AppProperties getAppProperties()
	{
		return new AppProperties();
	}
}
