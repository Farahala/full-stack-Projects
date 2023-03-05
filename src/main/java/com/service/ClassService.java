package com.service;

import java.util.List;

import com.dao.ClassDAO;
import com.entity.Classes;

public class ClassService {

	private ClassDAO classDAO;

	public ClassService() {
		this.classDAO = new ClassDAO();
	}

	public List<Classes> getAllClasses() {
		return classDAO.getAllClasses();
	}

	public Classes getClassById(int id) {
		return classDAO.getById(id);
	}

	public void addClass(Classes classes) {
		classDAO.create(classes);
	}

	public void updateClass(Classes classes) {
		classDAO.update(classes);
	}

	public void deleteClass(int id) {
		classDAO.delete(id);
	}
}
