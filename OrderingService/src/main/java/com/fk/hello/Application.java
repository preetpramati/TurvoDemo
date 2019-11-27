package com.fk.hello;


import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.fk")
public class Application {
    
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(Application.class);
        //app.run(args);
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
    }


}
