package com.ling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Lian on 04/29/2019.
 */
@SpringBootApplication
@ComponentScan("com.ling")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
