package com.example.springbootsecurity.repository;

import com.example.springbootsecurity.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPASeatRepository extends JpaRepository<Seat, String> {
}
