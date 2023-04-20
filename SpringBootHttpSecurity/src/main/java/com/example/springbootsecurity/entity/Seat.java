package com.example.springbootsecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "Seat")
public class Seat {
    @Id
    @Column(name = "seat_id")
    private String seatId;

    @JsonIgnore
    @OneToOne(mappedBy = "seat")
    private Student student;

    @Column(name = "location")
    private String location;

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
