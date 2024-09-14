package com.example.schoolmanager.dao;

import com.example.schoolmanager.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    Student findById(int id);
    Student findByStudentId(String StudentId);
    Student save(Student student);
    String deleteById(int id);
    Student update(Student student);

    Student findByUsername(String username);
    Student login(String username, String password);

}
