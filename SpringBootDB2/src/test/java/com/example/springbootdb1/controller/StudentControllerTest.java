package com.example.springbootdb1.controller;

import com.example.springbootdb1.configuration.SpringUnitTestBase;
import com.example.springbootdb1.entity.Student;
import com.example.springbootdb1.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class StudentControllerTest extends SpringUnitTestBase {

    @Autowired
    StudentController studentController;

    @MockBean
    StudentService studentService;

    @Before
    public void setUp() {
        Student student = new Student("0001", "alex");
        Mockito.when(studentService.getStudentById(anyString()))
                .thenReturn(student);
    }

    @Test
    public void testGetByStudentId() {
        String id = "0001";
        Student student = studentController.getStudentById(id);
        assertThat(student.getName()).isEqualTo("alex");
    }


}
