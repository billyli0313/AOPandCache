package com.example.springbootsecurity.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "id")
    private String id;

    // Add relation into Model on both side
    // name specify new column name, referred by real entity's name

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id")
    private Seat seat;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<Card> cards;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST
    })
    @JoinTable(
        name = "Student_Teacher",
        joinColumns = { @JoinColumn(name = "student_id", referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")})
    private Set<Teacher> teachers;

    @Column(name ="name")
    private String name;
    @Column(name = "age")
    private int age;

    @Column(name = "teacher_id")
    private String teacherId;
    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
        super();
    }

    public String toString() {
        return "Student id: " + this.id + "; " +
                "Student name: " + this.name + "; " +
                "Student address " + this.address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

}
