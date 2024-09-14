package com.example.schoolmanager.restservice;

import com.example.schoolmanager.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {
    List<Teacher> getListTeacher();
    Teacher getTeacherById(int id);
    Teacher getTeacherByTeacherId(String teacherId);
    Teacher updateTeacher(Teacher teacher);
    Teacher addTeacher(Teacher teacher);
    String deleteTeacher(int id);
    String deleteTeacher(String teacherId);
    List<Teacher> getListTeacherByFaculty(String faculty);

    Teacher TeacherLogin(String username, String password);

}
