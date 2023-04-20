package com.example.springbootsecurity.repository;

import com.example.springbootsecurity.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPATeacherRepository extends JpaRepository<Teacher, String> {
    Teacher getTeachersByTeacherId(String id);
}
