package com.gruponiche.fitorfat.hu18core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gruponiche.fitorfat.hu18core")
public class Hu18coreApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hu18coreApplication.class, args);
    }
}
