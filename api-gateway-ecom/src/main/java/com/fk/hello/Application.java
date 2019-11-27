package com.fk.hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableZuulProxy
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.fk")
public class Application {
    
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
        //ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
    }


}
