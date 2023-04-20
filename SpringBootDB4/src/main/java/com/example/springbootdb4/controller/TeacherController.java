package com.example.springbootdb4.controller;

import com.example.springbootdb4.entity.Teacher;
import com.example.springbootdb4.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
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
    public Teacher getTeacher(@RequestParam(value = "id") String id) throws HttpClientErrorException {
        // assume for teacher id, id digit should be longer than or equal 2.

        if (id.length() < 2) {
            throw new HttpClientErrorException(HttpStatusCode.valueOf(400), "Bad Request: parameter id is invalid!");
        }
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping(value = "/remove/teacher")
    @ResponseBody
    public void removeTeacher(@RequestParam(value = "id") String id) {
         teacherService.deleteTeacher(id);
    }

    /**
     * try {
     * 	    try all controller service and repository
     * } catch (Exception e) {
     * 	    handle it like below steps
     * }
     */
    @ExceptionHandler(HttpClientErrorException.class) // catch block
    public String handleHttpClientException(HttpClientErrorException e) {
        System.out.println(e.getStatusCode().value());
        switch (e.getStatusCode().value()) {
            case 400: return "Bad request. Error message: " + e.getMessage();
            case 412: return "No permission or not authorize to make the call.";
        }

        return "Sorry, there was an issue.";
    }

    @ExceptionHandler(Exception.class) // catch block
    public String handleExceptions(Exception e) {
        System.err.println(e.getMessage());
        return "Sorry, there was an issue: " + e.getMessage();
    }

}
