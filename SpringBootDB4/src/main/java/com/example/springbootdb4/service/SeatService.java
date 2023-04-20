package com.example.springbootdb4.service;

import com.example.springbootdb4.entity.Seat;
import com.example.springbootdb4.repository.JPASeatRepository;
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
