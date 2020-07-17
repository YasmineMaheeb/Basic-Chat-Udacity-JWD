package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@ComponentScan
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	@Primary
	public String message(){
		System.out.println("1");
		return "Hello there!";
	}

//	@Bean
//	public String uppercasemessage(MessageService ms){
//		System.out.println(4);
//
//
//		return ms.uppercase();
//	}
//
//	@Bean
//	public String lowercasecasemessage(MessageService ms){
//		System.out.println(5);
//		return ms.lowercase();
//	}
}
