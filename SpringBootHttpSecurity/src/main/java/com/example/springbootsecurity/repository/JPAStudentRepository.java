package com.example.springbootsecurity.repository;

import com.example.springbootsecurity.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Hibernate is a JPA implementation
public interface JPAStudentRepository extends JpaRepository<Student, String> {



//    List<Student> findStudentByName(String name);

    // the query here is not mySQL, it's jpql or HQL language
    // 1 here is a placeholder, represents here is the first param
//    @Query(value = "SELECT s FROM Student s WHERE s.name=?1")
//    List<Student> findByName(String name);


    // the query here is mySQL, but not jpql or HQL, since we are using original DB language
//    @Query(value = "SELECT s.* FROM Student s WHERE s.name=:name", nativeQuery=true)
//    List<Student> findByName(@Param("name") String name);

    //pagination example
    List<Student> findStudentByName(String name, Pageable page);

}
