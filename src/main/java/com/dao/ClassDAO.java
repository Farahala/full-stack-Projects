package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Classes;
import com.resource.HibernateUtil;

public class ClassDAO {
    private SessionFactory sessionFactory;

    public ClassDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void create(Classes classes) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(classes);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Classes> getAllClasses() {
        try (Session session = sessionFactory.openSession()) {
            Query<Classes> query = session.createQuery("FROM Classes", Classes.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Classes getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Classes.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Classes classes) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(classes);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Classes classes = session.get(Classes.class, id);
            session.delete(classes);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void close() {
        sessionFactory.close();
    }
}
