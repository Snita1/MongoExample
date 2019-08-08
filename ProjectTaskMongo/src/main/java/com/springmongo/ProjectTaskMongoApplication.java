package com.springmongo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
//@EnableEurekaServer	// Enable eureka server
public class ProjectTaskMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTaskMongoApplication.class, args);
	}


}
