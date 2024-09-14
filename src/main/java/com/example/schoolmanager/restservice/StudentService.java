package com.example.schoolmanager.restservice;

import com.example.schoolmanager.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student getStudentByStudentId(String studentId);
    Student addStudent(Student student);
    Student updateStudent(Student student);
    String deleteStudent(int id);
    String deleteStudent(String studentId);

    Student studentLogin(String username, String password);
}
