package com.myBank.Mybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MybankApplication {
	public static void main(String[] args) {
		SpringApplication.run(MybankApplication.class, args);
	}
}
