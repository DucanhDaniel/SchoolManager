package com.example.schoolmanager.dao;

import com.example.schoolmanager.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student",
                Student.class
        );
        return query.getResultList();
    }

    @Override
    public Student findById(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE id =: theData",
                Student.class
        );
        query.setParameter("theData", id);
        return query.getSingleResult();
    }

    @Override
    public Student findByStudentId(String StudentId) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE studentId =: theStudentId",
                Student.class
        );
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public String deleteById(int id) {
        if (findById(id) == null) throw new RuntimeException("Student id not found!");
        entityManager.remove(findById(id));
        return "Deleted Student with ID: " + id;
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Student findByUsername(String username) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE username =: theData",
                Student.class
        );
        return query.getSingleResult();
    }

    @Override
    public Student login(String username, String password) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE username =: theUsername AND password =: thePassword",
                Student.class
        );
        return query.getSingleResult();
    }
}
