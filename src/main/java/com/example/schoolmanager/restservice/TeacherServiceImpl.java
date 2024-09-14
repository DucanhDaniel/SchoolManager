package com.example.schoolmanager.restservice;

import com.example.schoolmanager.dao.TeacherDAO;
import com.example.schoolmanager.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherDAO teacherDAO;

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Teacher> getListTeacher() {
        return teacherDAO.findAll();
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherDAO.findById(id);
    }

    @Override
    public Teacher getTeacherByTeacherId(String teacherId) {
        return teacherDAO.findByTeacherId(teacherId);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherDAO.save(teacher);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherDAO.save(teacher);
    }

    @Override
    public String deleteTeacher(int id) {
        return teacherDAO.deleteById(id);
    }

    @Override
    public String deleteTeacher(String teacherId) {
        Teacher teacher = teacherDAO.findByTeacherId(teacherId);
        if (teacher == null) throw new RuntimeException("TeacherId not found!");
        return teacherDAO.deleteById(teacher.getId());
    }

    @Override
    public List<Teacher> getListTeacherByFaculty(String faculty) {
        return teacherDAO.findByFaculty(faculty);
    }

    @Override
    public Teacher TeacherLogin(String username, String password) {
        return teacherDAO.login(username, password);
    }
}
