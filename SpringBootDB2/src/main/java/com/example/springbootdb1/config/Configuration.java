package com.example.springbootdb1.config;

import com.example.springbootdb1.repository.TeacherRepository;
import com.example.springbootdb1.service.StudentService;
import com.example.springbootdb1.service.SystemService;
import com.example.springbootdb1.service.TeacherService;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    private String DEFAULT_SYSTEM_NAME = "Profile";

    @Bean
    public StudentService buildStudentService(){
        return new StudentService();
    }

    @Bean
    public TeacherService buildTeacherService() {
        return new TeacherService();
    }

    @Bean
    public TeacherRepository buildTeacherRepository() {
        return new TeacherRepository();
    }

    @Bean(value = "basic")
    public SystemService buildSystemService() {
        return new SystemService();
    }

    @Bean(value = "profile")
    public SystemService buildProfileSystemService() {
        return new SystemService(DEFAULT_SYSTEM_NAME);
    }
}
