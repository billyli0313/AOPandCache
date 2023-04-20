package com.example.springbootdb1.controller;

import com.example.springbootdb1.entity.Student;
import com.example.springbootdb1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @RequestMapping(value = "/index")
    public String start() {
        return "Hello World!";
    }

    @Autowired
    private StudentService service;


    @GetMapping(value = "/list/students")
    public List<Student> listStudentsByName(@RequestParam(value = "size_per_page") int sizePerPage,
                                            @RequestParam(value = "page") int page,
                                            @RequestParam(value = "name") String name) {
//       return service.listStudentsByName(name);
        return service.listStudentsByName(name, page, sizePerPage);
    }

    //list all students profile info
    @GetMapping(value = "/students")
    public List<Student> listAllStudents() {
        return service.listAllStudents();
    }

    //get one student profile by id
    @GetMapping(value = "/student/{id}")
    public Student getStudentById(@PathVariable(value="id")String id) {
        return service.getStudentById(id);
    }


    @PostMapping(value = "/create/student")
    // create one new student
    public void createStudent(@RequestParam(value="id") String id, @RequestParam(value="name") String name,
                              @RequestParam(value="address") String address) {
        Student student = new Student(id, name);
        student.setAddress(address);
        service.saveStudent(student);
    }


    // update student infos
    @PutMapping(value = "/update/student")
    public void updateStudent(@RequestParam(value="id") String id, @RequestParam(value="name", required = false) String name,
                              @RequestParam(value="address", required = false) String address) {
        Student student = service.getStudentById(id);
        if (address != null) {
            student.setAddress(address);
        }
        if (name != null) {
            student.setName(name);
        }
        service.saveStudent(student);
    }

    // remove student from storage
    @DeleteMapping(value = "/delete/student")
    public void deleteStudent(@RequestParam(value="id") String id) {
        service.deleteStudent(id);
    }

    // use requestBody instead

    @PostMapping(value = "/create/new/student")
    // create one new student
    public void createNewStudent(@RequestBody Student student) {
        service.saveStudent(student);
    }

    //get new student
    @GetMapping(value = "/student/new/{id}")
    @ResponseBody
    public Student getNewStudent(@PathVariable(value="id")String id) {
        return service.getStudentById(id);
    }
}
