package com.example.springbootsecurity.service;

import com.example.springbootsecurity.entity.Seat;
import com.example.springbootsecurity.repository.JPASeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    @Autowired
    JPASeatRepository jpaSeatRepository;

    public void saveSeat(Seat seat) {
        jpaSeatRepository.save(seat);
    }

    public Seat getSeat(String id) {
        return jpaSeatRepository.getReferenceById(id);
    }
}
