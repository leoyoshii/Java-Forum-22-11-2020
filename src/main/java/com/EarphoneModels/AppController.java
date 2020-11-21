package com.EarphoneModels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppController {
    public static void main(String[] args) {

        SpringApplication.run(AppController.class, args);
        System.out.println("Server is running in port 9093");
    }

}
