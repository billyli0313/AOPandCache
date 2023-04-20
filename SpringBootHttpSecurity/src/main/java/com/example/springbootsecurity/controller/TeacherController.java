package com.example.springbootsecurity.controller;

import com.example.springbootsecurity.entity.Teacher;
import com.example.springbootsecurity.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping(value = "/create/teacher")
    public void createTeacher(@RequestBody Teacher teacher) {
        System.out.println(teacher.getTeacherId());
        teacherService.saveTeacher(teacher);
    }

    @GetMapping(value = "/teacher")
    @ResponseBody
    public Teacher getTeacher(@RequestParam(value = "id") String id) {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping(value = "/remove/teacher")
    @ResponseBody
    public void removeTeacher(@RequestParam(value = "id") String id) {
         teacherService.deleteTeacher(id);
    }
}
