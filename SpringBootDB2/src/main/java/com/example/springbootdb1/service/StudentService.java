package com.example.springbootdb1.service;

import com.example.springbootdb1.entity.Student;
import com.example.springbootdb1.repository.JPAStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class StudentService {
    @Autowired
    private JPAStudentRepository jpaStudentRepository;

    public List<Student> listStudentsByName(String name, int page, int sizePerPage) {
//        return jpaStudentRepository.findStudentByName(name);

        Pageable pageable = PageRequest.of(page, sizePerPage, Sort.by("id"));

        return jpaStudentRepository.findStudentByName(name, pageable);
    }

    //list all students profile info
    public List<Student> listAllStudents() {
        return jpaStudentRepository.findAll();
    }

    //get one student profile by id
    public Student getStudentById(String id) {
        Optional<Student> loadStudent = jpaStudentRepository.findById(id);
        if (loadStudent.isPresent()) {
            return loadStudent.get();
        }
        return null;
    }


    // save one new student
    public void saveStudent(Student student) {
        jpaStudentRepository.save(student);
    }

    // delete student
    public void deleteStudent(String id) {
        Optional<Student> loadStudentResult = jpaStudentRepository.findById(id);
        if (loadStudentResult.isPresent()) {
            Student student = loadStudentResult.get();
            jpaStudentRepository.delete(student);
        }
    }

}
