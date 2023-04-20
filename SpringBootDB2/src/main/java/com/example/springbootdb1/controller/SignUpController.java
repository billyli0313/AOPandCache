package com.example.springbootdb1.controller;

import com.example.springbootdb1.entity.Student;
import com.example.springbootdb1.entity.Teacher;
import com.example.springbootdb1.service.StudentService;
import com.example.springbootdb1.service.SystemService;
import com.example.springbootdb1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.swing.text.BadLocationException;

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
            student.setTeacherId(teacherId);
            studentService.saveStudent(student);

            teacherService.addStudent(teacher, student);
            teacherService.saveTeacher(teacher);
        }

    }
}
