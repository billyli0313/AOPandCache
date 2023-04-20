package com.example.springbootdb1.service;

import com.example.springbootdb1.entity.Student;
import com.example.springbootdb1.repository.JPAStudentRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @Autowired
    StudentService service;

    @Autowired
    JPAStudentRepository studentRepository;

    @Before
    public void setUp() {
        Student student = new Student("0001", "alex");
        Mockito.when(studentRepository.findById(anyString()))
                .thenReturn(Optional.of(student));
    }

    @Test
    public void testGetByStudentId() {
        String id = "0001";
        Student student = service.getStudentById(id);
        assertThat(student.getName()).isEqualTo("alex");
    }

}
