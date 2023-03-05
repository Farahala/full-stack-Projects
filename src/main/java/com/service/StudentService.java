package com.service;

import java.util.List;

import com.dao.StudentDAO;
import com.entity.Student;

public class StudentService {

	private StudentDAO studentDAO;

	public StudentService() {
		this.studentDAO = new StudentDAO();
	}

	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}

	public Student getStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}

	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);
	}
}
