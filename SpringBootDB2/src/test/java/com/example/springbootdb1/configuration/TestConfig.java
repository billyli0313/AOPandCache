package com.example.springbootdb1.configuration;

import com.example.springbootdb1.controller.StudentController;
import com.example.springbootdb1.repository.JPAStudentRepository;
import com.example.springbootdb1.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public StudentController createStudentController() {
        return new StudentController();
    }

    @Bean
    public StudentService createStudentService() {
        return new StudentService();
    }

}
