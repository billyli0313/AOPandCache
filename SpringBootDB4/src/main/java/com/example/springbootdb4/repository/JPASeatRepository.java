package com.example.springbootdb4.repository;

import com.example.springbootdb4.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPASeatRepository extends JpaRepository<Seat, String> {
}
