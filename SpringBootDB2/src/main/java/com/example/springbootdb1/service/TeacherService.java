package com.example.springbootdb1.service;

import com.example.springbootdb1.entity.Student;
import com.example.springbootdb1.entity.Teacher;
import com.example.springbootdb1.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher getTeacherById(String id) {
        return teacherRepository.getTeacher(id);
    }
    public void saveTeacher(Teacher teacher) {
        teacherRepository.saveTeacher(teacher);
    }

    public void addStudent(Teacher teacher, Student student) {
        teacherRepository.addStudent(teacher, student);
    }

    public List<Student> listAllStudents(Teacher teacher) {
        return teacherRepository.listAllStudents(teacher);
    }
}
