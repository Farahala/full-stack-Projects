package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Student;
import com.resource.HibernateUtil;

public class StudentDAO {

    private SessionFactory sessionFactory;
    
    public StudentDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public List<Student> getAllStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Student> studentList = null;
        try {
            Query<Student> query = session.createQuery("from Student", Student.class);
            studentList = query.getResultList();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        }
        return studentList;
    }
    
    public Student getStudentById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Student student = null;
        try {
            Query<Student> query = session.createQuery("from Student where id=:studentId", Student.class);
            query.setParameter("studentId", id);
            student = query.getSingleResult();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        }
        return student;
    }
    
    public void addStudent(Student student) {
    	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
			
        try {
            session.save(student);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        }
    }
    
    public void updateStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(student);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        }
    }
    
    public void deleteStudent(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(id);
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx.rollback();
        }
    }
}

