package com.example.springbootdb4.controller;

import com.example.springbootdb4.entity.Card;
import com.example.springbootdb4.entity.Seat;
import com.example.springbootdb4.entity.Student;
import com.example.springbootdb4.service.SeatService;
import com.example.springbootdb4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class StudentController {

    @RequestMapping(value = "/index")
    public String start() {
        return "Hello World!";
    }

    @Autowired
    private StudentService studentService;

    @Autowired
    private SeatService seatService;


    @GetMapping(value = "/list/students")
    public List<Student> listStudentsByName(@RequestParam(value = "size_per_page") int sizePerPage,
                                            @RequestParam(value = "page") int page,
                                            @RequestParam(value = "name") String name) {
//       return service.listStudentsByName(name);
        return studentService.listStudentsByName(name, page, sizePerPage);
    }

    //list all students profile info
    @GetMapping(value = "/students")
    public List<Student> listAllStudents() {
        return studentService.listAllStudents();
    }

    //get one student profile by id
    @GetMapping(value = "/student/{id}")
    public Student getStudentById(@PathVariable(value="id")String id) {
        return studentService.getStudentById(id);
    }


    @PostMapping(value = "/create/student")
    // create one new student
    public void createStudent(@RequestParam(value="id") String id, @RequestParam(value="name") String name,
                              @RequestParam(value="address") String address) {
        Student student = new Student(id, name);
        student.setAddress(address);

        // create a seat
        Seat seat = new Seat();
        seat.setSeatId(id);

        // set seat's student
//        seat.setStudent(student);
//        seatService.saveSeat(seat);



        //set student's seat - save student will save seat as well, since it has mapping in hibernate
        student.setSeat(seat);


        // set student card
        Card card = new Card();
        card.setCardId(id);
        Set<Card> cards = new HashSet<>();
        cards.add(card);
        student.setCards(cards);
        studentService.saveStudent(student);
    }


    // update student infos
    @PutMapping(value = "/update/student")
    public void updateStudent(@RequestParam(value="id") String id, @RequestParam(value="name", required = false) String name,
                              @RequestParam(value="address", required = false) String address) {
        Student student = studentService.getStudentById(id);
        if (address != null) {
            student.setAddress(address);
        }
        if (name != null) {
            student.setName(name);
        }
        studentService.update(student);
    }

    // remove student from storage
    @DeleteMapping(value = "/delete/student")
    public void deleteStudent(@RequestParam(value="id") String id) {
        studentService.deleteStudent(id);
    }

    // use requestBody instead

    @PostMapping(value = "/create/new/student")
    // create one new student
    public void createNewStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    //get new student
    @GetMapping(value = "/student/new/{id}")
    @ResponseBody
    public Student getNewStudent(@PathVariable(value="id")String id) {
        return studentService.getStudentById(id);
    }
}
