package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Subject;
import com.resource.HibernateUtil;

public class SubjectDAO {

	public void saveSubject(Subject subject) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(subject);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSubject(Subject subject) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(subject);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteSubject(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Subject subject = session.get(Subject.class, id);
			if (subject != null) {
				session.delete(subject);
			}
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Subject getSubjectById(int id) {
		Subject subject = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			subject = session.get(Subject.class, id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subject;
	}

	@SuppressWarnings("unchecked")
	public List<Subject> getAllSubjects() {
		List<Subject> subjects = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			subjects = session.createQuery("from Subject").getResultList();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjects;
	}

	public void addSubject(Subject subject) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			session.save(subject);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
