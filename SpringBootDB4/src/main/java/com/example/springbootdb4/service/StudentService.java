package com.example.springbootdb4.service;

import com.example.springbootdb4.entity.Student;
import com.example.springbootdb4.repository.JPAStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private JPAStudentRepository jpaStudentRepository;

    public List<Student> listStudentsByName(String name, int page, int sizePerPage) {
//        return jpaStudentRepository.findStudentByName(name);

        return jpaStudentRepository.findStudentByName(name, PageRequest.of(page, sizePerPage, Sort.by("id")));
    }

    //list all students profile info
    public List<Student> listAllStudents() {
        return jpaStudentRepository.findAll();
    }

    //get one student profile by id
    @Cacheable(cacheNames = "student")
    public Student getStudentById(String id) {
        Optional<Student> loadStudent = jpaStudentRepository.findById(id);
        if (loadStudent.isPresent()) {
            return loadStudent.get();
        }
        return null;
    }

    // save one new student
    @Cacheable(cacheNames = "student")
    public void saveStudent(Student student) {
        jpaStudentRepository.save(student);
    }

    //SpringBoot update the cache by return type: key->id, value -> return student
    @CachePut(cacheNames="student",  key="#student.id")
    public Student update(Student student) {
        return jpaStudentRepository.save(student);
    }


    // delete student
    @CacheEvict(cacheNames="student",  key="#id")
    public void deleteStudent(String id) {
        Optional<Student> loadStudentResult = jpaStudentRepository.findById(id);
        if (loadStudentResult.isPresent()) {
            Student student = loadStudentResult.get();
            jpaStudentRepository.delete(student);
        }
    }

}
