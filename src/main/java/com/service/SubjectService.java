package com.service;

import java.util.List;

import com.dao.SubjectDAO;
import com.entity.Subject;

public class SubjectService {

	private SubjectDAO subjectDAO;

	public SubjectService() {
		this.subjectDAO = new SubjectDAO();
	}

	public List<Subject> getAllSubjects() {
		return subjectDAO.getAllSubjects();
	}

	public Subject getSubjectById(int id) {
		return subjectDAO.getSubjectById(id);
	}

	public void addSubject(Subject subject) {
		subjectDAO.addSubject(subject);
	}

	public void updateSubject(Subject subject) {
		subjectDAO.updateSubject(subject);
	}

	public void deleteSubject(int id) {
		subjectDAO.deleteSubject(id);
	}
}
