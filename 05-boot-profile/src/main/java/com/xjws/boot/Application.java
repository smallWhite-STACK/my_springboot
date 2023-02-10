package com.xjws.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
//        ConfigurableEnvironment environment = ioc.getEnvironment();
//        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
//        Map<String, Object> systemProperties = environment.getSystemProperties();
//        System.out.println(systemEnvironment);
//        System.out.println(systemProperties);

    }

}
