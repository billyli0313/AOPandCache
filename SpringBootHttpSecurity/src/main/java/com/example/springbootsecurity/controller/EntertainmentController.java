package com.example.springbootsecurity.controller;

import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
@RestController
public class EntertainmentController {

    @PostMapping(value = "/club")
    public String registerForClub(@RequestParam(value = "age") int age, @RequestParam(value = "id") String id) {

        //store data ...
        return "Register Successfully for club activity!";
    }

}
