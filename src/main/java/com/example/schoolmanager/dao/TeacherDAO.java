package com.example.schoolmanager.dao;

import com.example.schoolmanager.entity.Teacher;

import java.util.List;

public interface TeacherDAO {
    List<Teacher> findAll();
    Teacher findById(int id);
    Teacher findByTeacherId(String teacherId);
    Teacher save(Teacher teacher);
    String deleteById(int id);
    List<Teacher> findByFaculty(String faculty);

    Teacher findByUsername(String username);
    Teacher login(String username, String password);
}
