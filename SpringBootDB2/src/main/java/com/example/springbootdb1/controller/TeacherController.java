package com.example.springbootdb1.controller;

import com.example.springbootdb1.entity.Teacher;
import com.example.springbootdb1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService service;

    @PostMapping(value = "/create/teacher")
    public void createTeacher(@RequestBody Teacher teacher) {
        service.saveTeacher(teacher);
    }

    @GetMapping(value = "/teacher")
    @ResponseBody
    public Teacher createTeacher(@RequestParam(value = "id") String id) {
        return service.getTeacherById(id);
    }
}
