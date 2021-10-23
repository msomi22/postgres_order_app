package com.himansusahoo.FileAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan
@SpringBootApplication
@EnableConfigurationProperties({
    FileUtilProperties.class,
})
public class FileApiApplication {
	
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		//SpringApplication.run(FileApiApplication.class, args);
		context = SpringApplication.run(FileApiApplication.class, args);
	}

}
