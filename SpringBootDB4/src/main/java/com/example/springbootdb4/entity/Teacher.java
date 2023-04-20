package com.example.springbootdb4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "Teacher")
public class Teacher {
    @Id
    @Column(name = "teacher_id")
    private String teacherId;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "teachers")
    private Set<Student> students;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phone;

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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
}
