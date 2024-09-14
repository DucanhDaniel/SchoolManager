package com.example.schoolmanager.dao;

import com.example.schoolmanager.entity.Student;
import com.example.schoolmanager.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO{

    private final EntityManager entityManager;

    @Autowired
    public TeacherDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Teacher> findAll() {
        TypedQuery<Teacher> query = entityManager.createQuery(
                "FROM Teacher",
                Teacher.class
        );
        return query.getResultList();
    }

    @Override
    public Teacher findById(int id) {
        TypedQuery<Teacher> query = entityManager.createQuery(
                "FROM Teacher WHERE id =: theId",
                Teacher.class
        );
        query.setParameter("theId", id);
        return query.getSingleResult();
    }

    @Override
    public Teacher findByTeacherId(String teacherId) {
        TypedQuery<Teacher> query = entityManager.createQuery(
                "FROM Teacher WHERE teacherId =: theTeacherId",
                Teacher.class
        );
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public Teacher save(Teacher teacher) {
        return entityManager.merge(teacher);
    }

    @Override
    @Transactional
    public String deleteById(int id) {
        if (findById(id) == null) throw new RuntimeException("Teacher id not found!");
        entityManager.remove(findById(id));
        return "Deleted Teacher with ID: " + id;
    }

    @Override
    public List<Teacher> findByFaculty(String faculty) {
        TypedQuery<Teacher> query = entityManager.createQuery(
                "FROM Teacher WHERE faculty =: theFaculty",
                Teacher.class
        );
        query.setParameter("theFaculty", faculty);
        return query.getResultList();
    }

    @Override
    public Teacher findByUsername(String username) {
        TypedQuery<Teacher> query = entityManager.createQuery(
                "FROM Teacher WHERE username =: theUsername",
                Teacher.class
        );
        query.setParameter("theUsername", username);
        return query.getSingleResult();
    }

    @Override
    public Teacher login(String username, String password) {
        TypedQuery<Teacher> query = entityManager.createQuery(
                "FROM Teacher WHERE username =: theUsername AND password =: thePassword",
                Teacher.class
        );
        query.setParameter("theUsername", username);
        query.setParameter("thePassword", password);
        return query.getSingleResult();
    }
}
