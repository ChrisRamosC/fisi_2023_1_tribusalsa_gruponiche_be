package com.gruponiche.fitorfat.hu16y17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gruponiche.fitorfat.hu16y17")
public class Hu16y17Application {
	public static void main(String[] args) {
		SpringApplication.run(Hu16y17Application.class, args);
	}

}
