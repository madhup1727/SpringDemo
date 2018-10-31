package com.example.demo;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootApplication
@RestController
@EnableScheduling
@EnableDiscoveryClient
@EnableHystrix
public class MicroserviceApplication {
	
	private static final Logger LOG = Logger.getLogger(MicroserviceApplication.class.getName());
	
	@Autowired
    private DiscoveryClient discoveryClient;

	@Value("${server.port}")
	public String port;
	
	@Value("${spring.application.name}")
	public String applicationName;

	
	@Value("${welcome.message}")
	public String welcomePropertiesMessage;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}
	
	//private static final Logger LOG =(Logger) LoggerFactory.getLogger(MicroserviceApplication.class);
	
	@RequestMapping(value="/")
	@ResponseBody
	public String hello() {
		LOG.log(Level.INFO, "INFO LOGGER");
		LOG.log(Level.WARNING,"WARN LOGGER");
		LOG.log(Level.SEVERE,"ERROR LOGGER");
		
		
		return "Application Name " + applicationName 
				+ "<br>RUNNING AT PORT : " + port  
				+ "<br>Eureka Client APP INTEGRATED :"
				+ "<br>Reading from Cloud config :" +welcomePropertiesMessage;
	}
	
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	
	
}
