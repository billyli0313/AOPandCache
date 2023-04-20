package com.example.springbootdb4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBootDB4 {
// Git
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDB4.class, args);
    }

}
