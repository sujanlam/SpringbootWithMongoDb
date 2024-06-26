package com.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpApplication.class, args);
		System.out.println("Employee application is running!!!!");
	}
}
