package com.example.springbootdb1.repository;

import com.example.springbootdb1.entity.Student;
import com.example.springbootdb1.entity.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherRepository {
    static HashMap<String, Teacher> teacherStorage = new HashMap<>();


    public Teacher getTeacher(String id) {
        return teacherStorage.get(id);
    }

    public void saveTeacher(Teacher teacher) {
        String id = teacher.getId();
        teacherStorage.put(id, teacher);
    }

    public void addStudent(Teacher teacher, Student student) {
        teacher.addStudent(student);
    }

    public List<Student> listAllStudents(Teacher teacher) {
        return teacher.getStudents().stream().collect(Collectors.toList());
    }
}
