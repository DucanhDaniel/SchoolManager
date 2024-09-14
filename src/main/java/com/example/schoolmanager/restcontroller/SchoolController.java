package com.example.schoolmanager.restcontroller;

import com.example.schoolmanager.entity.Student;
import com.example.schoolmanager.entity.Teacher;
import com.example.schoolmanager.restservice.StudentService;
import com.example.schoolmanager.restservice.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {
    // School-related RESTful API endpoints go here
    private final StudentService studentService;
    private final TeacherService teacherService;

    @Autowired
    public SchoolController(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping("/students")
    public List<Student> getListStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/teachers")
    public List<Teacher> getListTeacher() {
        return teacherService.getListTeacher();
    }

    @GetMapping("/teachers/{faculty}")
    public List<Teacher> getTeacherByFaculty(@PathVariable String faculty) {
        return teacherService.getListTeacherByFaculty(faculty);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/students/addAll")
    public void addAllStudents(@RequestBody List<Student> students) {
        for (Student student : students)
            studentService.addStudent(student);
    }

    @PutMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/teachers/addAll")
    public void addAllTeachers(@RequestBody List<Teacher> listTeacher) {
        for (Teacher teacher : listTeacher)
            teacherService.addTeacher(teacher);
    }

    @PutMapping("/teachers")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
    }

    @PostMapping("/students")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @PostMapping("/teachers")
    public void updateTeacher(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
    }

}
