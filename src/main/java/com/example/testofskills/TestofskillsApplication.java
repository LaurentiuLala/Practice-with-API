package com.example.testofskills;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestofskillsApplication {


    public static void main(String[] args) {
        SpringApplication.run(TestofskillsApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(){
return args -> {};
    }
}
