package com.example.springbootdb4.repository;

import com.example.springbootdb4.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPATeacherRepository extends JpaRepository<Teacher, String> {
    Teacher getTeachersByTeacherId(String id);
}
