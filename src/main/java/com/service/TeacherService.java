package com.service;

import java.util.List;

import com.dao.TeacherDAO;
import com.entity.Teacher;

public class TeacherService {

	private TeacherDAO teacherDAO;

	public TeacherService() {
		this.teacherDAO = new TeacherDAO();
	}

	public List<Teacher> getAllTeachers() {
		return teacherDAO.getAllTeachers();
	}

	public Teacher getTeacherById(int id) {
		return teacherDAO.getTeacherById(id);
	}

	public void addTeacher(Teacher teacher) {
		teacherDAO.addTeacher(teacher);
	}

	public void updateTeacher(Teacher teacher) {
		teacherDAO.updateTeacher(teacher);
	}

	public void deleteTeacher(int id) {
		teacherDAO.deleteTeacher(id);
	}
}
