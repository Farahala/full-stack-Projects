package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Teacher;
import com.resource.HibernateUtil;

public class TeacherDAO {

    private SessionFactory sessionFactory;

    public TeacherDAO() {
        sessionFactory = HibernateUtil.buildSessionFactory();
    }

    public List<Teacher> getAllTeachers() {
        try (Session session = sessionFactory.openSession()) {
            Query<Teacher> query = session.createQuery("FROM Teacher", Teacher.class);
            return query.getResultList();
        }
    }

    public Teacher getTeacherById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Teacher.class, id);
        }
    }

    public void addTeacher(Teacher teacher) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(teacher);
            tx.commit();
        }
    }

    public void updateTeacher(Teacher teacher) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(teacher);
            tx.commit();
        }
    }

    public void deleteTeacher(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Teacher teacher = session.get(Teacher.class, id);
            if (teacher != null) {
                session.delete(teacher);
            }
            tx.commit();
        }
    }
}
