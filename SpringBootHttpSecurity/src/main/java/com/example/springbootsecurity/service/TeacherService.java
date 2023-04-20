package com.example.springbootsecurity.service;

import com.example.springbootsecurity.entity.Teacher;
import com.example.springbootsecurity.repository.JPATeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private JPATeacherRepository jpaTeacherRepository;

    public Teacher getTeacherById(String id) {
        return jpaTeacherRepository.getTeachersByTeacherId(id);
    }
    public void saveTeacher(Teacher teacher) {
        jpaTeacherRepository.save(teacher);
    }

    public void deleteTeacher(String id) {
        jpaTeacherRepository.deleteById(id);
    }
}
