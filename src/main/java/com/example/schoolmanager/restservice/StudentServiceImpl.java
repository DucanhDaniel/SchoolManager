package com.example.schoolmanager.restservice;

import com.example.schoolmanager.dao.StudentDAO;
import com.example.schoolmanager.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public Student getStudentByStudentId(String studentId) {
        return studentDAO.findByStudentId(studentId);
    }

    @Override
    public Student addStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public String deleteStudent(int id) {
        return studentDAO.deleteById(id);
    }

    @Override
    public String deleteStudent(String studentId) {
        Student student = studentDAO.findByStudentId(studentId);
        if (student == null) throw new RuntimeException("StudentId not found!");
        return studentDAO.deleteById(student.getId());
    }

    @Override
    public Student studentLogin(String username, String password) {
        return studentDAO.login(username, password);
    }
}
