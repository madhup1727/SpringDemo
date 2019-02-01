package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldMsApplication.class, args);
	}
	
	@RequestMapping("/helloWorld")
	public String helloWorld () {
		return "Hello World,running in Spring boot application";
	}
}
