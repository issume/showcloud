package com.showcloud.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.showcloud")
public class Application {
    public static void main(String[] args) {        
        SpringApplication.run(Application.class);
    }

}
