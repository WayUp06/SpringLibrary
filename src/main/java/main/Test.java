package main;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan(basePackages = {"DAO", "main", "controller", "Service", "Entity"})
@EnableAutoConfiguration
public class Test {

    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
    }


}

