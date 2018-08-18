package com.brenomorais.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {

	//Iinicializa a aplicação
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
		System.out.println("==============================");
		System.out.println(" :: Spring Boot >> APP Blog ::");
		System.out.println("==============================");
	}
}
