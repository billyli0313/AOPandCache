package com.example.springbootdb1.entity;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
    private String id;
    private String name;
    private String phone;

    public Set<Student> getStudents() {
        return students;
    }

    private Set<Student> students = new HashSet<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void addStudent(Student student) {
        this.students.add(student);
    }
}
