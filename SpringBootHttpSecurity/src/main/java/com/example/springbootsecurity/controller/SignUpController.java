package com.example.springbootsecurity.controller;

import com.example.springbootsecurity.entity.Student;
import com.example.springbootsecurity.entity.Teacher;
import com.example.springbootsecurity.service.StudentService;
import com.example.springbootsecurity.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class SignUpController {
    
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/signup")
    public void signUpTeacher(@RequestParam(value ="studentId") String studentId,
                              @RequestParam(value = "teacherId") String teacherId) {

        Student student = studentService.getStudentById(studentId);
        Teacher teacher = teacherService.getTeacherById(teacherId);

        if(teacher != null && student != null) {
            Set<Teacher> teachers = student.getTeachers();
            teachers.add(teacher);
            student.setTeachers(teachers);
            studentService.saveStudent(student);
        }

    }
}
