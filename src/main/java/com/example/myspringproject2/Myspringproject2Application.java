package com.example.myspringproject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Myspringproject2Application {

	public static void main(String[] args) {
		SpringApplication.run(Myspringproject2Application.class, args);
	}
}
